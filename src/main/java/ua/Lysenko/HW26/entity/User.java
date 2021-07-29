package ua.Lysenko.HW26.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String workPlace;
    private String city;

    public User(String id, String firstName, String lastName, int age, String workPlace, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.workPlace = workPlace;
        this.city = city;
    }
}
