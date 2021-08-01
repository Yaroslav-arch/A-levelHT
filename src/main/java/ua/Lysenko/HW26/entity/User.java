package ua.Lysenko.HW26.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class User {
    private String  id;
    private String firstName;
    private String lastName;
    private int age;
    private int dateOfBirth;
    private String workPlace;
    private String city;
    private List<String> accounts;

    public User(String firstName, String lastName, int age, String workPlace, String city) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.workPlace = workPlace;
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                ", workPlace='" + workPlace + '\'' +
                ", city='" + city + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
