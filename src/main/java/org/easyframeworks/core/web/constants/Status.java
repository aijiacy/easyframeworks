package org.easyframeworks.core.web.constants;

public enum Status {
	OK("0"),ERROR("1");
	private final String val;
	
	private Status(String val){
		this.val = val;
	}
	
	public String getVal(){
		return val;
	}
}
