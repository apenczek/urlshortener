package com.penczek.urlshortener.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.penczek.urlshortener.model.UrlShortenerLog;
import com.penczek.urlshortener.repository.UrlShortenerLogRepository;

@Service
public class UrlShortenerLogServiceImpl implements UrlShortenerLogService {
	
	@Autowired
	UrlShortenerLogRepository urlShortenerLogRepository;

	@Override
	public void save(UrlShortenerLog urlShortenerLog) {
		urlShortenerLogRepository.save(urlShortenerLog);
	}

	public Long getTotalById(String urlShortenerId) {
		return urlShortenerLogRepository.countByUrlShortenerId(urlShortenerId);
	}
	
	public List<UrlShortenerLog> getLatest10RequestById(String urlShortenerId) {
		Pageable pageable = PageRequest.of(0,10, new Sort(Sort.Direction.DESC, "date"));
		return urlShortenerLogRepository.findByUrlShortenerId(urlShortenerId, pageable);
	}
	
}
