package carPark;
import carPark.Vehicle;

public class Van extends Vehicle {
    
    private  static String VehicleType = "Van";
    private  String VanCargo;

    public Van(DateTime VehicleInTime) {
        super(VehicleInTime);
    }
   
    public String getCargoVolume() {
        return VanCargo;
    }

    public void setCargoVolume(String cargoVol) {
        this.VanCargo = cargoVol;
    }
    
  
   
}
