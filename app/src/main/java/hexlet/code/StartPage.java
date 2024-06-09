package hexlet.code;

public final class StartPage {

    private final GameEngine gameEngine = new GameEngine();

    private final Cli cli = new Cli();

    public void selectGame() {
        String game = cli.selectGame();
        String playerName = cli.greet();

        gameEngine.runGame(game, playerName);
    }
}
