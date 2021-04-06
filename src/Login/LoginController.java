package Login;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Label QLKSLabel;

    @FXML
    private Label UserLabel;

    @FXML
    private Label PasswordLabel;

    @FXML
    private TextField UserTextField;

    @FXML
    private TextField PasswordTextField;

    @FXML
    private Button LoginButton;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
    
    public void HienThiQuanLi() throws Exception {
    	Parent parent = FXMLLoader.load(
				getClass().getResource("GiaoDienTong/GiaoDienQuanLiController.fxml"));
				Scene scene = new Scene(parent);
				Stage stage = new Stage();
				stage.setTitle("Giao Dien Quan Li");
				stage.setScene(scene);
				stage.show();
    }

    @FXML
    void LoginButtonListener(ActionEvent event) throws Exception {
    	try {
			 final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			 Connection conn = DriverManager.getConnection(DB_URL,"root","");
			 String query = "select * from taikhoan where username=? and psw=?";
			 PreparedStatement pst = conn.prepareStatement(query);
			 pst.setString(1,UserTextField.getText());
			 pst.setString(2, PasswordTextField.getText());
			 pst.executeQuery();
			 JOptionPane.showMessageDialog(null, "Dang zo"); 
			 HienThiQuanLi();
			 
   }
    	catch(SQLException e)
    	{
    		JOptionPane.showMessageDialog(null, e);
    	}
    	
    }

    @FXML
    void PasswordTextFieldListener(ActionEvent event) {

    }

    @FXML
    void UserTextFieldListener(ActionEvent event) {
    		

   }
    
    
    
}

