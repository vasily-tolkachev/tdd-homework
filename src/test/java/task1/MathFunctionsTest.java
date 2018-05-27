package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MathFunctionsTest {

    @Test
    @DisplayName("factorial() throws exception with negative parameter value")
    void factorial_NegativeValue_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> MathFunctions.factorial(-1));
    }

    @Test
    @DisplayName("divide() throws exception with second parameter equals zero")
    void divide_ZeroAsSecondParameter_ArithmeticException() {
        Assertions.assertThrows(ArithmeticException.class, () -> MathFunctions.divide(5,0));
    }
}
