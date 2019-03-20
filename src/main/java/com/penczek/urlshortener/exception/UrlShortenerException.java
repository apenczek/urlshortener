package com.penczek.urlshortener.exception;

public class UrlShortenerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UrlShortenerException(Throwable exception) {
		super(exception);		
	}
	

}
