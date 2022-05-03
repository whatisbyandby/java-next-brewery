package com.perkylab.brewery.dto;

import com.perkylab.brewery.domain.IngredientUse;
import com.perkylab.brewery.domain.Miscellaneous;
import com.perkylab.brewery.domain.MiscellaneousType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MiscellaneousDto extends IngredientDto {

    private MiscellaneousType miscType;
    private IngredientUse use;

    public MiscellaneousDto(){

    }

    public MiscellaneousDto(Miscellaneous misc) {
        super(misc);
        this.miscType = misc.getMiscType();
        this.use = misc.getUse();

    }

    public Miscellaneous toMiscellaneous() {
        Miscellaneous misc = new Miscellaneous();
        misc.setId(this.getId());
        misc.setName(this.getName());
        misc.setNotes(this.getNotes());
        misc.setOrigin(this.getOrigin());
        misc.setSupplier(this.getSupplier());
        misc.setMiscType(this.miscType);
        misc.setUse(this.use);
        return misc;
    }
}
