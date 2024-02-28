package com.incubationtasks.jdbctasks;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import utilities.InvalidInputException;
import utilities.UtilityTasks;

public class JDBCPOJOTasks {
	private String url;
	private String username;
	private String password;
	Logger logger=Logger.getAnonymousLogger();
	public JDBCPOJOTasks(String url,String username,String password) {
		this.url=url;
		this.username=username;
		this.password=password;
	}
	public JDBCPOJOTasks() {
		
	}
	public void addEmployee(EmployeePOJO employeePOJO) throws SQLException,InvalidInputException{
		UtilityTasks.checkNull(employeePOJO);
		try (Connection connection=DriverManager.getConnection(url, username,password);
				Statement statement=connection.createStatement()){
			String query="INSERT INTO Employee(EMPLOYEE_NAME,MOBILE,EMAIL,DEPARTMENT) VALUES('"+employeePOJO.getEmployeeName()+"',"+employeePOJO.getMobileNum()+",'"+
								employeePOJO.getMailID()+"','"+employeePOJO.getDepartment()+"');";
			
			statement.executeUpdate(query);
		} 
	}
	
	
	
	public void addDependant(DependantPOJO dependantPOJO) throws SQLException,InvalidInputException{
		UtilityTasks.checkNull(dependantPOJO);
		try (Connection connection=DriverManager.getConnection(url, username,password);
				Statement statement=connection.createStatement()){
			String query="INSERT INTO Employee(DEPENDANT_ID,DEPENDANT_NAME,AGE,RELATIONSHIP) VALUES('"+dependantPOJO.getDependantId()+"',"+dependantPOJO.getDependantName()+",'"+
								dependantPOJO.getAge()+"','"+dependantPOJO.getRelationship()+"');";
			
			statement.executeUpdate(query);
		} 
	}
	
	@SuppressWarnings("unchecked")
	public <T>List<T> getRecords(String tableName,Map<String, Object> keyMap) throws InvalidInputException,SQLException{
		UtilityTasks.checkNull(keyMap);
		try (Connection connection=DriverManager.getConnection(url, username,password);
				Statement statement=connection.createStatement()){
			String query=null;
			for(Map.Entry<String,Object> entry:keyMap.entrySet()) {
				query="SELECT * FROM "+tableName+" WHERE "+entry.getKey()+" = \'"+entry.getValue()+"\';";
			}
			try(ResultSet rs=statement.executeQuery(query)){
				if(tableName.equals("Employee")) {
					return (List<T>)fetchEmployeeDataFromResultSet(rs);
				}else if (tableName.equals("Dependant")) {
					return (List<T>)fetchDataFromResultSet(rs);
				}else {
					return null;
				}
				
			}
			}
		
	}
	
	public  List<EmployeePOJO> printNRecords(String tableName,int num) throws InvalidInputException,SQLException{
		UtilityTasks.checkNull(tableName);
		UtilityTasks.checkNull(num);
		try (Connection connection=DriverManager.getConnection(url, username,password);
				Statement statement=connection.createStatement()){
			String query=null;
			if (num==0) {
				query="SELECT * FROM "+tableName+";";
			}else {
				query="SELECT * FROM "+tableName+" WHERE EMPLOYEE_ID <="+num+";";
			}
			try(ResultSet rs=statement.executeQuery(query)){
				return fetchEmployeeDataFromResultSet(rs);
			}
		}
	}
	
	public List<EmployeePOJO> printNSortedRecords(String tableName,int num,String column,String sort) throws InvalidInputException,SQLException{
		UtilityTasks.checkNull(tableName);
		UtilityTasks.checkNull(num);
		UtilityTasks.checkNull(column);
		UtilityTasks.checkNull(sort);
		try (Connection connection=DriverManager.getConnection(url, username,password);
				Statement statement=connection.createStatement()){
			String query=null;
			if (sort.equals("DESC")) {				
				query="SELECT * FROM "+tableName+" WHERE EMPLOYEE_ID <="+num+" ORDER BY "+column+" DESC;";
			}else {
				query="SELECT * FROM "+tableName+" WHERE EMPLOYEE_ID <="+num+" ORDER BY "+column+";";
			}
			try(ResultSet rs=statement.executeQuery(query)){
				return fetchEmployeeDataFromResultSet(rs);
			}
		}
	}
	
