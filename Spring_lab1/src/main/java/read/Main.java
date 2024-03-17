package read;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Read read = context.getBean("read", Read.class);
        Customer[] a = read.readDataFromFile();
        String surname="Никитин";
        int buy = 70;
        long min = 3000000000000000l;
        long max = 7000000000000000l;
        read.surname(surname, a);
        read.buy(buy, a);
        read.card(min, max, a);
        read.sort(a);
    }

}