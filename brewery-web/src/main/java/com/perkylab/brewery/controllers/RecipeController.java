package com.perkylab.brewery.controllers;

import com.perkylab.brewery.domain.IngredientAddition;
import com.perkylab.brewery.domain.Recipe;
import com.perkylab.brewery.domain.RecipeType;
import com.perkylab.brewery.dto.RecipeDto;
import com.perkylab.brewery.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/1.0/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return recipes;
    }

    @GetMapping("/{id}")
    public Recipe getRecipeDetails(@PathVariable Long id) throws Exception {
        return recipeService.getRecipeDetails(id);
    }

    @PostMapping
    public ResponseEntity<Recipe> newRecipe(@RequestBody RecipeDto recipeDto) {
        Recipe recipe = recipeDto.toRecipe();
        return ResponseEntity.ok().body(recipeService.newRecipe(recipe));
    }

    @PostMapping("/{id}/ingredient")
    public ResponseEntity<IngredientAddition> addIngredient(@PathVariable Long id, @RequestBody IngredientAddition ingredientAddition) {
        return ResponseEntity.ok().body(recipeService.addIngredient(id, ingredientAddition));
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }

    @GetMapping("/types")
    public List<String> getRecipeTypes(){
        return Stream.of(RecipeType.values()).map(RecipeType::name).collect(Collectors.toList());
    }

}
