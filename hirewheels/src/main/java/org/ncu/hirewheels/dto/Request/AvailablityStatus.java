package org.ncu.hirewheels.dto.Request;

public class AvailablityStatus {
    private Integer availabilityStatus;

    public AvailablityStatus(Integer availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public AvailablityStatus() {
    }

    public Integer getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(Integer availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

}
