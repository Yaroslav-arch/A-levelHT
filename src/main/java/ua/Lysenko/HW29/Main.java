package ua.Lysenko.HW29;

import ua.Lysenko.HW29.entity.*;
import ua.Lysenko.HW29.factory.*;


public class Main {
    public static void main(String[] args) {

        Request request = Request.newBuilder()
                .setPricePerMile(2.0f)
                .setMaxWeight(5_000)
                .build();

        Creator creator = getCreator(request);
        Shipment shipment1 = creator.create(request);
        System.out.println("Shipment: " + shipment1.toString());

        Request requestCopy = request.deepCopy();
        requestCopy.setMaxWeight(45);
        System.out.println("Original request: " + request);
        System.out.println("Copy of request: " + requestCopy);
    }

    private static Creator getCreator(Request request) {
        switch (request.type) {
            case BOX_TRUCK -> {
                return new BoxTruckCreator();
            }
            case DRY_VAN -> {
                return new DryVanCreator();
            }
            case FLATBED -> {
                return new FlatbedCreator();
            }
            default -> throw new IllegalArgumentException(request.toString());
        }
    }
}

