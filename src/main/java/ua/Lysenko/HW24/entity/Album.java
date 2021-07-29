package ua.Lysenko.HW24.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Track> tracks = new ArrayList<>();

    @ManyToOne
//    @JoinTable(name = "albums_artists",
//            joinColumns = {@JoinColumn(name = "album_id")},
//            inverseJoinColumns = {@JoinColumn(name = "artist_id")})
    private Artist artist;

    @ManyToMany(mappedBy = "albums")
//    @JoinTable(name = "orders_albums",
//            joinColumns = {@JoinColumn(name = "album_id")},
//            inverseJoinColumns = {@JoinColumn(name = "order_id")})
    private List<Order> orders = new ArrayList<>();

    public Album() {
    }

    public Album(String title) {
        this.title = title;
    }
}
