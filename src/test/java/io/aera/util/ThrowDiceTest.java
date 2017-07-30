package io.aera.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ThrowDiceTest {
    @Test
    public void makeThrowDices() throws Exception {
        Map<Integer, Integer> dicesThrows = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            int result = ThrowDice.MakeThrowDices();
            assertTrue( "Incorrect result: " + result, (result >= 2) && (result <= 12));
            dicesThrows.put(result, (dicesThrows.get(result) == null) ? 0 : dicesThrows.get(result) + 1);
        }
        System.err.println(dicesThrows);
    }
}