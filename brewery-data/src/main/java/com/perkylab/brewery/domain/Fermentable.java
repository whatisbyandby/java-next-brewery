package com.perkylab.brewery.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Fermentable extends Ingredient {

    private FermentableType fermentableType;
    private BigDecimal potential;
    private BigDecimal yield;
    private boolean isFermentable;
    private GrainCategory grainCategory;

}
