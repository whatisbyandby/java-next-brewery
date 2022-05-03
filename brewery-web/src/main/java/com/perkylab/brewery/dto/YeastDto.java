package com.perkylab.brewery.dto;

import com.perkylab.brewery.domain.Yeast;
import com.perkylab.brewery.domain.YeastType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class YeastDto extends IngredientDto {
    private BigDecimal attenuation;
    private YeastType yeastType;
    private BigDecimal minimumTemperature;
    private BigDecimal maximumTemperature;
    private BigDecimal minimumAttenuation;
    private BigDecimal maximumAttenuation;
    private BigDecimal maximumABV;

    public YeastDto() {

    }

    public YeastDto(Yeast yeast) {
        super(yeast);
        this.attenuation = yeast.getAttenuation();
        this.yeastType = yeast.getYeastType();
        this.minimumTemperature = yeast.getMinimumTemperature();
        this.maximumTemperature = yeast.getMaximumTemperature();
        this.minimumAttenuation = yeast.getMinimumAttenuation();
        this.maximumAttenuation = yeast.getMaximumAttenuation();
        this.maximumABV = yeast.getMaximumABV();
    }

    public Yeast toYeast() {
        Yeast yeast = new Yeast();
        yeast.setId(this.getId());
        yeast.setName(this.getName());
        yeast.setNotes(this.getNotes());
        yeast.setSupplier(this.getSupplier());
        yeast.setOrigin(this.getOrigin());
        yeast.setAttenuation(this.attenuation);
        yeast.setYeastType(this.yeastType);
        yeast.setMinimumTemperature(this.minimumTemperature);
        yeast.setMaximumTemperature(this.maximumTemperature);
        yeast.setMinimumAttenuation(this.minimumAttenuation);
        yeast.setMaximumAttenuation(this.maximumAttenuation);
        yeast.setMaximumABV(this.maximumABV);
        return yeast;
    }
}
