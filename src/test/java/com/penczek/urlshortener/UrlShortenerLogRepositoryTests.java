package com.penczek.urlshortener;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.penczek.urlshortener.model.UrlShortener;
import com.penczek.urlshortener.model.UrlShortenerLog;
import com.penczek.urlshortener.repository.UrlShortenerLogRepository;
import com.penczek.urlshortener.repository.UrlShortenerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlShortenerLogRepositoryTests extends UrlShortenerTests {

	@Autowired
	UrlShortenerRepository urlShortenerRepository;
	
	@Autowired
	UrlShortenerLogRepository urlShortenerLogRepository;
	
	@Test
	public void test_countByUrlShortenerId_ok() {
		
		UrlShortenerLog urlShortenerLog = urlShortenerLogRepository.save( UrlShortenerLog.builder().id(ID).date(new Date()).urlShortenerId(ID).build() );
		assertThat(urlShortenerLog).isNotNull();
	
		Long total = urlShortenerLogRepository.countByUrlShortenerId(urlShortenerLog.getUrlShortenerId());
		assertThat(total).isNotNull();
		assertThat(total).isGreaterThan(0L);
		
		urlShortenerLogRepository.deleteById(ID);
		
	}
	

}
