package com.perkylab.brewery.repositories;

import com.perkylab.brewery.domain.Fermentable;
import org.springframework.data.repository.CrudRepository;

public interface FermentableRepository extends CrudRepository<Fermentable, Long> {
}
