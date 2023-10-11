import javax.swing.text.DefaultEditorKit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();


        //instantier File
        FileIO io = new FileIO();
        customers = io.readCustomerData("src/customer.txt");

        System.out.println("Tilstand ved indlæsning af data: ");
        printCustomers(customers);

        //Lidt manipulation med nogle af de objekter vi lige har lavet


        System.out.println("\n Sidste kunde får 2000 kr");
        Customer lastCustomer = customers.get(customers.size()-1);
        lastCustomer.deposit(2000);
        System.out.println("Første kunde får 1000kr");
        customers.get(0).deposit(1000);
        System.out.println("\n Ny tilstand efter manipulation: ");
        printCustomers(customers);

       //Nu skal vi gemme de ændringer der er sket (data persistence)
        io.saveCustomerData(customers);
    }

    private static void printCustomers(ArrayList<Customer> list) {
        for (Customer c:list) {
            System.out.println(c);
        }
    }
}