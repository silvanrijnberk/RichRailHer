package Session;

public interface SessionBuilder {
    Session getSession();

    void buildDomain();

    void buildPickAFile();

    void buildLog();

    void buildUI();
}
