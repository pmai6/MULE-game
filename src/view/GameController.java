import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;



public class GameController {

    //creating Main object so can talk to Main methods
    private Main mainapp;
    @FXML
    private Button goToTown;
    @FXML
    private AnchorPane town;
    @FXML
    private HBox map;
    @FXML
    private Button store;
    @FXML
    private Button landOffice;
    @FXML
    private Button assayOffice;
    @FXML
    private Button pub;
    @FXML
    private Button exit;

    @FXML
    private HBox playerthree;
    @FXML
    private HBox playerfour;
    @FXML
    private Button mapButton00;
    @FXML
    private Button mapButton01;
    @FXML
    private Button mapButton02;
    @FXML
    private Button mapButton03;
    @FXML
    private Button mapButton04;
    @FXML
    private Button mapButton05;
    @FXML
    private Button mapButton06;
    @FXML
    private Button mapButton07;
    @FXML
    private Button mapButton08;
    @FXML
    private Button mapButton10;
    @FXML
    private Button mapButton11;
    @FXML
    private Button mapButton12;
    @FXML
    private Button mapButton13;
    @FXML
    private Button mapButton14;
    @FXML
    private Button mapButton15;
    @FXML
    private Button mapButton16;
    @FXML
    private Button mapButton17;
    @FXML
    private Button mapButton18;
    @FXML
    private Button mapButton20;
    @FXML
    private Button mapButton21;
    @FXML
    private Button mapButton22;
    @FXML
    private Button mapButton23;
    @FXML
    private Button mapButton25;
    @FXML
    private Button mapButton26;
    @FXML
    private Button mapButton27;
    @FXML
    private Button mapButton28;
    @FXML
    private Button mapButton30;
    @FXML
    private Button mapButton31;
    @FXML
    private Button mapButton32;
    @FXML
    private Button mapButton33;
    @FXML
    private Button mapButton34;
    @FXML
    private Button mapButton35;
    @FXML
    private Button mapButton36;
    @FXML
    private Button mapButton37;
    @FXML
    private Button mapButton38;
    @FXML
    private Button mapButton40;
    @FXML
    private Button mapButton41;
    @FXML
    private Button mapButton42;
    @FXML
    private Button mapButton43;
    @FXML
    private Button mapButton44;
    @FXML
    private Button mapButton45;
    @FXML
    private Button mapButton46;
    @FXML
    private Button mapButton47;
    @FXML
    private Button mapButton48;


    private Button [][] mapButtonArray = new Button [][] {
            {mapButton00, mapButton01, mapButton02, mapButton03, mapButton04,
                    mapButton05, mapButton06, mapButton07, mapButton08},
            {mapButton00, mapButton11, mapButton12, mapButton13, mapButton14,
                    mapButton15, mapButton16, mapButton17, mapButton18},
            {mapButton00, mapButton21, mapButton22, mapButton23, goToTown,
                    mapButton25, mapButton26, mapButton27, mapButton28},
            {mapButton00, mapButton31, mapButton32, mapButton33, mapButton34,
                    mapButton35, mapButton36, mapButton37, mapButton38},
            {mapButton00, mapButton41, mapButton42, mapButton43, mapButton44,
                    mapButton45, mapButton46, mapButton47, mapButton48},
    };


