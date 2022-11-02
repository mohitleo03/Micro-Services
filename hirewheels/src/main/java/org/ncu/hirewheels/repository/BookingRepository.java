package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
