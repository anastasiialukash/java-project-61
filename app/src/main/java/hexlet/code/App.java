package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.Calculator;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        starGame();
    }

    public static void starGame() {
        EvenGame evenGame = new EvenGame();
        Calculator calculator = new Calculator();
        GCD gcd = new GCD();
        Progression progression = new Progression();
        Prime prime = new Prime();

        printMenu();
        String game = SCANNER.next();
        System.out.println("Your choice: " + game);

        switch (game) {
            case "1" -> Cli.greet();
            case "2" -> evenGame.isEven();
            case "3" -> calculator.calc();
            case "4" -> gcd.calculateGCD();
            case "5" -> progression.getArithmeticProgression();
            case "6" -> prime.isPrime();
            default -> exit();
        }
    }

    private static void printMenu() {
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
    }

    private static void exit() {
        SCANNER.close();
    }
}
