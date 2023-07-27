package com.LoginLogout.Util;
import lombok.Data;

@Data
public class ApiResponse {

	private String status;
	private boolean success;

	public ApiResponse(String status, boolean success) {
		super();
		this.status = status;
		this.success = success;
	}

}
