package ua.Lysenko.HW29.entity;

public enum ShipmentType {
    BOX_TRUCK("Box truck"),
    DRY_VAN("Dry van"),
    FLATBED("Flatbed");

    private final String type;

    ShipmentType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
