package com.perkylab.brewery.services;

import com.perkylab.brewery.domain.Fermentable;
import com.perkylab.brewery.domain.Hop;
import com.perkylab.brewery.domain.Ingredient;
import com.perkylab.brewery.domain.Yeast;
import com.perkylab.brewery.dto.YeastDto;

import java.util.List;

public interface IngredientService {

    List<Ingredient> getAllIngredients();

    Ingredient updateIngredient(Long id, Ingredient ingredientUpdates);

    List<Fermentable> getAllFermentables();

    Fermentable getFermentableById(Long id) throws Exception;

    void deleteFermentableById(Long id);

    Fermentable newFermentable(Fermentable fermentable);

    List<Hop> getAllHops();

    Hop newHop(Hop hop);

    Hop getHopById(Long id) throws Exception;

    void deleteHopById(Long id);

    List<Yeast> getAllYeast();

    Yeast getYeastById(Long id) throws Exception;

    Yeast newYeast(Yeast yeast);

    void deleteYeastById(Long id);

}
