package com.sunbeam;

public class Line {

	String s;
	
	public Line() {
		
	}
	
	public Line(String s) {
		this.s = s;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) throws ExceptionLineTooLong{
		if(s.length() > 80)
			throw new ExceptionLineTooLong();
		this.s = s;
	}
	
	
}
