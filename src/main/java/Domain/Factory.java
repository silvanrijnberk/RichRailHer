package Domain;

public class Factory {

    public Component newComponent(String component, String type) {

        if (type.equals("passengerwagon")) {
            return new PassengerWagon(component);
        }
        if (type.equals("transportwagon")) {
            return new TransportWagon(component);
        }
        if (type.equals("locomotive")) {
            return new Locomotive(component);
        }
        return null;
    }

    public Component newComponent(String component, String type, int numsteats) {
        if (type.equals("passengerwagon")) {
            return new PassengerWagon(component, numsteats);
        }
        return null;
    }
}
