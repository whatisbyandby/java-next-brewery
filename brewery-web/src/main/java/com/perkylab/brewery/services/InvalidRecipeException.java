package com.perkylab.brewery.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidRecipeException extends ResponseStatusException {
    public InvalidRecipeException(HttpStatus statusCode, String message) {
        super(statusCode, message);
    }
}
