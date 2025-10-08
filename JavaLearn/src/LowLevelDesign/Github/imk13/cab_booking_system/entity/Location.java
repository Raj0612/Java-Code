package LowLevelDesign.Github.imk13.cab_booking_system.entity;

public class Location {
  Integer x;
  Integer y;

  public Location(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }

  public Integer getX() {
    return x;
  }

  public Integer getY() {
    return y;
  }

  public void setX(Integer x) {
    this.x = x;
  }

  public void setY(Integer y) {
    this.y = y;
  }

  @Override
  public String toString(){
    return  "[Location:" + " x=" + this.x + " y=" + this.y + "]";
  }
}
