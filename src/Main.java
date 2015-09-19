import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/view/StartUp.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("M.U.L.E Main Screen");
        primaryStage.setScene(new Scene(root));
        StartUpController controller = fxmlLoader.getController();
        controller.setMainApp(this);
        primaryStage.show();
    }

    /** starts the player config window
     *
     * @param astage receives stage from previous window for reuse
     * @throws Exception
     */
    public void startPlayerConfig(Stage astage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/view/configScreen.fxml"));
        Parent root = fxmlLoader.load();
        astage.setScene(new Scene(root));
        astage.setTitle("M.U.L.E Player Config Screen");
        playerConfigController controller = fxmlLoader.getController();
        controller.setMainApp(this);
        astage.show();
    }

  /*  moved this method to the GameManager Class
  public void startGameController(Stage astage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/view/GameScreen.fxml"));
        Parent root = fxmlLoader.load();
        astage.setScene(new Scene(root));
        astage.setTitle("M.U.L.E Game Screen");
        GameController controller = fxmlLoader.getController();
        controller.setMainApp(this);
        astage.show();
    }
*/


    public static void main(String[] args) {
        launch(args);
    }
}
