package Session;

import Domain.Domain;


public class StandardSessionBuilder implements SessionBuilder {

    private Session session;

    public StandardSessionBuilder() {
        this.session = new Session();
    }

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public void buildDomain() {
        Domain domain = new Domain();
        domain.setSession(session);
        this.session.setDomain(domain);
    }

    @Override
    public void buildPickAFile() {
        this.session.setPickAFile(new PickAFile());
    }

    @Override
    public void buildLog() {
        this.session.setLog(new Log());
    }

    @Override
    public void buildUI() {
        this.session.setUI(session.createUI("standard"));
    }
}
