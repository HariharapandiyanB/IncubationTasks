package com.incubationtasks.jdbcrun;


import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import com.incubationtasks.jdbctasks.JDBCTasks;


import utilities.InvalidInputException;



public class JDBCRun {
	private static Scanner scan=new Scanner(System.in);
	private static JDBCTasks jdbcTasks=new JDBCTasks();
	public static void main(String... args) {
		Logger logger=Logger.getAnonymousLogger();
		
		int x=1;
		do {
		
				System.out.println("Enter the number to choose the operation to be done(1-12):");
				int choice=scan.nextInt();
				scan.nextLine();
			switch(choice) {
			case 0:
				String url="jdbc:mysql://localhost:3306/IncubationDB";
				String username="root";
				String password="hari03@mySql";
				jdbcTasks=new JDBCTasks(url,username,password);
				logger.info("Successfully linked Database");
				break;
			case 1:
				try {
					
					logger.info("Enter the command to create table");
					String tableQuery=scan.nextLine();
					jdbcTasks.createTable(tableQuery);
					
				} catch (SQLException e) {
					logger.info("\n"+e);
				}catch (InvalidInputException i) {
					logger.info("\n"+i);
				}break;
			case 2:
				try {
					logger.info("\n Adding the details of an employee");
					logger.info("\n How many employee's details would you like to add:");
					int size=scan.nextInt();scan.nextLine();
					logger.info("\n Enter the Table Name:");
					String tableName=scan.nextLine();
					List<String> fields=new ArrayList<String>();
					List<Object> recordValues=new ArrayList<Object>();
						
					for(int i=0;i<size;i++) {
						logger.info("\n Enter the Field Name:");
						fields.add(scan.nextLine());
						logger.info("\n Enter the Value:");
						recordValues.add(scan.next());
						jdbcTasks.addRecords(tableName,fields,recordValues);
					}
				} catch (SQLException  e) {
					logger.info("\n"+e);
				}catch (InvalidInputException e) {
					logger.info("\n"+e);
				}break;
			case 3:
				try {
					logger.info("\n Fetching data from the Table");
					Map<String, Object> keyMap=new HashMap<String, Object>();
					logger.info("\n Enter the Table Name:");
					String tableName=scan.nextLine();
					logger.info("\n The Condition on EMPLOYEE_ID/NAME/MOBILE/EMAIL/DEPARTMENT... ");
					logger.info("The value is:");
					keyMap.put(scan.nextLine(), scan.next());
					logger.info("\n"+jdbcTasks.getRecords(tableName,keyMap));
				}catch(InvalidInputException i) {
					logger.info("\n"+i);
				}catch (SQLException e) {
					logger.info("\n"+e);
				}break;
			
			case 4:
				try {
					logger.info("\n Modifying data in the table ");
					Map<String,Object>keyMap=new HashMap<String, Object>();
					Map<String,Object>updatingMap=new HashMap<String, Object>();
					logger.info("\n The Table on which you would like to make change...");
					String tableName=scan.nextLine();
					logger.info("\n The reference Column of the Employee you would like to change... EMPLOYEE_ID/NAME/MOBILE/EMAIL/DEPARTMENT... ");
					logger.info("\n The Value is:");
					keyMap.put(scan.nextLine(), scan.nextLine());
					logger.info("\n The Updating Column of the Employee EMPLOYEE_ID/NAME/MOBILE/EMAIL/DEPARTMENT... ");
					logger.info("\n The Updating value is:");
					updatingMap.put(scan.nextLine(), scan.nextLine());
					logger.info("\n"+jdbcTasks.modifyTable(tableName, keyMap,updatingMap));						}
					catch (InvalidInputException e) {
						logger.info("\n"+e);
					}catch(SQLException s) {
						logger.info("\n"+s);
					}break;
					
				case 5:
					try {
						logger.info("\n To print the first N records of the table");
						logger.info("\n Enter the Table Name");
						String tableName=scan.nextLine();
						logger.info("\n The number of records would you like to print...?");
						int num=scan.nextInt();scan.nextLine();
						logger.info("\n"+jdbcTasks.printNRecords(tableName,num));
					} catch (InvalidInputException e) {
						logger.info("\n"+e);
					}catch(SQLException e) {
						logger.info("\n"+e);
					}break;
					
				case 6:
					try {
						logger.info("\n To print the first N records of the table in a sorted order...");
						logger.info("\n Enter the Table Name");
						String tableName=scan.nextLine();
						logger.info("\n The number of records would you like to print...?");
						int num=scan.nextInt();scan.nextLine();
						logger.info("\n By which Column do you want to make sorting...?");
						String columnName=scan.nextLine();
						logger.info("\n The Sorting Order is: (ASC/DESC)");
						String sortingOrder=scan.nextLine();
						logger.info("\n"+jdbcTasks.printNSortedRecords(tableName,num,columnName,sortingOrder));
					} catch (InvalidInputException e) {
						logger.info("\n"+e);
					}catch(SQLException e) {
						logger.info("\n"+e);
					}break;
				
				case 7:
					try {
						logger.info("\n Deleting data from the Table");
						Map<String, Object> keyMap=new HashMap<String, Object>();
						logger.info("\n Enter the Table Name");
						String tableName=scan.nextLine();
						logger.info("\n The reference on EMPLOYEE_ID/NAME/MOBILE/EMAIL/DEPARTMENT... ");
						logger.info("The value is:");
						keyMap.put(scan.nextLine(), scan.next());
						jdbcTasks.deleteRecords(tableName,keyMap);
						logger.info("\n"+jdbcTasks.printNRecords(tableName, 0));
					}catch(InvalidInputException i) {
						logger.info("\n"+i);
					}catch (SQLException e) {
						logger.info("\n"+e);
					}break;
					
				case 9:
					try {
						logger.info("\n Creating a new dependant table");
						logger.info("Enter the command to create table");
						String tableQuery=scan.nextLine();
						jdbcTasks.createTable(tableQuery);
						
					}catch(InvalidInputException i) {
						logger.info("\n"+i);
					}catch(SQLException e) {
						logger.info("\n"+e);
					}
					
				case 10:
					try {
						logger.info("\n Adding the details of a dependant");
						logger.info("\n How many dependant's details would you like to add:");
						int size=scan.nextInt();scan.nextLine();
						logger.info("\n Enter the Table Name:");
						String tableName=scan.nextLine();
						List<String> fields=new ArrayList<String>();
						List<Object> recordValues=new ArrayList<Object>();
						
						for(int i=0;i<size;i++) {
							logger.info("\n Enter the Field Name:");
							fields.add(scan.nextLine());
							logger.info("\n Enter the Value:");
							recordValues.add(scan.next());
							jdbcTasks.addRecords(tableName,fields,recordValues);
						}
					}catch(SQLException  e) {
						logger.info("\n"+e);
					}catch(InvalidInputException e) {
						logger.info("\n"+e);
					}break;
					
				case 11:
					try {
						logger.info("\n Fetching the Records from Both Table");
						logger.info("\n Total Number of Fields to be fetched from both the Table");
						int numOfFields=scan.nextInt();scan.nextLine();
						Map<String,String> fieldsMap=new HashMap<String, String>();
						for(int i=0;i<numOfFields;i++) {
							logger.info("\n The Table Name");
							logger.info("\n The Field Name");
							fieldsMap.put(scan.nextLine(), scan.nextLine());
						}
						logger.info("\n Enter the Condition as per the MySQL syntax");
						String conditionString=scan.nextLine();
						logger.info("\n"+jdbcTasks.printJointly(conditionString, fieldsMap));
					} catch(SQLException  e) {
						logger.info("\n"+e);
					}catch(InvalidInputException e) {
						logger.info("\n"+e);
					}break;
					
				default:
					logger.info("Enter a proper integer from 1 to 12");
			}logger.info("press 1 to with play with DB tasks..");
			x=scan.nextInt();scan.nextLine();
		}while(x==1);scan.close();
		
	}
}