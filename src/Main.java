import javax.swing.text.DefaultEditorKit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static void main(String[] args) {


        //Læse data
        File file = new File("src/customer.txt");

        try {
            Scanner scan = new Scanner(file);
            scan.nextLine(); //Skip header
            while(scan.hasNextLine()){
                String s = scan.nextLine();// Hele linjen vil stå i én string   ==>  "Egon, 200"
                String [] row = s.split(","); // s splittes to strings ==>  "Egon", "200"
                String name = row[0];      // ==> "Egon"
                int balance = Integer.parseInt(row[1].trim()); // Konverterer string til int "200" ==> 200
                Customer c = new Customer(name, balance); //bruger de indlæste værdier til at konstruere et kundeobjekt (instansiering)
                customers.add(c); // placerer objektet i listen med kunder
            }
        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }
        //Test koden
        testCode();

       //Gemme ændringer  (data persistence)
        try{
            FileWriter writer = new FileWriter("src/customer.txt");
            writer.write("Name,Balance"+"\n");
            for (Customer c:customers) {
                String textTosave = c.name +","+c.balance;
                writer.write(textTosave+"\n");//Egon,5200
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("noget gik galt ved skrivning til fil");
        }
    }

    private static void testCode() {
        /* Denne kode foretager nogle ændringer i player objekterne for at teste at data bliver gemt korrekt
        Første player får 1000kr
        Sidste player får 2000 kr
         */

        printCustomers(customers);
        //Lidt manipulation med nogle af de objekter vi lige har lavet

        System.out.println("Første kunde får 1000kr");
        customers.get(0).deposit(1000);

        System.out.println("\n Sidste kunde får 2000 kr");
        Customer lastCustomer = customers.get(customers.size()-1);
        lastCustomer.deposit(2000);

        System.out.println("\n Ny tilstand efter manipulation: ");
        printCustomers(customers);
    }

    private static void printCustomers(ArrayList<Customer> list) {
        for (Customer c:list) {
            System.out.println(c);
        }
    }
}