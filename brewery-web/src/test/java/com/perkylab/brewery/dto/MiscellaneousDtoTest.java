package com.perkylab.brewery.dto;

import com.perkylab.brewery.domain.IngredientUse;
import com.perkylab.brewery.domain.Miscellaneous;
import com.perkylab.brewery.domain.MiscellaneousType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiscellaneousDtoTest {

    @Test
    void toMiscellaneous() {
        Miscellaneous misc = new Miscellaneous();
        misc.setId(Long.valueOf(1));
        misc.setName("Test Name");
        misc.setNotes("Test Notes");
        misc.setOrigin("Test Origin");
        misc.setSupplier("Test Supplier");
        misc.setMiscType(MiscellaneousType.HERB);
        misc.setUse(IngredientUse.MASH);

        MiscellaneousDto miscDto = new MiscellaneousDto(misc);

        assertEquals(Long.valueOf(1), miscDto.getId());
        assertEquals("Test Name", miscDto.getName());
        assertEquals("Test Notes", miscDto.getNotes());
        assertEquals("Test Origin", miscDto.getOrigin());
        assertEquals("Test Supplier", miscDto.getSupplier());
        assertEquals(MiscellaneousType.HERB, miscDto.getMiscType());
        assertEquals(IngredientUse.MASH, miscDto.getUse());

        Miscellaneous testMisc = miscDto.toMiscellaneous();

        assertEquals(miscDto.getId(), testMisc.getId());
        assertEquals(miscDto.getName(), testMisc.getName());
        assertEquals(miscDto.getNotes(), testMisc.getNotes());
        assertEquals(miscDto.getOrigin(), testMisc.getOrigin());
        assertEquals(miscDto.getSupplier(), testMisc.getSupplier());
        assertEquals(miscDto.getMiscType(), testMisc.getMiscType());
        assertEquals(miscDto.getUse(), testMisc.getUse());
    }
}