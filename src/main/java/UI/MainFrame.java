package UI;


import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    public MainFrame(String title, ExecutePanel executePanel, WagonsPanel wagonsPanel, CommandPanel commandPanel) {
        super(title);

        setLayout(new BorderLayout(10, 10));

        Container c = getContentPane();
        c.add(wagonsPanel, BorderLayout.NORTH);
        c.add(commandPanel, BorderLayout.CENTER);
        c.add(executePanel, BorderLayout.SOUTH);

        commandPanel.setBackground(Color.BLACK);
        commandPanel.setForeground(Color.WHITE);
    }

}

