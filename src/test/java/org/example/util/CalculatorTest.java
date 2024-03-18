package org.example.util;

import org.example.util.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void sum() {
        double sum = calculator.sum(15, 12.2);
        assertEquals(27.2, sum);
    }

    @Test
    void minus() {
        double result = calculator.minus(15.0, 12.1);
        double expected = 2.9;
        double delta = 0.0001;

        assertEquals(expected, result, delta);
    }

    @Test
    void multiplication() {
        double multiplication = Calculator.multiplication(15.1, 12);
        assertEquals(181.2, multiplication);
    }

    @Test
    void division() {
        double division = Calculator.division(15, 12);
        assertEquals(1.25, division);
    }

    @Test
    void div_byZero() {
        //  double division = calculator.division(15,12);
        Assertions.assertThrows(ArithmeticException.class, () -> Calculator.division(5.0, 0.0));
    }
}