package Domain;

import java.util.ArrayList;

public class Locomotive extends Component {
    private String name;
    private String type;

    public Locomotive(String name) {
        super(name, "locomotive");
    }


    @Override
    public Component makeCopy() {
        Locomotive locomotiveOjb = null;
        try {
            locomotiveOjb = (Locomotive) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cannot clone Locomotive");
            e.printStackTrace();
        }
        return locomotiveOjb;
    }
}