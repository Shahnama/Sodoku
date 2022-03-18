package com.navid.sodoku;

public class Data {
    public static final int SIZE = 9;
    public static final int BOX_COUNT = 3;

    public static final int[][] CELL_VALUES = new int[SIZE][SIZE];
    public static final boolean[][] NON_CHANGEABLE = new boolean[SIZE][SIZE];
    public static Integer[] SELECT_CELL = null;



//    public static final List<List<Integer>> ROWS_VALUES = new ArrayList<>();
//    public static final List<List<Integer>> COLS_VALUES = new ArrayList<>();
//    public static final List<Integer>[][] BOXS_VALUES = new List[BOX_COUNT][BOX_COUNT];
//
//    public static void init(){
//        for(int row=0;row<BOX_COUNT;row++){
//            for(int col=0;col<BOX_COUNT;col++){
//                List<Integer> temp =  new ArrayList<>();
//                for(int i=0;i<SIZE;i++){
//                    temp.add(0);
//                }
//                BOXS_VALUES[row][col] = temp;
//            }
//        }
//
//        for(int index=0;index<SIZE;index++){
//            List<Integer> tempRow =  new ArrayList<>();
//            List<Integer> tempCol =  new ArrayList<>();
//            for(int i=0;i<SIZE;i++){
//                tempRow.add(0);
//                tempCol.add(0);
//            }
//            ROWS_VALUES.add(tempRow);
//            COLS_VALUES.add(tempCol);
//        }
//
//
//
//    }
}
