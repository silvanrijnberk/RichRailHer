package UI;

import javax.swing.*;
import java.awt.*;

public class CommandPanel extends JPanel {
    public CommandPanel() {
        Dimension size = getPreferredSize();
        size.height = 250;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Command line"));

    }

    public void drawLabel(String text) {
        if (getComponents().length >= 18) {
            removeAll();
            repaint();
        }
        if (text.length() > 120) {
            String temp = text.substring(0, 120);
            JLabel label = new JLabel(temp + '\n');
            label.setForeground(Color.WHITE);
            label.setPreferredSize(new Dimension(750, 13));
            add(label);
            drawLabel(text.substring(120));
        } else {
            JLabel label = new JLabel(text + '\n');
            label.setForeground(Color.WHITE);
            label.setPreferredSize(new Dimension(750, 13));
            add(label);
        }
        revalidate();
    }

}
