package Educative.Locker1.model;

import Educative.Locker1.enums.LockerSize;
import Educative.Locker1.enums.LockerStatus;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

public class Locker {
    private final String id;
    private final LockerSize size;
    private LockerStatus status;
    private User assignedUser;
    private Parcel parcel;

    private Locker(Builder builder) {
        this.id = builder.id;
        this.size = builder.size;
        this.status = LockerStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public LockerSize getSize() {
        return size;
    }

    public LockerStatus getStatus() {
        return status;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public boolean isAvailable() {
        return status == LockerStatus.AVAILABLE;
    }

    public void reserve(User user) {
        if (!isAvailable()) throw new IllegalStateException("Locker not available");
        this.assignedUser = user;
        this.status = LockerStatus.RESERVED;
    }

    public void storeParcel(Parcel parcel) {
        if (status != LockerStatus.RESERVED) throw new IllegalStateException("Locker not reserved");
        this.parcel = parcel;
        this.status = LockerStatus.OCCUPIED;
        parcel.assignToLocker(this.id);
    }

    public void release() {
        this.assignedUser = null;
        this.parcel = null;
        this.status = LockerStatus.AVAILABLE;
    }

    // === Builder ===
    public static class Builder {
        private final String id;
        private final LockerSize size;

        public Builder(String id, LockerSize size) {
            this.id = id;
            this.size = size;
        }

        public Locker build() {
            return new Locker(this);
        }
    }

    @Override
    public String toString() {
        return "Locker{" +
                "id='" + id + '\'' +
                ", size=" + size +
                ", status=" + status +
                ", user=" + (assignedUser != null ? assignedUser.name() : "none") +
                ", parcel=" + (parcel != null ? parcel.getTrackingNumber() : "none") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Locker)) return false;
        Locker locker = (Locker) o;
        return id.equals(locker.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
