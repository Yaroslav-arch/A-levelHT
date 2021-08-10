package ua.Lysenko.HW29.factory;

import ua.Lysenko.HW29.Request;
import ua.Lysenko.HW29.entity.*;

public class BoxTruckCreator implements Creator {

    @Override
    public Shipment create(Request request) {
        return BoxTruck.newBuilder()
                .setType(request.getType())
                .setPricePerMile(request.getPricePerMile())
                .setMaxWeight(request.getMaxWeight())
                .build();
    }
}
