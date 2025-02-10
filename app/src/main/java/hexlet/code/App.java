package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.Calculator;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final EvenGame EVEN_GAME = new EvenGame();
    private static final Calculator CALCULATOR = new Calculator();
    private static final GCD CALCULATOR_GCD = new GCD();
    private static final Progression PROGRESSION = new Progression();
    private static final Prime PRIME = new Prime();

    public static void main(String[] args) {
        String gameNumber = selectGame();
        starGame(gameNumber);
    }

    public static String selectGame() {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                """);
        String game = SCANNER.next();
        System.out.println("Your choice: " + game);
        return game;
    }

    public static void starGame(String gameNumber) {
        switch (gameNumber) {
            case "1" -> Cli.greet();
            case "2" -> EVEN_GAME.isEven();
            case "3" -> CALCULATOR.calc();
            case "4" -> CALCULATOR_GCD.calculateGCD();
            case "5" -> PROGRESSION.getArithmeticProgression();
            case "6" -> PRIME.isPrime();
            default -> exit();
        }
    }

    private static void exit() {
        SCANNER.close();
    }
}
