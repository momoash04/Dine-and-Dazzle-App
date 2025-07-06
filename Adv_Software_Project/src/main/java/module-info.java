module com.example.adv_software_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;


    opens com.example.adv_software_project to javafx.fxml;
    exports com.example.adv_software_project;
}