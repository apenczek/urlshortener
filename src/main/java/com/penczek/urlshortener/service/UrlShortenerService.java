package com.penczek.urlshortener.service;

import com.penczek.urlshortener.exception.UrlShortenerException;
import com.penczek.urlshortener.exception.UrlShortenerInvalidUrlException;
import com.penczek.urlshortener.exception.UrlShortenerNotFoundException;
import com.penczek.urlshortener.model.UrlShortener;

public interface UrlShortenerService {
	
	UrlShortener findById(String id) throws UrlShortenerNotFoundException;
	
	UrlShortener save( String url ) throws UrlShortenerException, UrlShortenerInvalidUrlException;
	
}
