package com.app.exception;

public class CourseContentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8920057568349964000L;

	public CourseContentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CourseContentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CourseContentNotFoundException(String message) {
		super(message);
	}

	public CourseContentNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
