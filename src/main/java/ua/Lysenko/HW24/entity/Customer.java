package ua.Lysenko.HW24.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "fullName")
    private String fullName;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @Column(name = "track")
    private List<Order> orders;

    public Customer() {
    }
}
