package LowLevelDesign.GeekForGeeks.DesignParkingLot.parkingspot;

public abstract class ParkingSpot {

    private int id;
    private boolean isFree;

    public ParkingSpot(int id){
        this.id = id;
        isFree = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
