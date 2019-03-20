package com.penczek.urlshortener.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.penczek.urlshortener.model.UrlShortenerLog;

@Repository
public interface UrlShortenerLogRepository extends MongoRepository<UrlShortenerLog, String>{
	
	Long countByUrlShortenerId(String urlShortenerId);
	
	List<UrlShortenerLog> findByUrlShortenerId(String urlShortenerId, Pageable pageable);


}
