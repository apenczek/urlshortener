package com.penczek.urlshortener;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.penczek.urlshortener.exception.UrlShortenerException;
import com.penczek.urlshortener.exception.UrlShortenerInvalidUrlException;
import com.penczek.urlshortener.exception.UrlShortenerNotFoundException;
import com.penczek.urlshortener.model.UrlShortener;
import com.penczek.urlshortener.service.UrlShortenerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlShortenerServiceTests extends UrlShortenerTests {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Autowired
	UrlShortenerService urlShortenerService;
	
	@Test
	public void test_save_ok() throws UrlShortenerException, UrlShortenerInvalidUrlException {
		UrlShortener urlShortener = urlShortenerService.save(URL);
		assertThat(urlShortener).isNotNull();
	}

	
	@Test
	public void test_save_invalid_url() throws UrlShortenerException, UrlShortenerInvalidUrlException {
		thrown.expect( UrlShortenerInvalidUrlException.class );	
		UrlShortener urlShortener = urlShortenerService.save(INVALID_URL);
		assertThat(urlShortener).isNotNull();

	}
	public void test_findById_ok() throws UrlShortenerNotFoundException, UrlShortenerException, UrlShortenerInvalidUrlException {
		UrlShortener urlShortener = urlShortenerService.save(URL);
		assertThat(urlShortener).isNotNull();
		
		UrlShortener urlShortenerResult = urlShortenerService.findById(urlShortener.getId());
		assertThat(urlShortenerResult).isNotNull();
		assertThat(urlShortenerResult.getId()).isEqualTo(urlShortener.getId());
		assertThat(urlShortenerResult.getOriginalUrl()).isEqualTo(URL);
		
		
	}

}
