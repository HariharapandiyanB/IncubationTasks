package com.incubationtasks.customclass;

public class CustomPOJO {
	private String word;
	private int number;
	public CustomPOJO() {
		
	}
	public CustomPOJO(String word,int number) {
		this.word=word;
		this.number=number;
	}
	public void setWord(String word) {
		this.word=word;
	}
	public void setNumber(int number) {
		this.number=number;
	}
	public String getWord() {
		return word;
	}
	public int getNumber() {
		return number;
	}
	
	public String toString() {
		return word+number;
	}
}
