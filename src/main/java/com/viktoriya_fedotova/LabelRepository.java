package main.java.com.viktoriya_fedotova;

import java.io.*;
import java.util.*;

public class LabelRepository {

    final File filePath = new File("C:\\IdeaProjects\\CrudApp\\src\\main\\resources\\files\\labels.txt");

    Label save(Label l) {
        List<Label> labelList = new ArrayList<>();
        labelList.add(l);

        try(FileWriter fileWriter = new FileWriter(filePath, true)) {
            for (Label label : labelList) {
                fileWriter.write(label + "\n");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    Label getById(Long id) {
       Label l = null;
       List<String> auxiliaryList = new ArrayList<>();
       List<Label> labelList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            Scanner scanner = new Scanner(bufferedReader);

            while (scanner.hasNextLine()) {
                auxiliaryList.add(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (String str : auxiliaryList) {
            String nameFromStr = str.substring(str.lastIndexOf(".") +1);
            String idFromStr = str.split("\\.")[0];
            Long convertIdFromStr = Long.parseLong(idFromStr);
            l = new Label(convertIdFromStr, nameFromStr);
            labelList.add(l);
        }

        for (Label label : labelList) {
            if (label.getId() == id) {
                l = label;
                break;
            }
        }

        return l;

    }

    List<Label> getAll() {
        Label l = null;
        List<String> auxiliaryList = new ArrayList<>();
        List<Label> labelList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            Scanner scanner = new Scanner(bufferedReader);

            while (scanner.hasNextLine()) {
                auxiliaryList.add(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (String str : auxiliaryList) {
            String nameFromStr = str.substring(str.lastIndexOf(".") +1);
            String idFromStr = str.split("\\.")[0];
            Long convertIdFromStr = Long.parseLong(idFromStr);
            l = new Label(convertIdFromStr, nameFromStr);
            labelList.add(l);
        }

        return labelList;

    }

   Label update(Label l) {
       List<String> auxiliaryList = new ArrayList<>();
       List<Label> labelList = new ArrayList<>();
       try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
           Scanner scanner = new Scanner(bufferedReader);

           while (scanner.hasNextLine()) {
               auxiliaryList.add(scanner.nextLine());
           }

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }

       Label label = null;

       for (String str : auxiliaryList) {
           String nameFromStr = str.substring(str.lastIndexOf(".") +1);
           String idFromStr = str.split("\\.")[0];
           Long convertIdFromStr = Long.parseLong(idFromStr);
           label = new Label(convertIdFromStr, nameFromStr);
           labelList.add(label);

           }

       for(Label newLabel : labelList) {
           if (newLabel.getId().equals(l.getId())) {
               newLabel.setName(l.getName());

               break;

           } else new IOException("The element is missing!");

       }

       try(FileWriter writer = new FileWriter(filePath)) {
          for (Label newLabel : labelList) {
              writer.write(newLabel + "\n");
          }

       } catch (IOException e) {
           e.printStackTrace();
       }
       return label;
    }

    void deleteById(Long id) {
        Label l = null;
        List<String> auxiliaryList = new ArrayList<>();
        List<Label> labelList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            Scanner scanner = new Scanner(bufferedReader);

            while (scanner.hasNextLine()) {
                auxiliaryList.add(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String str : auxiliaryList) {
            String nameFromStr = str.substring(str.lastIndexOf(".") +1);
            String idFromStr = str.split("\\.")[0];
            Long convertIdFromStr = Long.parseLong(idFromStr);
            l = new Label(convertIdFromStr, nameFromStr);
            labelList.add(l);
        }

        labelList.remove(getById(id));

        try(FileWriter writer = new FileWriter(filePath)) {
            for (Label newLabel : labelList) {
                writer.write(newLabel + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
