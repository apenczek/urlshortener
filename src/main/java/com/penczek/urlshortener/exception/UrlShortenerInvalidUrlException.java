package com.penczek.urlshortener.exception;

public class UrlShortenerInvalidUrlException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String message;

	public UrlShortenerInvalidUrlException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getLocalizedMessage() {
		return this.message;
	}	

}
