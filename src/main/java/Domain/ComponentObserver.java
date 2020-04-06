package Domain;

import Session.Session;


public class ComponentObserver implements Observer {


    private Component component;
    private Session session;

    public ComponentObserver(Component component, Session session) {
        this.component = component;
        this.session = session;
        component.register(this);
        session.notify(" Component created: " + component.toString());
    }

    @Override
    public void update(Object componentsNew) {
        Component cNew = (Component) componentsNew;
        session.notify("changed " + component.toString() + " to " + cNew.toString());
        this.component = cNew;
    }

}
