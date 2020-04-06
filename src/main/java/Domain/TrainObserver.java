package Domain;

import java.util.ArrayList;
import java.util.List;


import Session.Session;

public class TrainObserver implements Observer {


    private String name;
    private List<Component> components;
    private Session session;

    public TrainObserver(Object objTrain, Session session) {
        this.session = session;
        Train t = (Train) objTrain;
        this.components = t.getCopyComponents();
        this.name = t.getName();
        this.session.notify(" Train created: " + t.toString());
        t.register(this);
    }

    @Override
    public void update(Object newTrain) {
        Train newT = (Train) newTrain;
        if (!newT.getName().equals(this.name)) {
            session.notify(" Train name changed from " + this.name + " to " + newT.getName());
            this.name = newT.getName();
            return;
        }
        List temp = newT.getCopyComponents();

        List compOld = new ArrayList(components);
        List compNew = new ArrayList(newT.getComponents());

        compOld.removeAll(compNew);

        if (compOld.isEmpty()) {
            compOld = new ArrayList(components);
            compNew = new ArrayList(newT.getComponents());
            compNew.removeAll(compOld);
            session.notify(" Added " + compNew.get(0).toString() + " to " + newT.getName());
        } else {
            session.notify(" Removed " + compOld.get(0).toString() + " from " + newT.getName());
        }
        this.components = temp;
    }
}
