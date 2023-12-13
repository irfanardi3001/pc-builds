package com.simulation.controller;

import com.simulation.dao.BrandCpuDaoImpl;
import com.simulation.dao.BrandGpuDaoImpl;
import com.simulation.dao.GraphicsCardDaoImpl;
import com.simulation.dao.ProcessorDaoImpl;
import com.simulation.entity.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

abstract public class CompareController extends MenuController {
    @FXML
    protected Button btnCompare;
    protected ObservableList <BrandCPU> brandCPU;
    protected ObservableList <BrandGPU> brandGPU;
    protected ObservableList <Processor> processor;
    protected ObservableList <GraphicsCard> graphicsCards;
    protected BrandCpuDaoImpl brandCpuDao;
    protected BrandGpuDaoImpl brandGpuDao;
    protected ProcessorDaoImpl processorDao;
    protected GraphicsCardDaoImpl graphicsCardDao;
    @FXML
    protected HBox boxResult;

    @FXML
    @Override
    protected void MenuSimulation(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnSimulation.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected abstract void compareNow(ActionEvent actionEvent);

}
