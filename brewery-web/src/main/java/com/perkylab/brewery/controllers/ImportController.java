package com.perkylab.brewery.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.perkylab.brewery.dto.HopDto;
import com.perkylab.brewery.services.ImportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/1.0/import")
public class ImportController {

    private final ImportService importService;

    public ImportController(ImportService importService) {
        this.importService = importService;
    }

    @PostMapping("/hop")
    public List<HopDto> importHops(@RequestBody String hopString) throws IOException {
        return importService.importHops(hopString).stream().map(HopDto::new).collect(Collectors.toList());
    }
}
