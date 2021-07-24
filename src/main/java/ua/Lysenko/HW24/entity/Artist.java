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

    @Column(name = "fullName")
    private String fullName;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    @Column(name = "track")
    private List<Track> tracks;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "AlbumsArtists",
            joinColumns = {@JoinColumn(name = "ArtistId")},
            inverseJoinColumns = {@JoinColumn(name = "AlbumId")})
    private List<Album> albums = new ArrayList<>();

    public Artist() {
    }
}
