package com.navid.sodoku;

import static com.navid.sodoku.Data.*;

public class Logic {

    public static void setValue(int row,int col,Integer value) {
        CELL_VALUES[row][col] = value;
    }

    public static boolean isPossible(int row,int col,Integer value) {
        for(int i=0;i<SIZE;i++) {
            int boxRow = row/BOX_COUNT * BOX_COUNT + i/BOX_COUNT;
            int bocCol = col/BOX_COUNT * BOX_COUNT + i%BOX_COUNT;
            if (CELL_VALUES[row][i] == value ||
                    CELL_VALUES[i][col] == value ||
                    CELL_VALUES[boxRow][bocCol] == value)
                return false;
        }
        return true;
    }

    public static int countNum(int row,int col,Integer value) {
        int count =0;
        for(int i=0;i<SIZE;i++) {
            int boxRow = row/BOX_COUNT * BOX_COUNT + i/BOX_COUNT;
            int boxCol = col/BOX_COUNT * BOX_COUNT + i%BOX_COUNT;
            if (i!=col && CELL_VALUES[row][i] == value)
                count++;
            if(i!=row && CELL_VALUES[i][col] == value)
                count++;
            if(!(boxRow==row && boxCol== col) && CELL_VALUES[boxRow][boxCol] == value)
                count++;
        }
        return count;
    }

}
