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

        Album album = new Album("Fear of the dark");
        Artist artist = new Artist("Iron Maiden");
        Customer customer = new Customer("Donald Trump");
        Order order = new Order(123);
        Track track = new Track("The trooper");

        artist.getAlbums().add(album);
        album.getTracks().add(track);
        customer.getOrders().add(order);
        order.getAlbums().add(album);

        album.setArtist(artist);
        track.setAlbum(album);
        order.setCustomer(customer);
        album.getOrders().add(order);

        trackDao.saveTrack(track);
        artistDao.saveArtist(artist);
        albumDao.saveAlbum(album);
        customerDao.saveCustomer(customer);
        orderDao.saveOrder(order);

    }
}