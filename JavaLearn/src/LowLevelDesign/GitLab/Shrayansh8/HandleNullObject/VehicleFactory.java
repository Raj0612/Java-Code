package LowLevelDesign.GitLab.Shrayansh8.HandleNullObject;

public class VehicleFactory {


    static Vehicle getVehicleObject(String typeOfVehicle){

        if("Car".equals(typeOfVehicle)) {

            return new Car();
        }

        return new NullVehicle();
    }
}
