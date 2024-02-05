package com.billsnidorino.pogosimulator.model.base;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;

@Getter
@EqualsAndHashCode
public class PokemonSpeciesModel {

    // Self-Explanatory
    private int pokedexNumber;
    // The species dex name. Shared among Pokemon of the same species but different forms
    private String speciesDexName;
    private Map<String, PokemonUniqueFormModel> forms;
    // Some pokemon have a very clear "default" form, such as Genesect with no drives, Natural Trim Furfrou,
    // and Kantonian Raichu. Not all Pokmeon with forms do though (e.g. Florges)
    private Optional<PokemonUniqueFormModel> defaultForm;

    public String getName() {
        return ""; // TODO: Add formatting here
    }

    public String toString() {
        return ""; // TODO: Implement
    }


    /**
     * Functionality that goes from a pokemon dex entry to a given form.
     */

    public boolean hasForms() {
        return getForms().size() > 1;
    }

    public boolean hasDefaultForm() {
        return getDefaultForm().isPresent() || getForms().size() == 1;
    }

    /**
     * Switches pokemon to a specialized form.
     * @param form
     * @return
     */
    public PokemonUniqueFormModel withForm(final String form) {
        return null;
    }

    public PokemonUniqueFormModel setAsDefault() {
        return null;
    }

    /**
     * Functionality that converts a dex entry to a specific pokemon with unique characteristics.
     *
     * Note that
     *
     * TODO: Convert to builder setup, and implement
     */

    /**
     *
     * @param ivs
     * @return
     */
    public PokemonIndvModel withStats(final IvStatsModel ivs) {
        return withIvs(ivs);
    }

    public PokemonIndvModel withIvs(final IvStatsModel ivs) {
        return null;
    }

    public PokemonIndvModel withLevel(final int level) {
        return null;
    }

    public PokemonIndvModel withGender(final int level) {
        return null;
    }

    public PokemonIndvModel withFastMove() {
        return null;
    }

    public PokemonIndvModel withChargeMove() {
        return null;
    }

    public PokemonIndvModel withChargeMoves() {
        return null;
    }
}
