package com.perkylab.brewery.services;

import com.perkylab.brewery.domain.*;
import com.perkylab.brewery.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final HopRepository hopRepository;
    private final FermentableRepository fermentableRepository;
    private final YeastRepository yeastRepository;
    private final MiscellaneousRepository miscRepository;

    public IngredientServiceImpl(
            IngredientRepository ingredientRepository,
            FermentableRepository fermentableRepository,
            HopRepository hopRepository,
            YeastRepository yeastRepository,
            MiscellaneousRepository miscRepository
    ) {
        this.ingredientRepository = ingredientRepository;
        this.hopRepository = hopRepository;
        this.fermentableRepository = fermentableRepository;
        this.yeastRepository = yeastRepository;
        this.miscRepository = miscRepository;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return null;
    }


    @Override
    public Ingredient updateIngredient(Long id, Ingredient ingredientUpdates) {
       Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);
       if (ingredientOptional.isPresent()){
           Ingredient existingIngredient = ingredientOptional.get();
           if (ingredientUpdates.getName() != null){
               existingIngredient.setName(ingredientUpdates.getName());
           }

           return ingredientRepository.save(existingIngredient);
       }
        return null;
    }

    @Override
    public List<Fermentable> getAllFermentables() {
        return StreamSupport.stream(fermentableRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Fermentable getFermentableById(Long id) throws Exception {
        Optional<Fermentable> result = fermentableRepository.findById(id);
        if (result.isEmpty()) {
            throw new Exception("Fermentable does not exist");
        }
        return result.get();
    }

    @Override
    public void deleteFermentableById(Long id) {
        fermentableRepository.deleteById(id);
    }

    @Override
    public Fermentable newFermentable(Fermentable fermentable) {
        return fermentableRepository.save(fermentable);
    }

    @Override
    public List<Hop> getAllHops() {
        return (List<Hop>) hopRepository.findAll();
    }

    @Override
    public Hop newHop(Hop hop) {
        return hopRepository.save(hop);
    }

    @Override
    public Hop getHopById(Long id) throws Exception {
        Optional<Hop> result = hopRepository.findById(id);
        if (result.isEmpty()) {
            throw new Exception("No Hop with id" + id.toString());
        }

        return result.get();
    }

    @Override
    public void deleteHopById(Long id) {
        hopRepository.deleteById(id);
    }

    @Override
    public List<Yeast> getAllYeast() {
        return StreamSupport
                .stream(yeastRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Yeast getYeastById(Long id) throws Exception {
        Optional<Yeast> result = yeastRepository.findById(id);
        if (result.isEmpty()){
            throw new Exception("No yeast with that id");
        }
        return result.get();
    }

    @Override
    public Yeast newYeast(Yeast yeast) {
        return yeastRepository.save(yeast);
    }

    @Override
    public void deleteYeastById(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public List<Miscellaneous> getAllMiscellaneous() {
        return StreamSupport
                .stream(miscRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Miscellaneous getMiscellaneousById(Long id) throws Exception {
        Optional<Miscellaneous> result = miscRepository.findById(id);
        if (result.isEmpty()) {
            throw new Exception("Mo misc with that id");
        }

        return result.get();
    }

    @Override
    public Miscellaneous newMiscellaneous(Miscellaneous misc) {
        return miscRepository.save(misc);
    }

    @Override
    public void deleteMiscellaneousById(Long id) {
        miscRepository.deleteById(id);
    }

}
