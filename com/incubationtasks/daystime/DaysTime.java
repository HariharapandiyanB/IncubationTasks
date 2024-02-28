package com.incubationtasks.daystime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Set;

import utilities.InvalidInputException;
import utilities.UtilityTasks;

import java.time.ZoneId;



public class DaysTime {
	public LocalDateTime currentTimeAndDate() throws InvalidInputException{
		return LocalDateTime.now();
	}
	
	public ZonedDateTime getZonedDateAndTime(String dateTime,ZoneId zone) throws InvalidInputException,DateTimeParseException{
		UtilityTasks.checkNull(dateTime);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return ZonedDateTime.of(LocalDateTime.parse(dateTime, formatter), zone);
	}
	
	public String currentTimeWithMilliSeconds() throws InvalidInputException{
		LocalDateTime currentTime=currentTimeAndDate();
		int currentTime1=currentTime.getNano()/1000000;
		return currentTime.minusNanos(currentTime.getNano()).toString()+"."+currentTime1;
	}

	public ZonedDateTime getDateTimeInTheZone(ZoneId zone) throws InvalidInputException{
		UtilityTasks.checkNull(zone);
		return ZonedDateTime.now(zone);
	}
	
	
	public Set<String> getAvailableZoneIds(){
		return ZoneId.getAvailableZoneIds();
	}
	
	
	public ZoneId getZoneId(String zone) throws InvalidInputException{
		UtilityTasks.checkNull(zone);
		return ZoneId.of(zone);
	}
	
	public ZoneId getDefaultZone() {
		return ZoneId.systemDefault();
	}

	
	public DayOfWeek getDayOfWeekAtTime(String dateTime,ZoneId zone) throws InvalidInputException,DateTimeParseException{
		UtilityTasks.checkNull(dateTime);
		return getZonedDateAndTime(dateTime,zone).getDayOfWeek();
	}
	
	
	
	public DayOfWeek getDayOfWeekAtTime(ZoneId zone) throws InvalidInputException {
		UtilityTasks.checkNull(zone);
		return getDateTimeInTheZone(zone).getDayOfWeek();
	}
	
	
	
	public Month getMonthOfDateTime(String dateTime,ZoneId zone) throws InvalidInputException,DateTimeParseException{
		UtilityTasks.checkNull(dateTime);
		return getZonedDateAndTime(dateTime,zone).getMonth();
	}
	
	
	
	public Month getMonthOfDateTime(ZoneId zone) throws InvalidInputException {
		UtilityTasks.checkNull(zone);
		return  getDateTimeInTheZone(zone).getMonth();
	}
	
	
	
	public int getYearOfDateTime(String dateTime,ZoneId zone) throws InvalidInputException,DateTimeParseException{
		UtilityTasks.checkNull(dateTime);
		return getZonedDateAndTime(dateTime,zone).getYear();
	}
	
	
	
	public int getYearOfDateTime(ZoneId zone) throws InvalidInputException{
		UtilityTasks.checkNull(zone);
		return  getDateTimeInTheZone(zone).getYear();
	}
	
	
}
