package com.somniuss.guitarstore.controller.impl;

import com.somniuss.guitarstore.controller.Command;
import com.somniuss.guitarstore.entity.MusicalInstrument;
import com.somniuss.guitarstore.logic.GuitarstoreLogic;
import com.somniuss.guitarstore.logic.GuitarstoreLogicProvider;

public class UpdateInstrumentCommand implements Command {
    private final GuitarstoreLogic logic = GuitarstoreLogicProvider.getInstance().getGuitarstoreLogic();

    @Override
    public String execute(String request) {
        String response;
        String[] params = request.split("\n");

        try {
            int id = Integer.parseInt(params[1].split("=")[1]);
            String type = params[2].split("=")[1];
            String brand = params[3].split("=")[1];
            String model = params[4].split("=")[1];
            double price = Double.parseDouble(params[5].split("=")[1]);

            MusicalInstrument instrument = new MusicalInstrument(id, type, brand, model, price);
            logic.updateInstrument(instrument);

            response = "Instrument updated successfully.";
        } catch (Exception e) {
            response = "Error updating instrument.";
        }

        return response;
    }
}
