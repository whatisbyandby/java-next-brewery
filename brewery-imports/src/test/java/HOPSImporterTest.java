import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HOPSImporterTest {

    @Test
    void importHops() throws JsonProcessingException {
        String testString ="<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
                "<HOPS>\n" +
                "    <HOP>\n" +
                "        <NAME>Admiral</NAME>\n" +
                "        <VERSION>1</VERSION>\n" +
                "        <ORIGIN>United Kingdom</ORIGIN>\n" +
                "        <ALPHA>14.7500000</ALPHA>\n" +
                "        <AMOUNT>0.0000000</AMOUNT>\n" +
                "        <USE>Boil</USE>\n" +
                "        <TIME>0.0000000</TIME>\n" +
                "        <NOTES>Bittering hops derived from Wye Challenger.  Good high-alpha bittering hops.\n" +
                "Used for: Ales\n" +
                "Aroma: Primarily for bittering\n" +
                "Substitutes: Target, Northdown, Challenger\n" +
                "        </NOTES>\n" +
                "        <TYPE>Bittering</TYPE>\n" +
                "        <FORM>Pellet</FORM>\n" +
                "        <BETA>5.6000000</BETA>\n" +
                "        <HSI>15.0000000</HSI>\n" +
                "        <DISPLAY_AMOUNT>0.00 oz</DISPLAY_AMOUNT>\n" +
                "        <INVENTORY>0.00 oz</INVENTORY>\n" +
                "        <DISPLAY_TIME>0.0 min</DISPLAY_TIME>\n" +
                "    </HOP>\n" +
                "</HOPS>\n";

        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        HopsImporter hp = new HopsImporter(objectMapper);

        List<Hop> hopImports = hp.importHops(testString);

        assertEquals(1, hopImports.size());
    }
}