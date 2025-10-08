package Educative.Locker1.interfaces;

import Educative.Locker1.enums.LockerSize;
import Educative.Locker1.model.Locker;
import Educative.Locker1.model.User;

import java.util.Optional;

public interface LockerAllocationStrategy {
    Optional<Locker> allocate(LockerSize size, User user, LockerRepository repo);
}
