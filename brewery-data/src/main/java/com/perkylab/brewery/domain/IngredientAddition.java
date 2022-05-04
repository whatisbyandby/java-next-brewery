package com.perkylab.brewery.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class IngredientAddition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amount;
    private UnitOfMeasure unitOfMeasure;

    @ManyToOne(optional = false)
    private Ingredient ingredient;

    @ManyToOne(optional = false)
    private Recipe recipe;

}
