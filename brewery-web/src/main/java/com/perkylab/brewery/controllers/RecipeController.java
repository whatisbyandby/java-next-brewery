package com.perkylab.brewery.controllers;

import com.perkylab.brewery.domain.IngredientAddition;
import com.perkylab.brewery.domain.Recipe;
import com.perkylab.brewery.domain.RecipeType;
import com.perkylab.brewery.dto.IngredientAdditionDto;
import com.perkylab.brewery.dto.RecipeDto;
import com.perkylab.brewery.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/1.0/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<RecipeDto> getRecipes() {
       return recipeService.getAllRecipes().stream()
               .map(RecipeDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RecipeDto getRecipeDetails(@PathVariable Long id) throws Exception {
        return new RecipeDto(recipeService.getRecipeDetails(id));
    }

    @PostMapping
    public ResponseEntity<RecipeDto> newRecipe(@RequestBody RecipeDto recipeDto) {
        Recipe recipe = recipeDto.toRecipe();
        return ResponseEntity.ok().body(new RecipeDto(recipeService.newRecipe(recipe)));
    }

    @PostMapping("/{id}/ingredient")
    public ResponseEntity<IngredientAdditionDto> addIngredient(@PathVariable Long id, @RequestBody IngredientAdditionDto ingredientAdditionDto) {

        IngredientAddition ingredientAddition = ingredientAdditionDto.toIngredientAddition();

        return ResponseEntity.ok().body(
                        new IngredientAdditionDto(recipeService.addIngredient(id, ingredientAdditionDto.getIngredientId(), ingredientAddition)));
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
