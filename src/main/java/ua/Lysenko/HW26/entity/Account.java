package ua.Lysenko.HW26.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Account {
    private String id;
    private double amount;
    private String userId;

    public Account(double amount) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", userId='" + userId + '\'' +
                '}';
    }
}
