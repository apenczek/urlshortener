package com.penczek.urlshortener.controller;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.penczek.urlshortener.exception.UrlShortenerException;
import com.penczek.urlshortener.exception.UrlShortenerInvalidUrlException;
import com.penczek.urlshortener.exception.UrlShortenerNotFoundException;
import com.penczek.urlshortener.model.UrlShortener;
import com.penczek.urlshortener.model.UrlShortenerLog;
import com.penczek.urlshortener.service.UrlShortenerLogService;
import com.penczek.urlshortener.service.UrlShortenerService;


@RestController
public class UrlShortenerController {
	
	@Autowired
	UrlShortenerService urlShortenerService;
	
	@Autowired
	UrlShortenerLogService urlShortenerLogService;
	
    @GetMapping("/{id}")
    public void getUrlShortener(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws UrlShortenerNotFoundException, IOException {
    	urlShortenerLogService.save(buildUrlShortenerLog(id,request));
    	response.sendRedirect( urlShortenerService.findById(id).getOriginalUrl() );
    }
    
    @PostMapping()
    public ResponseEntity<UrlShortener> postUrlShortener(@RequestBody String url) throws UrlShortenerException, UrlShortenerInvalidUrlException{
        return ResponseEntity.ok( urlShortenerService.save( url ) );
    }
    
    private UrlShortenerLog buildUrlShortenerLog(String id, HttpServletRequest request) {
    	return UrlShortenerLog.builder()
    			.id(UUID.randomUUID().toString())
    			.urlShortenerId(id)
    			.date(new Date())
    			.host(request.getHeader("Host"))
    			.userAgent(request.getHeader("User-Agent"))
    			.build();
    }

}
