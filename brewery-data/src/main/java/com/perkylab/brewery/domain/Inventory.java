package com.perkylab.brewery.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Ingredient ingredient;

    private UnitOfMeasure unitOfMeasure;
    private UnitOfMeasure unitOfPurchase;
    private BigDecimal amount;

}
