package Domain;

public interface Subject extends Cloneable {

    void register(Observer o);

    void unregister(Observer o);

    void notifyObserver();

    Object makeCopy();

}
