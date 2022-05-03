package com.perkylab.brewery.repositories;

import com.perkylab.brewery.domain.Batch;
import org.springframework.data.repository.CrudRepository;

public interface BatchRepository extends CrudRepository<Batch, Long> {
}
