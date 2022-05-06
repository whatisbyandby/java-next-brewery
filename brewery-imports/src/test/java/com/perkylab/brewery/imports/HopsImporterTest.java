package com.perkylab.brewery.imports;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HopsImporterTest {

    @Test
    void importHops() throws JsonProcessingException {
        String testString = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
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

        List<HopImport> hopImports = hp.importHops(testString);

        assertEquals(1, hopImports.size());
        HopImport testHop = hopImports.get(0);

        assertEquals("Admiral", testHop.getName());
        assertEquals(1, testHop.getVersion());
        assertEquals("United Kingdom", testHop.getOrigin());
        assertEquals(new BigDecimal("14.7500000"), testHop.getAlpha());
        assertEquals(new BigDecimal("0.0000000"), testHop.getAmount());
        assertEquals("Boil", testHop.getUse());
        assertEquals(new BigDecimal("0.0000000"), testHop.getTime());
        assertEquals("Bittering", testHop.getType());
        assertEquals("Pellet", testHop.getForm());
        assertEquals(new BigDecimal("5.6000000"), testHop.getBeta());
        assertEquals(new BigDecimal("15.0000000"), testHop.getHsi());
        assertEquals("0.00 oz", testHop.getDisplayAmount());
        assertEquals("0.00 oz", testHop.getInventory());
        assertEquals("0.0 min", testHop.getDisplayTime());
    }
}