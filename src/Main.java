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
        File file = new File("src/customer.txt");

        try {

            Scanner scan = new Scanner(file);//System.in
            scan.nextLine();// skip header
            while(scan.hasNextLine()){

                String line = scan.nextLine();// Egon,30000
                String[] values = line.split(",");
                customers.add(new Customer(values[0] , Integer.parseInt(values[1]) ));
            }

            System.out.println(customers.get(0).name+" : "+customers.get(0).balance);
            System.out.println(customers.get(1).name+" : "+customers.get(1).balance);
            System.out.println(customers.get(2).name+" : "+customers.get(2).balance);

        }catch (FileNotFoundException e){

            System.out.println("Filen blev ikke fundet");

        }
           customers.get(0).deposit(1000);
        // Opdatere customers.txt
       try {
           FileWriter writer = new FileWriter("src/customer.txt");
           writer.write("Name, Balance \n");
           for(Customer c : customers){

               writer.write(c.name+","+c.balance+"\n");

           }
           writer.close();
       }catch(IOException e){


       }

    }
}