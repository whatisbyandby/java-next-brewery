package com.perkylab.brewery.dto;

import com.perkylab.brewery.domain.Hop;
import com.perkylab.brewery.domain.HopType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class HopDtoTest {

    @Test
    void testConstructor() {
        HopDto hopDto = new HopDto();
    }

    @Test
    void toHop() {

        Hop hop = new Hop();
        hop.setId(Long.valueOf(1));
        hop.setName("Test Name");
        hop.setNotes("Test Notes");
        hop.setOrigin("Test Origin");
        hop.setHopType(HopType.PELLET);
        hop.setAlpha(new BigDecimal(1.0));

        HopDto hopDto = new HopDto(hop);

        assertEquals("Test Name", hopDto.getName());
        assertEquals("Test Notes", hopDto.getNotes());
        assertEquals("Test Origin", hopDto.getOrigin());
        assertEquals(HopType.PELLET, hopDto.getHopType());
        assertEquals(new BigDecimal(1.0), hopDto.getAlpha());

        Hop testHop = hopDto.toHop();

        assertEquals(hop.getId(), testHop.getId());
        assertEquals(hop.getName(), testHop.getName());
        assertEquals(hop.getNotes(), testHop.getNotes());
        assertEquals(hop.getOrigin(), testHop.getOrigin());
        assertEquals(hop.getHopType(), testHop.getHopType());
        assertEquals(hop.getAlpha(), testHop.getAlpha());
    }
}