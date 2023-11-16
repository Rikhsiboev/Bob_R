package OOP_design_interview_questions_solutionsv.vehicles;

import OOP_design_interview_questions_solutionsv.enums.VehicleSize;
import OOP_design_interview_questions_solutionsv.parking.ParkingSpot;

import java.util.List;

public abstract class Vehicle {
    VehicleSize vehicleSize;
    String licensePlate;
    int spotSize;
    List<ParkingSpot> spotsTaken;

    public void parkInSpot(ParkingSpot spot) {
        spotsTaken.add(spot);
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
}