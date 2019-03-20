package com.penczek.urlshortener.exception;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ApiError implements Serializable {

    private static final long serialVersionUID = 1L;

    private final HttpStatus status;
    private final String message;
    private final List<String> errors;

    public ApiError(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
        this.errors = Collections.emptyList();
    }

    public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

    public int getStatusCode() {
        return status.value();
    }
}
