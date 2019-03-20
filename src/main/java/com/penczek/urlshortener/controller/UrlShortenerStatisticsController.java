package com.penczek.urlshortener.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.penczek.urlshortener.model.UrlShortenerLog;
import com.penczek.urlshortener.service.UrlShortenerLogService;


@RestController
@RequestMapping("/statistics")
public class UrlShortenerStatisticsController {
	
	@Autowired
	UrlShortenerLogService urlShortenerLogService;
	
    @GetMapping("/totalRequestById/{id}")
    public ResponseEntity<Long> getTotalRequestById(@PathVariable("id") String id) {
    	return ResponseEntity.ok(urlShortenerLogService.getTotalById(id));
    }
    
    @GetMapping("/latest10RequestById/{id}")
    public ResponseEntity<List<UrlShortenerLog>> getLatest10RequestById(@PathVariable("id") String id) {
    	return ResponseEntity.ok(urlShortenerLogService.getLatest10RequestById(id));
    }
    

}
