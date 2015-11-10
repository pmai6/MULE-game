package mule.tests;


import mule.GameManager;
import mule.PlayerManager;
import mule.RoundManager;
import mule.model.Game;
import mule.model.Player;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TravisJunit {
    public static final int TIMEOUT = 200;
    public GameManager gameManager;
    public Player myPlayer;
    public Game mulegame;

    @Before
    public void setUp() {
        gameManager = new GameManager();
        gameManager.createGame("Beginner", 4, "Standard", 4);
        PlayerManager.createNewGamePlayer("Drew",
                "Human", "Purple");
        PlayerManager.createNewGamePlayer("Ryyan",
                "Ugaite", "Green");
        PlayerManager.createNewGamePlayer("Travis",
                "Flapper", "Red");
        PlayerManager.createNewGamePlayer("Zuri",
                "Bonzoid", "Blue");
        RoundManager.startRounds(gameManager);
        myPlayer = RoundManager.getCurrentPlayer();
        mulegame = gameManager.getMulegame();

    }

    @Test(timeout = TIMEOUT)
    public void calcPlayerTimeTest() {
        assertEquals(50, myPlayer.calcPlayerTime());

        myPlayer.setFood(0);
        assertEquals(5, myPlayer.calcPlayerTime());

        myPlayer.setFood(2);
        assertEquals(30, myPlayer.calcPlayerTime());
    }
}
