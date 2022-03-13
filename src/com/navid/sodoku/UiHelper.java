package com.navid.sodoku;

import javax.swing.*;
import java.awt.*;

import static com.navid.sodoku.Data.SIZE;

public class UiHelper {
    private final MainCanvas mainCanvas;

    public UiHelper(MainCanvas mainCanvas) {
        this.mainCanvas = mainCanvas;
        mainCanvas.setLayout(null);
        addButton();
    }

    public void createAndShowGui() {
        Main.canvasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.canvasFrame.getContentPane().add(this.mainCanvas);
        Main.canvasFrame.pack();
        Main.canvasFrame.setLocationByPlatform(true);
        Main.canvasFrame.setVisible(true);
    }

    private void addButton(){
        for(int i=0;i<SIZE+1;i++){
            Button button = new Button();
            button.setLabel(String.valueOf(i));
            button.setBounds(new Rectangle(28 + i * 55,580,50,50));
            button.addActionListener(mainCanvas);
            mainCanvas.add(button);
        }
    }
}
