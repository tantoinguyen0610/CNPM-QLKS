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

public class GiaoDienQuanLiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button QLPButton;

    @FXML
    private Button QLNVButton;

    @FXML
    private Button QLDVButton;
    
    @FXML
    private Button Button_Thoat;


    @FXML
    void QLDVButtonListener(ActionEvent event) throws Exception {
    	Parent parent = FXMLLoader.load(
				 getClass().getClassLoader().getResource("QuanLiDichVu/QuanLiDichVuController.fxml"));
				 // Build the scene graph.
				 Scene scene = new Scene(parent);
				Stage stage = new Stage();
				 // Display our window, using the scene graph.
				 stage.setTitle("Giao Diện Dịch Vụ");
				stage.setScene(scene);
				 stage.show();
    }

    @FXML
    void QLNVButtonListener(ActionEvent event) throws Exception {
    	Parent parent = FXMLLoader.load(
				 getClass().getClassLoader().getResource("NhanVien/GiaoDien_NhanVien.fxml"));
				 // Build the scene graph.
				 Scene scene = new Scene(parent);
				Stage stage = new Stage();
				 // Display our window, using the scene graph.
				 stage.setTitle("Giao Diện Nhân Viên");
				stage.setScene(scene);
				 stage.show();
    }

    @FXML
    void QLPButtonListener(ActionEvent event) throws Exception {
    	Parent parent = FXMLLoader.load(
				 getClass().getClassLoader().getResource("QuanLyPhong/GiaoDienQuanLyPhong.fxml"));
				 // Build the scene graph.
				 Scene scene = new Scene(parent);
				Stage stage = new Stage();
				 // Display our window, using the scene graph.
				 stage.setTitle("Giao Diện Quản Lý Phòng");
				stage.setScene(scene);
				 stage.show();
    }
    
    @FXML
    void QL_Thoat_ButtonListener(ActionEvent event) {
    	
    }
   
}
