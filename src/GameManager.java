/**
 * Created by travisclement on 9/18/15.
 */
public class GameManager {
    private static GameManager gameManager = new GameManager();

    public static void startTheGame () {

        Game.setIsLandSelectionPhase(true);
        MapManager.setUpMap();
        //Round.startRounds();
        gameManager.disablePlayers(3);
    }

    public void disablePlayers (int numPlayers) {

/*
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
                ("/view/GameScreen.fxml"));
        Parent root = fxmlLoader.load();
        GameController controller = fxmlLoader.getController();
        controller.disablePlayerThree();*/
    }

}
