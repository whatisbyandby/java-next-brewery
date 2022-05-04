package com.perkylab.brewery.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;
    private String description;
    private RecipeType recipeType;
    private BigInteger boilTime;
    private BigDecimal batchVolume;
    private BigDecimal preBoilVolume;
    private BigDecimal brewhouseEfficiency;
    private BigDecimal mashEfficiency;
    private String notes;

    @OneToMany(mappedBy = "recipe")
    private Set<IngredientAddition> ingredients;

    public Recipe() {
    }

    public Recipe(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", recipeType=" + recipeType +
                '}';
    }
}
