
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //                              referencen   objektet
    public static ArrayList<Player> players = new ArrayList<>();
    public static void main(String[] args) {
        //Læse data
       FileIO io = new FileIO();

       ArrayList<String> data;
       data =  io.readPlayerData("src/data.txt");

       if(data.size()>0){

           for (String s:data) {
              String[] row = s.split(",");
                String name = row[0];      // ==> "Egon"
                int balance = Integer.parseInt(row[1].trim()); // Konverterer string til int "200" ==> 200
                Player c = new Player(name, balance); //bruger de indlæste værdier til at konstruere et kundeobjekt (instansiering)
                players.add(c); // placerer objektet i listen med kunder


           }





        }



        //Test koden
        testCode();
       //Gem data
        io.savePlayerData(players);

    }

    private static void testCode() {
        /* Denne kode foretager nogle ændringer i player objekterne for at teste at data bliver gemt korrekt
        Første player får 1000kr
        Sidste player får 2000 kr
         */


        //Lidt manipulation med nogle af de objekter vi lige har lavet

        System.out.println("Første spiller får 1000kr");
        players.get(0).deposit(1000);

        System.out.println("\n Sidste spiller får 2000 kr");
        Player lastCustomer = players.get(players.size()-1);
        lastCustomer.deposit(2000);

        System.out.println("\n Ny tilstand efter manipulation: ");
        displayPlayers();
    }

    private static void displayPlayers() {
        for (Player p:players) {
            System.out.println(p);
        }
    }
}