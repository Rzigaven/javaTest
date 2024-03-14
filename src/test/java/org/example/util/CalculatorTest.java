package org.example.util;

import org.example.util.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator =  new Calculator();
    }

    @Test
    void sum(){
        int sum = calculator.sum(15,12);
        Assertions.assertEquals(27,sum);
    }

    @Test
    void minus(){
        int minus = calculator.minus(15,12);
        Assertions.assertEquals(3,minus);
    }

    @Test
    void multiplication(){
        int multiplication = calculator.multiplication(15,12);
        Assertions.assertEquals(180,multiplication);
    }

    @Test
    void division(){
        int division = calculator.division(15,12);
        Assertions.assertEquals(1,division);
    }

    @Test
    void div_byZero(){
        int division = calculator.division(15,12);
        Assertions.assertThrows(ArithmeticException.class, ()  ->  calculator.division(5,0));
    }

}
