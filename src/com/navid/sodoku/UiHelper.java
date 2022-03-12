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
        Main.canvasFrame.addKeyListener(mainCanvas);
        Main.canvasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.canvasFrame.getContentPane().add(this.mainCanvas);
        Main.canvasFrame.pack();
        Main.canvasFrame.setLocationByPlatform(true);
        Main.canvasFrame.setVisible(true);
    }

    private void addButton(){
        for(int i=0;i<SIZE;i++){
            Button button = new Button();
            button.setLabel(String.valueOf(i+1));
            button.setBounds(new Rectangle(30 + i * 61,580,50,50));
            button.addActionListener(mainCanvas);
            mainCanvas.add(button);
        }
    }
}
