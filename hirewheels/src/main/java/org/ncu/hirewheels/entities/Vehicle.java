package org.ncu.hirewheels.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id", columnDefinition = "numeric(10)")
    private Integer vehicle_id;

    @Column(name = "vehicle_model", columnDefinition = "varchar(50)", nullable = false)
    private String vehicle_model;

    @Column(name = "vehicle_number", columnDefinition = "char(10)", nullable = false)
    private String vehicle_number;

    @Column(name = "color", columnDefinition = "varchar(50)", nullable = false)
    private String color;

    @Column(name = "availability_status", columnDefinition = "numeric(1)", nullable = false)
    private Integer availability_status;

    @Column(name = "vehicle_image_url", columnDefinition = "varchar(500)", nullable = false)
    private String vehicle_image_url;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_subcategory_id", columnDefinition = "numeric(10)", nullable = false)
    private VehicleSubcategory vehicleSubcategory;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", columnDefinition = "numeric(10)")
    private Location location;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fuel_type_id", columnDefinition = "numeric(10)")
    private FuelType fuelType;

    @OneToMany(mappedBy = "vehicle",cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public Vehicle(String vehicle_model, String vehicle_number, String color, Integer availability_status,
            String vehicle_image_url, VehicleSubcategory vehicleSubcategory, Location location, FuelType fuelType) {
        this.vehicle_model = vehicle_model;
        this.vehicle_number = vehicle_number;
        this.color = color;
        this.availability_status = availability_status;
        this.vehicle_image_url = vehicle_image_url;
        this.vehicleSubcategory = vehicleSubcategory;
        this.location = location;
        this.fuelType = fuelType;
    }

    public Vehicle() {
    }

    public Integer getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Integer vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAvailability_status() {
        return availability_status;
    }

    public void setAvailability_status(Integer availability_status) {
        this.availability_status = availability_status;
    }

    public String getVehicle_image_url() {
        return vehicle_image_url;
    }

    public void setVehicle_image_url(String vehicle_image_url) {
        this.vehicle_image_url = vehicle_image_url;
    }

    public VehicleSubcategory getVehicleSubcategory() {
        return vehicleSubcategory;
    }

    public void setVehicleSubcategory(VehicleSubcategory vehicleSubcategory) {
        this.vehicleSubcategory = vehicleSubcategory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
