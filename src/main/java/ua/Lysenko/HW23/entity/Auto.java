package ua.Lysenko.HW23.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
   private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name = "manufactureDate")
    private String manufactureDate;

    @Column(name = "sellDate")
    private String sellDate;

    @Column(name = "gearType")
    private String gearType;

    @Column(name = "fuelVolume")
    private int fuelVolume;

    public Auto() {
    }

    public Auto(String title, double price, String manufactureDate,
                String sellDate, String gearType, int fuelVolume) {

        
        this.title = title;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.sellDate = sellDate;
        this.gearType = gearType;
        this.fuelVolume = fuelVolume;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public int getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(int fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", title='" + title +
                ", price=" + price +
                ", manufactureDate=" + manufactureDate +
                ", sellDate=" + sellDate +
                ", gearType='" + gearType +
                ", fuelVolume=" + fuelVolume +
                '}';
    }
}
