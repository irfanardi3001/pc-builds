package com.simulation.controller;

import com.simulation.dao.BrandCpuDaoImpl;
import com.simulation.dao.ProcessorDaoImpl;
import com.simulation.entity.BrandCPU;
import com.simulation.entity.Processor;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CPUCompareController extends CompareController implements Initializable {

    @FXML
    protected ChoiceBox <BrandCPU> brand1Select;
    @FXML
    protected ChoiceBox <BrandCPU> brand2Select;
    @FXML
    protected ChoiceBox <Processor> series1Select;
    @FXML
    protected ChoiceBox <Processor> series2Select;
    @FXML
    private ImageView  cpu1LogoResult;
    @FXML
    private Label cpu1SeriesResult;
    @FXML
    private Label coreThread1Result;
    @FXML
    private Label clock1Result;
    @FXML
    private Label memory1Result;
    @FXML
    private Label l3Cache1Result;
    @FXML
    private Label power1Result;
    @FXML
    private Label benchmark1Result;
    @FXML
    private ImageView cpu2LogoResult;
    @FXML
    private Label cpu2SeriesResult;
    @FXML
    private Label coreThread2Result;
    @FXML
    private Label clock2Result;
    @FXML
    private Label memory2Result;
    @FXML
    private Label l3Cache2Result;
    @FXML
    private Label power2Result;
    @FXML
    private Label benchmark2Result;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boxResult.setVisible(false);

        brandCpuDao = new BrandCpuDaoImpl();
        processorDao = new ProcessorDaoImpl();

        brandCPU = FXCollections.observableArrayList();
        processor = FXCollections.observableArrayList();

        try {
            brandCPU.addAll(brandCpuDao.fetchAll());
            processor.addAll(processorDao.fetchAll());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        brand1Select.setItems(brandCPU);
        brand2Select.setItems(brandCPU);
        series1Select.setItems(processor);
        series2Select.setItems(processor);
    }

    @FXML
    @Override
    protected void compareNow(ActionEvent actionEvent) {
            boxResult.setVisible(true);
            try {
                Processor selectedProcessor1 = series1Select.getSelectionModel().getSelectedItem();
                Processor selectedProcessor2 = series2Select.getSelectionModel().getSelectedItem();
                if (selectedProcessor1 != null) {
                    cpu1SeriesResult.setText(selectedProcessor1.getName());
                    coreThread1Result.setText(selectedProcessor1.getCore());
                    clock1Result.setText(selectedProcessor1.getClockSpeed());
                    memory1Result.setText(selectedProcessor1.getMemory());
                    l3Cache1Result.setText(selectedProcessor1.getL3Cache());
                    power1Result.setText(selectedProcessor1.getPower());
                    benchmark1Result.setText(selectedProcessor1.getBenchmark());
                } else {
                    cpu1SeriesResult.setText("");
                    coreThread1Result.setText("");
                    clock1Result.setText("");
                    memory1Result.setText("");
                    l3Cache1Result.setText("");
                    power1Result.setText("");
                    benchmark1Result.setText("");
                }

                if (selectedProcessor2 != null) {
                    cpu2SeriesResult.setText(selectedProcessor2.getName());
                    coreThread2Result.setText(selectedProcessor2.getCore());
                    clock2Result.setText(selectedProcessor2.getClockSpeed());
                    memory2Result.setText(selectedProcessor2.getMemory());
                    l3Cache2Result.setText(selectedProcessor2.getL3Cache());
                    power2Result.setText(selectedProcessor2.getPower());
                    benchmark2Result.setText(selectedProcessor2.getBenchmark());
                } else {
                    cpu2SeriesResult.setText("");
                    coreThread2Result.setText("");
                    clock2Result.setText("");
                    memory2Result.setText("");
                    l3Cache2Result.setText("");
                    power2Result.setText("");
                    benchmark2Result.setText("");
                }
            } catch (NullPointerException e) {
                boxResult.setVisible(false);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setHeaderText(null);
                alert.setContentText("Please fill the questioner");

                alert.showAndWait();
            }

    }
}
