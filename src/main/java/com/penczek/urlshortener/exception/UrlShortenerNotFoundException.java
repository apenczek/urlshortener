package com.penczek.urlshortener.exception;

public class UrlShortenerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String message;

	public UrlShortenerNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getLocalizedMessage() {
		return this.message;
	}	

}
