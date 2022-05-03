package com.perkylab.brewery.repositories;

import com.perkylab.brewery.domain.Hop;
import org.springframework.data.repository.CrudRepository;

public interface HopRepository extends CrudRepository<Hop, Long> {
}
