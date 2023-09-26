module mrzleviatan.marketplace {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.mapstruct;

    opens co.edu.uniquindio.subastasUq to javafx.fxml;
    exports co.edu.uniquindio.subastasUq;
    exports co.edu.uniquindio.subastasUq.viewController;
    opens co.edu.uniquindio.subastasUq.viewController to javafx.fxml;
    exports co.edu.uniquindio.subastasUq.controller;
    exports co.edu.uniquindio.subastasUq.mapping.dto;
    exports co.edu.uniquindio.subastasUq.mapping.mappers;
    exports co.edu.uniquindio.subastasUq.model;
    opens co.edu.uniquindio.subastasUq.controller to javafx.fxml;

}