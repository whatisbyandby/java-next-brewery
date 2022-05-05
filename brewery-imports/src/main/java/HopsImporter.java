import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class HopsImporter {

    private final ObjectMapper xmlMapper;

    public HopsImporter(ObjectMapper xmlMapper) {

        this.xmlMapper = xmlMapper;
    }

    public List<Hop> importHops(String hopString) throws JsonProcessingException {
        HopsImport hopsImport = this.xmlMapper.readValue(hopString, HopsImport.class);
        System.out.println(hopsImport);
        return new ArrayList<>();
    }
}
