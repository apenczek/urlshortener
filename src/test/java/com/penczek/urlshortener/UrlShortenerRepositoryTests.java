package com.penczek.urlshortener;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.penczek.urlshortener.model.UrlShortener;
import com.penczek.urlshortener.repository.UrlShortenerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlShortenerRepositoryTests extends UrlShortenerTests {

	@Autowired
	UrlShortenerRepository urlShortenerRepository;
	
	@Test
	public void test_save_ok() {
		
		UrlShortener urlShortener = urlShortenerRepository.save(UrlShortener.builder().id(ID).originalUrl(URL).build());
		assertThat(urlShortener).isNotNull();
		
	}
	
	public void test_findById_ok() {
		
		UrlShortener urlShortener = urlShortenerRepository.save(UrlShortener.builder().id(ID).originalUrl(URL).build());
		assertThat(urlShortener).isNotNull();
		
		Optional<UrlShortener> urlShortenerOptional = urlShortenerRepository.findById(ID);
		assertThat(urlShortenerOptional).isNotEmpty();
		assertThat(urlShortenerOptional.get().getId()).isEqualTo(ID);
		assertThat(urlShortenerOptional.get().getOriginalUrl()).isEqualTo(URL);
		
		
	}

}
