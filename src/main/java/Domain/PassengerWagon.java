package Domain;

import java.util.ArrayList;

public class PassengerWagon extends Component {
    private int seats;


    public PassengerWagon(String name, int seats) {
        super(name, "passengerwagon");
        this.seats = seats;
    }

    public PassengerWagon(String name) {
        super(name, "passengerwagon");
        this.seats = 24;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Component{" +
                "name='" + getName() + '\'' +
                ", seats=" + seats +
                ", type='" + getType() + '\'' +
                '}';
    }

    @Override
    public Component makeCopy() {
        PassengerWagon Ojb = null;
        try {
            Ojb = (PassengerWagon) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cannot clone PassengerWagon");
            e.printStackTrace();
        }
        return Ojb;
    }
}
