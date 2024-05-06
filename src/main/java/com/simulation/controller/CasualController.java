package com.simulation.controller;

import com.simulation.dao.*;
import com.simulation.entity.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CasualController extends SimulationController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vboxResult.setVisible(false);
        brandCpuDao = new BrandCpuDaoImpl();
        processorDao = new ProcessorDaoImpl();
        graphicsCardDao = new GraphicsCardDaoImpl();

        brandCPU = FXCollections.observableArrayList();
        processor = FXCollections.observableArrayList();
        ram = FXCollections.observableArrayList();
        graphicsCards = FXCollections.observableArrayList();
        psu = FXCollections.observableArrayList();
        res = FXCollections.observableArrayList();

        ram.add(new Ram("8GB"));
        ram.add(new Ram("16GB"));
        ram.add(new Ram("32GB"));

        psu.add(new Psu("450Watt"));
        psu.add(new Psu("550Watt"));
        psu.add(new Psu("650Watt"));
        psu.add(new Psu("800Watt"));
        psu.add(new Psu("1000Watt"));

        res.add(new Res("1080p"));
        res.add(new Res("1440p"));


        try {
            brandCPU.addAll(brandCpuDao.fetchAll());
            processor.addAll(processorDao.fetchAll());
            graphicsCards.addAll(graphicsCardDao.fetchAll());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        brandSelect.setItems(brandCPU);
        cpuSelect.setItems(processor);
        gpuSelect.setItems(graphicsCards);
        ramSelect.setItems(ram);
        psuSelect.setItems(psu);
    }

    @FXML
    @Override
    public void CheckPC(ActionEvent actionEvent) {
        vboxResult.setVisible(true);
        try {
            Processor processor = cpuSelect.getSelectionModel().getSelectedItem();
            GraphicsCard graphicsCard = gpuSelect.getSelectionModel().getSelectedItem();
            Ram ram = ramSelect.getSelectionModel().getSelectedItem();
            Psu psu = psuSelect.getSelectionModel().getSelectedItem();

            String selectedRam = ram.getCappacity();
            String selectedPSU = psu.getCappacity();

            if(processor != null){
                cpuResult.setText(processor.getName() + "(Good)");
            } else {
                cpuResult.setText("");
            }

            if(graphicsCard != null){
                gpuResult.setText(graphicsCard.getName() + "(Excellent)");
            } else {
                gpuResult.setText("");
                }

            if (selectedRam.equals("8GB")) {
                ramResult.setText(ram.getCappacity() + "(Good)");
            } else {
                ramResult.setText(ram.getCappacity());
            }

            if (selectedPSU.equals("450Watt")) {
                psuResult.setText(psu.getCappacity() + "(Good)");
            } else {
                psuResult.setText(psu.getCappacity());
            }

        } catch (NullPointerException e) {
            vboxResult.setVisible(false);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("Please fill the questioner");

            alert.showAndWait();
        }


    }
}
