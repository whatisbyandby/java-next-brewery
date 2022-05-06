package com.perkylab.brewery.imports;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HopsImporter {
    private final XmlMapper xmlMapper;
    public HopsImporter(ObjectMapper xmlMapper) {

        this.xmlMapper = new XmlMapper();
    }

    public List<HopImport> importHops(String hopString) throws JsonProcessingException {
        Hops hops = this.xmlMapper.readValue(hopString, Hops.class);
        return hops.getHops();
    }
}
