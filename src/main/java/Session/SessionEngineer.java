package Session;

public class SessionEngineer {
    private SessionBuilder sessionBuilder;

    public SessionEngineer(SessionBuilder sessionBuilder) {
        this.sessionBuilder = sessionBuilder;
    }

    public Session getSession() {
        return this.sessionBuilder.getSession();
    }

    public void makeSession() {
        sessionBuilder.buildDomain();
        sessionBuilder.buildLog();
        sessionBuilder.buildPickAFile();
        sessionBuilder.buildUI();
    }
}
