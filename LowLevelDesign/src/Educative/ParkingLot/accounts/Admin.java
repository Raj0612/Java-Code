package Educative.ParkingLot.accounts;

import Educative.ParkingLot.enums.AccountStatus;
import Educative.ParkingLot.features.DisplayBoard;
import Educative.ParkingLot.features.Entrance;
import Educative.ParkingLot.features.*;
import Educative.ParkingLot.parkingspots.ParkingSpot;
import Educative.ParkingLot.system.ParkingLot;

public class Admin extends Account{
        public Admin(String userName, String password, Person person, AccountStatus status) {
                super(userName, password, person, status);
        }
        public boolean addParkingSpot(ParkingSpot spot) {
                return ParkingLot.getInstance().addParkingSpot(spot);
        }

        public boolean addDisplayBoard(DisplayBoard board) {
                return ParkingLot.getInstance().addDisplayBoard(board);
        }

        public boolean addEntrance(Entrance entrance) {
                return ParkingLot.getInstance().addEntrance(entrance);
        }

        public boolean addExit(Exit exit) {
                return ParkingLot.getInstance().addExit(exit);
        }

        // Will implement the functionality in this class
        @Override
        public boolean resetPassword() {
                // Reset password logic (dummy)
                System.out.println("Password reset for admin: " + getUserName());
                return true;
        }
}
