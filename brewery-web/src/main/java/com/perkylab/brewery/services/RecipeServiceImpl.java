package com.perkylab.brewery.services;

import com.perkylab.brewery.domain.IngredientAddition;
import com.perkylab.brewery.domain.Recipe;
import com.perkylab.brewery.repositories.IngredientAdditionRepository;
import com.perkylab.brewery.repositories.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @PersistenceContext
    private EntityManager entityManager;

    private final RecipeRepository recipeRepository;
    private final IngredientAdditionRepository ingredientAdditionRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository, IngredientAdditionRepository ingredientAdditionRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientAdditionRepository = ingredientAdditionRepository;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return (List<Recipe>) recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeDetails(Long id) throws Exception {
        Optional<Recipe> result = recipeRepository.findById(id);
        if (result.isEmpty()) {
            throw new Exception("No Recipe With That Id");
        }
        return result.get();
    }

    @Override
    public Recipe newRecipe(Recipe recipe) throws InvalidRecipeException {
        this.validate(recipe);
        return recipeRepository.save(recipe);
    }

    @Override
    public IngredientAddition addIngredient(Long id, IngredientAddition ingredientAddition) {
        Recipe recipe = entityManager.getReference(Recipe.class, id);
        ingredientAddition.setRecipe(recipe);
        return ingredientAdditionRepository.save(ingredientAddition);
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    private void validate(Recipe recipe) throws InvalidRecipeException {
        boolean isValid = true;
        String message = "";

        if (recipe.getName() == null || recipe.getName().trim() == ""){
            isValid = false;
            message = "Name is a required field";
        }

        if (!isValid) {
            throw new InvalidRecipeException(HttpStatus.BAD_REQUEST, message);
        }
    }
}
