package carPark;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import static java.lang.String.format;
import static java.lang.String.format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/*
 * implementing	a	class	called	WestminsterCarParkManager,	which	extends	the	interface	CarParkManager.	
 * WestminsterCarParkManager	maintains	the	list	of	the	vehicles	currently	in	the	parking.
 *
 * */

//westminster interface implements  car park manager class

public class WestminsterCarParkManager implements CarParkManager {
	Scanner sc = new Scanner(System.in);
	static ArrayList<Vehicle> vehicle = new ArrayList<Vehicle>(20);
	Vehicle[] array; // creating the vehicle array

	static int numVehicle = 0;
	static int freeSlots;

	static long hour;
	static long longtime = 0;
	static String longid;
	static String longtype;

	static String id;
	static String type;

	static String startDate;
	static String stopDate;
	static String stopTime;
	static String finalDate;

	// static String Id;

	// menu of car park system
	public void menu() {

		System.out.println("Make your choice - Please enter the letter assigned");
		System.out.println("A - To add new vehicle");
		System.out.println("D - To delete a vehicle");
		System.out.println("L - Currently parked vehicle list");
		System.out.println("P - Vehicle types in percentage");
		System.out.println("T - Vehicle with hte longest parking time");
		String se = sc.next();

		switch (se.toUpperCase()) {
		case "A":
			AddVehicle();
			break;
		case "D":
			DeleteVehicle();
			break;
		case "L":
			DispalyVehicleList();
			break;
		case "P":
			PercentageOfVehicle();
			break;
		case "T":
			LongestPakedVehicle();
			break;

		default:
			System.out.println("Invalid Input");
			menu();
		}

	}

	// adding the vehicle to the park if there are free slots

	public void AddVehicle() {

		freeSlots = 19 - numVehicle;
		System.out.println("");
		System.out.println("");
		System.out.println("Please Enter Valid Vehicle ID Plate No:");
		String vehId = sc.next();
		System.out.println("Please Enter Valid Vehicle Brand:");
		String vehBrand = sc.next();
		System.out.println("Please Enter Valid Entry Date: [Format:yyyy/mm/dd]");
		String vehDate = sc.next();
		System.out.println("Please Enter Valid Entry Time: [Format:hh/mm]");
		String vehTime = sc.next();

		System.out.println("----------------------------------------------");
		System.out.println("**********ADD VEHICLE TO CAR PARK*************");
		System.out.println("----------------------------------------------");
		System.out.println("1 - Add Car");
		System.out.println("2 - Add Van");
		System.out.println("3 - Add Motorbike");

		int choise1 = sc.nextInt();

		switch (choise1) {
		case 1:
			// mainly 20 slots are avalable in the car park
			
			

			if (numVehicle < 19) {

				System.out.println("Available Free Slots: " + freeSlots);

				System.out.println("********ADD CAR**************");
				// declaring the date time class

				DateTime dateTime = new DateTime();
				dateTime.setDate(vehDate);
				dateTime.setTime(vehTime);
				Car car = new Car(dateTime);
				// datetime tells when is the car entering to the car park
				car.setVehicleIdPlate(vehId);
				car.setVehicleBrand(vehBrand);
				
				

				System.out.println("");
				System.out.println("Please Enter Colour Of Car:");
				String carColor = sc.next();
				System.out.println("Please Enter Number Of Doors in Car:");

				String carNoOfDoors = sc.next();
				car.setNumOfDoors(carNoOfDoors);
				car.setColour(carColor);
				// set veh id and brand and etc to the class and dateTime
				
				// adding car for the vehicle
				vehicle.add(car);

				numVehicle++;

				car.getDateTime();
				// System.out.println(vehicle.toString());

				menu();

			} else {
				System.out.println("-------------CAR PARK IS FULL--------------");

				menu();
			}
			break;
		case 2:

			if (numVehicle < 18) {
				System.out.println("Available Free Slots: " + freeSlots);

				System.out.println("********ADD VAN**************");
				// declring datetime obj for the van
				DateTime dateTime2 = new DateTime();
				// van has datetime
				Van van = new Van(dateTime2);
				System.out.println("");
				System.out.println("Please Enter Valid Cargo Volume in Van: ");
				String vanCargoVol = sc.next();
				van.setVehicleIdPlate(vehId);
				van.setVehicleBrand(vehBrand);
				van.setCargoVolume(vanCargoVol);
				dateTime2.setDate(vehDate);
				dateTime2.setTime(vehTime);

				// adding van in the vehicle obj
				vehicle.add(van);
				vehicle.add(van);
				// van is allocating two slots
				numVehicle++;
				numVehicle++;

				menu();

			} else {
				System.out.println("-------------CAR PARK IS FULL--------------");

				menu();
			}
			break;
		case 3:

			if (numVehicle < 19) {

				System.out.println("Available Free Slots: " + freeSlots);
				System.out.println("");

				System.out.println("********ADD MOTORBIKE**************");
				// creating datetime obj for the motorbike
				DateTime dateTime3 = new DateTime();
				// motor bike has datetime obj
				Motorbike motorbike = new Motorbike(dateTime3);

				System.out.println("");
				System.out.println("Please Enter Valid Size Of Engine in Motorbike: ");
				String SizeOfEngine = sc.next();
				motorbike.setVehicleIdPlate(vehId);
				motorbike.setVehicleBrand(vehBrand);
				motorbike.setEngineSize(SizeOfEngine);
				dateTime3.setDate(vehDate);
				dateTime3.setTime(vehTime);

				vehicle.add(motorbike);
				numVehicle++;
				menu();
			} else {
				System.out.println("-------------CAR PARK IS FULL--------------");

				menu();
			}

			break;

		}

	}

