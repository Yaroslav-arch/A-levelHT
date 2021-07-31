package ua.Lysenko.HW24.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tracks")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "artist_id",nullable = false)
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "album_id", insertable = false, updatable = false)
    private Album album;

    public Track() {
    }

    public Track(String name) {
        this.name = name;
    }
}
