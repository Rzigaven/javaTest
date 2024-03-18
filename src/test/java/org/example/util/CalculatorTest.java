package org.example.util;

import org.example.util.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.2, 2.5, 10, 9})
    void sum(Double arg) {
        double sum = calculator.sum(arg, arg);
        assertEquals(2 * arg, sum);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.2, 2.5, 10, 9})
    void minus(Double arg) {
        double result = calculator.minus(arg, arg);
        double delta = 0.0001;

        assertEquals(0.0, result, delta);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.2, 2.5, 10, 9})
    void multiplication(Double arg) {
        double multiplication = Calculator.multiplication(arg, arg);
        assertEquals(arg * arg, multiplication);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.2, 2.5, 10, 9})
    void division(Double arg) {
        double division = Calculator.division(arg, arg);
        assertEquals(1.0, division);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.2, 2.5, 10, 9})
    void div_byZero(double arg) {
        Assertions.assertThrows(ArithmeticException.class, () -> Calculator.division(arg, 0.0));
    }
}