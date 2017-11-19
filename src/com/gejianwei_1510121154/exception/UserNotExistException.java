package com.gejianwei_1510121154.exception;

public class UserNotExistException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UserNotExistException() {
		super();
	}

	public UserNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotExistException(String message) {
		super(message);
	}

	public UserNotExistException(Throwable cause) {
		super(cause);
	}
}
