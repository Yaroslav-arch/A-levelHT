package ua.Lysenko.HW18.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}