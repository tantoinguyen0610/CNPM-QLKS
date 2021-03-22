package GiaoDienTong;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import HoaDon.QuanLiHoaDonController;
public class GiaoDienKeToanController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ThongKeButton;

    @FXML
    private Button QLHDButton;

    @FXML
    void QLHDButtonListener(ActionEvent event) throws Exception {
    	Parent parent = FXMLLoader.load(
				 getClass().getClassLoader().getResource("HoaDon/QuanLiHoaDonController.fxml"));
				 // Build the scene graph.
				 Scene scene = new Scene(parent);
				Stage stage = new Stage();
				 // Display our window, using the scene graph.
				 stage.setTitle("DatCoc");
				stage.setScene(scene);
				 stage.show();
    }

    @FXML
    void ThongKeButtonListener(ActionEvent event) {

    }

    
}
