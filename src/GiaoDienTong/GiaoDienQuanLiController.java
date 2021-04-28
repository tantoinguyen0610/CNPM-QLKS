package GiaoDienTong;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
				scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

				 // Display our window, using the scene graph.
				 stage.setTitle("Giao Diện Quản Lý Phòng");
				stage.setScene(scene);
				 stage.show();
    }
    
    @FXML
    void QL_Thoat_ButtonListener(ActionEvent event) {
    	int response=	JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn Xóa Khách Hàng này?", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     	if(response == JOptionPane.YES_OPTION) {
    		try {
    			
   			 Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
   		      	FXMLLoader loader = new FXMLLoader();
   		      	loader.setLocation(getClass().getClassLoader().getResource("Login/LoginController.fxml"));
   		      	Parent sampleParent = loader.load();
   		      	Scene scene = new Scene(sampleParent);
   		     scene.getStylesheets().add(getClass().getClassLoader().getResource("Login/Login.css").toExternalForm());
   		      	stage.setScene(scene);
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
    		
	}
else if(response == JOptionPane.NO_OPTION){
     		
     	}
    }
   
}
