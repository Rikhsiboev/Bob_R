package OOP_design_interview_questions_solutionsv.parking;

import OOP_design_interview_questions_solutionsv.parking.enums.VehicleSize;
import OOP_design_interview_questions_solutionsv.parking.vehicles.Vehicle;


public class ParkingSpot {
    Level level;
    int row;
    int spotNumber;
    public VehicleSize spotSize;
    VehicleSize vehicleSize;
    Vehicle vehicle;

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        if (this.vehicle != null) {
            return false;
        }
        return vehicle.canFitInSpot(this);
    }

    public void parkVehicle(Vehicle vehicle) {
        // ...
    }

    public void removeVehicle() {
        // ...
    }
}
