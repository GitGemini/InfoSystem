package com.gejianwei_1510121154.exception;

public class UserExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserExistException() {
		super();
	}

	public UserExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserExistException(String message) {
		super(message);
	}

	public UserExistException(Throwable cause) {
		super(cause);
	}
	
	
}
