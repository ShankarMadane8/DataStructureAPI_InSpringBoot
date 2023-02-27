package com.humanCloud.Entity;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ResponseException {
	public Date timestamp;
	public HttpStatus error;
	public String msg;
	
	public ResponseException(HttpStatus error, String msg, Date timestamp) {
		super();
		this.error = error;
		this.msg = msg;
		this.timestamp=timestamp;
	}

}
