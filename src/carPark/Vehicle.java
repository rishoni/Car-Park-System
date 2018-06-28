package carPark;

public abstract class Vehicle {
   
    DateTime dateNtime;
    
     String VehiclePlateID;
     String VehicleBrand;
     private  DateTime VehicleCheckInTime;
     
  
     
    Vehicle (DateTime CheckInTime){
    this.VehicleCheckInTime  = CheckInTime;
    
    }

    public DateTime getDateTime() {
        return VehicleCheckInTime;
    }
   
    public String getVehicleIdPlate() {
        return VehiclePlateID;
    }

    public void setVehicleIdPlate(String PlateID) {
        this.VehiclePlateID = PlateID;

    }

    // public abstract DateTime getDateTime();

   public void setDateTime(DateTime DateTime) {
        this.dateNtime = DateTime;

    }
    

    public String getVehicleBrand() {
        return VehicleBrand;
    }

     public void setVehicleBrand(String Brand) {
        this.VehicleBrand = Brand;

    }

	public String toString() {
	    return "ID : " + getVehicleIdPlate() + "\n" + " Brand : " + getVehicleBrand() + "\n" + " Cargo Volume : " + getCargoVolume();
	}

	private String getCargoVolume() {
		// TODO Auto-generated method stub
		return null;
	}

	
   

}
