package UI;


import Domain.Domain;
import Session.Session;

public interface UIPlan {
    void setDraw(Draw draw);

    void setCommanPanel(CommandPanel commanpanel);

    void setWagonsPanel(WagonsPanel WagonsPanel);

    void setExecutePanel(ExecutePanel ExecutePanel);

    void setListener(RichRailCli listener);

    void setDomain(Domain domain);

    void setSession(Session session);
}
