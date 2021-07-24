package ua.Lysenko.HW24.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "orderNumber")
    private int orderNumber;

    @ManyToMany
    @JoinTable(name = "OrdersAlbums",
            joinColumns = {@JoinColumn(name = "OrderId")},
            inverseJoinColumns = {@JoinColumn(name = "AlbumId")})
    private List<Album> album;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    public Order() {
    }
}
