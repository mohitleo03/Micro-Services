package org.ncu.hirewheels.services;

import org.ncu.hirewheels.dto.Request.AvailablityStatus;
import org.ncu.hirewheels.dto.Request.VehicleDto;
import org.springframework.boot.availability.AvailabilityState;

public interface AdminService {
    public VehicleDto registerVehicle(VehicleDto vehicleDto);
    public VehicleDto changeAvailability(Integer vehicle_id, AvailablityStatus availabilityStatus) throws Exception;
}
