package com.penczek.urlshortener.model;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UrlShortener {

	@Id
	private String id;
	
	private String originalUrl;
	
}
