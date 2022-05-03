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
public class Yeast extends Ingredient {
    private BigDecimal attenuation;
    private YeastType yeastType;
    private BigDecimal minimumTemperature;
    private BigDecimal maximumTemperature;
    private BigDecimal minimumAttenuation;
    private BigDecimal maximumAttenuation;
    private BigDecimal maximumABV;
}
