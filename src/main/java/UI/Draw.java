package UI;

import Domain.Component;
import Domain.Train;

import java.util.List;

public class Draw {


    public void draw(List<Train> trains, WagonsPanel wp) {
        int traincount = 0;
        int wagoncount = 0;
        int offset = 40;
        wp.removeAll();
        wp.empty();
        System.out.println(trains.toString());
        if (trains == null) {
            return;
        }
        for (Train t : trains) {
            int limit = trains.size() - ((trains.size() - 1) % 5);
            System.out.println(limit);
            if (trains.indexOf(t) < limit - 1) {
                continue;
            }
            wp.drawTrain(t.getName(), traincount, wagoncount, 40);
            wagoncount++;

            if (t.getComponents() == null) {
                continue;
            }
            drawComponents(t, traincount, wagoncount, offset, wp);
            wagoncount = 0;
            traincount++;
        }
        wp.revalidate();
    }

    public void drawOne(Train t, WagonsPanel wp) {
        int traincount = 0;
        int wagoncount = 0;
        int offset = 40;
        wp.removeAll();
        wp.empty();
        wp.drawTrain(t.getName(), traincount, wagoncount, 40);
        wagoncount++;
        traincount++;
        if (t.getComponents() != null) {
            drawComponents(t, traincount, wagoncount, offset, wp);
        }
        wp.revalidate();
    }

    public void drawComponents(Train t, int traincount, int wagoncount, int offset, WagonsPanel wp) {
        for (Component c : t.getComponents()) {
            wp.drawWagon(c, traincount, wagoncount, offset);
            wagoncount++;
        }
    }

    public void drawLabel(String text, CommandPanel cp) {
        cp.drawLabel(text);
    }
}
