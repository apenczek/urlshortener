package com.penczek.urlshortener.model;


import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UrlShortenerLog {
	
	@Id
	private String id;
	
	private String urlShortenerId;
	
	private String userAgent;
	
	private String host;
	
	private Date date;
	

}
