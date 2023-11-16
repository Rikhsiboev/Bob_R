package OOP_design_interview_questions_solutionsv.parking;



import OOP_design_interview_questions_solutionsv.parking.vehicles.Vehicle;

import java.util.List;


public class Level {
    static final int SPOTS_PER_ROW = 10;
    int floor;
    int numSpots;
    int availableSpots;
    List<ParkingSpot> parkingSpots;

    public void spotFreed() {
        availableSpots++;
    }

//    public boolean parkVehicle(Vehicle vehicle) {
//        ParkingSpot spot = findAvailableSpot(vehicle);
//        if (spot == null) {
////            return null;
//        } else {
//            spot.parkVehicle(vehicle);
//            return spot.isAvailable();
//        }
//
//    }
//
//    private ParkingSpot findAvailableSpot(Vehicle vehicle) {
//        // Find an available spot where vehicle can fit, or return null
//        // ...
//    }

    private void parkStartingAtSpot(ParkingSpot spot, Vehicle vehicle) {
        // Occupy starting at spot.spotNumber to vehicle.spotSize
        // ...
    }
}

