package org.ncu.hirewheels.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.ncu.hirewheels.dto.Request.BookingDto;
import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.Location;
import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.repository.BookingRepository;
import org.ncu.hirewheels.repository.LocationRepository;
import org.ncu.hirewheels.repository.UserRepository;
import org.ncu.hirewheels.repository.VehicleRepository;
import org.ncu.hirewheels.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    @Transactional
    public BookingDto addBooking(BookingDto booking) {
        try {
            Optional<Location> location = locationRepository.findById(booking.getLocationId());
            Optional<User> user = userRepository.findById(booking.getUserId());
            Optional<Vehicle> vehcle = vehicleRepository.findById(booking.getVehicleId());
            Booking booking2 = new Booking(booking.getPickup_date(), booking.getDropoff_date(), booking.getBooking_date(), booking.getAmount(), location.get(), vehcle.get(), user.get());
            return booking;
        } catch (Exception e) {
            throw e;
        }
    }

}
