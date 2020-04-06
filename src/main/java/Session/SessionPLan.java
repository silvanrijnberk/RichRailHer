package Session;

import Domain.Domain;
import UI.UI;

public interface SessionPLan {
    void setDomain(Domain domain);

    void setPickAFile(PickAFile pickAFile);

    void setLog(Log log);

    void setUI(UI ui);
}
