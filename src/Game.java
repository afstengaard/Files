import java.util.ArrayList;

public class Game {
    private int maxPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();

    public Game(int maxPlayers) {
        this.maxPlayers = maxPlayers;

    }

    public void setup(){
        ArrayList<String> data = io.readPlayerData("src/data.txt");
        if(data.size() > 0){
            String input = ui.getInput("Vil du bruge de gemte spillere? y/n");
            if(input.equals("y")){
                for(String line : data){
                    String[] row = line.split(","); // s splittes to strings ==>  "Egon", "200"
                    String name = row[0];      // ==> "Egon"
                    int balance = Integer.parseInt(row[1].trim()); // Konverterer string til int "200" ==> 200
                    Player c = new Player(name, balance); //bruger de indlæste værdier til at konstruere et spillerobjekt (instansiering)
                    players.add(c); // placerer objektet i listen med spillerr
                }
            }else if(input.equals("n")){
                int playerAmount = Integer.parseInt(ui.getInput("Hvor mange spillere vil du lave?"));
                for(int i = 0; i < playerAmount; i++) {
                    String name = ui.getInput("Hvad hedder spiller nr. " + i+1);
                    Player kevin = new Player(name,2000);
                    players.add(kevin);
                }
            }
        }else{
            int playerAmount = Integer.parseInt(ui.getInput("Hvor mange spillere vil du lave?"));
            for(int i = 0; i < playerAmount; i++) {
                String name = ui.getInput("Hvad hedder spiller nr. " + i+1);
                Player kevin = new Player(name,2000);
                players.add(kevin);
            }
        }
        displayPlayers(players);
    }

    public void registerPlayer(String name,int amount){

    }

    public void displayPlayers(ArrayList<Player> list) {
        for (Player c:list) {
            System.out.println(c);
        }
    }

    public void endGame(){
        io.savePlayerData(players);
    }







}
