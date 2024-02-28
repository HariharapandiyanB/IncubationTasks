package com.incubationtasks.jdbctasks;

public class DependantPOJO {
	private int sno;
	private int dependantId;
	private String name;
	private int age;
	private String relationship;
	public void setSno(int sno) {
		this.sno=sno;
	}
	public void setDependantId(int dependantId) {
		this.dependantId=dependantId;
	}
	public void setDependantName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setRelationship(String relationship) {
		this.relationship=relationship;
	}
	public int getSno() {
		return sno;
	}
	public int getDependantId() {
		return dependantId;
	}
	public String getDependantName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getRelationship() {
		return relationship;
	}
}
