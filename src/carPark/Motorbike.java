package carPark;

import carPark.Vehicle;

public class Motorbike extends Vehicle {
    
   private  String VehicleType = "Motorbike";
   private  String BikeCC;
  

    public Motorbike(DateTime VehicleInTime) {
        super(VehicleInTime);
    }


    public String getEngineSize() {
        return BikeCC;
    }

    public void setEngineSize(String EngineSize) {
        this.BikeCC = EngineSize;
    }

    public String toString() {
        return "ID : " + getVehicleIdPlate() + "\n" + " Brand : " + getVehicleBrand() + "\n" + " Engine Capacity : " + getEngineSize();
    } 
   

}
