package com.billsnidorino.pogosimulator.model.base;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Model for representing IVs for a given pokemon.
 */
@Getter
@EqualsAndHashCode
public class IvStatsModel {
    private int attack;
    private int defense;
    private int hp;
}
