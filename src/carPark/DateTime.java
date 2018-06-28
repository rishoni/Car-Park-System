package carPark;
import java.util.Scanner;

public class DateTime {
    //date time class to determine the time and date of vehicle parking period
    static Scanner sc = new Scanner(System.in);
		String yearCheck = "[2-9]\\d{3}";
		String monthCheck = "(0[1-9]|1[0-2])";
		String dateCheck = "((1|2)\\d|3(0|1)|0[1-9]|[1-9])";
		
		String hourCheck = "([0|1]\\d|2[0-4])";
		String minuteCheck ="([0-5]\\d|60)";
		
		private int year;
		private int month;
		private int date;
		private int hour;
		private int minute;
		
		
		
		public void setDate(String userDate){
			if(userDate.matches(yearCheck + "\\/"+monthCheck +"\\/" + dateCheck)){
				String[] YYMMDD = (userDate.split("\\/"));
				 year = Integer.parseInt(YYMMDD[0]);//Returns an Integer object holding the value of the this String 
				 month = Integer.parseInt(YYMMDD[1]);
				 date = Integer.parseInt(YYMMDD[2]);
			}
		}
		
	//setting the user time
		
		public void setTime(String userTime){
			if(userTime.matches(hourCheck + "\\:"+minuteCheck )){
				String[] HHMM = (userTime.split("\\:"));
				 hour = Integer.parseInt(HHMM[0]);
				 minute = Integer.parseInt(HHMM[1]);
				
			
			}}
		
		public int getYear(){
			return year ;
		}
		public int getMonth(){
			return month ;
		}
		public int getdate(){
			return date ;
		}
		public int getHour(){
			return hour ;
		}
		public int getMinute(){
			return minute ;
		}
		
                
		
	
		public String toString(){
			return String.format("%d/%d/%d %d:%d", year,month,date,hour,minute);
		}
		

		
		
    
    
}
