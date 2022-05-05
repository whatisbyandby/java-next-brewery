import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
public class HOPS {

    @JacksonXmlProperty(localName = "HOP")
    private List<Hop> hops;
}
