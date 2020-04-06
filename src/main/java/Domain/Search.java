package Domain;


import java.util.List;

public class Search {


    public Train findTrain(String train, List<Train> trains) {
        for (Train t : trains) {
            if (t.getName().equals(train))
                return t;
        }
        return null;
    }

    public Component findComponent(String component, List<Component> components) {
        for (Component c : components) {
            if (c.getName().equals(component))
                return c;
        }
        return null;
    }

    public Component findTrainComponent(String name, List<Train> trains) {
        for (Train t : trains) {
            for (Component c : t.getComponents()) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
        }
        return null;
    }
}
