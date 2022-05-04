package com.perkylab.brewery.services;

import com.perkylab.brewery.domain.IngredientAddition;
import com.perkylab.brewery.domain.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();
    Recipe getRecipeDetails(Long id) throws Exception;
    Recipe newRecipe(Recipe recipe) throws InvalidRecipeException;
    void deleteRecipe(Long id);
    IngredientAddition addIngredient(Long id, Long ingredientId, IngredientAddition ingredientAddition);
}
