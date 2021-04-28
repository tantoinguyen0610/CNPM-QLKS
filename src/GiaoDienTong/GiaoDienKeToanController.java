package GiaoDienTong;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    private Button Button_Thoat_QLKS;
    
    @FXML
    private Label lbKeToan;

    @FXML
    void QLHDButtonListener(ActionEvent event) throws Exception {
    	Parent parent = FXMLLoader.load(
				 getClass().getClassLoader().getResource("HoaDon/QuanLiHoaDonController.fxml"));
				 // Build the scene graph.
				 Scene scene = new Scene(parent);
				Stage stage = new Stage();
				 // Display our window, using the scene graph.
				 stage.setTitle("Quản Lí Hoá Đơn");
				stage.setScene(scene);
				 stage.show();
    }

    @FXML
    void ThongKeButtonListener(ActionEvent event) throws Exception{
    	Parent parent = FXMLLoader.load(
				 getClass().getClassLoader().getResource("ThongKe/GiaoDienThongKe.fxml"));
				 Scene scene = new Scene(parent);
				Stage stage = new Stage();
				 stage.setTitle("Thống Kê");
				stage.setScene(scene);
				 stage.show();
    }
    @FXML
    void Thoat_ActionListener(ActionEvent event) {
    	int response=	JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn thoát giao diện?", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
