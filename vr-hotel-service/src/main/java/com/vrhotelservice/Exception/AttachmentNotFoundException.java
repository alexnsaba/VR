package com.vrhotelservice.Exception;

public class AttachmentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public AttachmentNotFoundException(String message) {
		super(message);
	}
}
