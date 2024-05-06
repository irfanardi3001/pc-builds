package com.simulation.controller;

import com.simulation.dao.*;
import com.simulation.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GamingController extends SimulationController implements Initializable {
    @FXML
    private ChoiceBox <CategoryGame> gameSelect;
    @FXML
    private ChoiceBox <Game> titleSelect;
    @FXML
    private ChoiceBox <Res> resSelect;
    @FXML
    private Label titleResult;
    @FXML
    private Label resResult;
    private GameDaoImpl gameDao;
    private ObservableList <CategoryGame> categoryGame;
    private ObservableList <Game> games;
    private CategoryGameDaoImpl categoryGameDao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vboxResult.setVisible(false);
        brandCpuDao = new BrandCpuDaoImpl();
        processorDao = new ProcessorDaoImpl();
        graphicsCardDao = new GraphicsCardDaoImpl();
        categoryGameDao = new CategoryGameDaoImpl();
        gameDao = new GameDaoImpl();

        brandCPU = FXCollections.observableArrayList();
        processor = FXCollections.observableArrayList();
        ram = FXCollections.observableArrayList();
        graphicsCards = FXCollections.observableArrayList();
        psu = FXCollections.observableArrayList();
        res = FXCollections.observableArrayList();
        categoryGame = FXCollections.observableArrayList();
        games = FXCollections.observableArrayList();

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
            categoryGame.addAll(categoryGameDao.fetchAll());
            games.addAll(gameDao.fetchAll());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        brandSelect.setItems(brandCPU);
        cpuSelect.setItems(processor);
        gpuSelect.setItems(graphicsCards);
        gameSelect.setItems(categoryGame);
        titleSelect.setItems(games);
        ramSelect.setItems(ram);
        psuSelect.setItems(psu);
        resSelect.setItems(res);

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
            CategoryGame categoryGame = gameSelect.getSelectionModel().getSelectedItem();
            Game game = titleSelect.getSelectionModel().getSelectedItem();
            Res resolution = resSelect.getSelectionModel().getSelectedItem();

            String selectedCategory = categoryGame.getName();
            String selectedRam = ram.getCappacity();
            String selectedPSU = psu.getCappacity();

            if(processor != null){
                if(selectedCategory.equals("Esport")) {
                    cpuResult.setText(processor.getName() + "(CPU Bound Game)");
                } else {
                    cpuResult.setText(processor.getName());
                }
            } else {
                cpuResult.setText("");
            }

            if(graphicsCard != null){
                if(selectedCategory.equals("Esport")) {
                    gpuResult.setText(graphicsCard.getName());
                } else {
                    gpuResult.setText(graphicsCard.getName() + "(GPU Bound Game)");
                }
            } else {
                gpuResult.setText("");
            }

            if (selectedRam.equals("8GB")) {
                ramResult.setText(ram.getCappacity() + "(More Capacity!)");
            } else {
                ramResult.setText(ram.getCappacity());
            }

            if (selectedPSU.equals("450Watt")) {
                psuResult.setText(psu.getCappacity() + "(More Capacity!)");
            } else {
                psuResult.setText(psu.getCappacity());
            }

            if (game != null){
                titleResult.setText(game.getName());
            }

            resResult.setText(resolution.getResolution());
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
