package com.simulation.controller;

import com.simulation.dao.BrandGpuDaoImpl;
import com.simulation.dao.GraphicsCardDaoImpl;
import com.simulation.entity.BrandGPU;
import com.simulation.entity.GraphicsCard;
import com.simulation.entity.Processor;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GPUCompareController extends CompareController implements Initializable {

    @FXML
    protected ChoiceBox <BrandGPU> brand1Select;
    @FXML
    protected ChoiceBox <BrandGPU> brand2Select;
    @FXML
    protected ChoiceBox <GraphicsCard> series1Select;
    @FXML
    protected ChoiceBox <GraphicsCard> series2Select;
    @FXML
    private ImageView gpu1LogoResult;
    @FXML
    private Label gpu1SeriesResult;
    @FXML
    private Label core1Result;
    @FXML
    private Label memory1Result;
    @FXML
    private Label bus1Result;
    @FXML
    private Label clock1Result;
    @FXML
    private Label power1Result;
    @FXML
    private Label benchmark1Result;
    @FXML
    private ImageView gpu2LogoResult;
    @FXML
    private Label gpu2SeriesResult;
    @FXML
    private Label core2Result;
    @FXML
    private Label memory2Result;
    @FXML
    private Label bus2Result;
    @FXML
    private Label clock2Result;
    @FXML
    private Label power2Result;
    @FXML
    private Label benchmark2Result;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boxResult.setVisible(false);
        brandGpuDao = new BrandGpuDaoImpl();
        graphicsCardDao = new GraphicsCardDaoImpl();

        brandGPU = FXCollections.observableArrayList();
        graphicsCards = FXCollections.observableArrayList();

        try {
            brandGPU.addAll(brandGpuDao.fetchAll());
            graphicsCards.addAll(graphicsCardDao.fetchAll());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        brand1Select.setItems(brandGPU);
        brand2Select.setItems(brandGPU);
        series1Select.setItems(graphicsCards);
        series2Select.setItems(graphicsCards);
    }

    @FXML
    @Override
    protected void compareNow(ActionEvent actionEvent) {
        boxResult.setVisible(true);
        GraphicsCard selectedgraphicsCard1 = series1Select.getSelectionModel().getSelectedItem();
        GraphicsCard selectedgraphicsCard2 = series2Select.getSelectionModel().getSelectedItem();
        if (selectedgraphicsCard1 != null) {
            gpu1SeriesResult.setText(selectedgraphicsCard1.getName());
            core1Result.setText(selectedgraphicsCard1.getCore());
            clock1Result.setText(selectedgraphicsCard1.getClock());
            memory1Result.setText(selectedgraphicsCard1.getMemory());
            bus1Result.setText(selectedgraphicsCard1.getBus());
            power1Result.setText(selectedgraphicsCard1.getPower());
            benchmark1Result.setText(selectedgraphicsCard1.getBenchmark());
        } else {
            gpu1SeriesResult.setText("");
            core1Result.setText("");
            clock1Result.setText("");
            memory1Result.setText("");
            bus1Result.setText("");
            power1Result.setText("");
            benchmark1Result.setText("");
        }
        if (selectedgraphicsCard2 != null) {
            gpu2SeriesResult.setText(selectedgraphicsCard2.getName());
            core2Result.setText(selectedgraphicsCard2.getCore());
            clock2Result.setText(selectedgraphicsCard2.getClock());
            memory2Result.setText(selectedgraphicsCard2.getMemory());
            bus2Result.setText(selectedgraphicsCard2.getBus());
            power2Result.setText(selectedgraphicsCard2.getPower());
            benchmark2Result.setText(selectedgraphicsCard2.getBenchmark());
        } else {
            gpu2SeriesResult.setText("");
            core2Result.setText("");
            clock2Result.setText("");
            memory2Result.setText("");
            bus2Result.setText("");
            power2Result.setText("");
            benchmark2Result.setText("");
        }

    }
}
