package com.incubationtasks.daystime;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

import utilities.InvalidInputException;

public class DaysTimeRun {

		public static void main(String... args) {
			 Scanner scan=new Scanner(System.in);
			 DaysTime daysTime=new DaysTime();
			 Logger logger=Logger.getLogger(DaysTimeRun.class.getName());
			 int x=1;
				do {
				logger.log(Level.INFO,"Enter the number to choose the operation to be done:  (1-5)");
				int option=scan.nextInt();
				scan.nextLine();
				switch(option) {
			
				case 1:
					try {
						logger.log(Level.INFO,"The Current Time and Date is: "+daysTime.currentTimeAndDate());
					}catch (InvalidInputException e) {
						e.printStackTrace();
					}break;
						
				case 2:
					try {
						logger.log(Level.INFO,"The Current Time in MilliSeconds is: "+daysTime.currentTimeWithMilliSeconds());
					}catch(DateTimeException d2) {
						d2.printStackTrace();
					}catch(InvalidInputException i2){
						i2.printStackTrace();
					}
					
					break;
						
				case 3:
					try {
						logger.log(Level.INFO,daysTime.getAvailableZoneIds().toString());
						logger.log(Level.INFO,"The Zone ID of your desired zone is: ");
						ZoneId zoneId=daysTime.getZoneId(scan.nextLine());
						logger.log(Level.INFO,"The Time in the Zone: "+daysTime.getDateTimeInTheZone(zoneId));
					}catch(InvalidInputException i3) {
						i3.printStackTrace();
					}
						break;
						
				case 4:
					logger.log(Level.INFO,"Do you wish to give own time: (yes/no)");
					String choice4=scan.nextLine();
					logger.log(Level.INFO,daysTime.getAvailableZoneIds().toString());
					logger.log(Level.INFO,"The Zone ID of your desired zone is: ");
					String zone=scan.nextLine();
					ZoneId zoneId4;
					try {
					if(choice4=="no") {
						zoneId4=daysTime.getZoneId(zone);
						logger.log(Level.INFO,"The Time in the Zone: "+daysTime.getDateTimeInTheZone(zoneId4));
						logger.log(Level.INFO,"The Day: "+daysTime.getDayOfWeekAtTime(zoneId4));
					}else if(choice4=="yes"){
						logger.log(Level.INFO,"Enter Time: (dd-mm-yyyy hh:mm:ss)");
						String dateTime=scan.nextLine();
						zoneId4=daysTime.getZoneId(zone);
						logger.log(Level.INFO,"The Day: "+daysTime.getDayOfWeekAtTime(dateTime,zoneId4));
						}
					
					
					}catch(DateTimeParseException d4) {
						d4.printStackTrace();
					}catch(InvalidInputException i4) {
						i4.printStackTrace();
					}break;
					
				case 5:
					logger.log(Level.INFO,"Do you wish to give own time: (yes/no)");
					String choice5=scan.nextLine();
					logger.log(Level.INFO,daysTime.getAvailableZoneIds().toString());
					logger.log(Level.INFO,"The Zone ID of your desired zone is: ");
					String zone5=scan.nextLine();
					ZoneId zoneId5;
					try {
					if(choice5=="no") {
							zoneId5=daysTime.getZoneId(zone5);
							logger.log(Level.INFO,"The Time in the Zone: "+daysTime.getDateTimeInTheZone(zoneId5));
							logger.log(Level.INFO,"The Day: "+daysTime.getMonthOfDateTime(zoneId5));
						
					}else if(choice5=="yes"){
						logger.log(Level.INFO,"Enter Time: (dd-mm-yyyy hh:mm:ss)");
						String dateTime5=scan.nextLine();
						zoneId5=daysTime.getZoneId(zone5);
						logger.log(Level.INFO,"The Day: "+daysTime.getMonthOfDateTime(dateTime5,zoneId5));
						
					}
					}catch(DateTimeParseException d5) {
						d5.printStackTrace();
					}catch(InvalidInputException i5) {
						i5.printStackTrace();
					}
					break;
					
				case 6:
					logger.log(Level.INFO,"Do you wish to give own time: (yes/no)");
					String choice6=scan.nextLine();
					logger.log(Level.INFO,daysTime.getAvailableZoneIds().toString());
					logger.log(Level.INFO,"The Zone ID of your desired zone is: ");
					String zone6=scan.nextLine();
					ZoneId zoneId6;
					try {
					if(choice6=="no") {
							zoneId6=daysTime.getZoneId(zone6);
							logger.log(Level.INFO,"The Time in the Zone: "+daysTime.getDateTimeInTheZone(zoneId6));
							logger.log(Level.INFO,"The Day: "+daysTime.getYearOfDateTime(zoneId6));
					}else if(choice6=="yes"){
						logger.log(Level.INFO,"Enter Time: (dd-mm-yyyy hh:mm:ss)");
						String dateTime6=scan.nextLine();
						zoneId6=daysTime.getZoneId(zone6);
						logger.log(Level.INFO,"The day: "+ daysTime.getYearOfDateTime(dateTime6,zoneId6));
					}
					}catch(DateTimeParseException d6) {
						d6.printStackTrace();
					}
					catch(InvalidInputException i6) {
						i6.printStackTrace();
					}
					break;
				}
		
					
				}while(x==1);
				scan.close();
	}
}
