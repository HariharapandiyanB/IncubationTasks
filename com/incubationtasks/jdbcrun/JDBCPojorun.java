package com.incubationtasks.jdbcrun;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import com.incubationtasks.jdbctasks.DependantPOJO;
import com.incubationtasks.jdbctasks.EmployeePOJO;

import com.incubationtasks.jdbctasks.JDBCPOJOTasks;

import utilities.InvalidInputException;
public class JDBCPojorun {
	private static Scanner scan=new Scanner(System.in);
	
	private static String url="jdbc:mysql://localhost:3306/IncubationDB";
	private static String username="root";
	private static String password="hari03@mySql";
	private static JDBCPOJOTasks jdbcPojoTasks=new JDBCPOJOTasks(url,username,password);
	
	public static void main(String... args) {
		Logger logger=Logger.getAnonymousLogger();
		
		int x=1;
		do {
		
				System.out.println("Enter the number to choose the operation to be done(1-12):");
				int choice=scan.nextInt();
				scan.nextLine();
			switch(choice) {
			
			case 1:
				try {
					logger.info("\n Adding the details of an employee");
					logger.info("\n How many employee's details would you like to add:");
					int size=scan.nextInt();scan.nextLine();
					for(int i=0;i<size;i++) {
						EmployeePOJO employeePOJO=new EmployeePOJO();
						logger.info("\n The employee id of the employee:");
						employeePOJO.setEmployee_id(scan.nextInt());scan.nextLine();
						logger.info("\n The name of the Employee:");
						employeePOJO.setEmployeeName(scan.nextLine());
						logger.info("\n The Mobile Number of the Employee:");
						employeePOJO.setMobilenum(scan.nextLong());scan.nextLine();
						logger.info("\n The email ID:");
						employeePOJO.setmailID(scan.nextLine());
						logger.info("\n The Department:");
						employeePOJO.setDepartment(scan.nextLine());
						jdbcPojoTasks.addEmployee(employeePOJO);
					}
				} catch (InvalidInputException e) {
					logger.info("\n"+e);
				}catch(SQLException s) {
					logger.info("\n"+s);
				}break;
				
			case 2:
				try {
					logger.info("\n Fetching data from the Table");
					Map<String, Object> keyMap=new HashMap<String, Object>();
					logger.info("\n Enter the Table Name:");
					String tableName=scan.nextLine();
					logger.info("\n The Condition on EMPLOYEE_ID/NAME/MOBILE/EMAIL/DEPARTMENT... ");
					logger.info("The value is:");
					keyMap.put(scan.nextLine(), scan.next());
					List<EmployeePOJO> recordList=jdbcPojoTasks.getRecords(tableName,keyMap);
					for(EmployeePOJO employeePOJO: recordList) {
						logger.info("EMPLOYEE_ID: "+employeePOJO.getEmployee_id()
								+ "\n NAME: "+employeePOJO.getEmployeeName()
								+"\n EMAIL ID: "+employeePOJO.getMailID()
								+"\n MOBILE: "+employeePOJO.getMobileNum()
								+"\n DEPARTMENT: "+employeePOJO.getDepartment());
					}
				}catch(InvalidInputException i) {
					logger.info("\n"+i);
				}catch (SQLException e) {
					logger.info("\n"+e);
				}break;
				
			case 3:
				try {
					logger.info("\n To print the first N records of the table");
					logger.info("\n Enter the Table Name");
					String tableName=scan.nextLine();
					logger.info("\n The number of records would you like to print...?");
					int num=scan.nextInt();scan.nextLine();
					List<EmployeePOJO> recordList=jdbcPojoTasks.printNRecords(tableName,num);
					for(EmployeePOJO employeePOJO: recordList) {
						logger.info("EMPLOYEE_ID: "+employeePOJO.getEmployee_id()
								+ "\n NAME: "+employeePOJO.getEmployeeName()
								+"\n EMAIL ID: "+employeePOJO.getMailID()
								+"\n MOBILE: "+employeePOJO.getMobileNum()
								+"\n DEPARTMENT: "+employeePOJO.getDepartment());
					}
				} catch (InvalidInputException e) {
					logger.info("\n"+e);
				}catch(SQLException e) {
					logger.info("\n"+e);
				}break;
				
			case 4:
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
					List<EmployeePOJO> recordList=jdbcPojoTasks.printNSortedRecords(tableName,num,columnName,sortingOrder);
					for(EmployeePOJO employeePOJO: recordList) {
						logger.info("EMPLOYEE_ID: "+employeePOJO.getEmployee_id()
								+ "\n NAME: "+employeePOJO.getEmployeeName()
								+"\n EMAIL ID: "+employeePOJO.getMailID()
								+"\n MOBILE: "+employeePOJO.getMobileNum()
								+"\n DEPARTMENT: "+employeePOJO.getDepartment());
					}
				} catch (InvalidInputException e) {
					logger.info("\n"+e);
				}catch(SQLException e) {
					logger.info("\n"+e);
				}break;
				
			case 5:
				try {
					logger.info("\n Fetching the Records from Both Table");
					logger.info("\n Total Number of Fields to be fetched from both the Table Employee");
					int numOfFields=scan.nextInt();scan.nextLine();
					Map<String,String> fieldsMap=new HashMap<String, String>();
					for(int i=0;i<numOfFields;i++) {
						
						logger.info("\n The Field Name");
						fieldsMap.put("Employee", scan.nextLine());
					}
					logger.info("\n Enter the 1st Table Name:");
					String tableName1=scan.nextLine();
					logger.info("Enter the 2nd Table name:");
					String tableName2=scan.nextLine();
					logger.info("\n Enter the EmployeeID:");
					int employeeID=scan.nextInt();scan.nextLine();
					Map<Integer,DependantPOJO>recordMap= jdbcPojoTasks.printJointly(tableName1,tableName2,fieldsMap);
					
						
						DependantPOJO dependantPOJO=(DependantPOJO)recordMap.get(employeeID);
						logger.info(
						"\n EMPLOYEE ID: "+dependantPOJO.getDependantId()
						+"\n DEPENDANT_ID: "+dependantPOJO.getDependantId()
						+ "\n DEPENDANT NAME: "+dependantPOJO.getDependantName()
						+"\n AGE: "+dependantPOJO.getAge()
						+"\n RELATIONSHIP: "+dependantPOJO.getRelationship());
						
					
				} catch(SQLException  e) {
					logger.info("\n"+e);
				}catch(InvalidInputException e) {
					logger.info("\n"+e);
				}break;
				
			case 6:
				try {
					logger.info("\n Fetching the Records from Both Table");
					logger.info("\n Total Number of Fields to be fetched from both the Table Employee");
					int numOfFields=scan.nextInt();scan.nextLine();
					Map<String,String> fieldsMap=new HashMap<String, String>();
					for(int i=0;i<numOfFields;i++) {
						logger.info("\n The Field Name");
						fieldsMap.put("Employee", scan.nextLine());
					}
					logger.info("\n Enter the 1st Table Name:");
					String tableName1="Employee";//scan.nextLine();
					logger.info("Enter the 2nd Table name:");
					String tableName2="Dependant";//scan.nextLine();
					logger.info("\n Enter the Number of Employees:");
					int numOfEmployees=scan.nextInt();scan.nextLine();
					Map<Integer, List<DependantPOJO>>recordMap= jdbcPojoTasks.printLimitedRecordsJointly(tableName1,tableName2,fieldsMap);
					logger.info("\n"+recordMap);
				
					
					for(int i=1;i<=numOfEmployees;i++) {
					for(DependantPOJO dependantPOJO:recordMap.get(i)) {
						
							
							
							logger.info(" Dependant Object:"+dependantPOJO+"map:"+recordMap);
							logger.info("\n"+dependantPOJO.getDependantId());
									logger.info(
									"\n EMPLOYEE ID: "+dependantPOJO.getDependantId()
									+"\n DEPENDANT_ID: "+dependantPOJO.getDependantId()
									+ "\n DEPENDANT NAME: "+dependantPOJO.getDependantName()
									+"\n AGE: "+dependantPOJO.getAge()
									+"\n RELATIONSHIP: "+dependantPOJO.getRelationship());
						}	
					}
				}catch(SQLException  e) {
					logger.info("\n"+e);
				}catch(InvalidInputException e) {
					logger.info("\n"+e);
				}break;
			default:
				logger.info("Enter a proper integer from 1 to 12");
				break;
			}logger.info("press 1 to with play with DB tasks..");
		x=scan.nextInt();scan.nextLine();
		}while(x==1);
		}
	}