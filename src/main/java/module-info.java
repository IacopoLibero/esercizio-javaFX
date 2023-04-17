module com.mycompany.progettografica {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.progettografica to javafx.fxml;
    exports com.mycompany.progettografica;
}
