package com.perkylab.brewery.dto;

import com.perkylab.brewery.domain.Ingredient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientDto {
    private Long id;
    private String name;
    private String notes;
    private String origin;
    private String supplier;

    public IngredientDto(){

    }

    public IngredientDto(Ingredient ingredient){
        this.id = ingredient.getId();
        this.name = ingredient.getName();
        this.origin = ingredient.getOrigin();
        this.supplier = ingredient.getSupplier();
        this.notes = ingredient.getNotes();

    }

    public Ingredient toIngredient(){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(this.name);
        ingredient.setOrigin(this.origin);
        ingredient.setSupplier(this.supplier);
        ingredient.setNotes(this.notes);

        return ingredient;
    }
}
