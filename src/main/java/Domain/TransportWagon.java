package Domain;


public class TransportWagon extends Component {


    public TransportWagon(String name) {
        super(name, "transportwagon");
    }

    @Override
    public Component makeCopy() {
        TransportWagon Ojb = null;
        try {
            Ojb = (TransportWagon) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cannot clone TransportWagon");
            e.printStackTrace();
        }
        return Ojb;
    }
}
