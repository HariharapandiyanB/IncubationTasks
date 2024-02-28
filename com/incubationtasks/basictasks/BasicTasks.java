package com.incubationtasks.basictasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import utilities.InvalidInputException;
import utilities.UtilityTasks;



public class BasicTasks {
	
	public File createFile(String fileName,List<String> statements) throws IOException,InvalidInputException{
		File file= new File(fileName);
		file.createNewFile();
		writeFile(file,statements);
		return file;
	} 
	
	public FileReader getReader(File file) throws FileNotFoundException,InvalidInputException{
		UtilityTasks.checkNull(file);
		return new FileReader(file);
		
	}
	
	public FileWriter getWriter(File file) throws IOException,InvalidInputException{
		UtilityTasks.checkNull(file);
		return new FileWriter(file);
		
	}
	
	public void writeFile(File file, List<String> statements) throws IOException, InvalidInputException{
		UtilityTasks.checkNull(file);
		UtilityTasks.checkNull(statements);
		try(BufferedWriter buffer=new BufferedWriter(getWriter(file))){
			long lengthOfList=statements.size();
			for(int i=0;i<lengthOfList;i++) {
				buffer.write(statements.get(i));
				buffer.newLine();
			}
			}

	}
	
	public StringBuilder readFile(File file) throws InvalidInputException,Exception {
		UtilityTasks.checkNull(file);
		StringBuilder statement=new StringBuilder();
		try(BufferedReader buffer=new BufferedReader(getReader(file))){
		long length=file.length();
		int i=0;
		while( i<length) {
			statement.append((char)buffer.read());
			i++;
		}
		}
		return statement;
	}
	
	public Properties createProperty() {
		return new Properties();
		 
	}
	
	public void addProperty(Properties property,String key,String value) throws InvalidInputException{
		UtilityTasks.checkNull(property);
		UtilityTasks.checkNull(key);
		UtilityTasks.checkNull(value);
		property.setProperty(key,value);
		
	}
	
	public File propertyToFile(Properties property,String fileName ) throws IOException, InvalidInputException {
		UtilityTasks.checkNull(property);
		File file=new File(fileName);
		try(FileWriter writer=getWriter(file)){
		property.store(writer, null);
		}
		return file;
	}
	
	public Properties fileToProperty(File file) throws IOException,InvalidInputException{
		Properties property=createProperty();
		try( FileReader reader=getReader(file)){
		property.load(reader);
		}
		return property;
	}
	
	public boolean createDirectory(File file) throws InvalidInputException{
		UtilityTasks.checkNull(file);
		return file.mkdirs();
	}
	
	}