	public void DeleteVehicle() {

		// DispalyVehicleList();
		System.out.println("Enter the vehicle ID that you want to delete: ");
		Scanner sc = new Scanner(System.in);
		String choice = sc.next();
		int arrayIndex = 0;
		boolean found = false;
		// use enhanced for loop
		for (Vehicle h : vehicle) {
			if (h.getVehicleIdPlate().equalsIgnoreCase(choice)) {
				// using tostring method for string represtation for the object
				startDate = (h.getDateTime()).toString();
				// print the leaving time
				System.out.println("Leaving Date Ex:yyyy/MM/dd");
				// DateTime dateTimeT = new DateTime();
				stopDate = sc.next();

				System.out.println("Leaving Time Ex:HH:mm");
				stopTime = sc.next();

				finalDate = (stopDate + " " + stopTime);
				// vehicle has vehicle id number
				id = h.getVehicleIdPlate();

				found = true;
				// print when no longer van is not in park
				if (h instanceof Van) {
					System.out.println("A van is leaving.");
					type = "Van";
				} else if (h instanceof Car) {
					System.out.println("A car is leaving.");
					type = "Car";
				} else if (h instanceof Motorbike) {
					System.out.println("A bike is leaving.");
					type = "Motorbike";
				}
				break;
			}
			arrayIndex++;
		}
		// finding the vehicle id that park so long time period

		if (found) {
			vehicle.remove(arrayIndex);
		} else {
			System.err.println("No such vehicle ID found.");
		}

		payment();
	}

