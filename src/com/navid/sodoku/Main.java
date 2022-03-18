package com.navid.sodoku;

import javax.swing.*;

import static com.navid.sodoku.Data.*;
import static com.navid.sodoku.Logic.setValue;

public class Main {

    public static JFrame canvasFrame;
    public static MainCanvas mainCanvas;

    private static int[][] value = new int[][]{
            {0,8,0,  0,3,5,  6,0,0},
            {0,1,0,  0,0,0,  0,7,0},
            {0,0,2,  0,0,0,  0,0,4},

            {0,0,5,  0,1,0,  0,0,6},
            {9,0,0,  4,0,6,  0,0,7},
            {1,0,0,  0,7,0,  8,0,0},

            {2,0,0,  0,0,0,  3,0,0},
            {0,5,0,  0,0,0,  0,9,0},
            {0,0,3,  5,8,0,  0,6,0},
    };

    public static void main(String[] args) {
        mainCanvas = new MainCanvas();
        canvasFrame = new JFrame();
//        Data.init();


        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                setValue(row,col,value[row][col]);
                if(value[row][col]!=0)
                    NON_CHANGEABLE[row][col] = true;
            }
        }

        UiHelper uiHelper = new UiHelper(mainCanvas);
        SwingUtilities.invokeLater(uiHelper::createAndShowGui);
    }
}
