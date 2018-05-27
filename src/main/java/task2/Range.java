package task2;

import java.util.Iterator;
import java.util.List;

public class Range implements IRange {
    public boolean isBefore(Range otherRange) {
        return false;
    }

    public boolean isAfter(Range otherRange) {
        return false;
    }

    public boolean isConcurrent(Range otherRange) {
        return false;
    }

    public long getLowerBound() {
        return 0;
    }

    public long getUpperBound() {
        return 0;
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
