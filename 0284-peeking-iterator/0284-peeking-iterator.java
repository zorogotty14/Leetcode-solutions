// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextElement;
    private boolean hasPeeked;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.nextElement = null;
        this.hasPeeked = false;
    }
    
    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked) {
            if (iterator.hasNext()) {
                nextElement = iterator.next();
                hasPeeked = true;
            }
        }
        return nextElement;
    }
    
    // Override the next() method to return the next element and advance the iterator.
    @Override
    public Integer next() {
        if (!hasPeeked) {
            return iterator.next();
        }
        Integer result = nextElement;
        hasPeeked = false;
        nextElement = null;
        return result;
    }
    
    // Override the hasNext() method to check if there are more elements.
    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }
}
