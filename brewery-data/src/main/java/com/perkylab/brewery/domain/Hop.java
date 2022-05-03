package com.perkylab.brewery.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Hop extends Ingredient {
    private HopType hopType;
    private BigDecimal alpha;
}
