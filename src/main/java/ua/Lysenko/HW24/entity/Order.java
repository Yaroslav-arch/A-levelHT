package ua.Lysenko.HW24.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "order_number")
    private int orderNumber;

    @ManyToMany
    private List<Album> albums = new ArrayList<>();

    @ManyToOne
//    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order() {
    }

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
