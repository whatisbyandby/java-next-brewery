package com.perkylab.brewery.dto;


import com.perkylab.brewery.domain.Recipe;
import com.perkylab.brewery.domain.RecipeType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
public class RecipeDto {
    private Long id;
    private String name;
    private String author;
    private String description;
    private RecipeType recipeType;
    private BigInteger boilTime;
    private BigDecimal batchVolume;
    private BigDecimal preBoilVolume;
    private BigDecimal brewhouseEfficiency;
    private BigDecimal mashEfficiency;
    private String notes;

    private List<IngredientAdditionDto> ingredientList;

    public RecipeDto() {
    }

    public RecipeDto(Recipe recipe) {
        this.setName(recipe.getName());
        this.setAuthor(recipe.getAuthor());
        this.setDescription(recipe.getDescription());
        this.setRecipeType(recipe.getRecipeType());
        this.setBoilTime(recipe.getBoilTime());
        this.setBatchVolume(recipe.getBatchVolume());
        this.setPreBoilVolume(recipe.getPreBoilVolume());
        this.setBrewhouseEfficiency(recipe.getBrewhouseEfficiency());
        this.setMashEfficiency(recipe.getMashEfficiency());
        this.setNotes(recipe.getNotes());
    }



    public Recipe toRecipe() {
        Recipe recipe = new Recipe();
        recipe.setName(this.getName());
        recipe.setAuthor(this.getAuthor());
        recipe.setDescription(this.getDescription());
        recipe.setRecipeType(this.getRecipeType());
        recipe.setBoilTime(this.getBoilTime());
        recipe.setBatchVolume(this.getBatchVolume());
        recipe.setPreBoilVolume(this.getPreBoilVolume());
        recipe.setBrewhouseEfficiency(this.getBrewhouseEfficiency());
        recipe.setMashEfficiency(this.getMashEfficiency());
        recipe.setNotes(this.getNotes());
        return recipe;
    }

}



