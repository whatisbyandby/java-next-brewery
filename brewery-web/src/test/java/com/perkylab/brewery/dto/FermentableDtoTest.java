package com.perkylab.brewery.dto;

import com.perkylab.brewery.domain.Fermentable;
import com.perkylab.brewery.domain.FermentableType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FermentableDtoTest {

    @Test
    void testConstructor() {
        FermentableDto testFermentableDto = new FermentableDto();
    }

    @Test
    void toFermentable() {
        Fermentable fermentable = new Fermentable();
        fermentable.setId(Long.valueOf(1));
        fermentable.setName("Test Name");
        fermentable.setNotes("Test Notes");
        fermentable.setOrigin("Test Origin");
        fermentable.setSupplier("Test Supplier");
        fermentable.setFermentableType(FermentableType.GRAIN);
        fermentable.setPotential(new BigDecimal("1.0"));
        fermentable.setYield(new BigDecimal("2.0"));
        fermentable.setFermentable(true);

        FermentableDto fermentableDto = new FermentableDto(fermentable);

        assertEquals(Long.valueOf(1), fermentableDto.getId());
        assertEquals("Test Name", fermentableDto.getName());
        assertEquals("Test Notes", fermentableDto.getNotes());
        assertEquals("Test Origin", fermentableDto.getOrigin());
        assertEquals("Test Supplier", fermentableDto.getSupplier());
        assertEquals(FermentableType.GRAIN, fermentableDto.getFermentableType());
        assertEquals(new BigDecimal("1.0"), fermentableDto.getPotential());
        assertEquals(new BigDecimal("2.0"), fermentableDto.getYield());
        assertEquals(true, fermentableDto.isFermentable());

        Fermentable testFermentable = fermentableDto.toFermentable();

        assertEquals(fermentable.getId(), testFermentable.getId());
        assertEquals(fermentable.getName(), testFermentable.getName());
        assertEquals(fermentable.getNotes(), testFermentable.getNotes());
        assertEquals(fermentable.getOrigin(), testFermentable.getOrigin());
        assertEquals(fermentable.getSupplier(), testFermentable.getSupplier());
        assertEquals(fermentable.getFermentableType(), testFermentable.getFermentableType());
        assertEquals(fermentable.getPotential(), testFermentable.getPotential());
        assertEquals(fermentable.getYield(), testFermentable.getYield());
        //assertEquals(fermentable.isFermentable(), testFermentable.isFermentable());

    }
}