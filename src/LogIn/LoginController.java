package LogIn;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane BP1;

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private ImageView pic1;

    @FXML
    private Text QLKS_Label;

    @FXML
    private AnchorPane AnchorPane2;

    @FXML
    private ImageView pic2;

    @FXML
    private Label username_Label;

    @FXML
    private Label psw_Label;

    @FXML
    private TextField username_textField;

    @FXML
    private PasswordField password_textField;

    @FXML
    private Button Button_LogIn;

    @FXML
    private Label wronglogin;

    @FXML
    void Login_ActionListener(ActionEvent event) throws IOException {
    	checkLogIn();
    }
    
    
    
    
    private void checkLogIn() throws IOException {
		// TODO Auto-generated method stub
		if (username_textField.getText().toString().equals("quanly") && password_textField.getText().toString().equals("QLKS")) {
			Parent root = FXMLLoader.load(getClass().getResource("GiaoDienQuanLiController.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		}
		else if (username_textField.getText().toString().equals("ketoan") && password_textField.getText().toString().equals("KTKS")) {
			Parent root = FXMLLoader.load(getClass().getResource("GiaoDienKeToanController.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		}
		else if (username_textField.getText().toString().equals("nhanvien") && password_textField.getText().toString().equals("NVKS")) {
			Parent root = FXMLLoader.load(getClass().getResource("GiaoDienNhanVien.java.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		}
	}




	public void connectDB() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:8080/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
    	}
    	catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
    }

   
}
