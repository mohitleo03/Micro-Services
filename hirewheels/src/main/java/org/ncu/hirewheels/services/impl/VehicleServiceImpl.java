package org.ncu.hirewheels.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.repository.VehicleRepository;
import org.ncu.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    @Transactional
    public List<Vehicle> getAllVehicles() {
        try {
            return vehicleRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public List<Vehicle> getAvailableVehicles() {
        try {
            return vehicleRepository.getAllAvailableVehicles();
        } catch (Exception e) {
            throw e;
        }
    }

}
