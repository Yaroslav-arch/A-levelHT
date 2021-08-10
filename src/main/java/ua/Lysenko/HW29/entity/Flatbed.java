package ua.Lysenko.HW29.entity;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class Flatbed extends Shipment {
    ShipmentType type;
    float pricePerMile;
    int maxWeight;

    @Override
    void carry() {
        System.out.println("Flatbed carries nice and easy");
    }

    private Flatbed(ShipmentType type, float pricePerMile, int maxWeight) {
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

        public Flatbed build() {
            return new Flatbed(type, pricePerMile, maxWeight);
        }
    }
}
