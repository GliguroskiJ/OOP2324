package org.strategy;

import java.util.List;

public class BubbleSort implements Sorting{
    @Override
    public List<Integer> sort(List<Integer> inputList) {
        for (int i = 0; i < inputList.size() - 1; i++) {
            for (int j = 0; j < inputList.size() - i - 1; j++) {
                if(inputList.get(j) < inputList.get(j+1)){
                    int tmp = inputList.get(j);
                    inputList.set(j,inputList.get(j+1));
                    inputList.set(j+1,tmp);
                }
            }
        }
        return inputList;
    }
}
