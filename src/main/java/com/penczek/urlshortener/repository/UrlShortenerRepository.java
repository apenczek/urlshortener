package com.penczek.urlshortener.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.penczek.urlshortener.model.UrlShortener;

@Repository
public interface UrlShortenerRepository extends MongoRepository<UrlShortener, String>{

}
