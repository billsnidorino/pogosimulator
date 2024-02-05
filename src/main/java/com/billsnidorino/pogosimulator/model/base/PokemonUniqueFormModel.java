package com.billsnidorino.pogosimulator.model.base;

import com.billsnidorino.pogosimulator.exceptions.NoEvolutionException;
import com.billsnidorino.pogosimulator.exceptions.NoMegaEvolutionException;
import com.billsnidorino.pogosimulator.exceptions.UndeterminableEvolutionException;
import com.billsnidorino.pogosimulator.exceptions.UndeterminableMegaEvolutionException;
import com.billsnidorino.pogosimulator.utils.MapHelper;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;

/**
 * Model for representing a given pokemon based on their given species and form.
 * This modeling s
 *  - Male and Female Pikachu use the same model
 *  - Male and Female Oinkalogne do not use the same model
 *  - Kantonian and Alolan Meowth do not use the same model
 *  - Rayquaza and Mega Rayquaza do not use the same model
 *  - Rockruff that can evolve into Dusk form Lycanroc use a different model than other Rockruff
 *  - Each Furfrou outfit would be a separate model
 *  - Costume pokemon would not be separate models in general (Notable exception is Armored Mewtwo)
 *  - Apex pokemon would be separate species models.
 *  - Shadow pokemon would be the same model
 *
 *  This class would not contain any data for individual specific pokemon of a given species, such as:
 *  - IVs
 *  - Level
 *  - Total health remaining
 *  - Current moveset
 *  - If a charged move is learned
 *  - If it is a shadow pokemon
 *
 * TODO: How should pokemon with gender requirements for evolve be handled? Or other restrictions?
 * TODO: Add more info on form-changing pokemon?
 * TODO: Add species size info?
 * TODO: Add region info?
 */
@Getter
//@EqualsAndHashCode TODO: Fix bug here. Function uses getter fields but then doesn't handle exceptions so can't build
public class PokemonUniqueFormModel extends PokemonSpeciesModel {

    // Distinguishes between forms
    private String formName;
    // A distinguishing dex name. This would differ between two pokemon of the same species but different forms
    private String uniqueDexName;
    // Model to maintain a pokemon's typing. Can handle dual types and single types
    private PokemonTypingModel typing;
    // Maintains stats
    private BaseStatsModel baseStats;
    private Map<String, PokemonUniqueFormModel> evolutions;
    // Default evolution is used for cases such as evolving Pikachu to Kantonian Raichu
    private Optional<PokemonUniqueFormModel> defaultEvolution;
    // Annoyingly needs to be a list due to Gimmighoul
    private Map<String, PokemonUniqueFormModel> preEvolutions;
    private Map<String, PokemonUniqueFormModel> megaEvolutions;

    private Map<String, MoveModel> possibleFastAttacks;
    private Map<String, MoveModel> possibleChargeAttacks;

    private boolean released;


    /**
     * Evolution functionality
     */

    /**
     *
     * @return
     */
    public boolean canEvolve() {
        return !getEvolutions().isEmpty();
    }

    /**
     *
     * @return
     */
    public Optional<PokemonUniqueFormModel> getDefaultEvolutionOptional() {
        if (defaultEvolution.isPresent()) {
            return defaultEvolution;
        } else if (getEvolutions().size() == 1) {
            return Optional.of(MapHelper.getDefaultMapValue(getEvolutions()));
        } else {
            return Optional.empty();
        }
    }

    /**
     *
     * @return
     * @throws UndeterminableEvolutionException
     */
    public PokemonUniqueFormModel getDefaultEvolution() throws UndeterminableEvolutionException {
        final Optional<PokemonUniqueFormModel> defaultEvolution = getDefaultEvolutionOptional();
        if (defaultEvolution.isPresent()) {
            return defaultEvolution.get();
        }

        throw new UndeterminableEvolutionException();
    }

    /**
     *
     * @return
     */
    public boolean hasDefaultEvolution() {
        return getDefaultEvolutionOptional().isPresent();
    }

    /**
     *
     * @return
     * @throws UndeterminableEvolutionException
     * @throws NoEvolutionException
     */
    public PokemonUniqueFormModel evolve() throws UndeterminableEvolutionException, NoEvolutionException {
        if (canEvolve()) {
            if (hasDefaultEvolution()) {
                return getDefaultEvolution();
            }
            throw new UndeterminableEvolutionException();
        }
        throw new NoEvolutionException();
    }

    /**
     * Mega Evolution functionality
     *
     * TODO: Refactor to be a "temporary form change" mechanic under the hood
     */

    /**
     *
     * @return
     */
    public boolean canMegaEvolve() {
        return !getMegaEvolutions().isEmpty();
    }

    public PokemonUniqueFormModel megaEvolve() throws UndeterminableMegaEvolutionException, NoMegaEvolutionException {
        if (canMegaEvolve()) {
            final Map<String, PokemonUniqueFormModel> megaEvolutions = getMegaEvolutions();
            if (megaEvolutions.size() == 1) {
                return MapHelper.getDefaultMapValue(megaEvolutions);
            }
            throw new UndeterminableMegaEvolutionException();
        }
        throw new NoMegaEvolutionException();
    }

    @Override
    public String getName() {
        return ""; // TODO: Add formatting here
    }

    @Override
    public String toString() {
        return ""; // TODO: Implement
    }
}
