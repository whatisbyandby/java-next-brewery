package com.perkylab.brewery.repositories;

import com.perkylab.brewery.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
