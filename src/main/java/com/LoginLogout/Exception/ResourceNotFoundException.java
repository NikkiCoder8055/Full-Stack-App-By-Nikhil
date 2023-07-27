package com.LoginLogout.Exception;

public class ResourceNotFoundException extends RuntimeException {
	
	private String resource;
	private String fileName;
	private Long value;
	
	public ResourceNotFoundException(String resource, String fileName, Long value) {
		super(String.format("%s is not found with this %s: %s",resource,fileName,value));
		this.resource = resource;
		this.fileName = fileName;
		this.value = value;
	}
	
	

}
