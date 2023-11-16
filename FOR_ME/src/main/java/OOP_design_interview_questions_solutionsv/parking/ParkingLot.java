package OOP_design_interview_questions_solutionsv.parking;

import OOP_design_interview_questions_solutionsv.parking.vehicles.Vehicle;

import java.util.List;


class ParkingLot {
    int numLevels;
    List<Level> levels;

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
//            if (level.parkVehicle(vehicle)) {
//                return true;
//            }
        }
        return false;
    }
}