	public Map<Integer,DependantPOJO> printJointly(String leftTableName,String rightTableName, Map<String, String> fieldsMap)
			throws InvalidInputException, SQLException {
		UtilityTasks.checkNull(fieldsMap);
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {
			StringBuilder subQueryBuilder = new StringBuilder();
		
			for (Map.Entry<String, String> entry : fieldsMap.entrySet()) {
				subQueryBuilder.append(entry.getKey() + "." + entry.getValue() + ",");
			}
			String subQuery = (subQueryBuilder.toString())+rightTableName+".*";
			String query = "SELECT " + subQuery + " FROM " + leftTableName+ " JOIN "+ rightTableName+ " ON Employee.EMPLOYEE_ID=Dependant.DEPENDANT_ID;";
		
		  try(ResultSet rs= statement.executeQuery(query)){
			  
			  return fetchDataFromResultSet(rs);
		  }

		}
	}
	
	public Map<Integer, List<DependantPOJO>> printLimitedRecordsJointly(String leftTableName,String rightTableName, Map<String, String> fieldsMap)
			throws InvalidInputException ,SQLException {
		UtilityTasks.checkNull(fieldsMap);
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {
			StringBuilder subQueryBuilder = new StringBuilder();
			
			for (Map.Entry<String, String> entry :  fieldsMap.entrySet()) {
				subQueryBuilder.append(entry.getKey() + "." + entry.getValue() + ",");
			}
			String subQuery = (subQueryBuilder.toString())+rightTableName+".*";
			
			String query = "SELECT " + subQuery + " FROM " + leftTableName+ " JOIN "+ rightTableName+ " ON Employee.EMPLOYEE_ID=Dependant.DEPENDANT_ID;";
			
		  try(ResultSet rs= statement.executeQuery(query)){
			  return fetchDependantDataFromResultSet(rs);
			 
			  
		  }
		}
			 
			  
		 
	}
	
	
	
	
	
	
	
	public Map<Integer, List<DependantPOJO>> fetchDependantDataFromResultSet(ResultSet rs) throws SQLException,InvalidInputException {
		UtilityTasks.checkNull(rs);
		int columnLen = rs.getMetaData().getColumnCount();
		String[] columns = new String[columnLen];
		for (int i=1;i<=columnLen;i++) {
			columns[i-1] = rs.getMetaData().getColumnLabel(i);
		}
		List<Map<String,Object>> list = new ArrayList<>();
		
		while(rs.next()) {
			Map<String,Object> resultMap = new HashMap<>();
			for(int i=1;i<=columnLen;i++) {
				resultMap.put(columns[i-1], rs.getObject(i));
			}
			list.add(resultMap);
		}
		List<DependantPOJO> resultPOJOList=new ArrayList<DependantPOJO>();
		int num=1;
		Map<Integer, List<DependantPOJO>> resultPojoMap=new HashMap<Integer, List<DependantPOJO>>(); 
		for(Map<String,Object> recordMap:list) {
			
			DependantPOJO  dependantPOJO=new DependantPOJO();
			
			dependantPOJO.setSno((int)recordMap.get("SNO"));
			dependantPOJO.setDependantId((int)recordMap.get("DEPENDANT_ID"));
			dependantPOJO.setDependantName((String)recordMap.get("DEPENDANT_NAME"));
			dependantPOJO.setAge((int)recordMap.get("AGE"));
			dependantPOJO.setRelationship((String)recordMap.get("RELATIONSHIP"));
			
			
			num=dependantPOJO.getDependantId(); 
				
			 if (resultPojoMap.containsKey(num)) {
				resultPOJOList=resultPojoMap.get(num);
				resultPOJOList.add(dependantPOJO);
			}else {
				
				resultPOJOList=new ArrayList<DependantPOJO>();
				resultPOJOList.add(dependantPOJO);
				resultPojoMap.put(num, resultPOJOList);
				
				
			}
			
			
			
		}
		return resultPojoMap;
		
	}
	
