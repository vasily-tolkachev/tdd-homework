package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;


public class RangeTest {
    static Range testingRange;

    @BeforeAll
    public static void init() {
        testingRange = new Range(10, 20);
    }

    @Test
    @DisplayName("isBefore with lower range")
    void isBefore_LowerRange_False() {
        Range lowerRange = new Range(0, 5);
        assertThat(testingRange.isBefore(lowerRange), is(false));
    }

    @Test
    @DisplayName("isBefore with upper range")
    void isBefore_UpperRange_True() {
        Range upperRange = new Range(20, 30);
        assertThat(testingRange.isBefore(upperRange), is(true));
    }

    @Test
    @DisplayName("isBefore with partly lower range")
    void isBefore_PartlyLower_False() {
        Range partlyLowerRange = new Range(0, 15);
        assertThat(testingRange.isBefore(partlyLowerRange), is(false));
    }

    @Test
    @DisplayName("isBefore with partly upper range")
    void isBefore_PartlyUpper_False() {
        Range partlyUpperRange = new Range(15, 30);
        assertThat(testingRange.isBefore(partlyUpperRange), is(false));
    }

    @Test
    @DisplayName("isBefore with the same range")
    void isBefore_EqualRange_False() {
        Range equalRange = new Range(10, 20);
        assertThat(testingRange.isBefore(equalRange), is(false));
    }

    @Test
    @DisplayName("isBefore with lower negative range")
    void isBefore_NegativeLowerRange_False() {
        Range negativeTestingRange = new Range(-20, -10);
        Range lowerNegativeRange = new Range(-40, -30);
        assertThat(negativeTestingRange.isBefore(lowerNegativeRange), is(false));
    }

    @Test
    @DisplayName("isBefore with upper negative range")
    void isBefore_NegativeUpperRange_True() {
        Range negativeTestingRange = new Range(-20, -10);
        Range upperNegativeRange = new Range(-8, -5);
        assertThat(negativeTestingRange.isBefore(upperNegativeRange), is(true));
    }

    @Test
    @DisplayName("isBefore throws exception with null value")
    void isBefore_Null_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> testingRange.isBefore(null));
    }

    @Test
    @DisplayName("isBefore with one by one range")
    void isBefore_OneSameBound_True() {
        Range oneSameBound = new Range(20, 25);
        assertThat(testingRange.isBefore(oneSameBound), is(true));
    }

    @Test
    @DisplayName("isAfter with lower range")
    void isAfter_LowerRange_True() {
        Range lowerRange = new Range(0, 5);
        assertThat(testingRange.isAfter(lowerRange), is(true));
    }

    @Test
    @DisplayName("isAfter with upper range")
    void isAfter_UpperRange_False() {
        Range upperRange = new Range(20, 30);
        assertThat(testingRange.isAfter(upperRange), is(false));
    }

    @Test
    @DisplayName("isAfter with partly lower range")
    void isAfter_PartlyLower_False() {
        Range partlyLowerRange = new Range(0, 15);
        assertThat(testingRange.isAfter(partlyLowerRange), is(false));
    }

    @Test
    @DisplayName("isAfter with partly upper range")
    void isAfter_PartlyUpper_False() {
        Range partlyUpperRange = new Range(15, 30);
        assertThat(testingRange.isAfter(partlyUpperRange), is(false));
    }

    @Test
    @DisplayName("isAfter with the same range")
    void isAfter_EqualRange_False() {
        Range equalRange = new Range(10, 20);
        assertThat(testingRange.isAfter(equalRange), is(false));
    }

    @Test
    @DisplayName("isAfter with lower negative range")
    void isAfter_NegativeLowerRange_True() {
        Range negativeTestingRange = new Range(-20, -10);
        Range lowerNegativeRange = new Range(-40, -30);
        assertThat(negativeTestingRange.isAfter(lowerNegativeRange), is(true));
    }

    @Test
    @DisplayName("isAfter with upper negative range")
    void isAfter_NegativeUpperRange_False() {
        Range negativeTestingRange = new Range(-20, -10);
        Range upperNegativeRange = new Range(-8, -5);
        assertThat(negativeTestingRange.isAfter(upperNegativeRange), is(false));
    }

    @Test
    @DisplayName("isAfter throws exception with null value")
    void isAfter_Null_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> testingRange.isAfter(null));
    }

    @Test
    @DisplayName("isAfter with one by one range")
    void isAfter_OneSameBound_True() {
        Range lowerRange = new Range(5, 10);
        assertThat(testingRange.isAfter(lowerRange), is(true));
    }

    @Test
    @DisplayName("method contains with containing value")
    void contains_ContainingValue_True() {
        assertThat(testingRange.contains(15), is(true));
    }

    @Test
    @DisplayName("method contains with not containing value")
    void contains_NotContainingValue_False() {
        assertThat(testingRange.contains(30), is(false));
    }

    @ParameterizedTest
    @CsvSource({"-10, 15, true", "15, 100, true", "-100, 100, true", "12, 18, true", "-100, -50, false", "50, 100, false"})
    @DisplayName("check if isConcurrent works with different ranges")
    void isConcurrent_DifferentRanges(long lowerBound, long upperBound, boolean expectedResult) {
        Range anotherRange = new Range(lowerBound, upperBound);
        assertThat(testingRange.isConcurrent(anotherRange), is(expectedResult));
    }

    @Test
    @DisplayName("isConcurrent throw exception if range is null")
    void isConcurrent_Null_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> testingRange.isConcurrent(null));
    }

    @Test
    @DisplayName("asList doesn't return null")
    void asList_NotNull() {
        assertThat(testingRange.asList(), notNullValue());
    }

    @Test
    @DisplayName("asList check if number result items equal to expected number")
    void asList_10Items() {
        assertThat(testingRange.asList().size(), equalTo(10));
    }

    @Test
    @DisplayName("asList returns list")
    void asList_ListClass() {
        assertThat(testingRange.asList(), isA(List.class));
    }

    @Test
    @DisplayName("asIterator return Iterator class")
    void asIterator_IteratorClass() {
        assertThat(testingRange.asIterator(), isA(Iterator.class));
    }

    @Test
    @DisplayName("asIterator return not null value")
    void asIterator_NotNull() {
        assertThat(testingRange.asIterator(), notNullValue());
    }

    @Test
    @DisplayName("asIterator hasNext() returns true")
    void asIteratorHasNext_True() {
        assertThat(testingRange.asIterator().hasNext(), is(true));
    }

    @Test
    @DisplayName("check asIterator next() method")
    void asIteratorNext_LowerBound() {
        assertThat(testingRange.asIterator().next(), is(testingRange.getLowerBound()));
    }

    @Test
    @DisplayName("asIterator thows NoSuchElementException")
    void asIterator_OutOfBounds_NoSuchElementException() {
        Iterator<Long> iterator = testingRange.asIterator();
        for (long i = testingRange.getLowerBound(); i <= testingRange.getUpperBound(); i++) {
            iterator.next();
        }
        Assertions.assertThrows(NoSuchElementException.class, iterator::next);
    }
}
