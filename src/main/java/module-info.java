module org.example.tdrevision2java {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tdrevision2java to javafx.fxml;
    exports org.example.tdrevision2java;
}