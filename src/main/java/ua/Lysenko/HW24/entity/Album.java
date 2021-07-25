package ua.Lysenko.HW24.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "album")
    private List<Track> tracks = new ArrayList<>();

    @ManyToMany(mappedBy = "albums")
//    @JoinTable(name = "albums_artists",
//            joinColumns = {@JoinColumn(name = "album_id")},
//            inverseJoinColumns = {@JoinColumn(name = "artist_id")})
    private List<Artist> artist = new ArrayList<>();

    @ManyToMany(mappedBy = "albums")
//    @JoinTable(name = "orders_albums",
//            joinColumns = {@JoinColumn(name = "album_id")},
//            inverseJoinColumns = {@JoinColumn(name = "order_id")})
    private List<Order> orders = new ArrayList<>();

    public Album() {
    }

    public Album(long id, String title) {
        this.id = id;
        this.title = title;
    }
}
