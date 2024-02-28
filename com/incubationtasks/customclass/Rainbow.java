package com.incubationtasks.customclass;


public enum Rainbow{
		VIOLET(1),
		INDIGO(2),
		BLUE(3),
		GREEN(4),
		YELLOW(5),
		ORANGE(6),
		RED(7);
		
	
	int colorCode;
	private Rainbow(int colorCode) {
		  this.colorCode=colorCode;
		}
	public int getColorCode() {
		return colorCode;
	}
}
