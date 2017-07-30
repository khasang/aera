package io.aera.util;

import java.util.Random;

/**
 * Util for get result by throw dice.
 *
 * @author SGavr
 * @since 1.0
 */
public class ThrowDice {
    private static final Random RANDOM = new Random();

    /**
     * Usage only static methods
     */
    private ThrowDice() {
    }

    /**
     * Make throw dices
     * @return point on dices
     */
    public static int MakeThrowDices() {
        int result = 0;
        int COUNT_DICES = 2;
        for (int i = 0; i < COUNT_DICES; i++) {
            int SCORES_PER_DICE = 6;
            result += RANDOM.nextInt(SCORES_PER_DICE) + 1;
        }
        return result;
    }
}
