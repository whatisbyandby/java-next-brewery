package com.perkylab.brewery.dto;

import com.perkylab.brewery.domain.Fermentable;
import com.perkylab.brewery.domain.FermentableType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FermentableDto extends IngredientDto {


    private FermentableType fermentableType;
    private BigDecimal potential;
    private BigDecimal yield;
    private boolean isFermentable;

    public FermentableDto() {

    }

    public FermentableDto(Fermentable fermentable) {
        super(fermentable);

        this.fermentableType = fermentable.getFermentableType();
        this.potential = fermentable.getPotential();
        this.yield = fermentable.getYield();
        this.isFermentable = fermentable.isFermentable();
    }

    public Fermentable toFermentable() {
        Fermentable fermentable = new Fermentable();
        fermentable.setId(this.getId());
        fermentable.setName(this.getName());
        fermentable.setNotes(this.getNotes());
        fermentable.setOrigin(this.getOrigin());
        fermentable.setSupplier(this.getSupplier());
        fermentable.setFermentableType(this.fermentableType);
        fermentable.setPotential(this.potential);
        fermentable.setYield(this.yield);
        setFermentable(this.isFermentable);

        return fermentable;
    }
}