	// vehicle payment
	public void payment() {
		// delcring parkind date and leving date to startdat
		String dateStart = startDate;
		String dateStop = finalDate;

		// HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);

			// in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			long hour24 = diffDays * 24;

			hour = hour24 + diffHours;

			if (hour >= 0) {

				if (hour > 3) {
					long nexthour = hour - 3;
					long price = nexthour + 9;
					System.out.println("$" + price + " parking charge");
				} else {
					long price2 = hour * 3;
					System.out.println("$" + price2 + " parking charge");
				}
			} else {
				System.out.println("Invalid time enterd");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		menu();
	}

	// method for displaying vehicle list currently parked.


	public void DispalyVehicleList() {

		array = new Vehicle[0];
		array = new Vehicle[vehicle.size()];
		int counter = 0;
		for (Vehicle h : vehicle) {
			array[counter] = h;
			counter++;
		}
		// use swapped cz the lis should displaying the last vehicle entered

		boolean swapped = true;

		int j = 0;
		Vehicle tmp;
		// swapping year
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < array.length - 1; i++) {

				String l = (array[i].getDateTime()).toString();
				// date and time
				String[] dateSeperater = (l.split("\\ "));

				String date = dateSeperater[0];
				String time = dateSeperater[1];
				// create date time object
				DateTime dateTime = new DateTime();

				dateTime.setDate(date);
				dateTime.setTime(time);

				int year1 = dateTime.getYear();

				String f = (array[i + 1].getDateTime()).toString();

				String[] dateSeperater1 = (f.split("\\ "));

				String date1 = dateSeperater1[0];
				String time1 = dateSeperater1[1];

				DateTime dateTime1 = new DateTime();

				dateTime.setDate(date1);
				dateTime.setTime(time1);

				int year2 = dateTime.getYear();

				if (year1 > year2) {
					tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
					swapped = true;
				}
			}
		}
		// swapping month
		swapped = true;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < array.length - 1; i++) {

				String l = (array[i].getDateTime()).toString();

				String[] dateSeperater = (l.split("\\ "));

				String date = dateSeperater[0];
				String time = dateSeperater[1];

				DateTime dateTime = new DateTime();

				dateTime.setDate(date);
				dateTime.setTime(time);

				int year1 = dateTime.getYear();
				int month1 = dateTime.getMonth();

				String f = (array[i + 1].getDateTime()).toString();

				String[] dateSeperater1 = (f.split("\\ "));

				String date1 = dateSeperater1[0];
				String time1 = dateSeperater1[1];

				DateTime dateTime1 = new DateTime();

				dateTime.setDate(date1);
				dateTime.setTime(time1);

				int year2 = dateTime.getYear();
				int month2 = dateTime.getMonth();

				if (year1 == year2) {
					if (month1 > month2) {
						tmp = array[i];
						array[i] = array[i + 1];
						array[i + 1] = tmp;
						swapped = true;
					}
				}
			}
		}
		// swapping date
		swapped = true;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < array.length - 1; i++) {

				String l = (array[i].getDateTime()).toString();

				String[] dateSeperater = (l.split("\\ "));

				String date = dateSeperater[0];
				String time = dateSeperater[1];

				DateTime dateTime = new DateTime();

				dateTime.setDate(date);
				dateTime.setTime(time);

				int year1 = dateTime.getYear();
				int month1 = dateTime.getMonth();
				int day1 = dateTime.getdate();

				String f = (array[i + 1].getDateTime()).toString();

				String[] dateSeperater1 = (f.split("\\ "));

				String date1 = dateSeperater1[0];
				String time1 = dateSeperater1[1];

				DateTime dateTime1 = new DateTime();

				dateTime.setDate(date1);
				dateTime.setTime(time1);

				int year2 = dateTime.getYear();
				int month2 = dateTime.getMonth();
				int day2 = dateTime.getdate();

				if (year1 == year2) {
					if (month1 == month2) {
						if (day1 > day2) {
							tmp = array[i];
							array[i] = array[i + 1];
							array[i + 1] = tmp;
							swapped = true;

						}
					}
				}
			}
		}

		swapped = true;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < array.length - 1; i++) {

				String l = (array[i].getDateTime()).toString();

				String[] dateSeperater = (l.split("\\ "));

				String date = dateSeperater[0];
				String time = dateSeperater[1];

				DateTime dateTime = new DateTime();

				dateTime.setDate(date);
				dateTime.setTime(time);

				int year1 = dateTime.getYear();
				int month1 = dateTime.getMonth();
				int day1 = dateTime.getdate();
				int hour1 = dateTime.getHour();

				String f = (array[i + 1].getDateTime()).toString();

				String[] dateSeperater1 = (f.split("\\ "));

				String date1 = dateSeperater1[0];
				String time1 = dateSeperater1[1];

				DateTime dateTime1 = new DateTime();

				dateTime.setDate(date1);
				dateTime.setTime(time1);

				int year2 = dateTime.getYear();
				int month2 = dateTime.getMonth();
				int day2 = dateTime.getdate();
				int hour2 = dateTime.getHour();

				if (year1 == year2) {
					if (month1 == month2) {
						if (day1 == day2) {
							if (hour1 > hour2) {
								tmp = array[i];
								array[i] = array[i + 1];
								array[i + 1] = tmp;
								swapped = true;
							}
						}
					}
				}

			}
		}

		swapped = true;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < array.length - 1; i++) {

				String l = (array[i].getDateTime()).toString();

				String[] dateSeperater = (l.split("\\ "));

				String date = dateSeperater[0];
				String time = dateSeperater[1];

				DateTime dateTime = new DateTime();

				dateTime.setDate(date);
				dateTime.setTime(time);

				int year1 = dateTime.getYear();
				int month1 = dateTime.getMonth();
				int day1 = dateTime.getdate();
				int hour1 = dateTime.getHour();
				int minute1 = dateTime.getMinute();

				String f = (array[i + 1].getDateTime()).toString();

				String[] dateSeperater1 = (f.split("\\ "));

				String date1 = dateSeperater1[0];
				String time1 = dateSeperater1[1];

				DateTime dateTime1 = new DateTime();

				dateTime.setDate(date1);
				dateTime.setTime(time1);

				int year2 = dateTime.getYear();
				int month2 = dateTime.getMonth();
				int day2 = dateTime.getdate();
				int hour2 = dateTime.getHour();
				int minute2 = dateTime.getMinute();

				if (year1 == year2) {
					if (month1 == month2) {
						if (day1 == day2) {
							if (hour1 == hour2) {
								if (minute1 > minute2) {
									tmp = array[i];
									array[i] = array[i + 1];
									array[i + 1] = tmp;
									swapped = true;
								}
							}
						}
					}
				}

			}
		}

		for (int i = 0; i < vehicle.size(); i++) {
			System.out.println(array[i].getVehicleIdPlate());
			System.out.println(array[i].getDateTime());

//			if (array[i] instanceof Van) {
//				System.out.println("A van is leaving.");
//			} else if (array[i] instanceof Car) {
//				System.out.println("A car is leaving.");
//			} else if (array[i] instanceof Motorbike) {
//				System.out.println("A bike is leaving.");
//			}
			System.out.println("  ");
		}

		menu();

	}



	// calculating percentage of cars ,vans,bikes currently parked.

	public void PercentageOfVehicle() {

		int carCount = 0;
		int vanCount = 0;
		int motorbikeCount = 0;

		for (Vehicle h : vehicle) {
			if (h != null) {
				if (h instanceof Van) {
					vanCount++;
				} else if (h instanceof Car) {
					carCount++;
				} else if (h instanceof Motorbike) {
					motorbikeCount++;
				}
			}
		}

		int total = carCount + vanCount + motorbikeCount;

		System.out.println("  ");
		System.out.println("Cars Preantage" + carCount / total * 100 + "%");
		System.out.println("Vans Preantage" + vanCount / total * 100 + "%");
		System.out.println("Motorbikes Preantage" + motorbikeCount / total * 100 + "%");
		System.out.println("  ");
		menu();
	}

	// method vehcile is passing for a long time and last veh that was paarked

	public void longstvehicle() {
		if (longtime < hour) {
			longtime = hour;
			// if its lesser than hour type and id will be record
			longid = id;
			longtype = type;
			menu();
		}

	}

	
	public void LongestPakedVehicle() {

		System.out.println(longid);
		System.out.println(longtype);
		System.out.println(longtime);
		menu();
	}

}
