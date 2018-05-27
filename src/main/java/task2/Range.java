package task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Range implements IRange {
    private long lowerBound;
    private long upperBound;
    long iteratorPosition;

    private Iterator<Long> iterator = new Iterator<Long>() {
        @Override
        public boolean hasNext() {
            return iteratorPosition < upperBound;
        }

        @Override
        public Long next() {
            if (iteratorPosition >  upperBound) throw new NoSuchElementException();
            return iteratorPosition++;
        }
    };

    public Range(long lowerBound, long upperBound) {
        if (lowerBound > upperBound) {
            this.lowerBound = upperBound;
            this.upperBound = lowerBound;
        } else {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }

    public long getLowerBound() {
        return lowerBound;
    }

    public long getUpperBound() { return upperBound; }

    public boolean isBefore(Range otherRange) {
        if (otherRange == null) throw new IllegalArgumentException();
        return upperBound <= otherRange.getLowerBound();
    }

    public boolean isAfter(Range otherRange) {
        if (otherRange == null) throw new IllegalArgumentException();
        return lowerBound >= otherRange.getUpperBound();
    }

    public boolean isConcurrent(Range otherRange) {
        if (otherRange == null) throw new IllegalArgumentException();
        return this.lowerBound <= otherRange.upperBound && this.upperBound >= otherRange.lowerBound;
    }

    public boolean contains(long value) {
        return value >= lowerBound && value <= upperBound;
    }

    public List<Long> asList() {
        List<Long> list = new ArrayList<>();
        for (Long i = lowerBound; i < upperBound; i++) {
            list.add(i);
        }
        return list;
    }

    public Iterator<Long> asIterator() {
        iteratorPosition = lowerBound;
        return iterator;
    }
}
