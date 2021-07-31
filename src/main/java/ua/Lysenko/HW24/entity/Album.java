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

    @OneToMany(mappedBy = "album")
    private List<Track> tracks = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @ManyToMany(mappedBy = "albums")
    private List<Order> orders = new ArrayList<>();

    public Album() {
    }

    public Album(String title) {
        this.title = title;
    }
}
