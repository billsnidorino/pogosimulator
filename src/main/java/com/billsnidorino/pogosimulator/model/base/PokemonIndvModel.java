package com.billsnidorino.pogosimulator.model.base;

import com.billsnidorino.pogosimulator.model.enums.PokemonGender;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * A model to represent an individual pokemon species.
 *
 * This model points to a {}@link package com.billsnidorino.pogosimulator.model.base.PokemonUniqueFormModel}
 *
 * Data contained by an individual pokemon that can vary between pokemon of the same form and species exist here
 */
@Getter
@EqualsAndHashCode
public class PokemonIndvModel extends PokemonUniqueFormModel {

    // Stats that vary for each pokemon
    private IvStatsModel ivs;
    private int level;
    private PokemonMovesetModel moveset;
    private PokemonGender gender;

    // TODO: Add size information?
}
