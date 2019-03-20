package com.penczek.urlshortener.service;

import java.util.List;

import com.penczek.urlshortener.model.UrlShortenerLog;

public interface UrlShortenerLogService {

	void save( UrlShortenerLog urlShortenerLog );
	
	Long getTotalById(String urlShortenerId);
	
	List<UrlShortenerLog> getLatest10RequestById(String urlShortenerId);
	
}
