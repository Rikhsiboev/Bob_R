package OOP_design_interview_questions_solutionsv.vehicles;

import OOP_design_interview_questions_solutionsv.enums.VehicleSize;
import OOP_design_interview_questions_solutionsv.parking.ParkingSpot;

class Bus extends Vehicle {
    public Bus(String licensePlate) {
        this.vehicleSize = VehicleSize.LARGE;
        this.licensePlate = licensePlate;
        this.spotSize = 5;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.spotSize == VehicleSize.LARGE;
    }
}