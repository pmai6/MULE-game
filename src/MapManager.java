import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * Created by travisclement on 9/18/15.
 */
public class MapManager {

    public static void handleMapButton(Button button){
        System.out.println("Row " + GridPane.getRowIndex(button) + " Column "
                + GridPane.getColumnIndex(button));


    }

}
