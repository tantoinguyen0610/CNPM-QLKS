package QuanLiKhachHang;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ThemKhachHangController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ThemKHLabel;

    @FXML
    private Label MaKHLabel;

    @FXML
    private Label TenKHLabel;

    @FXML
    private Label GTLabel;

    @FXML
    private Label SDTLabel;

    @FXML
    private Label CMNDLabel;

    @FXML
    private Label QuocTichLabel;

    @FXML
    private Label NgaySinhLabel;

    @FXML
    private Label DiaChiLabel;

    @FXML
    private Label NgayCheck_inLabel;

    @FXML
    private Label SoNgayOLabel;

    @FXML
    private TextField MaKHTextField;

    @FXML
    private TextField TenKhTextField;

    @FXML
    private TextField GTTextField;

    @FXML
    private TextField SDTTextField;

    @FXML
    private TextField CMNDTextField;

    @FXML
    private TextField QuocTichTextField;

    @FXML
    private TextField NgaySinhTextField;

    @FXML
    private TextField DiaChiTextField;

    @FXML
    private TextField NgayCheck_inTextField;

    @FXML
    private TextField SoNgayOTextField;

    @FXML
    private Button LuuButton;

    @FXML
    private Button HuyButton;

    @FXML
    void CMNDTextFieldListener(ActionEvent event) {

    }

    @FXML
    void DiaChiTextFieldListener(ActionEvent event) {

    }

    @FXML
    void GTTextFieldListener(ActionEvent event) {

    }

    @FXML
    void HuyButtonListener(ActionEvent event) throws IOException {
    	Stage stage = (Stage) HuyButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void LuuButtonListener(ActionEvent event) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query = "insert into `khachhang`(MAKH,TENKH,DIACHI,SDT,QUOCTICH,CMND,GIOITINH,NGAYSINH) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, MaKHTextField.getText());
			pst.setString(2, TenKhTextField.getText());
			pst.setString(3, DiaChiTextField.getText());
			pst.setString(4,  SDTTextField.getText());		
			pst.setString(5, QuocTichTextField.getText());
			pst.setString(6,  CMNDTextField.getText());
			pst.setString(7, GTTextField.getText());
			pst.setString(8, NgaySinhTextField.getText());
			pst.executeUpdate();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
} 
    

    @FXML
    void MaKHTextFieldListener(ActionEvent event) {

    }

    @FXML
    void NgayCheck_inTextFieldListener(ActionEvent event) {

    }

    @FXML
    void NgaySinhTextFieldListener(ActionEvent event) {

    }

    @FXML
    void QuocTichTextFieldListener(ActionEvent event) {

    }

    @FXML
    void SDTTextFieldListener(ActionEvent event) {

    }

    @FXML
    void SoNgayOTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TenKhTextFieldListener(ActionEvent event) {

    }

 
}
