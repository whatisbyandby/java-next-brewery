package com.perkylab.brewery.dto;

import com.perkylab.brewery.domain.Recipe;
import com.perkylab.brewery.domain.RecipeType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class RecipeDtoTest {

    @Test
    void toRecipe() {
        // Create a test DTO
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setName("Test Name");
        recipeDto.setAuthor("Test Author");
        recipeDto.setDescription("Test Description");
        recipeDto.setRecipeType(RecipeType.EXTRACT);
        recipeDto.setBoilTime(new BigInteger("100"));
        recipeDto.setBatchVolume(new BigDecimal("1.0"));
        recipeDto.setPreBoilVolume(new BigDecimal("2.0"));
        recipeDto.setBrewhouseEfficiency(new BigDecimal("75.0"));
        recipeDto.setMashEfficiency(new BigDecimal("30.0"));
        recipeDto.setNotes("Test Notes");


       Recipe recipe = recipeDto.toRecipe();

       assertEquals("Test Name", recipe.getName());
       assertEquals("Test Author", recipe.getAuthor());
       assertEquals("Test Description", recipe.getDescription());
       assertEquals(RecipeType.EXTRACT, recipe.getRecipeType());
       assertEquals(new BigInteger("100"), recipe.getBoilTime());
       assertEquals(new BigDecimal("1.0"), recipe.getBatchVolume());
       assertEquals(new BigDecimal("2.0"), recipe.getPreBoilVolume());
       assertEquals(new BigDecimal("75.0"), recipe.getBrewhouseEfficiency());
       assertEquals(new BigDecimal("30.0"), recipe.getMashEfficiency());
       assertEquals("Test Notes", recipe.getNotes());

       RecipeDto convertedRecipeDto = new RecipeDto(recipe);

        assertEquals("Test Name", convertedRecipeDto.getName());
        assertEquals("Test Author", convertedRecipeDto.getAuthor());
        assertEquals("Test Description", convertedRecipeDto.getDescription());
        assertEquals(RecipeType.EXTRACT, convertedRecipeDto.getRecipeType());
        assertEquals(new BigInteger("100"), convertedRecipeDto.getBoilTime());
        assertEquals(new BigDecimal("1.0"), convertedRecipeDto.getBatchVolume());
        assertEquals(new BigDecimal("2.0"), convertedRecipeDto.getPreBoilVolume());
        assertEquals(new BigDecimal("75.0"), convertedRecipeDto.getBrewhouseEfficiency());
        assertEquals(new BigDecimal("30.0"), convertedRecipeDto.getMashEfficiency());
        assertEquals("Test Notes", convertedRecipeDto.getNotes());
    }


}