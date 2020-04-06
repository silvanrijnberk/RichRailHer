package UI;

import Session.Session;
import Domain.Domain;
import Domain.Train;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UI implements UIPlan {


    private Draw draw;
    private Session session;
    private Domain domain;
    private ExecutePanel executePanel;
    private WagonsPanel wagonsPanel;
    private CommandPanel commandPanel;
    private RichRailCli listener;


    public void start() {
        MainFrame mainFrame = new MainFrame("RichRail", executePanel, wagonsPanel, commandPanel);
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                session.save(true);
            }
        });
        mainFrame.setVisible(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainFrame.setSize(800, 800);
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainFrame.setVisible(true);
            }
        });
    }

    public void loadSession() {
        session.load();
        draw();
    }

    public void saveSession(boolean saveLog) {
        session.save(saveLog);
    }

    public void delSession() {
        session.delete();
        draw();
    }

    public void create(String name) {
        Train t = domain.newTrain(name);
        if (t != null) {
            draw();
        }
    }

    public void create(String name, String type) {
        if (domain.newComponent(name, type) != null) {
            draw();
        }
    }

    public void create(String name, String type, int seats) {
        if (domain.newComponent(name, type, seats) != null) {
            draw();
        }
    }

    public void delete(String type, String name) {
        if (type.equals("train"))
            domain.deleteTrain(name);
        if (type.equals("component"))
            domain.deleteComponent(name);
        draw();
    }

    public void remove(String c, String t) {
        domain.removeFromTrain(c, t);
        draw();
    }

    public void add(String c, String t) {
        domain.addToTrain(c, t);
        draw();
    }

    public void draw() {
        draw.draw(session.getDomain().getTrains(), wagonsPanel);
    }

    public void drawLabel(String text) {
        draw.drawLabel(text, commandPanel);
    }

    public void drawOne(String train) {
        draw.drawOne(domain.findTrain(train), wagonsPanel);
    }


    public void setDraw(Draw draw) {
        this.draw = draw;
    }

    public void setCommanPanel(CommandPanel commanpanel) {
        this.commandPanel = commanpanel;
    }

    public void setWagonsPanel(WagonsPanel wagonsPanel) {
        this.wagonsPanel = wagonsPanel;
    }

    public void setExecutePanel(ExecutePanel executePanel) {
        this.executePanel = executePanel;
    }

    public void setListener(RichRailCli listener) {
        this.listener = listener;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Draw getDraw() {
        return draw;
    }

    public Session getSession() {
        return session;
    }

    public Domain getDomain() {
        return domain;
    }

    public ExecutePanel getExecutePanel() {
        return executePanel;
    }

    public WagonsPanel getWagonsPanel() {
        return wagonsPanel;
    }

    public CommandPanel getCommandPanel() {
        return commandPanel;
    }

    public RichRailCli getListener() {
        return listener;
    }
}
