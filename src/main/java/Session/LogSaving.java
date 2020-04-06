package Session;

import Session.PickAFile;

import java.io.*;
import java.util.List;

public class LogSaving {

    public void saveLog(List log) {
        PickAFile pickAFile = new PickAFile();
        String path = pickAFile.pick("Choose file to save log to", "txt");
        write(path, log);

    }

    private void write(String path, List log) {
        try {
            if (path.isEmpty()) {
                return;
            }
            FileWriter write = new FileWriter(path, true);
            PrintWriter print_line = new PrintWriter(write);
            for (Object line : log) {
                print_line.println((String) line);
            }
            print_line.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
