package com.perkylab.brewery.domain;

import javax.persistence.*;

@Entity
public class IngredientAddition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UnitOfMeasure unitOfMeasure;

    @ManyToOne(optional = false)
    private Ingredient ingredient;

    @ManyToOne(optional = false)
    private Recipe recipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
