package com.navid.sodoku;

import javax.swing.*;

import static com.navid.sodoku.Data.CELL_VALUES_POSSIBILITY;
import static com.navid.sodoku.Data.SIZE;
import static com.navid.sodoku.Logic.setValue;

public class Main {

    public static JFrame canvasFrame;
    public static MainCanvas mainCanvas;

    public static void main(String[] args) {
//        int row = 0 ;
//        int col = 3 ;
//        for(int i=0;i<SIZE;i++){
//            System.out.printf("%s %s \n",(row/3)*3+i/3,col/3+(i%3)*3);
//        }
        mainCanvas = new MainCanvas();
        canvasFrame = new JFrame();
        Data.init();
        setValue(5,2,5);
        setValue(3,4,2);
        setValue(1,8,4);
        UiHelper uiHelper = new UiHelper(mainCanvas);
        SwingUtilities.invokeLater(uiHelper::createAndShowGui);
    }
}
