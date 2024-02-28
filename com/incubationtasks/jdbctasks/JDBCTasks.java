package com.incubationtasks.jdbctasks;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import utilities.InvalidInputException;
import utilities.UtilityTasks;

public class JDBCTasks {
	private String url;
	private String username;
	private String password;
	public JDBCTasks(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public JDBCTasks() {

	}

	public void createTable(String query) throws InvalidInputException, SQLException {

		UtilityTasks.checkNull(query);
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {

			statement.executeUpdate(query);
		}

	}

	public void addRecords(String tableName, List<String> fieldsList, List<Object> valuesList)
			throws SQLException, InvalidInputException {
		UtilityTasks.checkNull(fieldsList);
		UtilityTasks.checkNull(valuesList);
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {
			StringBuilder fields = new StringBuilder();
			for (String field : fieldsList) {
				fields.append(field+",");
			}
			StringBuilder recordValues = new StringBuilder();
			for (Object recordValue : valuesList) {
				if (recordValue instanceof String) {
					recordValues.append("\'" + recordValue + "\'");
				} else {
					recordValues.append(recordValue);
				}
			}
			String query = "INSERT " + tableName + " (" + fields.toString() + ") VALUES(" + recordValues.toString()+ ");";
			statement.executeUpdate(query);
		}
	}

	public List<Map<String, Object>> getRecords(String tableName, Map<String, Object> keyMap)
			throws InvalidInputException, SQLException {
		UtilityTasks.checkNull(keyMap);
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement();) {

			String query=null;
			for (Map.Entry<String, Object> entry : keyMap.entrySet()) {
				query = "SELECT * FROM " + tableName + " WHERE " + entry.getKey() + " = \'" + entry.getValue() + "\';";
			}
			try (ResultSet rs = statement.executeQuery(query)) {
				return fetchDataFromResultSet(rs);
			}
		}
	}



	public List<Map<String, Object>> modifyTable(String tableName, Map<String, Object> keyMap,
			Map<String, Object> updatingMap) throws InvalidInputException, SQLException {
		UtilityTasks.checkNull(tableName);
		UtilityTasks.checkNull(keyMap);
		UtilityTasks.checkNull(updatingMap);
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {
			
			for (Map.Entry<String, Object> entry : keyMap.entrySet()) {
				for (Map.Entry<String, Object> entry2 : updatingMap.entrySet()) {
					String query = "UPDATE " + tableName + " SET " + entry2.getKey() + "= \'" + entry2.getValue()
							+ "\' WHERE " + entry.getKey() + "= \'" + entry.getValue() + "\';";
					statement.executeUpdate(query);
				}

			}
		}
		return getRecords(tableName, updatingMap);
	}

	public List<Map<String, Object>> printNRecords(String tableName, int num)
			throws InvalidInputException, SQLException {
		UtilityTasks.checkNull(tableName);
		UtilityTasks.checkNull(num);
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {
			String query = null;
			if (num == 0) {
				query = "SELECT * FROM " + tableName + ";";
			} else {
				if (tableName.equals("Employee")) {
					query = "SELECT * FROM " + tableName + " WHERE EMPLOYEE_ID <=" + num + ";";
				} else if (tableName.equals("Dependant")) {
					query = "SELECT * FROM " + tableName + " WHERE SNO <=" + num + ";";
				} else {
					throw new InvalidInputException("The Table is not Found in the DataBase");
				}
			}
			 try(ResultSet rs= statement.executeQuery(query)){
				  return fetchDataFromResultSet(rs);
			  }
		}
	}

	public List<Map<String, Object>> printNSortedRecords(String tableName, int num, String column, String sort)
			throws InvalidInputException, SQLException {
		UtilityTasks.checkNull(tableName);
		UtilityTasks.checkNull(num);
		UtilityTasks.checkNull(column);
		UtilityTasks.checkNull(sort);
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {
			String query = null;
			if (tableName.equals("Employee")) {
				query = "SELECT * FROM " + tableName + " WHERE EMPLOYEE_ID <=" + num + " ORDER BY " + column+ sort+";";
			}else if (tableName.equals("Dependant")) {
				query = "SELECT * FROM " + tableName + " WHERE SNO <=" + num + " ORDER BY " + column +sort+ ";";
			}else {
				throw new InvalidInputException("The Table is not Found in the DataBase");
			}

			 try(ResultSet rs= statement.executeQuery(query)){
				  return fetchDataFromResultSet(rs);
			  }
		}
	}

	private List<Map<String, Object>> fetchDataFromResultSet(ResultSet rs) throws SQLException {
		int columnLen = rs.getMetaData().getColumnCount();
		String[] columns = new String[columnLen];
		for (int i = 1; i <= columnLen; i++) {
			columns[i - 1] = rs.getMetaData().getColumnLabel(i);
		}
		List<Map<String, Object>> list = new ArrayList<>();
		while (rs.next()) {
			Map<String, Object> resultMap = new HashMap<>();
			for (int i = 1; i <= columnLen; i++) {
				resultMap.put(columns[i - 1], rs.getObject(i));
			}
			list.add(resultMap);
		}
		return list;
	}

	public void deleteRecords(String tableName, Map<String, Object> keyMap) throws InvalidInputException, SQLException {
		UtilityTasks.checkNull(tableName);
		UtilityTasks.checkNull(keyMap);
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {
			String query = null;
			for (Map.Entry<String, Object> entry : keyMap.entrySet()) {
				query = "DELETE FROM " + tableName + " WHERE " + entry.getKey() + " = \'" + entry.getValue() + "\';";
				statement.executeUpdate(query);
			}
		}
	}

	public List<Map<String, Object>> printJointly(String conditionString, Map<String, String> fieldsMap)
			throws InvalidInputException, SQLException {
		UtilityTasks.checkNull(fieldsMap);
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {
			StringBuilder subQueryBuilder = new StringBuilder();
			Set<Map.Entry<String, String>> set = fieldsMap.entrySet();
			for (Map.Entry<String, String> entry : set) {
				subQueryBuilder.append(entry.getKey() + "." + entry.getValue() + ",");
			}
			String subQuery = (subQueryBuilder.toString()).substring(0, (subQueryBuilder.toString()).lastIndexOf(","));
			String query = "SELECT " + subQuery + " FROM " + conditionString.substring(0, conditionString.indexOf('.'))
					+ " JOIN "
					+ conditionString.substring(conditionString.indexOf('=') + 1, conditionString.lastIndexOf('.'))
					+ " ON " + conditionString + ";";
		  try(ResultSet rs= statement.executeQuery(query)){
			  return fetchDataFromResultSet(rs);
		  }

		}
	}
}
