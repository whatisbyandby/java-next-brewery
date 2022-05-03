package com.perkylab.brewery.repositories;

import com.perkylab.brewery.domain.Yeast;
import org.springframework.data.repository.CrudRepository;

public interface YeastRepository extends CrudRepository<Yeast, Long> {
}
