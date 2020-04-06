package Domain;

import java.util.ArrayList;

public abstract class Component implements Subject {

    private String name;
    private String type;
    private ArrayList<Observer> observers;

    public Component(String name, String type) {
        this.name = name;
        this.type = type;
        this.observers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
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

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Component component = (Component) obj;

        return component.getName().equals(this.name);
    }


}
