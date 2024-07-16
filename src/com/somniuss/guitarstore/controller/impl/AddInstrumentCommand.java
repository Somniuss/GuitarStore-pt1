package com.somniuss.guitarstore.controller.impl;

import com.somniuss.guitarstore.controller.Command;
import com.somniuss.guitarstore.entity.MusicalInstrument;
import com.somniuss.guitarstore.logic.GuitarstoreLogic;
import com.somniuss.guitarstore.logic.GuitarstoreLogicProvider;

public class AddInstrumentCommand implements Command {
    private final GuitarstoreLogic logic = GuitarstoreLogicProvider.getInstance().getGuitarstoreLogic();

    @Override
    public String execute(String request) {
        String response;
        String[] params = request.split("\n");

        try {
            String type = params[1].split("=")[1];
            String brand = params[2].split("=")[1];
            String model = params[3].split("=")[1];
            double price = Double.parseDouble(params[4].split("=")[1]);

            MusicalInstrument instrument = new MusicalInstrument(type, brand, model, price);
            logic.addInstrument(instrument);

            response = "Instrument added successfully.";
        } catch (Exception e) {
            response = "Error adding instrument.";
        }

        return response;
    }
}
