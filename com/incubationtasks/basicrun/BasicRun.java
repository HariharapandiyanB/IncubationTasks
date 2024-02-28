package com.incubationtasks.basicrun;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.lang.reflect.*;
import java.security.PublicKey;

import com.incubationtasks.basictasks.BasicTasks;
import com.incubationtasks.customclass.CustomClass;
import com.incubationtasks.customclass.CustomPOJO;
import com.incubationtasks.customclass.Rainbow;
import com.incubationtasks.daystime.DaysTime;
import com.incubationtasks.singleton.SingletonClass;

import utilities.InvalidInputException;

public class BasicRun {
	private static Scanner scan=new Scanner(System.in);
	private static BasicTasks bt=new BasicTasks();
	public static void main(String ... args){
	
		int x=1;
		do {
		System.out.println("Enter the number to choose the operation to be done:");
		int choice=scan.nextInt();
		scan.nextLine();
		switch(choice) {
		
		case 1:
			try {
	     		System.out.println("Create a .txt file programmatically");
				File file= createFile();
				
				StringBuilder sb=bt.readFile(file);
				System.out.println(sb);
			}catch(IOException io1) {
				io1.printStackTrace();
			}catch(InvalidInputException i1) {
				i1.printStackTrace();
			}catch(Exception ex) {
				ex.printStackTrace();
		
			}break;
		
		case 2:
			try {
				System.out.println("Enter the directory with file name at end:");
				String propertyFileName=scan.nextLine();
				Properties property = bt.createProperty();
				System.out.println("Access the file from properties..");
				addProperty(property);
				System.out.println(property);
				File propertyFile=bt.propertyToFile(property, propertyFileName);
				StringBuilder sb=bt.readFile(propertyFile);
		    	System.out.println(sb);
			}catch(IOException io2) {
				io2.printStackTrace();
		    }catch(InvalidInputException i1) {
				i1.printStackTrace();
			}catch(Exception ex2) {
			    ex2.printStackTrace();
		    }break;
			
		case 3:
			System.out.println("Enter the path of the existing file..");
			String propertyFilePath=scan.nextLine();
			File propertyFile=new File(propertyFilePath);
			try{
				StringBuilder sb=bt.readFile(propertyFile);
				System.out.println(sb);
				
				Properties property=bt.fileToProperty(propertyFile);
				System.out.println(property);
			}catch(IOException io3 ) {
				io3.printStackTrace();
			}catch(InvalidInputException i) {
				i.printStackTrace();
			}catch(Exception e3){
		    	e3.printStackTrace();
			}break;
			
		case 4:
			try {
				File file=createFile();
				System.out.println(file.isDirectory());
				
				
				StringBuilder sb=bt.readFile(file);
				System.out.println(sb);
		
				System.out.println("Enter the directory with file name at end:");
				String additionalPropertyFileName=scan.nextLine();
				Properties additionalProperty = bt.createProperty();
				addProperty(additionalProperty);
				File additionalPropertyFile=bt.propertyToFile(additionalProperty,additionalPropertyFileName);
				bt.createDirectory(additionalPropertyFile);
				writeFile(additionalPropertyFile);
				StringBuilder sb1=bt.readFile(additionalPropertyFile);
				System.out.println(sb1);
				
				System.out.println("Access the file from properties..");
				additionalProperty=bt.fileToProperty(additionalPropertyFile);
				System.out.println(additionalProperty);
			}catch(IOException io3 ) {
				io3.printStackTrace();
			}catch(InvalidInputException i) {
				i.printStackTrace();
			}catch(Exception ex1) {
					ex1.printStackTrace();
			}break;
			
		case 5:
			System.out.println("Enter the String..");
			CustomClass customObj=new CustomClass(scan.nextLine());
			System.out.println(customObj);
			break;
			
		case 6:
			System.out.println("Enter a string followed by an integer...");
			CustomPOJO customObject=new CustomPOJO(scan.nextLine(),scan.nextInt());
			scan.nextLine();
			System.out.println(customObject);
			break;
			
		case 7:
			CustomPOJO custom_P_Object=new CustomPOJO();
			System.out.println("Enter the number..");
			custom_P_Object.setNumber(scan.nextInt());
			scan.nextLine();
			System.out.println("Enter the String..");
			custom_P_Object.setWord(scan.nextLine());
			System.out.println(custom_P_Object.getWord());
			System.out.println(custom_P_Object.getNumber());
			break;
			
		case 8:
			try {
				Class<?> clazz = Class.forName("com.incubationtasks.customclass.CustomPOJO");
				clazz.getClass();
				System.out.println(clazz.getSimpleName());
				Method[] methods=clazz.getDeclaredMethods();	
				for (Method method:methods){
					System.out.println(method.getName());		
				}
				System.out.println("Enter a string followed by an integer...");
				Object myPOJO=clazz.getDeclaredConstructor().newInstance();
				Object urPOJO=clazz.getDeclaredConstructor(String.class,int.class).newInstance(scan.nextLine(),scan.nextInt());
				scan.nextLine();
				
				for (Method method:methods){
					if (method.getName().equals("setWord")){
						method.invoke(myPOJO,"Come on Jeffrey..!");
						
					}
					if(method.getName().equals("getWord")){
						System.out.println(method.invoke(myPOJO));
							
					}
					if(method.getName().equals("getNumber")) {
						System.out.println(method.invoke(urPOJO));
					}
					}
			} catch (Exception e) {
				e.printStackTrace();
			}break;
			
		case 9:
			System.out.println("The Colors of Rainbow");
			for(Rainbow color: Rainbow.values()) {
				System.out.println("The color "+color+" code is "+color.getColorCode());
			}break;
			
		case 10:
			try {
				Class<?> Singleton = Class.forName("com.incubationtasks.singleton.SingletonClass");
				Object asd = Singleton.getDeclaredConstructor().newInstance();
				SingletonClass qsx =  SingletonClass.getInstance();
				SingletonClass rtr = (SingletonClass)qsx.clone();
				
			} catch (IllegalAccessException i) {
				i.printStackTrace();
			} catch(CloneNotSupportedException c) {
				c.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}break;
			
		
			
			
		
			 
			
			}System.out.println("Press 1 to continue operations....!");
			x=scan.nextInt();
			scan.nextLine();
		}while(x==1);
		scan.close();
}
	
