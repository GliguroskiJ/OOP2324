package org.strategy;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort implements Sorting{

    @Override
    public List<Integer> sort(List<Integer> inputList) {
        List<Integer> list = new ArrayList<>(inputList); // Create a copy of the input list
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part of the list
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element of the unsorted part
            int temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }

        return list;
    }
}
