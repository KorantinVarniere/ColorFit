module vkorantin.colorfit {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;

    opens vkorantin.colorfit to javafx.fxml;
    exports vkorantin.colorfit;
}
