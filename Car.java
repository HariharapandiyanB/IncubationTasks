package com.incubationtasks.car.cars;
import utilities.UtilityTasks;
import utilities.InvalidInputException;
public class Car{
	private int yearOfMake;
	private String engineNumber;
	private String type;
	public int getYearOfMake(){
		return yearOfMake;
		}
	public String getEngineNumber(){
		return engineNumber;
		}
	public String getType(){
		return type;
		}
	public void setYearOfMake(int year){
		yearOfMake=year;
		}
	public void setEngineNumber(String engineNum) throws InvalidInputException{
		UtilityTasks.checkNull(engineNum);
		engineNumber=engineNum;
		}
	public void setType(String carType) throws InvalidInputException{
		UtilityTasks.checkNull(carType);
		type=carType;
		}
	public void maintenance(){
		System.out.println("Car under maintenance");
		}
	public Car(String str){
		System.out.println(str);
		}
	public Car() {
		
	}
	}