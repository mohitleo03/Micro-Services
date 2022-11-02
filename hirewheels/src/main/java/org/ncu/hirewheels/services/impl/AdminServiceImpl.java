package org.ncu.hirewheels.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.ncu.hirewheels.dto.Request.AvailablityStatus;
import org.ncu.hirewheels.dto.Request.VehicleDto;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.entities.VehicleSubcategory;
import org.ncu.hirewheels.repository.VehicleRepository;
import org.ncu.hirewheels.repository.VehicleSubcategoryRepository;
import org.ncu.hirewheels.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    VehicleSubcategoryRepository vehicleSubcategoryRepository;

    @Override
    @Transactional
    public VehicleDto registerVehicle(VehicleDto vehicleDto) {
        try {
            Optional<VehicleSubcategory> vehicleSubcategory = vehicleSubcategoryRepository
                    .findById(vehicleDto.getVehicleSubcategoryId());
            if (vehicleSubcategory.isPresent()) {
                Vehicle vehicle = new Vehicle(vehicleDto.getVehicle_model(), vehicleDto.getVehicle_number(),
                        vehicleDto.getColor(), vehicleDto.getAvailability_status(), vehicleDto.getVehicle_image_url(),
                        vehicleSubcategory.get(), null, null);
                vehicleRepository.save(vehicle);
                return vehicleDto;
            }
        } catch (Exception e) {
            throw e;
        }
        return vehicleDto;
    }

    @Override
    @Transactional
    public VehicleDto changeAvailability(Integer vehicle_id, AvailablityStatus availablityStatus) throws Exception {
        try {
            Optional<Vehicle> vehicle = vehicleRepository.findById(vehicle_id);
            if (vehicle.isPresent()) {
                Vehicle vehicle2 = vehicle.get();
                Integer vehicle_availability_toSet = availablityStatus.getAvailabilityStatus();
                vehicle2.setAvailability_status(vehicle_availability_toSet);
                Vehicle vehicle3 = vehicleRepository.save(vehicle2);
                VehicleSubcategory vehicleSubcategory = vehicle3.getVehicleSubcategory();
                VehicleDto vehicleDto = new VehicleDto(vehicle3.getVehicle_model(), vehicle3.getVehicle_number(),
                        vehicle3.getColor(), vehicle3.getAvailability_status(), vehicle3.getVehicle_image_url(),
                        vehicleSubcategory.getVehicle_subcategory_id());
                return vehicleDto;
            } else {
                throw new Exception("Vehicle Not Found");
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
