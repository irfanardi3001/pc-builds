package com.simulation.controller;

import com.simulation.pcbuild.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;


public class MainController extends MenuController {
    @FXML
    private Button btnGaming;
    @FXML
    private Button btnCasual;
    @FXML
    private Button btnProductivity;

    @FXML
    @Override
    protected void MenuSimulation(ActionEvent actionEvent) throws IOException{
    }

    @FXML
    private void MenuGamingPC(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("gaming-layout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1050, 576);
        Stage gamingPC = new Stage();
        gamingPC.setTitle("PC BUILD SIMULATION");
        gamingPC.setScene(scene);
        gamingPC.initOwner(rootAnchor.getScene().getWindow());
        gamingPC.initModality(Modality.APPLICATION_MODAL);
        gamingPC.show();
    }

    @FXML
    private void MenuCasualPC(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("casual-layout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1050, 576);
        Stage casualPC = new Stage();
        casualPC.setTitle("PC BUILD SIMULATION");
        casualPC.setScene(scene);
        casualPC.initOwner(rootAnchor.getScene().getWindow());
        casualPC.initModality(Modality.APPLICATION_MODAL);
        casualPC.show();
    }

    @FXML
    private void MenuProductivityPC(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("productivity-layout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1050, 576);
        Stage productivityPC = new Stage();
        productivityPC.setTitle("PC BUILD SIMULATION");
        productivityPC.setScene(scene);
        productivityPC.initOwner(rootAnchor.getScene().getWindow());
        productivityPC.initModality(Modality.APPLICATION_MODAL);
        productivityPC.show();
    }
}
