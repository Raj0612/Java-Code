package Educative.Locker1.impl;

import Educative.Locker1.enums.LockerSize;
import Educative.Locker1.interfaces.LockerAllocationStrategy;
import Educative.Locker1.interfaces.LockerRepository;
import Educative.Locker1.model.Locker;
import Educative.Locker1.model.User;

import java.util.Optional;

public class FirstFitAllocationStrategy implements LockerAllocationStrategy {

    @Override
    public Optional<Locker> allocate(LockerSize size, User user, LockerRepository repo) {
        return repo.findAvailable(size).stream().findFirst();
    }
}
