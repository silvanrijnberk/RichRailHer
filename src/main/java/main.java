import Session.*;

public class main {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        SessionBuilder standardSessionBuilder = new StandardSessionBuilder();
        SessionEngineer sessionEngineer = new SessionEngineer(standardSessionBuilder);
        sessionEngineer.makeSession();
        Session session = sessionEngineer.getSession();
        session.start();
    }
}
