package org.iterator;

import java.util.Iterator;

public class SimpleIterator<T> implements Iterator<T> {

    private int currentIndex = 0;

    private T[] array;

    public SimpleIterator(T[] array) {
        this.array = array;
    }
    @Override
    public boolean hasNext() {
        // Return if array has another index
        return currentIndex <= (array.length - 1);
    }
    @Override
    public T next() {
        if (!hasNext()) {
            // Throw exception if array has no next index
            throw new IndexOutOfBoundsException();
        }
        return array[currentIndex++];

    }
}
