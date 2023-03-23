module vkorantin.colorfit {
    requires javafx.controls;
    requires javafx.fxml;

    opens vkorantin.colorfit to javafx.fxml;
    exports vkorantin.colorfit;
}
