package org.easyframeworks.core.web.constants;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResultMsg implements Cloneable {

	private Status status;

	private String message;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void pushResult(Status status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public void pushOK(String message){
		this.status = Status.OK;
		this.message = message;
	}
	
	public void pushError(String message){
		this.status = Status.ERROR;
		this.message = message;
	}
	
	public String toJsonString(){
		ObjectMapper objMapper = new ObjectMapper();
		String str = null;
		try {
			str = objMapper.writeValueAsString(this);
		} catch (Exception e) {
			System.out.println("ex:" + e);
		}
		return str;
	}
	
	public static void main(String[] args) {
		ResultMsg resultMsg = new ResultMsg();
		resultMsg.pushOK("success");
		System.out.println("json:" + resultMsg.toJsonString());
	}
}
