package hexlet.code;

import hexlet.code.games.GameEngine;

public class StartPage {

    private final GameEngine gameEngine = new GameEngine();

    private final Cli cli = new Cli();

    public void selectGame() {
        String playerName = cli.greet();
        String game = cli.selectGame();

        gameEngine.runGame(game, playerName);
    }
}
