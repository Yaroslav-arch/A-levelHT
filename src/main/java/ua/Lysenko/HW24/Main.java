package ua.Lysenko.HW24;

import ua.Lysenko.HW24.dao.*;
import ua.Lysenko.HW24.entity.*;

public class Main {
    public static void main(String[] args) {

        AlbumDao albumDao = new AlbumDao();
        ArtistDao artistDao = new ArtistDao();
        CustomerDao customerDao = new CustomerDao();
        OrderDao orderDao = new OrderDao();
        TrackDao trackDao = new TrackDao();

        Album album = new Album(1, "Fear of the dark");
        Artist artist = new Artist(1, "Iron Maiden");
        Customer customer = new Customer(1, "Donald Trump");
        Order order = new Order(1, 123);
        Track track = new Track(1, "The trooper");

        artist.getAlbums().add(album);
        album.getTracks().add(track);
        customer.getOrders().add(order);
        order.getAlbums().add(album);

        album.getArtist().add(artist);
        track.setAlbum(album);
        order.setCustomer(customer);
        album.getOrders().add(order);

//        orderDao.saveOrder(order);
        artistDao.saveArtist(artist);
    }
}