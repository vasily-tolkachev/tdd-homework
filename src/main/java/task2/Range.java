package task2;

import java.util.Iterator;
import java.util.List;

public class Range implements IRange {
    private long lowerBound;
    private long upperBound;

    public Range(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public long getLowerBound() {
        return lowerBound;
    }

    public long getUpperBound() {
        return upperBound;
    }

    public boolean isBefore(Range otherRange) {
        if (otherRange == null) throw new IllegalArgumentException();
        return  upperBound <= otherRange.getLowerBound();
    }

    public boolean isAfter(Range otherRange) {
        return false;
    }

    public boolean isConcurrent(Range otherRange) {
        return false;
    }

    public boolean contains(long value) {
        return false;
    }

    public List<Long> asList() {
        return null;
    }

    public Iterator<Long> asIterator() {
        return null;
    }
}
