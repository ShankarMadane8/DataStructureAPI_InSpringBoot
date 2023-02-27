package com.humanCloud.customeException;

public class EmptyQueueException extends Exception {
	
	public EmptyQueueException(String str) {
		super(str);
	}

}
