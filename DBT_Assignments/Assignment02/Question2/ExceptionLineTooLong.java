package com.sunbeam;

public class ExceptionLineTooLong extends Exception{

	private String longLine;

	public ExceptionLineTooLong() {
		
	}
	
	public ExceptionLineTooLong(String longLine) {
		this.longLine = longLine;
	}

	public String getLongLine() {
		return longLine;
	}

	public void setLongLine(String longLine) {
		this.longLine = longLine;
	}
	
	@Override
	public String getMessage() {
		return String.format("The string is too long"); 
	}
	
}