	private static void writeFile(File file) throws IOException,InvalidInputException{
		
		String y="y";
		ArrayList<String> arrayList=new ArrayList<String>();
		do {
			System.out.println("The text you would like to add in this file");
			String statements=scan.nextLine();
			arrayList.add(statements);
			System.out.println("press y to add more strings...");
			y=scan.nextLine();
			
		}while(y.equals("y"));
		bt.writeFile(file, arrayList);
		
	}
	
	private static void addProperty(Properties property) throws InvalidInputException {
		
		System.out.println("Adding Keys and Values to the Property");
		String key,value;
		
		String z="y";
		do {
			System.out.println("Enter the key:");
			key=scan.nextLine();
			
			System.out.println("Enter the value");
			value=scan.nextLine();
			bt.addProperty(property, key,value);
			System.out.println("Want to add more pairs..?  then press y");
			z=scan.nextLine();
			
		}while(z.equals("y"));
		
		
	}
	
	private static File createFile() throws IOException,InvalidInputException{
		File file;
		System.out.println("Do you want to create the file in current directory: yes/no");
		
		if(scan.nextLine().equals("yes")) {
			System.out.println("The file name is: ");
			String fileName=scan.nextLine();
			ArrayList<String> arrayList=getContent();
			
			
			file=bt.createFile(System.getProperty("user.dir")+fileName,arrayList);
		}else {
			System.out.println("Enter Your desired directory: ");
			String directoryPath=scan.nextLine();
			System.out.println("The file name is: ");
			String fileName=scan.nextLine();
			ArrayList<String> arrayList=getContent();
			file=bt.createFile(directoryPath+fileName,arrayList);
		}

		bt.createDirectory(file);
		System.out.println("The directory is "+file.getAbsolutePath());
		
		
		return file;
	}
	
	private static ArrayList<String> getContent(){
		String y="y";
		ArrayList<String> arrayList=new ArrayList<String>();
		do {
			System.out.println("The text you would like to add in this file");
			String statements=scan.nextLine();
			arrayList.add(statements);
			System.out.println("press y to add more strings...");
			y=scan.nextLine();
			
		}while(y.equals("y"));
		return arrayList;
	}
}
