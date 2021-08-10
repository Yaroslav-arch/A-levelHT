package ua.Lysenko.HW29.entity;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class DryVan extends Shipment {
    ShipmentType type;
    float pricePerMile;
    int maxWeight;

    @Override
    void carry() {
        System.out.println("Dry van says: 'Wrom-wrom'");
    }

    private DryVan(ShipmentType type, float pricePerMile, int maxWeight) {
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

        public DryVan build() {
            return new DryVan(type, pricePerMile, maxWeight);
        }
    }
}
