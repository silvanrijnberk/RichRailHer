package Session;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Log {


    private List log = new ArrayList();


    public String notify(Object target, String type) {
        String line = getDateTime() + ">>>" + " Object " + type + ": " + target.toString();
        log.add(line);
        return line;
    }

    public String notify(String change) {
        String line = getDateTime() + ">>>" + change;
        log.add(line);
        return line;
    }

    public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public void save() {
        LogSaving logSave = new LogSaving();
        logSave.saveLog(this.log);
    }

    public boolean isEmpty() {
        return this.log.isEmpty();
    }
}
