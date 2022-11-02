package org.ncu.hirewheels.services;

import java.util.List;

import org.ncu.hirewheels.entities.Vehicle;

public interface VehicleService {
    public List<Vehicle> getAllVehicles();
    public List<Vehicle> getAvailableVehicles();
}
