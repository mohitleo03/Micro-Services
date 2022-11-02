package org.ncu.hirewheels.controller;

import org.ncu.hirewheels.dto.Request.BookingDto;
import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hirewheels/v1")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping(value = "/bookings", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingDto> addBooking(@RequestBody BookingDto bookingDto) {
        try {
            BookingDto curr_booking = bookingService.addBooking(bookingDto);
            return new ResponseEntity<BookingDto>(curr_booking, HttpStatus.CREATED);
        } catch (Exception e) {
            throw e;
        }
    }


}
