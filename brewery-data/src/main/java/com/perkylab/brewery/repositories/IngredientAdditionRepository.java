package com.perkylab.brewery.repositories;

import com.perkylab.brewery.domain.IngredientAddition;
import org.springframework.data.repository.CrudRepository;

public interface IngredientAdditionRepository extends CrudRepository<IngredientAddition, Long> {
}
