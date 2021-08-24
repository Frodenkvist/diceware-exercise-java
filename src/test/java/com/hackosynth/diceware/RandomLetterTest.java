package com.hackosynth.diceware;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomLetterTest {
    @Test
    public void someLettersTest() {
        Assertions.assertEquals('~', DiceWareUtil.randomLetter(1, 1));
        Assertions.assertEquals('*', DiceWareUtil.randomLetter(2, 2));
        Assertions.assertEquals('9', DiceWareUtil.randomLetter(6, 6));
        Assertions.assertEquals('4', DiceWareUtil.randomLetter(1, 6));
        Assertions.assertEquals('^', DiceWareUtil.randomLetter(6, 1));
    }
}
