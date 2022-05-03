package com.perkylab.brewery.services;

import com.perkylab.brewery.domain.IngredientAddition;
import com.perkylab.brewery.domain.Recipe;
import com.perkylab.brewery.repositories.IngredientAdditionRepository;
import com.perkylab.brewery.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private RecipeRepository recipeRepository;

    @Mock
    private IngredientAdditionRepository ingredientAdditionRepository;

    @InjectMocks
    private RecipeServiceImpl recipeService;

    @BeforeEach
    void setUp() {
        recipeService = new RecipeServiceImpl(recipeRepository, ingredientAdditionRepository);
    }

    @Test
    void getAllRecipes() {

        List<Recipe> recipeSet = new ArrayList<>();
        Recipe recipe = new Recipe();
        recipeSet.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeSet);

        List<Recipe> returnedList = recipeService.getAllRecipes();

        assertEquals(1, returnedList.size());
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    void newRecipe() {
    }

   @Test
    void addIngredient() {
        IngredientAddition ingredientAddition = new IngredientAddition();

        recipeService.addIngredient(1L, ingredientAddition);
//
//        verify(ingredientAdditionRepository, times(1)).save(ingredientAddition);
   }
}