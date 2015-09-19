import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by travisclement on 9/18/15.
 */
public class GameManager {
    private static GameManager gameManager = new GameManager();
    private static GameController controller;
    public static void startTheGame (Stage stage) throws Exception {

        Game.setIsLandSelectionPhase(true);
        MapManager.setUpMap();
        //Round.startRounds();
        gameManager.startGameController(stage);
        gameManager.setGameStateLabel();
        gameManager.disablePlayers(Game.getMulegame().getNumberOfPlayers());

        for (Player element : Game.getMulegame().getPlayerArray()) {
            System.out.println(element.getPlayerName());
        }
    }

    public void disablePlayers (int numPlayers) {
        if (numPlayers == 2) {
            controller.disablePlayerThree();
            controller.disablePlayerFour();
        }else if (numPlayers == 3)
        {
            controller.disablePlayerFour();
        }
    }
    public void startGameController(Stage astage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
                ("/view/GameScreen.fxml"));
        Parent root = fxmlLoader.load();
        astage.setScene(new Scene(root));
        astage.setTitle("M.U.L.E Game Screen");
        controller = fxmlLoader.getController();
        astage.show();
    }


    public void setGameStateLabel () {
        if (Game.isLandSelectionPhase()) {
            controller.setGameStateLabel("LAND SELECTION PHASE");
        } else {
            controller.setGameStateLabel("NORMAL GAME MODE");
        }
    }

}
