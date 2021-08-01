package ua.Lysenko.HW26.entity;

public enum UserFields {
    ID("id"),
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    AGE("age"),
    WORK_PLACE("workPlace"),
    CITY("city");

    private final String fieldName;

    UserFields(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return fieldName;
    }
}
