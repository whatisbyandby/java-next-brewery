package com.perkylab.brewery;

import com.perkylab.brewery.domain.UnitOfMeasure;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class IngredientAdditionDto implements Serializable {
    private final Long id;
    private final BigDecimal amount;
    private final UnitOfMeasure unitOfMeasure;
}
