package GiaoDienTong;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GiaoDienNhanVienController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Check_inButton;

    @FXML
    private Button Check_outButton;

    @FXML
    private Button TraCuuPhongButton;

    @FXML
    private Button QuanLiKhachHangButton;

    @FXML
    void Check_inButtonListener(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(
				 getClass().getClassLoader().getResource("Check_in/GiaoDien_Check_In.fxml"));
				 // Build the scene graph.
				 Scene scene = new Scene(parent);
				Stage stage = new Stage();
				 // Display our window, using the scene graph.
				 stage.setTitle("Giao Diện Check-in");
				stage.setScene(scene);
				 stage.show();
    }

    @FXML
    void Check_outButtonListener(ActionEvent event) throws Exception {
    	Parent parent = FXMLLoader.load(
				 getClass().getClassLoader().getResource("Check_out/GiaoDien_Check_Out.fxml"));
				 // Build the scene graph.
				 Scene scene = new Scene(parent);
				Stage stage = new Stage();
				 // Display our window, using the scene graph.
				 stage.setTitle("Giao Diện Check-out");
				stage.setScene(scene);
				 stage.show();
    }

    @FXML
    void QuanLiKhachHangButtonListener(ActionEvent event) throws Exception {
    	Parent parent = FXMLLoader.load(
				 getClass().getClassLoader().getResource("QuanLiKhachHang/QuanLiKhachHangController.fxml"));
				 // Build the scene graph.
				 Scene scene = new Scene(parent);
				Stage stage = new Stage();
				 // Display our window, using the scene graph.
				 stage.setTitle("Quản Lí Khách Hàng");
				stage.setScene(scene);
				 stage.show();
    }

    @FXML
    void TraCuuPhong_ButtonListener(ActionEvent event) throws Exception {
    	Parent parent = FXMLLoader.load(
				 getClass().getClassLoader().getResource("QuanLyPhong/GiaoDienQuanLyPhong.fxml"));
				 // Build the scene graph.
				 Scene scene = new Scene(parent);
				Stage stage = new Stage();
				 // Display our window, using the scene graph.
				 stage.setTitle("Tra cứu phòng");
				stage.setScene(scene);
				 stage.show();
    }
}
