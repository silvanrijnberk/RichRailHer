package Domain;

import java.util.ArrayList;
import java.util.List;

public class Train implements Subject {
    private String name;
    private List<Component> components;
    private ArrayList<Observer> observers;

    public Train(String name) {
        this.name = name;
        this.components = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getSeats() {
        int sum = 0;
        for (Component c : components) {
            if (c.getType().equals("passengerwagon")) {
                PassengerWagon w = (PassengerWagon) c;
                sum = +w.getSeats();
            }
        }
        return sum;
    }

    public void add(Component c) {
        components.add(c);
        notifyObserver();
    }

    public void remove(Component c) {
        components.remove(c);
        notifyObserver();
    }


    public List<Component> getCopyComponents() {
        List<Component> clone = new ArrayList<Component>(components.size());
        for (Component c : components) clone.add((Component) c.makeCopy());
        return clone;
    }


    public List<Component> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        return "Train{" +
                "name='" + name + '\'' +
                ", components=" + components.size() +
                '}';
    }

    public Component getComponent(String component) {
        for (Component c : components) {
            if (c.getName().equals(component))
                return c;
        }
        return null;
    }


    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    @Override
    public Train makeCopy() {
        Train Ojb = null;
        try {
            Ojb = (Train) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cannot clone train");
            e.printStackTrace();
        }
        return Ojb;
    }

    @Override
    public boolean equals(Object obj) {
        Train train = (Train) obj;

        return train.getName().equals(this.name);
    }
}
