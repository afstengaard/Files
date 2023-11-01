import org.w3c.dom.Text;

import java.util.ArrayList;

public class Game {
    public ArrayList<Player> players = new ArrayList<>();
    FileIO io;
    TextUI ui;
    public void setup(){


        //Læse data
        io = new FileIO();
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
        }else{
            ui= new TextUI();
           while(players.size() < 6) {
               String input = ui.getInput("Skriv navn på spiller: ");
               Player p = new Player(input, 3000);
               players.add(p);
           }
        }
        //Test koden
        testCode();

    }

    private void testCode() {
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

    private void displayPlayers() {
        for (Player p:players) {
            System.out.println(p);
        }
    }
    public void endGame(){

        //Gem data
        io.savePlayerData(players);

    }
}
