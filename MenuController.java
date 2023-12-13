package com.simulation.controller;

import com.simulation.pcbuild.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

abstract public class MenuController {
    @FXML
    protected Button btnSimulation;
    @FXML
    protected Button btnCompareCPU;
    @FXML
    protected Button btnCompareGPU;
    @FXML
    protected AnchorPane rootAnchor;

    @FXML
    protected abstract void MenuSimulation(ActionEvent actionEvent) throws IOException;

    @FXML
    protected void MenuCompareCPU(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("cpu-compare-layout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1050, 576);
        Stage compareCPU = new Stage();
        compareCPU.setTitle("PC BUILD SIMULATION");
        compareCPU.setScene(scene);
        compareCPU.initOwner(rootAnchor.getScene().getWindow());
        compareCPU.initModality(Modality.APPLICATION_MODAL);
        compareCPU.show();
    }

    @FXML
    protected void MenuCompareGPU(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("gpu-compare-layout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1050, 576);
        Stage compareGPU = new Stage();
        compareGPU.setTitle("PC BUILD SIMULATION");
        compareGPU.setScene(scene);
        compareGPU.initOwner(rootAnchor.getScene().getWindow());
        compareGPU.initModality(Modality.APPLICATION_MODAL);
        compareGPU.show();
    }
}
