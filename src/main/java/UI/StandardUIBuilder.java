package UI;

import Session.Session;

public class StandardUIBuilder implements UIBuilder {


    private UI ui;

    public StandardUIBuilder(Session session) {
        this.ui = new UI();
        ui.setSession(session);
        ui.setDomain(session.getDomain());
    }

    @Override
    public UI getUi() {
        return ui;
    }

    @Override
    public void buildCommanPanel() {
        CommandPanel commandPanel = new CommandPanel();
        ui.setCommanPanel(commandPanel);
    }

    @Override
    public void buildWagonsPanel() {
        WagonsPanel wagonsPanel = new WagonsPanel();
        ui.setWagonsPanel(wagonsPanel);
    }

    @Override
    public void buildListener() {
        ui.setListener(new RichRailCli(ui.getSession()));
    }

    @Override
    public void buildExecutePanel() {
        ui.setExecutePanel(new ExecutePanel(ui.getSession()));
    }

    @Override
    public void buildDraw() {
        ui.setDraw(new Draw());

    }

}
