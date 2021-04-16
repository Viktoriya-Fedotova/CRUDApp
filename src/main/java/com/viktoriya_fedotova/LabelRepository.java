package main.java.com.viktoriya_fedotova;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class LabelRepository {

    final File filePath = new File("./src/main/resources/files/labels.txt");

    private static Long idCounter = 1L;


    Long generateId() {
        return idCounter++;
    }

    Label save(Label l) {
        List<Label> labelList = new ArrayList<>();
        l.setId(generateId());
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

    Label convertFromStrToLabel(String str) {
        String nameFromStr = str.substring(str.lastIndexOf("|") +1);
        String idFromStr = str.split("\\|")[0];
        Long convertIdFromStr = Long.parseLong(idFromStr);
        Label l = new Label(convertIdFromStr, nameFromStr);
        l.setId(convertIdFromStr);
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
            labelList.add(convertFromStrToLabel(str));
        }

        for (Label label : labelList) {
            if (label.getId().equals(id)) {
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
            labelList.add(convertFromStrToLabel(str));
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


       for (String str : auxiliaryList) {
           labelList.add(convertFromStrToLabel(str));

           }

       labelList.stream().map(e -> {
           if (e.getId().equals(l.getId())) {
               e.setName(l.getName());
           }
           return e;
       }).collect(Collectors.toList());


       try(FileWriter writer = new FileWriter(filePath)) {
          for (Label newLabel : labelList) {
              writer.write(newLabel + "\n");
          }

       } catch (IOException e) {
           e.printStackTrace();
       }
       return l;
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
            labelList.add(convertFromStrToLabel(str));
        }

        labelList.removeIf(t -> t.getId().equals(id));

        try(FileWriter writer = new FileWriter(filePath)) {
            for (Label newLabel : labelList) {
                writer.write(newLabel + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
