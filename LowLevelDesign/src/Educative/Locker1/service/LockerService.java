package Educative.Locker1.service;
import Educative.Locker1.enums.*;
import Educative.Locker1.impl.FirstFitAllocationStrategy;
import Educative.Locker1.interfaces.LockerAllocationStrategy;
import Educative.Locker1.interfaces.LockerRepository;
import Educative.Locker1.interfaces.NotificationListener;
import Educative.Locker1.model.Locker;
import Educative.Locker1.model.Parcel;
import Educative.Locker1.model.User;

import java.util.*;

public class LockerService {
    private static LockerService INSTANCE;


    private final LockerRepository repo;
    private final LockerAllocationStrategy strategy;
    private final List<NotificationListener> listeners = new ArrayList<>();

    private LockerService(LockerRepository repo, LockerAllocationStrategy strategy) {
        this.repo = repo;
        this.strategy = strategy;
    }

    public static synchronized LockerService getInstance(LockerRepository repo) {
        if (INSTANCE == null) {
            INSTANCE = new LockerService(repo, new FirstFitAllocationStrategy());
        }
        return INSTANCE;
    }


    public static LockerService getInstance() {
        if (INSTANCE == null) throw new IllegalStateException("LockerService not initialized. Call init(...) first.");
        return INSTANCE;
    }

    public void registerListener(NotificationListener listener) {
        listeners.add(listener);
    }

    public List<Locker> findAvailable(LockerSize size) {
        return repo.findAvailable(size);
    }

    public synchronized Locker reserveLocker(LockerSize size, User user) {
        Locker locker = strategy.allocate(size, user, repo)
                .orElseThrow(() -> new IllegalStateException("No available locker of size " + size));
        locker.reserve(user);
        repo.save(locker);
        notifyReserved(locker);
        return locker;
    }
    public synchronized void storeParcel(String lockerId, Parcel parcel) {
        Locker locker = repo.findById(lockerId)
                .orElseThrow(() -> new IllegalArgumentException("Locker not found: " + lockerId));
        locker.storeParcel(parcel);
        repo.save(locker);
    }

    public synchronized Parcel pickupParcel(String lockerId, User user) {
        Locker locker = repo.findById(lockerId)
                .orElseThrow(() -> new IllegalArgumentException("Locker not found: " + lockerId));

        if (!user.equals(locker.getAssignedUser())) {
            throw new IllegalStateException("Locker is not assigned to this user");
        }

        Parcel parcel = locker.getParcel();
        if (parcel == null) {
            throw new IllegalStateException("No parcel inside locker " + lockerId);
        }

        parcel.releaseFromLocker();
        locker.release();
        repo.save(locker);

        notifyReleased(locker, parcel);
        return parcel;
    }

    public synchronized void forceRelease(String lockerId) {
        Locker locker = repo.findById(lockerId)
                .orElseThrow(() -> new IllegalArgumentException("Locker not found: " + lockerId));
        Parcel parcel = locker.getParcel();
        locker.release();
        repo.save(locker);
        notifyReleased(locker, parcel);
    }

    private void notifyReserved(Locker locker) {
        for (NotificationListener l : listeners) {
            try { l.onReserved(locker); } catch (Exception e) { e.printStackTrace(); }
        }
    }

    private void notifyReleased(Locker locker, Parcel parcel) {
        for (NotificationListener l : listeners) {
            try { l.onReleased(locker, parcel); } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
