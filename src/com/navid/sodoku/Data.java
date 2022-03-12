package com.navid.sodoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Data {
    public static final int SIZE = 9;
    public static final int[][] CELL_VALUES = new int[SIZE][SIZE];
    public static final List<List<Set<Integer>>> CELL_VALUES_POSSIBILITY = new ArrayList<>();
    public static Integer[] SELECT_CELL = null;
    public static final int BOX_COUNT = 3;

    public static void init(){
        for(int row=0;row<SIZE;row++) {
            List<Set<Integer>> list = new ArrayList<>();
            for (int col = 0; col < SIZE; col++) {
                Set<Integer> set = new HashSet<>();
                for (int guide = 0; guide < SIZE; guide++) {
                    set.add(guide+1);
                }
                list.add(set);
            }
            CELL_VALUES_POSSIBILITY.add(list);
        }
    }
}
