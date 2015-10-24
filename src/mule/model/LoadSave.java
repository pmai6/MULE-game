package mule.model;

import javafx.stage.*;
import mule.*;

import java.io.*;

/**
 * Created by travisclement on 10/24/15.
 */
public class LoadSave {


    public static void saveGame() {
        Game saveGame = GameManager.getGameManager().getMulegame();
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("gamedata.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(saveGame);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
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
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        GameManager.getGameManager().setGameFromSave(mulegame, stage);
    }
}
