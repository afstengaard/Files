
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private ArrayList<String> players = new ArrayList<>();

    public static void main(String[] args) {
        Game game = new Game(6);
        FileIO io = new FileIO();
        game.setup();
    }

}