	public Map<Integer,DependantPOJO> fetchDataFromResultSet(ResultSet rs) throws SQLException{
		int columnLen = rs.getMetaData().getColumnCount();
		String[] columns = new String[columnLen];
		for (int i=1;i<=columnLen;i++) {
			columns[i-1] = rs.getMetaData().getColumnLabel(i);
		}
		List<Map<String,Object>> list = new ArrayList<>();
		Map<Integer, DependantPOJO> resultPojoMap=new HashMap<Integer, DependantPOJO>();
		while(rs.next()) {
			Map<String,Object> resultMap = new HashMap<>();
			for(int i=1;i<=columnLen;i++) {
				resultMap.put(columns[i-1], rs.getObject(i));
			}
			list.add(resultMap);
		}
			for(Map<String,Object> recordMap:list) {
				DependantPOJO dependantPOJO=new DependantPOJO();
				dependantPOJO.setSno((int)recordMap.get("SNO"));
				dependantPOJO.setDependantId((int)recordMap.get("DEPENDANT_ID"));
				dependantPOJO.setDependantName((String)recordMap.get("DEPENDANT_NAME"));
				dependantPOJO.setAge((int)recordMap.get("AGE"));
				dependantPOJO.setRelationship((String)recordMap.get("RELATIONSHIP"));
				//EmployeePOJO employeePOJO=new EmployeePOJO();
				//employeePOJO.setEmployee_id((int)recordMap.get("EMPLOYEE_ID"));
				//employeePOJO.setEmployeeName((String)recordMap.get("EMPLOYEE_NAME"));
				//employeePOJO.setmailID((String)recordMap.get("EMAIL"));
				//employeePOJO.setMobilenum((long)recordMap.get("MOBILE"));
				//employeePOJO.setDepartment((String)recordMap.get("DEPARTMENT"));
				
				//resultPojoMap.put(employeePOJO.getEmployee_id(), employeePOJO);
				resultPojoMap.put(dependantPOJO.getDependantId(), dependantPOJO);
				
			}
		return resultPojoMap;
	
	}
	
	public List<EmployeePOJO> fetchEmployeeDataFromResultSet(ResultSet rs) throws SQLException{
		int columnLen = rs.getMetaData().getColumnCount();
		String[] columns = new String[columnLen];
		for (int i=1;i<=columnLen;i++) {
			columns[i-1] = rs.getMetaData().getColumnLabel(i);
		}
		List<Map<String,Object>> list = new ArrayList<>();
		List<EmployeePOJO> employeePOJOList=new ArrayList<EmployeePOJO>();
		while(rs.next()) {
			Map<String,Object> resultMap = new HashMap<>();
			for(int i=1;i<=columnLen;i++) {
				resultMap.put(columns[i-1], rs.getObject(i));
			}
			list.add(resultMap);
			
			for(Map<String,Object> recordMap:list) {
				EmployeePOJO employeePOJO=new EmployeePOJO();
				
				employeePOJO.setEmployee_id((int)recordMap.get("EMPLOYEE_ID"));
				employeePOJO.setEmployeeName((String)recordMap.get("EMPLOYEE_NAME"));
				employeePOJO.setmailID((String)recordMap.get("EMAIL"));
				employeePOJO.setMobilenum((long)recordMap.get("MOBILE"));
				employeePOJO.setDepartment((String)recordMap.get("DEPARTMENT"));
				
				employeePOJOList.add(employeePOJO);
			}
		}return employeePOJOList;
	
	}
	
	
	
}
