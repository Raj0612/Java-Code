package Educative.Locker1;

import Educative.Locker1.enums.LockerSize;
import Educative.Locker1.impl.*;
import Educative.Locker1.interfaces.LockerRepository;
import Educative.Locker1.model.Locker;
import Educative.Locker1.model.Parcel;
import Educative.Locker1.model.User;
import Educative.Locker1.service.LockerService;

import java.util.*;

public class LockerDemo {
    public static void main(String[] args) throws InterruptedException {
        LockerRepository repo = new InMemoryLockerRepository();
        LockerService service = LockerService.getInstance(repo);
        service.registerListener(new ConsoleNotificationListener());

        // Create lockers
        repo.save(new Locker.Builder("L1", LockerSize.SMALL).build());
        repo.save(new Locker.Builder("L2", LockerSize.MEDIUM).build());
        repo.save(new Locker.Builder("L3", LockerSize.LARGE).build());

        // Create users
        User alice = new User("U1", "Alice", "alice@example.com");

        // Create parcel
        Parcel parcel = new Parcel.Builder(alice)
                .weight(2.5)
                .length(30)
                .width(20)
                .height(15)
                .build();

        // Reserve locker
        Locker reserved = service.reserveLocker(LockerSize.SMALL, alice);
        System.out.println("Reserved: " + reserved);

        // Store parcel
        service.storeParcel(reserved.getId(), parcel);
        System.out.println("Stored parcel: " + parcel);

        // Pickup
        Parcel picked = service.pickupParcel(reserved.getId(), alice);
        System.out.println("Picked up parcel: " + picked);

        // Force release scenario (simulate admin unlock)
        service.forceRelease("L2");
    }
}
