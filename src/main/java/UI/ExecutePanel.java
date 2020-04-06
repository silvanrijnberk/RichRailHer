package UI;

import Domain.Component;
import Domain.Domain;
import Session.Session;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.RichRailLexer;
import parser.RichRailParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class ExecutePanel extends JPanel {

    private Session session;
    private JButton button;
    private JButton change;
    private JButton createT;
    private JButton deleteT;
    private JButton createC;
    private JButton deleteC;
    private JButton addTo;
    private JButton removeFrom;
    private JButton newSession;
    private JButton loadSession;
    private JButton saveSession;
    private JTextField field;
    private JTextField input;
    private JTextField createTrain;
    private JTextField createComponent;
    private Choice deleteTrain;
    private Choice deleteComponent;
    private Choice Type;
    private Choice detTrain;
    private Choice addComp;
    private Choice addTrain;
    private Choice removeComp;
    private Choice removeTrain;
    private JLabel details = new JLabel("Draw one train:");

    public ExecutePanel(Session session) {
        this.session = session;
        Dimension size = getPreferredSize();
        size.width = 800;
        size.height = 135;
        setPreferredSize(size);
        input = new JTextField("Input: ");
        input.setEditable(false);
        field = new JTextField("");
        createTrain = new JTextField("");
        createComponent = new JTextField("");
        Dimension d = new Dimension(200, 24);
        field.setPreferredSize(d);
        createTrain.setColumns(2);
        createComponent.setColumns(2);
        button = new JButton("Execute");
        createT = new JButton("Create t");
        deleteT = new JButton("Delete t");
        createC = new JButton("Create c");
        deleteC = new JButton("Delete c");
        addTo = new JButton("add to");
        newSession = new JButton("New session");
        loadSession = new JButton("Load session");
        saveSession = new JButton("Save session");
        String[] trains = session.getDomain().getTrainsString();
        String[] components = session.getDomain().getComponentsString();
        deleteTrain = new Choice();
        deleteComponent = new Choice();
        detTrain = new Choice();
        addTrain = new Choice();
        addComp = new Choice();
        removeComp = new Choice();
        removeTrain = new Choice();
        removeFrom = new JButton("remove from");
        detTrain.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                session.getUI().drawOne(detTrain.getSelectedItem());
                ;
            }
        });
        Type = new Choice();
        Type.add("passengerwagon");
        Type.add("transportwagon");
        Type.add("locomotive");
        for (String t : trains) {
            deleteTrain.add(t);
            detTrain.add(t);
            addTrain.add(t);
            removeTrain.add(t);
        }

        for (String c : components) {
            deleteComponent.add(c);
            addComp.add(c);
            removeComp.add(c);
        }
        detTrain.setBounds(100, 100, 100, 75);
        deleteTrain.setBounds(100, 100, 100, 75);
        deleteComponent.setBounds(100, 100, 100, 75);
        setLayout(new GridBagLayout());
        addTo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (addTrain.getSelectedItem() == null || addComp.getSelectedItem() == null) {
                    return;
                }
                session.getUI().add(addComp.getSelectedItem(), addTrain.getSelectedItem());

                recalc();

            }
        });
        removeFrom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (removeTrain.getSelectedItem() == null || removeComp.getSelectedItem() == null) {
                    return;
                }
                session.getUI().remove(removeComp.getSelectedItem(), removeTrain.getSelectedItem());
                recalc();

            }
        });
        loadSession.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                session.getUI().loadSession();
            }
        });
        newSession.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                session.getUI().delSession();
            }
        });
        saveSession.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                session.getUI().saveSession(false);
            }
        });

        createT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (createTrain.getText().isEmpty()) {
                    return;
                }
                session.getUI().create(createTrain.getText());
                recalc();

            }
        });
        deleteT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (deleteTrain.getSelectedItem() == null) {
                    return;
                }
                session.getUI().delete("train", deleteTrain.getSelectedItem());
                recalc();

            }
        });
        createC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (createComponent.getText().isEmpty() || Type.getSelectedItem() == null) {
                    return;
                }
                session.getUI().create(createComponent.getText(), Type.getSelectedItem());
                recalc();

            }
        });
        deleteC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (deleteComponent.getSelectedItem() == null) {
                    return;
                }
                session.getUI().delete("component", deleteComponent.getSelectedItem());

                recalc();

            }
        });


        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 1;
        gc.weighty = 0;
        gc.fill = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 0;
        gc.gridy = 0;
        add(input, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        add(field, gc);
        gc.gridx = 1;
        gc.gridy = 1;
        add(saveSession, gc);
        gc.gridx = 2;
        gc.gridy = 1;
        add(loadSession, gc);
        gc.gridx = 4;
        gc.gridy = 1;
        add(newSession, gc);
        gc.gridx = 2;
        gc.gridy = 0;
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (field.getText().isEmpty()) {
                    return;
                }
                execute(field.getText());
            }
        });

        add(button, gc);
        gc.gridx = 4;
        gc.gridy = 0;
        change = new JButton("Buttons");
        change.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                if (change.getText().equals("Commands")) {
                    removeAll();
                    GridBagConstraints gc = new GridBagConstraints();
                    gc.anchor = GridBagConstraints.LINE_START;
                    gc.weightx = 1;
                    gc.weighty = 0;
                    gc.fill = 1;

                    gc.anchor = GridBagConstraints.LINE_START;
                    gc.gridx = 0;
                    gc.gridy = 0;
                    add(input, gc);

                    gc.gridx = 1;
                    gc.gridy = 0;
                    add(field, gc);

                    gc.gridx = 2;
                    gc.gridy = 0;
                    add(button, gc);
                    gc.gridx = 3;
                    gc.gridy = 0;
                    add(change, gc);
                    gc.gridx = 1;
                    gc.gridy = 1;
                    add(saveSession, gc);
                    gc.gridx = 2;
                    gc.gridy = 1;
                    add(loadSession, gc);
                    gc.gridx = 3;
                    gc.gridy = 1;
                    add(newSession, gc);
                    change.setText("Buttons");
                    revalidate();
                    repaint();
                    session.getUI().draw();
                    return;
                }

                if (change.getText().equals("Buttons")) {
                    removeAll();
                    recalc();
                    setLayout(new GridBagLayout());
                    GridBagConstraints gc = new GridBagConstraints();
                    gc.anchor = GridBagConstraints.LINE_START;
                    gc.weightx = 1;
                    gc.weighty = 1;
                    gc.fill = 1;
                    gc.anchor = GridBagConstraints.LINE_START;
                    gc.gridx = 0;
                    gc.gridy = 0;
                    add(createT, gc);
                    gc.gridx = 1;
                    gc.gridy = 0;
                    add(createTrain, gc);
                    gc.gridx = 2;
                    gc.gridy = 0;
                    add(createC, gc);
                    gc.gridx = 3;
                    gc.gridy = 0;
                    add(createComponent, gc);
                    gc.gridx = 4;
                    gc.gridy = 0;
                    add(Type, gc);

                    gc.gridx = 0;
                    gc.gridy = 2;
                    add(deleteT, gc);
                    gc.gridx = 1;
                    gc.gridy = 2;
                    add(deleteTrain, gc);
                    gc.gridx = 2;
                    gc.gridy = 2;
                    add(deleteC, gc);
                    gc.gridx = 3;
                    gc.gridy = 2;
                    add(deleteComponent, gc);

                    gc.gridx = 0;
                    gc.gridy = 1;
                    add(details, gc);
                    gc.gridx = 1;
                    gc.gridy = 1;
                    add(detTrain, gc);
                    gc.gridx = 2;
                    gc.gridy = 1;
                    add(addComp, gc);
                    gc.gridx = 3;
                    gc.gridy = 1;
                    add(addTo, gc);
                    gc.gridx = 4;
                    gc.gridy = 1;
                    add(addTrain, gc);
                    gc.gridx = 2;
                    gc.gridy = 3;
                    add(removeComp, gc);
                    gc.gridx = 3;
                    gc.gridy = 3;
                    add(removeFrom, gc);
                    gc.gridx = 4;
                    gc.gridy = 3;
                    add(removeTrain, gc);
                    gc.gridx = 4;
                    gc.gridy = 2;
                    add(change, gc);
                    change.setText("Commands");
                    revalidate();
                    repaint();
                    session.getUI().draw();
                    return;
                }
            }
        });
        add(change, gc);
    }

    public void recalc() {
        deleteTrain.removeAll();
        detTrain.removeAll();
        addTrain.removeAll();
        removeTrain.removeAll();
        String[] trains = session.getDomain().getTrainsString();
        for (String t : trains) {
            deleteTrain.add(t);
            detTrain.add(t);
            addTrain.add(t);
            if (!session.getDomain().findTrain(t).getComponents().isEmpty())
                removeTrain.add(t);
        }
        deleteComponent.removeAll();
        addComp.removeAll();
        removeComp.removeAll();
        String[] components = session.getDomain().getComponentsString();
        for (String c : components) {
            deleteComponent.add(c);
            addComp.add(c);
        }
        if (removeTrain.getSelectedItem() != null && !removeTrain.getSelectedItem().isEmpty()) {
            List tempComp = session.getDomain().findTrain(removeTrain.getSelectedItem()).getComponents();
            for (Object o : tempComp) {
                Component c = (Component) o;
                removeComp.add(c.getName());
            }
        }
    }


    public void execute(String command) {
        CharStream lineStream = CharStreams.fromString(command);

        Lexer lexer = new RichRailLexer(lineStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        RichRailParser parser = new RichRailParser(tokens);
        ParseTree tree = parser.command();

        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(session.getUI().getListener(), tree);
    }

}


