import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Notepad");

        boolean run = true;

        while(run) {
            System.out.println("--------------------");
            String userInput = scanner.nextLine();
            String[] userInputArray = userInput.split(" ");

            if(userInputArray.length < 1) {
                System.err.println("ERROR: not a valid amount of arguments!");
            }

            switch(userInputArray[0].toUpperCase()) {
                case "ADD":
                    Main.add();
                    break;
                case "DEL":
                    Main.del();
                    break;
                case "DUMMY":
                    Main.dummy();
                    break;
                case "EXIT":
                    Main.exit();
                    break;
                case "FORMAT":
                    Main.format();
                    break;
                case "INDEX":
                    Main.index();
                    break;
                case "PRINT":
                    Main.print();
                    break;
                case "REPLACE":
                    Main.replace();
                    break;
                default:
                    System.err.println("ERROR: wrong argument");
                    break;
            }
        }
    }

    public static void add() {
        System.out.println("ADD");
    }

    public static void del() {
        System.out.println("DEL");
    }

    public static void dummy() {
        System.out.println("DUMMY");
    }

    public static void exit() {
        System.out.println("EXIT");
    }

    public static void format() {
        System.out.println("FORMAT");
    }

    public static void index() {
        System.out.println("INDEX");
    }

    public static void print() {
        System.out.println("PRINT");
    }

    public static void replace() {
        System.out.println("REPLACE");
    }
}