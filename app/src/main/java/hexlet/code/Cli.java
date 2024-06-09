package hexlet.code;

import java.util.Scanner;

public class Cli {

    Scanner scanner = new Scanner(System.in);

    public Cli() { }

    public String handleGameInputAndReturnAnswer(String question) {
        System.out.println("Question: " + question);
        var answer = scanner.next();
        System.out.println("Your answer: " + answer);

        return answer;
    }

    public String greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name: ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public String selectGame() {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                0 - Exit
                """);
        String game = scanner.next();
        System.out.println("Your choice: " + game);
        return game;
    }
}
