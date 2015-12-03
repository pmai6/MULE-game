package mule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mule.model.ChatClient;
import mule.view.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "view/splashScreen.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("U.N.I.C.O.R.N Splash Screen");
        primaryStage.setScene(new Scene(root));
        SplashController controller = fxmlLoader.getController();
        controller.setMainApp(this);
        primaryStage.show();
        ChatClient.initConnection();
    }

    public void startUpConfig(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "view/StartUp.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("U.N.I.C.O.R.N Main Screen");
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
                "view/configScreen.fxml"));
        Parent root = fxmlLoader.load();
        astage.setScene(new Scene(root));
        astage.setTitle("U.N.I.C.O.R.N Player Config Screen");
        PlayerConfigController controller = fxmlLoader.getController();
        controller.setMainApp(this);
        astage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
