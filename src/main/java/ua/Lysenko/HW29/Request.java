package ua.Lysenko.HW29;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import ua.Lysenko.HW29.entity.ShipmentType;

@Getter
@Setter
public class Request {
    ShipmentType type;
    float pricePerMile;
    int maxWeight;

    private Request(ShipmentType type, float pricePerMile, int maxWeight) {
        this.type = type;
        this.pricePerMile = pricePerMile;
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type=" + type +
                ", pricePerMile=" + pricePerMile +
                ", maxWeight=" + maxWeight +
                '}';
    }

    public Request deepCopy() {
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(this), Request.class);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        ShipmentType type;
        float pricePerMile;
        int maxWeight;

        public Builder setType() {
            if (maxWeight <= 10_000) {
                this.type = ShipmentType.BOX_TRUCK;
            } else if (maxWeight <= 40_000) {
                this.type = ShipmentType.DRY_VAN;
            } else {
                this.type = ShipmentType.FLATBED;
            }
            return this;
        }

        public Builder setPricePerMile(float price) {
            if (1.5f < price && price < 3.5f) {
                this.pricePerMile = price;
            } else {
                this.pricePerMile = 1.5f;
            }
            return this;
        }

        public Builder setMaxWeight(int maxWeight) {
            if (maxWeight < 60_000) {
                this.maxWeight = maxWeight;
            } else throw new IllegalStateException("OVERLOAD");
            return this;
        }

        public Request build() {
            setType();
            return new Request(type, pricePerMile, maxWeight);
        }
    }
}
