package read;

import java.io.*;
import java.util.Scanner;
public class Read {
    public int surname(String sur, Customer[] a) {
        System.out.println();
        System.out.printf("Поиск по фамилии (%s)%n", sur);
        System.out.println(Customer.getLine());
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].getSurname().equals(sur)) {
                System.out.println(a[i].toString());
                System.out.println(Customer.getLine());
                count++;
            }
        }
        return count;
    }
    public int buy(int buy, Customer[] a) {
        System.out.println();
        System.out.printf("Поиск по количеству покупок (>%d)%n", buy);
        System.out.println(Customer.getLine());
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].getBuy() >= buy) {
                System.out.println(a[i].toString());
                System.out.println(Customer.getLine());
                count++;
                //System.out.println(0 / 0);
            }
        }
        return count;
    }
    public int card(long min, long max, Customer[] a) {
        System.out.println();
        System.out.printf("Поиск по кредитной карте (>%d & <%d)%n", min, max);
        System.out.println(Customer.getLine());
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].getCard() >= min && a[i].getCard() <= max) {
                System.out.println(a[i].toString());
                System.out.println(Customer.getLine());
                count++;
            }
        }
        return count;
    }
    public void sort(Customer[] a) {
        System.out.println();
        System.out.println("Сортировка по количеству покупок");
        System.out.println(Customer.getLine());
        int i = 0;
        boolean flag = false;
        do {
            flag = false;
            for (int j = a.length - 2; j >= i; j--) {
                if (a[j].getBuy() > a[j + 1].getBuy()) {
                    Customer c = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = c;
                    flag = true;
                }
            }
            i++;
        } while (flag);
        for (int k = 0; k < a.length; k++) {
            System.out.println(a[k].toString());
            System.out.println(Customer.getLine());
        }
    }

    public Customer[] readDataFromFile() throws IOException {
        File file = new File("src/main/java/read/input.txt");
        Scanner in = new Scanner(file);
        int n = in.nextInt();
        in.nextLine();
        Customer[] a = new Customer[n];
        System.out.println(Customer.getLine());
        for (int i = 0; i < n; i++) {
            in.nextLine();
            int id = in.nextInt();
            in.nextLine();
            String surname = in.nextLine();
            String name = in.nextLine();
            String otch = in.nextLine();
            String phone = in.nextLine();
            long card = in.nextLong();
            in.nextLine();
            int buy = in.nextInt();
            in.nextLine();
            int skid = in.nextInt();
            a[i] = new Customer(id, surname, name, otch, phone, card, buy, skid);
            System.out.println(a[i].toString());
            System.out.println(Customer.getLine());
        }
        return a;
    }

}