package Educative.Locker1.interfaces;

import Educative.Locker1.enums.LockerSize;
import Educative.Locker1.model.Locker;

import java.util.*;

public interface LockerRepository {

    Optional<Locker> findById(String id);
    void save(Locker locker);
    List<Locker> findAll();
    List<Locker> findAvailable(LockerSize size);
}
