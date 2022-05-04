package com.perkylab.brewery.dto;

import com.perkylab.brewery.domain.IngredientAddition;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class IngredientAdditionDto {

    private Long id;
    private Long ingredientId;
    private Long recipeId;
    private BigDecimal amount;

    public IngredientAdditionDto() {

    }

    public IngredientAdditionDto(IngredientAddition ingredientAddition) {
        this.id = ingredientAddition.getId();
        this.amount = ingredientAddition.getAmount();
        this.ingredientId = ingredientAddition.getIngredient().getId();
        this.recipeId = ingredientAddition.getRecipe().getId();
    }

    public IngredientAddition toIngredientAddition() {
        IngredientAddition ingredientAddition = new IngredientAddition();

        ingredientAddition.setId(this.id);
        ingredientAddition.setAmount(this.amount);
        return ingredientAddition;
    }

}
