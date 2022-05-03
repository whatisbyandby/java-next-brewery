package com.perkylab.brewery.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Miscellaneous extends Ingredient {

    private MiscellaneousType miscType;
}
