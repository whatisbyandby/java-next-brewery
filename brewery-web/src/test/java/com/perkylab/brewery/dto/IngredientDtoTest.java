package com.perkylab.brewery.dto;

import com.perkylab.brewery.domain.Ingredient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientDtoTest {
    @Test
    void toIngredient() {

        Ingredient ingredient = new Ingredient();
        ingredient.setName("Test Ingredient");
        ingredient.setOrigin("Test Origin");
        ingredient.setSupplier("Test Supplier");
        ingredient.setNotes("Test Notes");

        IngredientDto ingredientDto = new IngredientDto(ingredient);

        assertEquals("Test Ingredient", ingredientDto.getName());
        assertEquals("Test Origin", ingredientDto.getOrigin());
        assertEquals("Test Supplier", ingredientDto.getSupplier());
        assertEquals("Test Notes", ingredientDto.getNotes());

        Ingredient testIngredient = ingredientDto.toIngredient();

        assertEquals("Test Ingredient", testIngredient.getName());
        assertEquals("Test Origin", testIngredient.getOrigin());
        assertEquals("Test Supplier", testIngredient.getSupplier());
        assertEquals("Test Notes", testIngredient.getNotes());
    }
}