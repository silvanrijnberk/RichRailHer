package Session;

import Domain.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Iterator;
import java.util.List;

public class SaveSessionJson implements SaveSession {


    private String path;
    private Domain domain;

    public SaveSessionJson(String path, Domain domain) {
        this.path = path;
        this.domain = domain;
    }

    public String getPath() {
        return path;
    }

    private Component getComponent(String component, JSONObject json) {


        String type = (String) json.get("component-" + component);

        if (type.equals("passengerwagon")) {
            Long temp = (Long) json.get(component + "-seats");
            int numseats = temp.intValue();
            Component comp = domain.newComponent(component, type, numseats);
            return comp;
        }

        Component comp = domain.newComponent(component, type);
        return comp;
    }

    private JSONObject saveComponent(Component c) {

        JSONObject component = new JSONObject();
        component.put("name", c.getName());
        component.put("type", c.getType());
        if (c.getType().equals("passengerwagon")) {
            PassengerWagon pw = (PassengerWagon) c;
            component.put("numseats", pw.getSeats());
        }
        return component;
    }

    private Train getTrain(String train, JSONObject json) {

        Long temp = (Long) json.get("train-" + train);
        int size = temp.intValue();
        Train trainOBJ = new Train(train);

        if (size < 1) {
            return trainOBJ;
        }
        for (int i = 0; i < size; i++) {
            String component = (String) json.get(trainOBJ.getName() + "-" + i);
            trainOBJ.add(getComponent(component, json));
        }


        return trainOBJ;
    }

    private JSONObject saveTrain(Train train) {
        JSONObject jsonTrain = new JSONObject();
        JSONArray jsonComponents = new JSONArray();
        jsonTrain.put("name", train.getName());
        for (Component c : train.getComponents()) {
            JSONObject temp = new JSONObject();
            temp.put("name", c.getName());
            temp.put("type", c.getType());
            if (c.getType().equals("passengerwagon")) {
                PassengerWagon pw = (PassengerWagon) c;
                temp.put("numseats", pw.getSeats());
            }
            jsonComponents.add(temp);
        }
        jsonTrain.put("components", jsonComponents);


        return jsonTrain;
    }


    public void load(List<Train> trains, List<Component> components) {
        Object obj = null;
        if (path.equals(""))
            return;
        try {
            obj = new JSONParser().parse(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject json = (JSONObject) obj;
        JSONArray jsonTrains = (JSONArray) json.get("trains");
        JSONArray jsonComponents = (JSONArray) json.get("components");
        if (jsonTrains == null || jsonComponents == null) {
            return;
        }
        Iterator iterTrains = jsonTrains.iterator();
        Iterator iterComponents = jsonComponents.iterator();
        while (iterTrains.hasNext()) {
            JSONObject t = (JSONObject) iterTrains.next();
            String tName = (String) t.get("name");
            domain.newTrain(tName);
            JSONArray tComponents = (JSONArray) t.get("components");
            Iterator iterTComponents = tComponents.iterator();
            while (iterTComponents.hasNext()) {
                JSONObject tC = (JSONObject) iterTComponents.next();
                String cName = (String) tC.get("name");
                String cType = (String) tC.get("type");
                if (cType.equals("passengerwagon")) {
                    Long cNumseats = (Long) tC.get("numseats");
                    domain.newComponent(cName, cType, cNumseats.intValue());
                    domain.addToTrain(cName, tName);
                } else {
                    domain.newComponent(cName, cType);
                    domain.addToTrain(cName, tName);
                }
            }
        }
        while (iterComponents.hasNext()) {
            JSONObject tC = (JSONObject) iterComponents.next();
            String cName = (String) tC.get("name");
            String cType = (String) tC.get("type");
            if (cType.equals("passengerwagon")) {
                Long cNumseats = (Long) tC.get("numseats");
                if (domain.findComponent(cName) == null)
                    domain.newComponent(cName, cType, cNumseats.intValue());
            } else {
                if (domain.findComponent(cName) == null)
                    domain.newComponent(cName, cType);
            }
        }
    }

    public void save(List<Train> trains, List<Component> components) {
        JSONObject jobject = new JSONObject();
        JSONArray jsonTrains = new JSONArray();
        JSONArray jsonComponents = new JSONArray();
        if (path.equals(""))
            return;
        for (Train t : trains) {
            jsonTrains.add(saveTrain(t));
        }
        System.out.println("components size" + components.size());
        for (Component c : components) {
            jsonComponents.add(saveComponent(c));

        }
        jobject.put("trains", jsonTrains);
        jobject.put("components", jsonComponents);
        try (FileWriter file = new FileWriter(path)) {
            file.write(jobject.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
