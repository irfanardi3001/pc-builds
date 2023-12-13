module com.simulation.pcbuild {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.j;

    opens com.simulation.pcbuild to javafx.fxml;

    exports com.simulation.pcbuild;
    exports com.simulation.controller;
    opens com.simulation.controller to javafx.fxml;

}