package com.calculator.homework22;

import exception.DivideByZero;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @Test
    public void plusTest() {
        int result = calculatorService.plus(7, 3);
        assertThat(result).isEqualTo(10);

        result = calculatorService.plus(2, 9);
        assertThat(result).isEqualTo(11);
    }

    @Test
    public void minusTest() {
        int result = calculatorService.minus(2, 1);
        assertThat(result).isEqualTo(1);

        result = calculatorService.minus(3, 4);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void multiplyTest() {
        int result = calculatorService.multiply(2, 3);
        assertThat(result).isEqualTo(6);

        result = calculatorService.multiply(7, 6);
        assertThat(result).isEqualTo(42);
    }

    @Test
    public void dividePositiveTest() {
        int result = calculatorService.divide(12, 4);
        assertThat(result).isEqualTo(3);

        result = calculatorService.divide(15, 3);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void divideNegativeTest() {
        assertThrows(DivideByZero.class,
                () -> calculatorService.divide(1, 0));
    }


}