package Educative.Locker1.impl;

import Educative.Locker1.interfaces.NotificationListener;
import Educative.Locker1.model.Locker;
import Educative.Locker1.model.Parcel;

public class ConsoleNotificationListener implements NotificationListener {

    @Override
    public void onReserved(Locker locker) {
        System.out.println("🔔 Reserved: " + locker);
    }

    @Override
    public void onReleased(Locker locker, Parcel parcel) {
        System.out.println("🔔 Released: " + locker + " with parcel " + parcel);
    }
}
