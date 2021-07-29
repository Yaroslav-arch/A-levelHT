package ua.Lysenko.HW24.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "track")
    private List<Track> tracks = new ArrayList<>();

    @OneToMany//(mappedBy = "artists")
//    @JoinTable(name = "albums_artists",
//            joinColumns = {@JoinColumn(name = "artist_id")},
//            inverseJoinColumns = {@JoinColumn(name = "album_id")})
    private List<Album> albums = new ArrayList<>();

    public Artist() {
    }

    public Artist(String fullName) {
        this.fullName = fullName;
    }
}
