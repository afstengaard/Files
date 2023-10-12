import java.util.ArrayList;

public class Main {
    private static ArrayList<Player> players;
    public static void main(String[] args) {

        //instantier File
        FileIO io = new FileIO();
        players = io.readPlayerData("src/data.txt");

        System.out.println("Tilstand ved indlæsning af data: ");
        printPlayers();

        //Lidt manipulation med nogle af de objekter vi lige har lavet


        System.out.println("\n Sidste kunde får 2000 kr");
        Player lastPlayer = players.get(players.size()-1);
        lastPlayer.deposit(2000);
        System.out.println("Første kunde får 1000kr");
        players.get(0).deposit(1000);
        System.out.println("\n Ny tilstand efter manipulation: ");
        printPlayers();

       //Nu skal vi gemme de ændringer der er sket (data persistence)
        io.savePlayerData(players);
    }

    private static void printPlayers() {
        for (Player p:players) {
            System.out.println(p);
        }
    }
}