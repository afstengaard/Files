import java.util.Scanner;

public class TextUI {
    private Scanner scan = new Scanner(System.in);

    public String getInput(String msg) {
        System.out.println(msg);
        return scan.nextLine();
    }
}
