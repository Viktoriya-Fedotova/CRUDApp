package main.java.com.viktoriya_fedotova;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Label l = new Label(1L, "ABCD");
        LabelRepository lr = new LabelRepository();

        System.out.println(lr.save(l));
        System.out.println(lr.getAll());
        l = new Label(2L, "EFJ");
        System.out.println(lr.save(l));
        System.out.println(lr.getAll());
        l = new Label(3L, "KLOIU");
        System.out.println(lr.save(l));
        System.out.println(lr.getAll());
        System.out.println(lr.update(new Label(2L, "DCBA")));
        System.out.println(lr.getAll());
       // lr.deleteById(1L);
       // System.out.println(lr.getAll());



    }
}
