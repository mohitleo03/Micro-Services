package org.ncu.hirewheels.dto.Request;

public class VehicleDto {
    private String vehicle_model;
    private String vehicle_number;
    private String color;
    private Integer availability_status;
    private String vehicle_image_url;
    private Integer vehicleSubcategoryId;
    public VehicleDto(String vehicle_model, String vehicle_number, String color, Integer availability_status,
            String vehicle_image_url, Integer vehicleSubcategoryId) {
        this.vehicle_model = vehicle_model;
        this.vehicle_number = vehicle_number;
        this.color = color;
        this.availability_status = availability_status;
        this.vehicle_image_url = vehicle_image_url;
        this.vehicleSubcategoryId = vehicleSubcategoryId;
    }
    public VehicleDto() {
    }
    public String getVehicle_model() {
        return vehicle_model;
    }
    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }
    public String getVehicle_number() {
        return vehicle_number;
    }
    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Integer getAvailability_status() {
        return availability_status;
    }
    public void setAvailability_status(Integer availability_status) {
        this.availability_status = availability_status;
    }
    public String getVehicle_image_url() {
        return vehicle_image_url;
    }
    public void setVehicle_image_url(String vehicle_image_url) {
        this.vehicle_image_url = vehicle_image_url;
    }
    public Integer getVehicleSubcategoryId() {
        return vehicleSubcategoryId;
    }
    public void setVehicleSubcategoryId(Integer vehicleSubcategoryId) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
    }
}
