package ua.Lysenko.HW24.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "tracks")
    private List<Track> tracks;

    @ManyToMany
    @JoinTable(name = "AlbumsArtists",
            joinColumns = {@JoinColumn(name = "AlbumId")},
            inverseJoinColumns = {@JoinColumn(name = "ArtistId")})
    private List<Artist> artist;

    @ManyToMany
    @JoinTable(name = "OrdersAlbums",
            joinColumns = {@JoinColumn(name = "AlbumId")},
            inverseJoinColumns = {@JoinColumn(name = "OrderId")})
    private List<Order> orders;

    public Album() {
    }

}
