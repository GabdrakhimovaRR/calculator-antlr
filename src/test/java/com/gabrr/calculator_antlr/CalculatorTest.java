package com.gabrr.calculator_antlr;

import com.gabrr.calculator_antlr.infrastructure.Calculator;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    @ParameterizedTest
    @MethodSource("mathExamples")
    void correctSyntax(String expression, Double expectedResult) {
        Calculator calculator = new Calculator();
        Double result = calculator.calculate(expression);

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("incorrectExamples")
    void incorrectSyntax (String expression) {
        Calculator calculator = new Calculator();

        assertThrows(ParseCancellationException.class,
                () -> calculator.calculate(expression));
    }

    static Stream<Arguments> mathExamples() {
        return Stream.of(
                Arguments.of("1 + 2", 3.0),
                Arguments.of("-1 + -2", -3.0),
                Arguments.of("1 / 2", 0.5),
                Arguments.of("1 / 4", 0.25),
                Arguments.of("1/4 + 1/4", 0.5),
                Arguments.of("4 / 1 * 2", 8.0),
                Arguments.of("4 / 0", Double.POSITIVE_INFINITY),
                Arguments.of("-4 / 0", Double.NEGATIVE_INFINITY),
                Arguments.of("2 * 3", 6.0),
                Arguments.of("-2 * 3", -6.0),
                Arguments.of("(2 + 3) * 2 - 1", 9.0),
                Arguments.of("1 - 2 * 3 + 4", -1.0),
                Arguments.of("1 + 2 * 3 - 4", 3.0)
        );
    }

    static Stream<String> incorrectExamples() {
        return Stream.of("1a2", "1+(2-4", "", " ", "abc", "1+-+2", "1.2.3+1");
    }
}
