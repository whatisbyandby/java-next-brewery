package com.perkylab.brewery.repositories;

import com.perkylab.brewery.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
