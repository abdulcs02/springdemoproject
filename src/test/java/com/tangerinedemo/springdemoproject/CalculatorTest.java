package com.tangerinedemo.springdemoproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void shouldAddTwoNumbers() {
        int result = 2 + 3;

        assertEquals(5, result);
        System.out.println("Success");
    }
}
