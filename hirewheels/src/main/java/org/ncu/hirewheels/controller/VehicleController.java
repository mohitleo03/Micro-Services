package org.ncu.hirewheels.controller;

import java.util.List;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.impl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hirewheels/v1")
public class VehicleController {

    @Autowired
    VehicleServiceImpl vehicleServiceImpl;

    @GetMapping(value = "/vehicles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Vehicle>> getVehicles() {
        System.out.println("Prakhar Bansal");
        List<Vehicle> vehicles = vehicleServiceImpl.getAllVehicles();
        return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
    }

}
