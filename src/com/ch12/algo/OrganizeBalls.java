package com.ch12.algo;

import java.util.*;

public class OrganizeBalls {
    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        // get the qty of each ball type
        // get the capacity of each container.
        HashMap<Integer, Integer> ballQtys = new HashMap<>();
        HashMap<Integer, Integer> containers = new HashMap<>();
        // hashmap<capacity, qty>

        for(List<Integer> row : container) {
            int currentContainerCap = 0;
            for(int count = 0; count < row.size(); count++) {
                int ballQty = row.get(count);
                if (!ballQtys.containsKey(count)) {
                    ballQtys.put(count, 0);
                }
                ballQtys.put(count, ballQtys.get(count) + ballQty);
                currentContainerCap += ballQty;
            }
            if(!containers.containsKey(currentContainerCap)) {
                containers.put(currentContainerCap, 0);
            }
            containers.put(currentContainerCap, containers.get(currentContainerCap) + 1);
        }

        for (Integer qty : ballQtys.values()) {
            if(!containers.containsKey(qty)) {
                return "Impossible";
            }
            if(containers.get(qty) <= 0 ) {
                return "Impossible";
            }
            containers.put(qty, containers.get(qty) - 1);
        }

        return "Possible";
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(1, 1));
        input.add(List.of(1, 1));
//        input.add(List.of(3, 3, 3));
        System.out.println(organizingContainers(input));
    }

}
