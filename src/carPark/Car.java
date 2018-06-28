package carPark;
import carPark.DateTime;
import carPark.Vehicle;

public class Car extends Vehicle {
    
    
   private  String VehicleType = "Car";
   private  String NumOfDoors;
   private  String CarColor;
  

    public Car(DateTime VehicleInTime) {
        super(VehicleInTime);
    }

    public String getNumOfDoors() {
        return NumOfDoors;
  
    }

    public void setNumOfDoors(String NumDoors) {
        this.NumOfDoors = NumDoors;
    }

    public String getColour() {
        return CarColor;
    }

    public void setColour(String colour) {
        this.CarColor = colour;

    }

    public String toString() {
        return "ID : " + getVehicleIdPlate() + "\n" + " Brand : " + getVehicleBrand() + "\n" + " Number Of Doors : " + getNumOfDoors();
    }
}
