package com.incubationtasks.jdbctasks;

public class EmployeePOJO {
	private int employee_id;
	private String name;
	private String mailID;
	private String department;
	private long mobileNum;
	public void setEmployee_id(int employee_id) {
		this.employee_id=employee_id;
	}
	
	public void setEmployeeName(String name) {
		this.name=name;
	}
	
	public void setmailID(String mailId) {
		this.mailID=mailId;
	}
	
	public void setDepartment(String department) {
		this.department=department;
	}
	
	public void setMobilenum(long mobileNum) {
		this.mobileNum=mobileNum;
	}
	
	public int getEmployee_id() {
		return employee_id;
	}
	
	public String getEmployeeName() {
		return name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String getMailID() {
		return mailID;
	}
	
	public long getMobileNum() {
		return mobileNum;
	}
}
