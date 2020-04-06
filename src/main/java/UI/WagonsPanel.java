package UI;

import Domain.Component;

import javax.swing.*;
import java.awt.*;


public class WagonsPanel extends JScrollPane {
    public WagonsPanel() {
        Dimension size = getPreferredSize();
        size.height = 250;
        setPreferredSize(size);
        setBackground(Color.WHITE);
    }

    public void empty() {
        Graphics g = this.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void drawTrain(String train, int trainCount, int wagonCount, int OFFSET) {
        if (!train.isEmpty()) {
            Graphics g = this.getGraphics();
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(30, 40 + trainCount * OFFSET, 40, 20);
            g.fillRect(55, 30 + trainCount * OFFSET, 15, 15);
            g.drawRoundRect(60, 20 + trainCount * OFFSET, 10, 10, 10, 10);
            g.drawRoundRect(60, 5 + trainCount * OFFSET, 15, 15, 15, 15);
            g.setColor(Color.BLACK);
            g.fillRoundRect(32, 55 + trainCount * OFFSET, 10, 10, 10, 10);
            g.fillRoundRect(60, 55 + trainCount * OFFSET, 10, 10, 10, 10);
            g.drawString(train, 40, 55 + trainCount * OFFSET);
        }
    }

    public void drawWagon(Component wagon, int trainCount, int wagonCount, int OFFSET) {
        Graphics g = this.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(30 + wagonCount * 42, 40 + trainCount * OFFSET, 40, 20);
        if (wagon.getType().equals("locomotive")) {
            g.fillRect(30 + wagonCount * 42, 40 + trainCount * OFFSET, 40, 20);
            g.fillRect(55 + wagonCount * 42, 30 + trainCount * OFFSET, 15, 15);
            g.drawRoundRect(60 + wagonCount * 42, 20 + trainCount * OFFSET, 10, 10, 10, 10);
            g.drawRoundRect(60 + wagonCount * 42, 5 + trainCount * OFFSET, 15, 15, 15, 15);
        }
        g.setColor(Color.WHITE);
        if (wagon.getType().equals("passengerwagon")) {
            g.fillRect(35 + wagonCount * 42, 47 + trainCount * OFFSET, 10, 5);
            g.fillRect(55 + wagonCount * 42, 47 + trainCount * OFFSET, 10, 5);
        }
        g.setColor(Color.BLACK);
        g.fillRoundRect(32 + wagonCount * 42, 55 + trainCount * OFFSET, 10, 10, 10, 10);
        g.fillRoundRect(60 + wagonCount * 42, 55 + trainCount * OFFSET, 10, 10, 10, 10);
        g.drawString(wagon.getName(), 40 + wagonCount * 42, 55 + trainCount * OFFSET);
    }


}


