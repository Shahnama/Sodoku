package com.navid.sodoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.navid.sodoku.Data.*;

public class MainCanvas extends JPanel implements MouseListener, ActionListener, KeyListener {

    private static final int GUIDE_SIZE = 20;
    private static final int V_MARGIN_GUIDE = 15;
    private static final int H_MARGIN_GUIDE = 5;

    private static final int GUIDE_COUNT = 3;
    private static final int ACTUAL_SIZE = GUIDE_SIZE * GUIDE_COUNT;
    private static final int CELL_COUNT = 9;
    private static final int MARGIN = ACTUAL_SIZE / 2;

    private static final int BOX_SIZE = ACTUAL_SIZE * 3;



    public MainCanvas(){
        this.addMouseListener(this);
        this.addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        drawSelectArea(g, SELECT_CELL);
    }

    private void drawSelectArea(Graphics g,Integer[] selectedCell) {
        if(selectedCell!=null)
            drawRectangle(g,selectedCell );
    }

    private void drawRectangle(Graphics graphics,Integer[] selectedCell ){
        int row = selectedCell[0];
        int col = selectedCell[1] ;
        Color color = new Color(250,0,0,50);
        graphics.setColor(color);
        graphics.fillRect(col * ACTUAL_SIZE  + MARGIN,MARGIN,ACTUAL_SIZE,CELL_COUNT*ACTUAL_SIZE);
        graphics.fillRect(MARGIN,row*ACTUAL_SIZE+ MARGIN,CELL_COUNT*ACTUAL_SIZE,ACTUAL_SIZE);
        graphics.fillRect(col/BOX_COUNT * BOX_SIZE  + MARGIN,row/BOX_COUNT*BOX_SIZE+MARGIN,BOX_COUNT*ACTUAL_SIZE,BOX_COUNT*ACTUAL_SIZE);
    }

    private void draw(Graphics graphics) {

        for(int col=0;col<CELL_COUNT;col++){
            for(int row=0;row<CELL_COUNT;row++) {
                if (CELL_VALUES[row][col] != 0) {
                    int fontSize = 50;
                    String numString = String.valueOf(CELL_VALUES[row][col]);

                    Graphics2D g2d = (Graphics2D) graphics;
                    g2d.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
                    g2d.setColor(Color.RED);
                    g2d.drawString(
                            numString,
                            MARGIN / 2 * 3 + col * ACTUAL_SIZE,
                            MARGIN / 3 * 2 + ( row + 1 ) * ACTUAL_SIZE
                    );

                }
                for (int rowG = 0; rowG < GUIDE_COUNT; rowG++) {
                    for (int colG = 0; colG < GUIDE_COUNT; colG++) {
                        int num = rowG + 1 + colG * GUIDE_COUNT;
                        String numString = String.valueOf(num);
                        int fontSize = 10;
                        graphics.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
                        graphics.setColor(Color.BLACK);
                        if (Data.CELL_VALUES_POSSIBILITY.get(row).get(col).contains(num)) {
                            graphics.drawString(
                                    numString,
                                    H_MARGIN_GUIDE + rowG * GUIDE_SIZE + MARGIN + col * ACTUAL_SIZE,
                                    V_MARGIN_GUIDE + colG * GUIDE_SIZE + MARGIN + row * ACTUAL_SIZE
                            );
                        }
                    }
                }

                graphics.setColor(Color.BLACK);
                graphics.drawRect(MARGIN + col * ACTUAL_SIZE, MARGIN + row * ACTUAL_SIZE, ACTUAL_SIZE, ACTUAL_SIZE);
            }
        }

        Graphics2D g2d = (Graphics2D) graphics;
        float thickness = 4;
        g2d.setStroke(new BasicStroke(thickness));


        for(int row=0;row<BOX_COUNT;row++){
            for(int col=0;col<BOX_COUNT;col++) {
                g2d.drawRect(
                        MARGIN+row * BOX_SIZE,
                        MARGIN+col * BOX_SIZE,
                        BOX_SIZE,
                        BOX_SIZE
                );

            }
        }
    }



    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,800);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int row = (e.getY() - MARGIN) / ACTUAL_SIZE ;
        int col = (e.getX() - MARGIN) / ACTUAL_SIZE ;
        if(e.getY()<MARGIN || e.getX() <MARGIN || row>8 || col>8) {
            SELECT_CELL = null;
            repaint();
            return;
        }
        if(SELECT_CELL==null)
            SELECT_CELL = new Integer[2];
        SELECT_CELL[0] = row;
        SELECT_CELL[1] = col;
        repaint();
        System.out.println("row:" + SELECT_CELL[0] +" col:" + SELECT_CELL[1]);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(SELECT_CELL!=null) {
            Logic.setValue(SELECT_CELL[0], SELECT_CELL[1], Integer.parseInt(e.getActionCommand()));
            repaint();
        }
        System.out.println(e.getActionCommand());

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
