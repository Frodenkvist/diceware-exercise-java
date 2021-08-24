package com.hackosynth.diceware;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceTest {
    @Test
    public void sanityCheckDice() {
        var rolls = new ArrayList<Integer>();

        for(var i = 0; i < 10_000; ++i) {
            rolls.add(Dice.rollDice());
        }

        assertTrue(rolls.stream().anyMatch(r -> r.equals(1)));
        assertTrue(rolls.stream().anyMatch(r -> r.equals(2)));
        assertTrue(rolls.stream().anyMatch(r -> r.equals(3)));
        assertTrue(rolls.stream().anyMatch(r -> r.equals(4)));
        assertTrue(rolls.stream().anyMatch(r -> r.equals(5)));
        assertTrue(rolls.stream().anyMatch(r -> r.equals(6)));

        assertTrue(rolls.stream().allMatch(r -> r <= 6 && r >= 1));
    }
}
