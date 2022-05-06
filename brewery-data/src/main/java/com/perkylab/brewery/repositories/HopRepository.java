package com.perkylab.brewery.repositories;

import com.perkylab.brewery.domain.Hop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HopRepository extends PagingAndSortingRepository<Hop, Long> {
}
