package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static task1.MathFunctions.*;


public class MathFunctionsTest {

    @ParameterizedTest
    @DisplayName("Test factorial() method using different parameter set")
    @CsvSource({"0, 1", "5, 120", "7, 5040"})
    void factorialParametrizedTest(int n, long result) {
        assertThat(factorial(n), is(result));
    }


    @ParameterizedTest
    @DisplayName("Test divide() method using different parameter set")
    @CsvSource({"1, 1, 1", "-100, 10, -10", "-25, 5, -5", "36, -6, -6"})
    void divideParametrizedTest(long dividend, long divisor, long quotient) {
        assertThat(divide(dividend, divisor), is(quotient));
    }

    @ParameterizedTest
    @DisplayName("Test multiply() method using different parameter set")
    @CsvSource({"0, 0, 0", "1, 1, 1", "-10, 10, -100", "-5, 5, -25", "-6, -6, 36"})
    void multiplyParametrizedTest(long multiplier, long multiplicand, long product) {
        assertThat(multiply(multiplicand, multiplier), is(product));
    }

    @Test
    @DisplayName("factorial() throws exception with negative parameter value")
    void factorial_NegativeValue_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> factorial(-1));
    }

    @Test
    @DisplayName("divide() throws exception with second parameter equals zero")
    void divide_ZeroAsSecondParameter_ArithmeticException() {
        Assertions.assertThrows(ArithmeticException.class, () -> divide(5, 0));
    }

    @Disabled
    @Test
    @DisplayName("Ignored test")
    void divide_6and2_3(){
        assertThat(divide(6L, 2L), is(3L));
    }
}
