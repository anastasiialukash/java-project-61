package hexlet.code;

import java.util.Scanner;

import static hexlet.code.games.Games.isEven;

public class StartPage {
    static Scanner scanner = new Scanner(System.in);

    public static String greet() {
        System.out.print("May I have your name: ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static void selectGame() {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Exit
                """);
        String game = scanner.next();
        System.out.println("Your choice: " + game);
        String name = greet();

        if (game.equals("2")) {
            isEven(name);
        }

        scanner.close();
    }
}
