package org.ncu.hirewheels.dto.Request;

import java.util.Date;

public class BookingDto {
    private Date pickup_date;
    private Date dropoff_date;
    private Date booking_date;
    private Integer amount;
    private Integer locationId;
    private Integer vehicleId;
    private Integer userId;

    public BookingDto(Date pickup_date, Date dropoff_date, Date booking_date, Integer amount, Integer locationId,
            Integer vehicleId, Integer userId) {
        this.pickup_date = pickup_date;
        this.dropoff_date = dropoff_date;
        this.booking_date = booking_date;
        this.amount = amount;
        this.locationId = locationId;
        this.vehicleId = vehicleId;
        this.userId = userId;
    }

    public Date getPickup_date() {
        return pickup_date;
    }

    public Date getDropoff_date() {
        return dropoff_date;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setPickup_date(Date pickup_date) {
        this.pickup_date = pickup_date;
    }

    public void setDropoff_date(Date dropoff_date) {
        this.dropoff_date = dropoff_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
