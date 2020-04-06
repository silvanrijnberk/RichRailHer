package Session;

import Domain.Component;
import Domain.Train;

import java.util.List;

public interface SaveSession {
    void save(List<Train> trains, List<Component> components);

    void load(List<Train> trains, List<Component> components);

    String getPath();
}
