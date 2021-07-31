package ua.Lysenko.HW23.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "autos")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name = "manufacture_date")
    private LocalDate manufactureDate;

    @Column(name = "sell_date")
    private LocalDate sellDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gear_type")
    private GearType gearType;

    @Column(name = "fuel_volume")
    private int fuelVolume;

    public Auto() {
    }

    public Auto(String title, double price, String manufactureDate,
                String sellDate, GearType gearType, int fuelVolume) {


        this.title = title;
        this.price = price;
        this.manufactureDate = LocalDate.parse(manufactureDate);
        this.sellDate = LocalDate.parse(sellDate);
        this.gearType = gearType;
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
