package com.incubationtasks.car.swift;
import utilities.UtilityTasks;

import com.incubationtasks.car.cars.Car;

import utilities.InvalidInputException;
public class Swift extends Car{
	private int seats;
	private int airbags;
	private String model;
	private String color;
	public int getSeats(){
		return seats;
		}
	public int getAirbags(){
		return airbags;
		}
	public String getModel(){
		return model;
		}
	public String getColor(){
		return color;
		}
	public void setSeats(int seat) throws InvalidInputException{
		
		this.seats=seat;
		}
	public void setAirbags(int airbag) throws InvalidInputException{
		
		this.airbags=airbag;
		}
	public void setModel(String model) throws InvalidInputException{
		UtilityTasks.checkNull(model);
		this.model=model;
		}
	public void setColor(String color) throws InvalidInputException{
		UtilityTasks.checkNull(color);
		this.color=color;
		}
		}