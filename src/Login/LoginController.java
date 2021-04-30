package Login;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.callback.PasswordCallback;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.PasswordField;
public class LoginController implements Initializable {

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
	    private PasswordField PasswordTextField;

	    @FXML
	    private Button LoginButton;
	    
	    @FXML
	    private Label thongbao;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	TextFormat();
    	TextFormatPsw();
	}
    
 public void TextFormat() {
    	
        
        TextFormatter<?> formatter = new TextFormatter<>((TextFormatter.Change change) -> {
            String text = change.getText();

            if (!text.isEmpty()) {
                String newText = text.replace(" ", "").toLowerCase();

                int carretPos = change.getCaretPosition() - text.length() + newText.length();
                change.setText(newText);

                change.selectRange(carretPos, carretPos);
            }
            return change;
        });
        UserTextField.setTextFormatter(formatter);
        //PasswordTextField.setTextFormatter(formatter);
        }
    
 public void TextFormatPsw() {
 	
     
     TextFormatter<?> formatter = new TextFormatter<>((TextFormatter.Change change) -> {
         String text = change.getText();

         if (!text.isEmpty()) {
             String newText = text.replace(" ", "").toLowerCase();

             int carretPos = change.getCaretPosition() - text.length() + newText.length();
             change.setText(newText);

             change.selectRange(carretPos, carretPos);
         }
         return change;
     });
     PasswordTextField.setTextFormatter(formatter);
     }
 
    @FXML
    void LoginButtonListener(ActionEvent event) throws Exception {
    	
    	Window owner = LoginButton.getScene().getWindow();

        if(KiemTraUserName() && KiemTraPassword()) {
        	
    	try {
			 final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			 Connection conn = DriverManager.getConnection(DB_URL,"root","");
			 String query = "select * from taikhoan, nhanvien where username=? and psw=? and taikhoan.chucvu = 'Quản Lý' ";
			 PreparedStatement pst = conn.prepareStatement(query);
			 pst.setString(1,UserTextField.getText());
			 pst.setString(2, PasswordTextField.getText());
			 ResultSet rs = pst.executeQuery();
			 
			 if(rs.next()) {
				 HienThiGiaoDienQuanLi(event);
			 }
			 else {
				 String query1 = "select * from taikhoan, nhanvien where username=? and psw=? and taikhoan.chucvu = 'Lễ Tân' ";
				 PreparedStatement pst1 = conn.prepareStatement(query1);
				 pst1.setString(1,UserTextField.getText());
				 pst1.setString(2, PasswordTextField.getText());
				 ResultSet rs1 = pst1.executeQuery();
				 
				 if(rs1.next()) {
					 HienThiGiaoDienLeTan(event);
				 }
				 else {
					 String query2 = "select * from taikhoan, nhanvien where username=? and psw=? and taikhoan.chucvu = 'Kế Toán' ";
					 PreparedStatement pst2 = conn.prepareStatement(query2);
					 pst2.setString(1,UserTextField.getText());
					 pst2.setString(2, PasswordTextField.getText());
					 ResultSet rs2 = pst2.executeQuery();
					 
					 if(rs2.next()) {
						 HienThiGiaoDienKeToan(event);
					 }
					 else {
						 JOptionPane.showMessageDialog(null, "Đăng nhập thất bại!");
					 }
				 }
			 }
			 
   }
    	catch(SQLException e)
    	{
    		JOptionPane.showMessageDialog(null, e);
    	}
    	
    	
        }
    }
    
    private boolean KiemTraUserName() {
		if(UserTextField.getText().isEmpty()){
			thongbao.setText("Bạn chưa nhập tài khoản !");
			return false;
		}
		else {
			
			thongbao.setText("");
			return true;
		}
	}
    
    private boolean KiemTraPassword() {
		if(PasswordTextField.getText().isEmpty()){
			thongbao.setText("Bạn chưa nhập mật khẩu !");
			return false;
		}
		else {
			thongbao.setText("");
			return true;
		}
	}
    
   
       
   
    //Hiển Thị Giao Diện
    public void HienThiGiaoDienQuanLi(ActionEvent event) throws Exception {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      	FXMLLoader loader = new FXMLLoader();
      	loader.setLocation(getClass().getClassLoader().getResource("GiaoDienTong/GiaoDienQuanLiController.fxml"));
      	Parent sampleParent = loader.load();
      	Scene scene = new Scene(sampleParent);
      	stage.setScene(scene);
      }
    
    public void HienThiGiaoDienLeTan(ActionEvent event) throws Exception {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      	FXMLLoader loader = new FXMLLoader();
      	loader.setLocation(getClass().getClassLoader().getResource("GiaoDienTong/GiaoDienNhanVienController.fxml"));
      	Parent sampleParent = loader.load();
      	Scene scene = new Scene(sampleParent);
      	stage.setScene(scene);
      }
    
    public void HienThiGiaoDienKeToan(ActionEvent event) throws Exception {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      	FXMLLoader loader = new FXMLLoader();
      	loader.setLocation(getClass().getClassLoader().getResource("GiaoDienTong/GiaoDienKeToanController.fxml"));
      	Parent sampleParent = loader.load();
      	Scene scene = new Scene(sampleParent);
      	stage.setScene(scene);
      }

    @FXML
    void PasswordTextFieldListener(ActionEvent event) {

    }

    @FXML
    void UserTextFieldListener(ActionEvent event) {
    		

   }
    
    
    
}

