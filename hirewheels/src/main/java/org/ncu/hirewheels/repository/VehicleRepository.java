package org.ncu.hirewheels.repository;

import java.util.List;

import org.ncu.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("select v from Vehicle v where v.availability_status = 1")
    public List<Vehicle> getAllAvailableVehicles();
}
