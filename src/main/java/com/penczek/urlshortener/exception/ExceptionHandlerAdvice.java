package com.penczek.urlshortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(UrlShortenerNotFoundException.class)
    public ResponseEntity<ApiError> handleUrlShortenerNotFoundException(final UrlShortenerNotFoundException e) {
        final ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(UrlShortenerException.class)
    public ResponseEntity<ApiError> handleUrlShortenerException(final UrlShortenerException e) {
        final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(UrlShortenerInvalidUrlException.class)
    public ResponseEntity<ApiError> handleUrlShortenerInvalidUrlException(final UrlShortenerInvalidUrlException e) {
        final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
