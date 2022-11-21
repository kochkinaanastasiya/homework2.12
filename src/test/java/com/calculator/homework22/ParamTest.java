package com.calculator.homework22;

import exception.DivideByZero;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParamTest {

    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource("paramsPlus")
    public void plusTest(int num1, int num2, Integer expected) {
        assertThat(calculatorService.plus(num1, num2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsMinus")
    public void minusTest(int num1, int num2, Integer expected) {
        assertThat(calculatorService.minus(num1, num2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsMultiply")
    public void multiplyTest(int num1, int num2, Integer expected) {
        assertThat(calculatorService.multiply(num1, num2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsDivide")
    public void divideTest(int num1, int num2, Integer expected) {
        if (num2 == 0) {
            assertThrows(DivideByZero.class,
                    () -> calculatorService.divide(1, 0));
        } else {
            assertThat(calculatorService.divide(num1, num2)).isEqualTo(expected);
        }
    }

    public static Stream<Arguments> paramsPlus() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 3, 5),
                Arguments.of(4, 5, 9),
                Arguments.of(0, 7, 7)
        );
    }

    public static Stream<Arguments> paramsMinus() {
        return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(2, 3, -1),
                Arguments.of(4, 5, -1),
                Arguments.of(0, 7, -7)
        );
    }

    public static Stream<Arguments> paramsMultiply() {
        return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(2, 3, 6),
                Arguments.of(4, 5, 20),
                Arguments.of(0, 7, 0)
        );
    }

    public static Stream<Arguments> paramsDivide() {
        return Stream.of(
                Arguments.of(4, 2, 2),
                Arguments.of(12, 3, 4),
                Arguments.of(15, 5, 3),
                Arguments.of(7, 0, 0)
        );
    }
}



