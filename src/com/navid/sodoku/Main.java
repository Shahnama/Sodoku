package com.navid.sodoku;

import javax.swing.*;

import static com.navid.sodoku.Data.*;
import static com.navid.sodoku.Logic.setValue;

public class Main {

    public static JFrame canvasFrame;
    public static MainCanvas mainCanvas;

    public static void main(String[] args) {
        mainCanvas = new MainCanvas();
        canvasFrame = new JFrame();
//        Data.init();


//        System.out.println(ROWS_VALUES);
//        System.out.println(COLS_VALUES);
//        System.out.println(BOXS_VALUES);

        setValue(5,2,5);
        setValue(3,4,2);
        setValue(1,8,4);
        UiHelper uiHelper = new UiHelper(mainCanvas);
        SwingUtilities.invokeLater(uiHelper::createAndShowGui);
    }
}
