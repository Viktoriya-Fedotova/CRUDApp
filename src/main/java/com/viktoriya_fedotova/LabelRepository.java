package main.java.com.viktoriya_fedotova;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class LabelRepository {

    private List<Label> labelList = new ArrayList<>();
    File filePath = new File("C:\\IdeaProjects\\CrudApp\\src\\main\\resources\\files\\labels.txt");

    Label save(Label l) throws IOException {
        FileOutputStream file = new FileOutputStream(filePath);
        byte buf[] = l.toString().getBytes();
        for (int i = 0; i < buf.length; i++) {
            file.write(buf[i]);
            labelList.add(l);
            break;
        }
        file.close();

        return l;

       /* labelList.add(l);
        FileWriter writer = new FileWriter("C:\\IdeaProjects\\CrudApp\\src\\main\\resources\\files\\labels.txt");
        for (Label x : labelList) {
            String name = x.getName();
            Long id = x.getId();
            writer.write(id + ". " + name + ";");
        } */
    }

    Label getById(Long id) {
        Label l = null;
        for (Label x : labelList) {
            if (x.getId() == id) {
                l = x;
                break;
            }
        }
        return l;

    }

    List<Label> getAll() {
        return labelList;

    }

   Label update(Label l) {
        Label label = getById(l.getId());
        label.setName(l.getName());


        return l;
    }

    void deleteById(Long id) {
        labelList.remove(getById(id));
    }

}
