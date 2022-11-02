package org.ncu.hirewheels.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id", columnDefinition = "numeric(10)")
    private Integer booking_id;

    @Column(name = "pickup_date", columnDefinition = "date", nullable = false)
    private Date pickup_date;

    @Column(name = "dropoff_date", columnDefinition = "date", nullable = false)
    private Date dropoff_date;

    @Column(name = "booking_date", columnDefinition = "date", nullable = false)
    private Date booking_date;

    @Column(name = "amount", columnDefinition = "numeric(10,2)", nullable = false)
    private Integer amount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", columnDefinition = "numeric(10)", nullable = false)
    private Location location;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", columnDefinition = "numeric(10)", nullable = false)
    private Vehicle vehicle;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "numeric(10)", nullable = false)
    private User user;


    public Booking(Date pickup_date, Date dropoff_date, Date booking_date, Integer amount, Location location,
            Vehicle vehicle, User user) {
        this.pickup_date = pickup_date;
        this.dropoff_date = dropoff_date;
        this.booking_date = booking_date;
        this.amount = amount;
        this.location = location;
        this.vehicle = vehicle;
        this.user = user;
    }

    public Integer getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Integer booking_id) {
        this.booking_id = booking_id;
    }

    public Date getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(Date pickup_date) {
        this.pickup_date = pickup_date;
    }

    public Date getDropoff_date() {
        return dropoff_date;
    }

    public void setDropoff_date(Date dropoff_date) {
        this.dropoff_date = dropoff_date;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
