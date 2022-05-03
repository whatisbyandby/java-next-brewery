package com.perkylab.brewery.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date brewDate;

    @ManyToOne
    private Recipe recipe;

    public Batch() {

    }

    public Batch(Recipe recipe) {
        this.recipe = recipe;
    }


    public Date getBrewDate() {
        return brewDate;
    }

    public void setBrewDate(Date brewDate) {
        this.brewDate = brewDate;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
