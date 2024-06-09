package hexlet.code;

import hexlet.code.games.GameEngine;

public class StartPage {

    GameEngine gameEngine = new GameEngine();

    public StartPage() { }

    public Cli cli = new Cli();

    public void selectGame() {
        String playerName = cli.greet();
        String game = cli.selectGame();

        gameEngine.runGame(game, playerName);
    }
}
