package Domain;

import Session.Session;

import java.util.ArrayList;
import java.util.List;

public class Domain {
    private List<Component> components = new ArrayList();
    private List<Train> trains = new ArrayList();
    private Session session;
    private Search search = new Search();
    private Factory factory = new Factory();
    private String nA = "name already exists";


    public Boolean addToTrain(String component, String train) {
        Train t = findTrain(train);
        if (t.getComponent(component) != null) {
            session.notify("Train can only contain unique components");
            return false;
        }
        Component c = findComponent(component);
        t.add(c);
        if (t == null || c == null)
            return false;
        return true;
    }

    public boolean removeFromTrain(String component, String train) {
        Train t = findTrain(train);
        Component c = t.getComponent(component);
        if (t == null || c == null)
            return false;
        t.remove(c);
        return true;
    }

    public Component newComponent(String component, String type) {
        if (!isUnique(component)) {
            session.notify(nA);
            System.out.println("not unique " + component);
            return null;
        }
        Component c = factory.newComponent(component, type);
        new ComponentObserver(c, session);
        components.add(c);
        return c;
    }

    public Component newComponent(String component, String type, int numseats) {
        if (!isUnique(component)) {
            session.notify(nA);
            System.out.println("not unique " + component);
            return null;
        }
        Component c = factory.newComponent(component, type, numseats);
        new ComponentObserver(c, session);
        components.add(c);
        return c;
    }

    public Train newTrain(String train) {
        if (!isUnique(train)) {
            session.notify(nA);
            System.out.println("not unique " + train);
            return null;
        }
        Train t = new Train(train);
        new TrainObserver(t, session);
        trains.add(t);
        return t;
    }


    public boolean deleteComponent(String component) {
        Component c = findComponent(component);
        if (c == null)
            return false;
        components.remove(c);
        session.notify(c, "deleted");
        for (Train t : trains) {
            if (t.getComponent(component) != null) {
                removeFromTrain(component, t.getName());
            }
        }
        return true;
    }

    public boolean deleteTrain(String train) {
        Train t = findTrain(train);
        if (t == null)
            return false;
        trains.remove(t);
        session.notify(t, "deleted");
        return true;
    }

    public int getNumSeats(boolean train, String name) {
        if (train) {
            return findTrain(name).getSeats();
        }
        PassengerWagon pw = (PassengerWagon) findComponent(name);
        return pw.getSeats();
    }

    public boolean isUnique(String name) {
        return findTrain(name) == null && findComponent(name) == null && findTrainComponent(name) == null;
    }

    public String[] getComponentsString() {
        String[] res = new String[components.size()];
        for (Component c : components) {
            res[components.indexOf(c)] = c.getName();
        }
        return res;
    }

    public String[] getTrainsString() {
        String[] res = new String[trains.size()];
        for (Train t : trains) {
            res[trains.indexOf(t)] = t.getName();
        }
        return res;
    }

    public void clear() {
        trains.clear();
        components.clear();
        session.notify("new session started");
    }

    public Train findTrain(String name) {
        return search.findTrain(name, trains);
    }

    public Component findComponent(String name) {
        return search.findComponent(name, components);
    }

    public Component findTrainComponent(String name) {
        return search.findTrainComponent(name, trains);
    }

    public List<Component> getComponents() {
        return components;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public boolean isEmpty() {
        return components.isEmpty() && trains.isEmpty();
    }
}
