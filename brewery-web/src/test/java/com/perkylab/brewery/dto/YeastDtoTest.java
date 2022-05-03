package com.perkylab.brewery.dto;

import com.perkylab.brewery.domain.Yeast;
import com.perkylab.brewery.domain.YeastType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class YeastDtoTest {

    @Test
    void toYeast() {
        Yeast yeast = new Yeast();
        yeast.setId(Long.valueOf(1));
        yeast.setName("Test Name");
        yeast.setNotes("Test Notes");
        yeast.setSupplier("Test Supplier");
        yeast.setOrigin("Test Origin");
        yeast.setAttenuation(new BigDecimal("75.0"));
        yeast.setYeastType(YeastType.ALE);
        yeast.setMinimumTemperature(new BigDecimal("50.0"));
        yeast.setMaximumTemperature(new BigDecimal("80.0"));
        yeast.setMinimumAttenuation(new BigDecimal("75.0"));
        yeast.setMaximumAttenuation(new BigDecimal("80.0"));
        yeast.setMaximumABV(new BigDecimal("10.0"));

        YeastDto yeastDto = new YeastDto(yeast);

        assertEquals(Long.valueOf(1), yeast.getId());
        assertEquals("Test Name", yeast.getName());
        assertEquals("Test Notes", yeast.getNotes());
        assertEquals("Test Supplier", yeast.getSupplier());
        assertEquals("Test Origin", yeast.getOrigin());
        assertEquals(new BigDecimal("75.0"), yeast.getAttenuation());
        assertEquals(YeastType.ALE, yeast.getYeastType());
        assertEquals(new BigDecimal("50.0"), yeast.getMinimumTemperature());
        assertEquals(new BigDecimal("80.0"), yeast.getMaximumTemperature());
        assertEquals(new BigDecimal("75.0"), yeast.getMinimumAttenuation());
        assertEquals(new BigDecimal("80.0"), yeast.getMaximumAttenuation());
        assertEquals(new BigDecimal("10.0"), yeast.getMaximumABV());

        Yeast testYeast = yeastDto.toYeast();

        assertEquals(yeastDto.getId(), testYeast.getId());
        assertEquals(yeastDto.getName(), testYeast.getName());
        assertEquals(yeastDto.getNotes(), testYeast.getNotes());
        assertEquals(yeastDto.getSupplier(), testYeast.getSupplier());
        assertEquals(yeastDto.getOrigin(), testYeast.getOrigin());
        assertEquals(yeastDto.getAttenuation(), testYeast.getAttenuation());
        assertEquals(yeastDto.getYeastType(), testYeast.getYeastType());
        assertEquals(yeastDto.getMinimumTemperature(), testYeast.getMinimumTemperature());
        assertEquals(yeastDto.getMaximumTemperature(), testYeast.getMaximumTemperature());
        assertEquals(yeastDto.getMinimumAttenuation(), testYeast.getMinimumAttenuation());
        assertEquals(yeastDto.getMaximumAttenuation(), testYeast.getMaximumAttenuation());
        assertEquals(yeastDto.getMaximumABV(), testYeast.getMaximumABV());

    }
}