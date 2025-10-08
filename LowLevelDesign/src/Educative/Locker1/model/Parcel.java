package Educative.Locker1.model;

import Educative.Locker1.enums.ParcelStatus;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Parcel {
    private final String parcelId;
    private final double weight; // in kg
    private final double length;  // in cm
    private final double width;   // in cm
    private final double height;  // in cm
    private final User owner;
    private final String trackingNumber;
    private ParcelStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
    private String lockerId;

    private Parcel(Builder builder) {
        this.parcelId = UUID.randomUUID().toString();
        this.trackingNumber = generateTrackingNumber();
        this.owner = builder.owner;
        this.weight = builder.weight;
        this.length = builder.length;
        this.width = builder.width;
        this.height = builder.height;
        this.status = ParcelStatus.REGISTERED;
        this.createdAt = LocalDateTime.now();
        this.lastUpdated = LocalDateTime.now();
    }

    private String generateTrackingNumber() {
        return "TRK" + UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase();
    }

    public double getVolume() {
        return length * width * height;
    }

    public boolean isOversized(double maxDimension) {
        return length > maxDimension || width > maxDimension || height > maxDimension;
    }

    public boolean isOverweight(double maxWeight) {
        return weight > maxWeight;
    }

    public void updateStatus(ParcelStatus newStatus) {
        this.status = newStatus;
        this.lastUpdated = LocalDateTime.now();
    }

    public void assignToLocker(String lockerId) {
        this.lockerId = lockerId;
        updateStatus(ParcelStatus.IN_LOCKER);
    }

    public void releaseFromLocker() {
        this.lockerId = null;
        updateStatus(ParcelStatus.DELIVERED);
    }

    // === Getters ===
    public String getParcelId() {
        return parcelId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public User getOwner() {
        return owner;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public ParcelStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public String getLockerId() {
        return lockerId;
    }

    // === Builder ===
    public static class Builder {
        private final User owner;
        private double weight;
        private double length;
        private double width;
        private double height;

        public Builder(User owner) {
            this.owner = owner;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder length(double length) {
            this.length = length;
            return this;
        }

        public Builder width(double width) {
            this.width = width;
            return this;
        }

        public Builder height(double height) {
            this.height = height;
            return this;
        }

        public Parcel build() {
            return new Parcel(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parcel)) return false;
        Parcel parcel = (Parcel) o;
        return parcelId.equals(parcel.parcelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parcelId);
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "parcelId='" + parcelId + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", status=" + status +
                ", lockerId='" + (lockerId != null ? lockerId : "Not assigned") + '\'' +
                '}';
    }
}
