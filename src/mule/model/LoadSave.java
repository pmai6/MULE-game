package mule.model;

import javafx.stage.*;
import mule.*;
import mule.view.*;

import java.io.*;

/**
 * Created by travisclement on 10/24/15.
 */
public class LoadSave {


    public static void saveGame() throws Exception{
        GameManager gamemanager = GameManager.getGameManager();
        Game saveGame = GameManager.getGameManager().getMulegame();
        if (!saveGame.isLandSelectionPhase()) {
            saveGame.setTimeLeftInTurn(gamemanager.getTimeLeft());
            gamemanager.stopTimer();
        }
        try {
            MySQLAccess dao = new MySQLAccess();
            dao.saveDataBase(saveGame);
            FileOutputStream fileOut =
                    new FileOutputStream("gamedata.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(saveGame);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in gamedata.ser");
            System.exit(0);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void loadGame(Stage stage) throws Exception {

        Game mulegame = new Game();
        try {
            MySQLAccess dao = new MySQLAccess();
            mulegame = dao.readDataBase();

            /*old saving to file method*/
            //FileInputStream fileIn = new FileInputStream("gamedata.ser");
            //ObjectInputStream in = new ObjectInputStream(fileIn);
            //mulegame = (Game) in.readObject();
            //in.close();
            //fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Game class not found");
            c.printStackTrace();
            return;
        }
        GameManager.getGameManager().setGameFromSave(mulegame, stage);
    }
}
