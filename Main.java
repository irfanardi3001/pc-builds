package com.simulation.pcbuild;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-layout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1050, 576);
        stage.setTitle("PC BUILD SIMULATION");
        stage.setScene(scene);
        stage.show();
    }
}
