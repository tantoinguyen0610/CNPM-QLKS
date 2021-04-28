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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;

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
    private Button Thoat_Button;
    
    @FXML
    private Label labelLeTan;

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
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(((Node) event.getSource()).getScene().getWindow());
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
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(((Node) event.getSource()).getScene().getWindow());
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
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(((Node) event.getSource()).getScene().getWindow());
				 stage.show();
    }

    @FXML
    void TraCuuPhong_ButtonListener(ActionEvent event) throws Exception {
    	Parent parent = FXMLLoader.load(
				 getClass().getClassLoader().getResource("TraCuuPhong/giaodienTraCuuPhong.fxml"));
				 // Build the scene graph.
				 Scene scene = new Scene(parent);
				Stage stage = new Stage();
				 // Display our window, using the scene graph.
				scene.getStylesheets().add(getClass().getResource("quanlyphong.css").toExternalForm());
				 stage.setTitle("Tra cứu phòng");
				stage.setScene(scene);
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(((Node) event.getSource()).getScene().getWindow());
				 stage.show();
    }
    
    @FXML
    void GDNV_Thoat_ActionListener(ActionEvent event) {
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
