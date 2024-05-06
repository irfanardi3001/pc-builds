package com.simulation.controller;

import com.simulation.dao.BrandCpuDaoImpl;
import com.simulation.dao.GraphicsCardDaoImpl;
import com.simulation.dao.ProcessorDaoImpl;
import com.simulation.entity.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class SimulationController extends MenuController {
    @FXML
    protected ChoiceBox <BrandCPU> brandSelect;
    @FXML
    protected ChoiceBox <Processor> cpuSelect;
    @FXML
    protected ChoiceBox <Ram> ramSelect;
    @FXML
    protected ChoiceBox <GraphicsCard> gpuSelect;
    @FXML
    protected ChoiceBox <Psu> psuSelect;
    @FXML
    protected Button btnCheck;
    @FXML
    protected Label cpuResult;
    @FXML
    protected Label ramResult;
    @FXML
    protected Label gpuResult;
    @FXML
    protected Label psuResult;
    @FXML
    protected VBox vboxResult;

    protected ObservableList <BrandCPU> brandCPU;
    protected ObservableList <Processor> processor;
    protected ObservableList <Ram> ram;
    protected ObservableList <GraphicsCard> graphicsCards;
    protected ObservableList <Psu> psu;
    protected ObservableList <Res> res;
    protected BrandCpuDaoImpl brandCpuDao;
    protected ProcessorDaoImpl processorDao;
    protected GraphicsCardDaoImpl graphicsCardDao;

    @Override
    protected void MenuSimulation(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnSimulation.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected abstract void CheckPC(ActionEvent actionEvent);

}
