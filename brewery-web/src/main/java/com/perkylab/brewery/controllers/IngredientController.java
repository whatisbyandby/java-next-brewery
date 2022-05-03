package com.perkylab.brewery.controllers;

import com.perkylab.brewery.domain.Fermentable;
import com.perkylab.brewery.domain.Hop;
import com.perkylab.brewery.domain.Ingredient;
import com.perkylab.brewery.domain.Yeast;
import com.perkylab.brewery.dto.FermentableDto;
import com.perkylab.brewery.dto.HopDto;
import com.perkylab.brewery.dto.YeastDto;
import com.perkylab.brewery.services.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/1.0/inventory")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/fermentable")
    public List<FermentableDto> getAllFermentables() {
        return ingredientService.getAllFermentables()
               .stream()
               .map(FermentableDto::new)
               .collect(Collectors.toList());
    }

    @GetMapping("/fermentable/{id}")
    public FermentableDto getFermentableById(@PathVariable Long id) throws Exception {
        Fermentable fermentable = ingredientService.getFermentableById(id);
        return new FermentableDto(fermentable);
    }

    @DeleteMapping("/fermentable/{id}")
    public void deleteFermentable(@PathVariable Long id) {
        ingredientService.deleteFermentableById(id);
    }

    @PostMapping("/fermentable")
    public FermentableDto newFermentable(@RequestBody FermentableDto fermentableDto) {
        Fermentable fermentable = fermentableDto.toFermentable();
        return new FermentableDto(ingredientService.newFermentable(fermentable));
    }

    @GetMapping("/hop")
    public List<Hop> getAllHops() {
        return ingredientService.getAllHops();
    }

    @PostMapping("/hop")
    public Ingredient newHop(@RequestBody Hop hop) {
        return ingredientService.newHop(hop);
    }

    @GetMapping("/hop/{id}")
    public HopDto getHopById(@PathVariable Long id) throws Exception {
        Hop hop = ingredientService.getHopById(id);
        return new HopDto(hop);
    }

    @DeleteMapping("/hop/{id}")
    public void deleteHopById(@PathVariable Long id){
        ingredientService.deleteHopById(id);
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredientUpdates) {
        ingredientService.updateIngredient(id, ingredientUpdates);
        return ingredientUpdates;
    }

    @GetMapping("/yeast")
    public List<YeastDto> getAllYeast() {
        return ingredientService.getAllYeast()
                .stream()
                .map(YeastDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/yeast/{id}")
    public YeastDto getYeastById(@PathVariable Long id) throws Exception {
        return new YeastDto(ingredientService.getYeastById(id));
    }

    @PostMapping("/yeast")
    public YeastDto newYeast(@RequestBody YeastDto yeastDto) {
        Yeast yeast = yeastDto.toYeast();
        return new YeastDto(ingredientService.newYeast(yeast));
    }

    @DeleteMapping("/yeast/{id}")
    public void deleteYeastById(@PathVariable Long id) {
        ingredientService.deleteYeastById(id);
    }

}
