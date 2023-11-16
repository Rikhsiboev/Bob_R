package OOP_design_interview_questions_solutionsv.parking.vehicles;

import OOP_design_interview_questions_solutionsv.parking.enums.VehicleSize;
import OOP_design_interview_questions_solutionsv.parking.ParkingSpot;

class Car extends Vehicle {
    public Car(String licensePlate) {
        this.vehicleSize = VehicleSize.COMPACT;
        this.licensePlate = licensePlate;
        this.spotSize = 1;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return (spot.spotSize == VehicleSize.LARGE || spot.spotSize == VehicleSize.COMPACT);
    }
}