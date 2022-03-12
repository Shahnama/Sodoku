package com.navid.sodoku;

import static com.navid.sodoku.Data.*;

public class Logic {

    public static void setValue(int row,int col,Integer value){
        if(!isValid(row,col,value))
            return;
        CELL_VALUES[row][col] =value;
        for(int i=0;i<SIZE;i++){
            CELL_VALUES_POSSIBILITY.get(i).get(col).remove(value);
            CELL_VALUES_POSSIBILITY.get(row).get(i).remove(value);
            CELL_VALUES_POSSIBILITY.get(row).get(col).remove(i+1);
            int boxRow = (row/BOX_COUNT)*BOX_COUNT+i/BOX_COUNT;
            int boxCol = (col/BOX_COUNT)*BOX_COUNT+i%BOX_COUNT;
            CELL_VALUES_POSSIBILITY.get(boxRow).get(boxCol).remove(value);
        }
    }



    public static boolean isValid(int row,int col,int value){
        return CELL_VALUES_POSSIBILITY.get(row).get(col).contains(value);
    }

}
