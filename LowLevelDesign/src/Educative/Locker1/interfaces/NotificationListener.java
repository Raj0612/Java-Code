package Educative.Locker1.interfaces;

import Educative.Locker1.model.Locker;
import Educative.Locker1.model.Parcel;
import Educative.Locker1.model.User;

public interface NotificationListener {
    void onReserved(Locker locker);
    void onReleased(Locker locker, Parcel parcel);
}
