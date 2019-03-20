package com.penczek.urlshortener.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.zip.CRC32;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.penczek.urlshortener.exception.UrlShortenerException;
import com.penczek.urlshortener.exception.UrlShortenerInvalidUrlException;
import com.penczek.urlshortener.exception.UrlShortenerNotFoundException;
import com.penczek.urlshortener.model.UrlShortener;
import com.penczek.urlshortener.repository.UrlShortenerRepository;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {
	
    private static final String URL_SHORTENER_NOT_FOUND = "Url with id %s not found";

    private static final String URL_SHORTENER_INVALID_URL = "Url %s invalid";

    
	@Autowired
	UrlShortenerRepository urlShortenerRepository;

	@Override
	public UrlShortener findById(String id) throws UrlShortenerNotFoundException {
		return urlShortenerRepository.findById(id).orElseThrow(() -> new UrlShortenerNotFoundException(String.format(URL_SHORTENER_NOT_FOUND, id)));
	}

	@Override
	public UrlShortener save(String url) throws UrlShortenerException, UrlShortenerInvalidUrlException {
		try {
            new URL(url);
        } catch (MalformedURLException e) {
            throw new UrlShortenerInvalidUrlException(String.format(URL_SHORTENER_INVALID_URL, url));
        }
		return urlShortenerRepository.save(UrlShortener.builder().id(generateId()).originalUrl( url ).build());
	}
	
	private String generateId() {
		CRC32 crc = new CRC32();
	    crc.update(UUID.randomUUID().toString().getBytes());
	    return Long.toHexString(crc.getValue());
	}

}
