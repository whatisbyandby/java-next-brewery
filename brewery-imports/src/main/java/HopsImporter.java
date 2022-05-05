import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perkylab.brewery.repositories.HopRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HopsImporter {

    private final ObjectMapper xmlMapper;

    public HopsImporter(ObjectMapper xmlMapper) {

        this.xmlMapper = xmlMapper;
    }

    public List<Hop> importHops(String hopString) throws JsonProcessingException {
        Hops hops = this.xmlMapper.readValue(hopString, Hops.class);
        return hops.getHops();
    }
}
