package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 2, 1, 3, 5, 5, 5, 5, 5, 3, 2, 1, 1, 1, 1, 1));

        System.out.println(String.format("Изначальные данные: %s", Arrays.toString(list.toArray())));
        
        List<Integer> listPart1 = new ArrayList<Integer>(list);

        int previousNumber = Integer.MIN_VALUE;
        List<Integer> needRemoveIndexes = new ArrayList<Integer>();
        List<Integer> tempList = new ArrayList<Integer>();;
        for (int i = 0; i < listPart1.size(); i++){
            int currentNumber = listPart1.get(i);

            boolean isLastItem = (listPart1.size() - 1) == i;

            if(previousNumber == currentNumber)
            {
                tempList.add(i);
            }

            if(previousNumber != currentNumber || isLastItem)
            {
                if(tempList.size() >= 3){
                    needRemoveIndexes.addAll(tempList);
                }
                previousNumber = currentNumber;
                tempList = new ArrayList<Integer>();
                tempList.add(i);
            }
        }

        for (int i = 0; i < needRemoveIndexes.size(); i++){
            listPart1.remove(needRemoveIndexes.get(i) - i);
        }

        System.out.println(String.format("3 и более и подряд: %s", Arrays.toString(listPart1.toArray())));


        List<Integer> listPart2 = new ArrayList<Integer>(list);

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < list.size(); i++){
            Integer currentItem = list.get(i);

            if (!map.containsKey(currentItem)) {
                List<Integer> indexList = new ArrayList<Integer>();
                indexList.add(i);

                map.put(currentItem, indexList);
            } else {
                map.get(currentItem).add(i);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if(entry.getValue().size() >= 3){
                listPart2.removeAll(Collections.singleton(entry.getKey()));
            }
        }

        System.out.println(String.format("3 и более: %s", Arrays.toString(listPart2.toArray())));
    }
}
