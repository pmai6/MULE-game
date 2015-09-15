import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartUp.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("M.U.L.E Main Screen");
        primaryStage.setScene(new Scene(root));
        StartUpController controller = fxmlLoader.getController();
        controller.setMainApp(this);
        primaryStage.show();
    }
    public void startPlayerConfig(Stage astage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("configScreen.fxml"));
        Parent root = fxmlLoader.load();
        astage.setScene(new Scene(root));
        astage.setTitle("M.U.L.E Player Config Screen");
        playerConfigController controller = fxmlLoader.getController();
        controller.setMainApp(this);
        astage.show();
    }

    public void startGameController(Stage astage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));
        Parent root = fxmlLoader.load();
        astage.setScene(new Scene(root));
        astage.setTitle("M.U.L.E Game Screen");
        GameController controller = fxmlLoader.getController();
        controller.setMainApp(this);
        astage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
