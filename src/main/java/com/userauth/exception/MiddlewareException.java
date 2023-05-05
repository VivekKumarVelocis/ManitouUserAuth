package com.userauth.exception;

public class MiddlewareException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MiddlewareException() {
		super();
	}

	public MiddlewareException(String message, Throwable cause) {
		super(message, cause);
	}

	public MiddlewareException(String message) {
		super(message);
	}

	public MiddlewareException(Throwable cause) {
		super(cause);
	}
}
