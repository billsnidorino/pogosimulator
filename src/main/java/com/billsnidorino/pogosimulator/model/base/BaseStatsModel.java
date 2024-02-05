package com.billsnidorino.pogosimulator.model.base;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Model to hold the base stats of a given pokemon. Base stats are constant for a given species/form
 *
 * These are based on the base stats from the mainline games, but don't actually match up.
 */
@Getter
@EqualsAndHashCode
public class BaseStatsModel {

    private int attack;
    private int defense;
    private int hp;
}
