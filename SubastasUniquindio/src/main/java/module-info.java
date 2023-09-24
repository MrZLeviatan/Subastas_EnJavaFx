module co.edu.uniquindio.marketplace {

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires org.mapstruct;

    opens co.edu.uniquindio.SubastasUniquindio to javafx.fxml;
    exports co.edu.uniquindio.SubastasUniquindio;
    opens co.edu.uniquindio.SubastasUniquindio.controller to javafx.fxml;
    exports co.edu.uniquindio.SubastasUniquindio.controller;
    opens co.edu.uniquindio.SubastasUniquindio.viewController to javafx.fxml;
    exports co.edu.uniquindio.SubastasUniquindio.viewController;

    //paquetes
    exports co.edu.uniquindio.SubastasUniquindio.model;
    exports co.edu.uniquindio.SubastasUniquindio.exceptions;
    exports co.edu.uniquindio.SubastasUniquindio.util;
    exports co.edu.uniquindio.SubastasUniquindio.mapping.dto;
    exports co.edu.uniquindio.SubastasUniquindio.mapping.mappers;

}