package com.rest.demo.users;

import java.time.LocalDateTime;

public class ErrorDetails {

	private final LocalDateTime timestamp;
	private final String message;
	private final String details;

	public ErrorDetails( final LocalDateTime timestamp, final String message, final String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}


}