    public  GameController() {
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainapp takes Main object
     */
    public void setMainApp(Main mainapp) {
        this.mainapp = mainapp;
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    @FXML
    private void handleStoreAction() {
        System.out.println("Store Opens");
    }
    @FXML
    private void handleLandOfficeAction() {
        System.out.println("Land Office Opens");
    }
    @FXML
    private void handleAssayOfficeAction() {
        System.out.println("Assay Office Opens");
    }
    @FXML private void handlePubAction() {
        System.out.println("Time to get Drunk");
    }


    @FXML
    private void exitButtonAction() throws Exception {
        town.setVisible(false);
        map.setVisible(true);
    }
    @FXML
    private void goToTownButton() throws Exception {
        map.setVisible(false);
      town.setVisible(true);
    }

    @FXML
    private void handleMapButton00() throws Exception {
        MapManager.handleMapButton(mapButton00);
    }
    @FXML
    private void handleMapButton01() throws Exception {
        MapManager.handleMapButton(mapButton01);
    }
    @FXML
    private void handleMapButton02() throws Exception {
        MapManager.handleMapButton(mapButton02);
    }
    @FXML
    private void handleMapButton03() throws Exception {
        MapManager.handleMapButton(mapButton03);
    }
    @FXML
    private void handleMapButton04() throws Exception {
        MapManager.handleMapButton(mapButton04);
    }
    @FXML
    private void handleMapButton05() throws Exception {
        MapManager.handleMapButton(mapButton05);
    }
    @FXML
    private void handleMapButton06() throws Exception {
        MapManager.handleMapButton(mapButton06);
    }
    @FXML
    private void handleMapButton07() throws Exception {
        MapManager.handleMapButton(mapButton07);
    }
    @FXML
    private void handleMapButton08() throws Exception {
        MapManager.handleMapButton(mapButton08);
    }
    @FXML
    private void handleMapButton10() throws Exception {
        MapManager.handleMapButton(mapButton10);
    }
    @FXML
    private void handleMapButton11() throws Exception {
        MapManager.handleMapButton(mapButton11);
    }
    @FXML
    private void handleMapButton12() throws Exception {
        MapManager.handleMapButton(mapButton12);
    }
    @FXML
    private void handleMapButton13() throws Exception {
        MapManager.handleMapButton(mapButton13);
    }
    @FXML
    private void handleMapButton14() throws Exception {
        MapManager.handleMapButton(mapButton14);
    }
    @FXML
    private void handleMapButton15() throws Exception {
        MapManager.handleMapButton(mapButton15);
    }
    @FXML
    private void handleMapButton16() throws Exception {
        MapManager.handleMapButton(mapButton16);
    }
    @FXML
    private void handleMapButton17() throws Exception {
        MapManager.handleMapButton(mapButton17);
    }
    @FXML
    private void handleMapButton18() throws Exception {
        MapManager.handleMapButton(mapButton18);
    }
    @FXML
    private void handleMapButton20() throws Exception {
        MapManager.handleMapButton(mapButton20);
    }
    @FXML
    private void handleMapButton21() throws Exception {
        MapManager.handleMapButton(mapButton21);
    }
    @FXML
    private void handleMapButton22() throws Exception {
        MapManager.handleMapButton(mapButton22);
    }
    @FXML
    private void handleMapButton23() throws Exception {
        MapManager.handleMapButton(mapButton23);
    }
    @FXML
    private void handleMapButton25() throws Exception {
        MapManager.handleMapButton(mapButton25);
    }
    @FXML
    private void handleMapButton26() throws Exception {
        MapManager.handleMapButton(mapButton26);
    }
    @FXML
    private void handleMapButton27() throws Exception {
        MapManager.handleMapButton(mapButton27);
    }
    @FXML
    private void handleMapButton28() throws Exception {
        MapManager.handleMapButton(mapButton28);
    }
    @FXML
    private void handleMapButton30() throws Exception {
        MapManager.handleMapButton(mapButton30);
    }
    @FXML
    private void handleMapButton31() throws Exception {
        MapManager.handleMapButton(mapButton31);
    }
    @FXML
    private void handleMapButton32() throws Exception {
        MapManager.handleMapButton(mapButton32);
    }
    @FXML
    private void handleMapButton33() throws Exception {
        MapManager.handleMapButton(mapButton33);
    }
    @FXML
    private void handleMapButton34() throws Exception {
        MapManager.handleMapButton(mapButton34);
    }
    @FXML
    private void handleMapButton35() throws Exception {
        MapManager.handleMapButton(mapButton35);
    }
    @FXML
    private void handleMapButton36() throws Exception {
        MapManager.handleMapButton(mapButton36);
    }
    @FXML
    private void handleMapButton37() throws Exception {
        MapManager.handleMapButton(mapButton37);
    }
    @FXML
    private void handleMapButton38() throws Exception {
        MapManager.handleMapButton(mapButton38);
    }
    @FXML
    private void handleMapButton40() throws Exception {
        MapManager.handleMapButton(mapButton40);
    }
    @FXML
    private void handleMapButton41() throws Exception {
        MapManager.handleMapButton(mapButton41);
    }
    @FXML
    private void handleMapButton42() throws Exception {
        MapManager.handleMapButton(mapButton42);
    }
    @FXML
    private void handleMapButton43() throws Exception {
        MapManager.handleMapButton(mapButton43);
    }
    @FXML
    private void handleMapButton44() throws Exception {
        MapManager.handleMapButton(mapButton44);
    }
    @FXML
    private void handleMapButton45() throws Exception {
        MapManager.handleMapButton(mapButton45);
    }
    @FXML
    private void handleMapButton46() throws Exception {
        MapManager.handleMapButton(mapButton46);
    }
    @FXML
    private void handleMapButton47() throws Exception {
        MapManager.handleMapButton(mapButton47);
    }
    @FXML
    private void handleMapButton48() throws Exception {
        MapManager.handleMapButton(mapButton48);
    }

    public Button[][] getMapButtonArray() {
        return mapButtonArray;
    }

    public void setMapButtonArray(Button[][] mapButtonArray) {
        this.mapButtonArray = mapButtonArray;
    }

    public void disablePlayerThree() {
        playerthree.setVisible(false);
    }

    public void disablePlayerFour() {
        playerfour.setVisible(false);
    }
}

