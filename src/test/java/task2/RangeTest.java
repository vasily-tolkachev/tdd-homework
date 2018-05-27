package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class RangeTest {
    static Range range;

    @BeforeAll
    public static void init() {
        range = new Range(10, 20);
    }
    //exception for constructor if first parameter more than last
    //check for negative range
    @Test
    @DisplayName("isBefore with lower range")
    void isBefore_LowerRange_True() {
        Range lowerRange = new Range(0,5 );
        assertThat(lowerRange.isBefore(range), is(true));
    }

    @Test
    @DisplayName("isBefore with upper range")
    void isBefore_UpperRange_False() {
        Range upperRange = new Range(20,30 );
        assertThat(upperRange.isBefore(range), is(false));
    }

    @Test
    @DisplayName("isBefore with partly lower range")
    void isBefore_PartlyLower_False() {
        Range partlyLowerRange = new Range(0,15 );
        assertThat(partlyLowerRange.isBefore(range), is(false));
    }

    @Test
    @DisplayName("isBefore with partly upper range")
    void isBefore_PartlyUpper_False() {
        Range partlyUpperRange = new Range(15,30 );
        assertThat(partlyUpperRange.isBefore(range), is(false));
    }

    @Test
    @DisplayName("isBefore with the same range")
    void isBefore_EqualRange_False() {
        Range equalRange = new Range(10,20 );
        assertThat(equalRange.isBefore(range), is(false));
    }

    @Test
    @DisplayName("isBefore with lower negative range")
    void isBefore_NegativeLowerRange_True() {
        Range negativeRange = new Range(-20,-10 );
        Range lowerRange = new Range(-40,-30 );
        assertThat(lowerRange.isBefore(negativeRange), is(true));
    }

    @Test
    @DisplayName("isBefore with upper negative range")
    void isBefore_NegativeUpperRange_False() {
        Range negativeRange = new Range(-20,-10 );
        Range upperRange = new Range(-8,-5 );
        assertThat(upperRange.isBefore(negativeRange), is(false));
    }

    @Test
    @DisplayName("isBefore throws exception with null value")
    void isBefore_Null_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> range.isBefore(null));
    }

    @Test
    @DisplayName("isBefore with one by one range")
    void isBefore_OneSameBound_True() {
        Range lowerRange = new Range(5,10 );
        assertThat(lowerRange.isBefore(range), is(true));
    }
}
