package mule.model;

import javafx.stage.Stage;
import mule.GameManager;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by travisclement on 10/24/15.
 */
public final class LoadSave {

    private LoadSave() { }

    public static void saveGame() {
        GameManager gamemanager = GameManager.getGameManager();
        Game saveGame = GameManager.getGameManager().getMulegame();
        if (!saveGame.isLandSelectionPhase()) {
            saveGame.setTimeLeftInTurn(gamemanager.getTimeLeft());
            gamemanager.stopTimer();
        }
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("gamedata.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(saveGame);
            out.close();
            fileOut.close();
            //System.out.printf("Serialized data is saved in gamedata.ser");
            System.exit(0);
        } catch (IOException i) {
            log.error("Ops!", i);
        }
    }

    public static void loadGame(Stage stage) throws Exception {

        Game mulegame = new Game();
        try {
            FileInputStream fileIn = new FileInputStream("gamedata.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            mulegame = (Game) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            log.error("Ops!", i);
            return;
        } catch (ClassNotFoundException c) {
            //System.out.println("Game class not found");
            log.error("Ops!", c);
            return;
        }
        GameManager.getGameManager().setGameFromSave(mulegame, stage);
    }
}
