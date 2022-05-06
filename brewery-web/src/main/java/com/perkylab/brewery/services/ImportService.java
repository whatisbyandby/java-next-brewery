package com.perkylab.brewery.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.perkylab.brewery.domain.Hop;
import com.perkylab.brewery.dto.HopDto;

import java.io.IOException;
import java.util.List;

public interface ImportService {
    List<Hop> importHops(String hopImport) throws IOException;
}
