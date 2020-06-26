package prep;

import java.time.*;    
import java.util.ArrayList;

/**
 * 7.4 Parking Lot 
 * 8/18/20
 */
public class ParkingLot {
    boolean full = false; 
    ArrayList<Spot> spots; 

    boolean isLotFull() {
        return full; 
    }

    public class Spot {
        boolean filled = false; 
        Vehicle filledBy; 

        boolean isSpotFilled() {
            return filled; 
        }
    }

    public class Vehicle {
        LocalDateTime timeEntered; 
        Spot spotTaken = null;
        boolean parked = false; 
        int spotsRequired;      // # spots required for car 

        Spot getSpot() {
            return spotTaken; 
        }

        int timeInLot() {
            LocalDateTime now = LocalDateTime.now();  
            return now.compareTo(timeEntered); 
        }

        int spotsRequired() {
            return spotsRequired; 
        }
        Vehicle(LocalDateTime t) {
            this.timeEntered = t; 
        }
    }

    class Car extends Vehicle {

        Car(LocalDateTime t) {
            super(t);
            this.spotsRequired = 1; 
        }
    }
}