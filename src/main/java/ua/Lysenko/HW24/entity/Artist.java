package ua.Lysenko.HW24.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    @Column(name = "track")
    private List<Track> tracks = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "albums_artists",
            joinColumns = {@JoinColumn(name = "artist_id")},
            inverseJoinColumns = {@JoinColumn(name = "album_id")})
    private List<Album> albums = new ArrayList<>();

    public Artist() {
    }

    public Artist(long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
