package com.somniuss.guitarstore.dao.impl;

import com.somniuss.guitarstore.dao.GuitarStoreDao;
import com.somniuss.guitarstore.entity.MusicalInstrument;
import com.somniuss.guitarstore.util.GenerateId;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileGuitarStoreDao implements GuitarStoreDao {

    private static final String FILE_NAME = "instruments.txt";

    @Override
    public void addInstrument(MusicalInstrument instrument) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(convertInstrumentToString(instrument));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MusicalInstrument findInstrumentById(int id) {
        return getAllInstruments().stream()
                .filter(instrument -> instrument.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<MusicalInstrument> findInstrumentsByType(String type) {
        return getAllInstruments().stream()
                .filter(instrument -> instrument.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<MusicalInstrument> findInstrumentsByBrand(String brand) {
        return getAllInstruments().stream()
                .filter(instrument -> instrument.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    @Override
    public List<MusicalInstrument> sortInstrumentsByPrice(boolean ascending) {
        return getAllInstruments().stream()
                .sorted(Comparator.comparingDouble(MusicalInstrument::getPrice)
                        .reversed().reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<MusicalInstrument> filterInstrumentsByPrice(double maxPrice) {
        return getAllInstruments().stream()
                .filter(instrument -> instrument.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    @Override
    public void updateInstrument(MusicalInstrument instrument) {
        List<MusicalInstrument> instruments = getAllInstruments();
        int index = instruments.indexOf(findInstrumentById(instrument.getId()));
        if (index >= 0) {
            instruments.set(index, instrument);
            writeAllInstrumentsToFile(instruments);
        }
    }

    @Override
    public boolean deleteInstrumentById(int id) {
        List<MusicalInstrument> instruments = getAllInstruments();
        boolean removed = instruments.removeIf(instrument -> instrument.getId() == id);
        if (removed) {
            writeAllInstrumentsToFile(instruments);
        }
        return removed;
    }

    private List<MusicalInstrument> getAllInstruments() {
        List<MusicalInstrument> instruments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                instruments.add(convertStringToInstrument(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instruments;
    }

    private void writeAllInstrumentsToFile(List<MusicalInstrument> instruments) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (MusicalInstrument instrument : instruments) {
                writer.write(convertInstrumentToString(instrument));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String convertInstrumentToString(MusicalInstrument instrument) {
        return instrument.getId() + "," + instrument.getType() + "," + instrument.getBrand() + "," +
                instrument.getModel() + "," + instrument.getPrice();
    }

    private MusicalInstrument convertStringToInstrument(String line) {
        String[] parts = line.split(",");
        return new MusicalInstrument(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], Double.parseDouble(parts[4]));
    }
}