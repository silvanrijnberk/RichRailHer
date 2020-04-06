package Session;

import Domain.Domain;
import UI.*;


public class Session implements SessionPLan {


    private SaveSession con;
    private PickAFile pickAFile;
    private Domain domain;
    private UI UI;
    private Log log;

    public void start() {
        UI.start();
    }

    public void load() {
        con = getCon();
        if (con == null)
            return;
        domain.clear();
        notify("File loaded: " + con.getPath());
        con.load(domain.getTrains(), domain.getComponents());
    }

    public void save(boolean saveLog) {
        if (domain.isEmpty() && log.isEmpty()) {
            notify("nothing to save");
            return;
        }
        saveSession();
        if (saveLog)
            saveLog();
    }

    private void saveSession() {
            if (domain.isEmpty())
                return;
            con = getCon();
            if (con == null)
                return;
            notify("File saved: " + con.getPath());
            con.save(domain.getTrains(), domain.getComponents());
    }

    private void saveLog() {
        if (log.isEmpty())
            return;
        log.save();
    }

    public void notify(Object target, String type) {
        UI.drawLabel(log.notify(target, type));
    }

    public void notify(String change) {
        UI.drawLabel(log.notify(change));
    }

    public Domain getDomain() {
        return domain;
    }

    public void delete() {
        domain.clear();
    }

    public UI createUI(String type) {
        UIEngineer uiEngineer;
        switch (type) {
            case ("standard"):
                uiEngineer = new UIEngineer(new StandardUIBuilder(this));
                break;
            default:
                uiEngineer = new UIEngineer(new StandardUIBuilder(this));
                break;
        }
        uiEngineer.makeUI();
        return uiEngineer.getUI();
    }

    public UI getUI() {
        return UI;
    }

    public SaveSession getCon() {
        String path = pickAFile.pick("Choose location for saving session");
        if (path.isEmpty())
            return null;
        String type = path.split("\\.")[1];
        switch (type) {
            case "json":
                return new SaveSessionJson(path, domain);
            default:
                notify("we dont support this file type");
                return getCon();
        }

    }

    @Override
    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    @Override
    public void setPickAFile(PickAFile pickAFile) {
        this.pickAFile = pickAFile;
    }

    @Override
    public void setLog(Log log) {
        this.log = log;
    }

    @Override
    public void setUI(UI ui) {
        this.UI = ui;
    }
}
