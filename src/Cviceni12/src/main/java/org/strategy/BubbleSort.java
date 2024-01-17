package org.strategy;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements Sorting{
    @Override
    public List<Integer> sort(List<Integer> inputList) {
        List<Integer> list = new ArrayList<>(inputList);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) < list.get(j + 1)) {
                    int tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }
        return list;
    }
}
