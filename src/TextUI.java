import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    private Scanner scan = new Scanner(System.in);

    //shows a message and returns the user's input as a String
    public String getInput(String msg){
        System.out.println(msg);
        return scan.nextLine();
    }


    /*
     *
     * ' shows a message, lists the content of a list and returns the user's choice
     * */




}