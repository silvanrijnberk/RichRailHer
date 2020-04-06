package Session;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PickAFile {

    public String pick(String title) {
        JFileChooser chooser = getChooser(title, "");
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        } else {
            return "";
        }
    }

    public String pick(String title, String filterText) {
        JFileChooser chooser = getChooser(title, filterText);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        } else {
            return "";
        }
    }

    private JFileChooser getChooser(String title, String filterText) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("./src/main/java/Data"));
        if (!filterText.isEmpty()) {
            FileFilter filter = new FileNameExtensionFilter(filterText, filterText);
            chooser.addChoosableFileFilter(filter);
        }
        chooser.setDialogTitle(title);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);
        return chooser;
    }
}
