package ua.Lysenko.HW29.entity;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class BoxTruck extends Shipment {
    ShipmentType type;
    float pricePerMile;
    int maxWeight;

    @Override
    void carry() {
        System.out.println("Box truck is on the way");
    }

    private BoxTruck(ShipmentType type, float pricePerMile, int maxWeight) {
        this.type = type;
        this.pricePerMile = pricePerMile;
        this.maxWeight = maxWeight;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        ShipmentType type;
        float pricePerMile;
        int maxWeight;

        public Builder setType(ShipmentType type) {
            this.type = type;
            return this;
        }

        public Builder setPricePerMile(float price) {
            this.pricePerMile = price;
            return this;
        }

        public Builder setMaxWeight(int maxWeight) {
            this.maxWeight = maxWeight;
            return this;
        }

        public BoxTruck build() {
            return new BoxTruck(type, pricePerMile, maxWeight);
        }
    }
}
