package com.hackosynth.diceware;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordMappingTest {
    @Test
    public void notEnoughDiceInDiceGroup() {
        assertThrows(IllegalArgumentException.class, () -> {
           DiceWareUtil.mapWords();
        });

        assertThrows(IllegalArgumentException.class, () -> {
           DiceWareUtil.mapWords(List.of());
        });

        assertThrows(IllegalArgumentException.class, () -> {
            DiceWareUtil.mapWords(List.of(1));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            DiceWareUtil.mapWords(List.of(1, 2, 3, 4));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            DiceWareUtil.mapWords(List.of(1, 2, 3, 4, 5), List.of(1, 2, 3, 4));
        });
    }

    @Test
    public void toManyDice() {
        assertThrows(IllegalArgumentException.class, () -> {
            DiceWareUtil.mapWords(List.of(1, 2, 3, 4, 5, 6));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            DiceWareUtil.mapWords(List.of(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            DiceWareUtil.mapWords(List.of(1, 2, 3, 4, 5), List.of(1, 2, 3, 4, 5, 6));
        });
    }

    @Test
    public void mapOneWord() {
        var result = DiceWareUtil.mapWords(List.of(1, 1, 1, 1, 1));

        assertEquals(1, result.size());
        assertEquals(result.keySet().stream().findFirst().get(), List.of(1, 1, 1, 1, 1));
        assertEquals("a", result.values().stream().findFirst().get());
    }

    @Test
    public void mapTwoWords() {
        var result = DiceWareUtil.mapWords(List.of(3, 3, 4, 6, 2), List.of(2, 2, 3, 4, 1));

        assertEquals(2, result.size());
        assertEquals("dante", result.get(List.of(2, 2, 3, 4, 1)));
        assertEquals("hymen", result.get(List.of(3, 3, 4, 6, 2)));
    }

    @Test
    public void identicalDiceRollsAggregates() {
        var result = DiceWareUtil.mapWords(List.of(2, 6, 6, 3, 6), List.of(2, 6, 6, 3, 6));

        assertEquals(1, result.size());
        assertEquals(List.of(2, 6, 6, 3, 6), result.keySet().stream().findFirst().get());
        assertEquals("gauge", result.values().stream().findFirst().get());
    }
}
