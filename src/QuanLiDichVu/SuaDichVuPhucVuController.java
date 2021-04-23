package QuanLiDichVu;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SuaDichVuPhucVuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane SuaDichVuGiaiTriAnchorPane;

    @FXML
    private Label SuaDichVuPhucVuLabel;

    @FXML
    private Label MaDVLabel;

    @FXML
    private Label TenDVLabel;

    @FXML
    private Label SoLuongLabel;

    @FXML
    private Label GiaLabel;

    @FXML
    private Label TinhTrangLLabel;

    @FXML
    private TextField MaDVTextField;

    @FXML
    private TextField TenDVTextField;

    @FXML
    private TextField SoLuongTextField;

    @FXML
    private TextField GiaTextField;

    @FXML
    private TextField TinhTrangTextField;

    @FXML
    private Button LuuButton;

    @FXML
    private Button HuyButton;
    
    @FXML
    private Button SuaButton;
    
    @FXML
    private Label LoaiDVLabel;

    @FXML
    private TextField LoaiDVTextField;

    @FXML
    void GiaTextFieldListener(ActionEvent event) {

    }

    @FXML
    void HuyButtonListener(ActionEvent event) throws IOException {
    	Stage stage = (Stage) HuyButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void LuuButtonListener(ActionEvent event) {
    	int response=	JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn lưu cập nhật?", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     	if(response == JOptionPane.YES_OPTION) {
     		try {
    			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
    			Connection conn = DriverManager.getConnection(DB_URL,"root","");
    			String value1 = MaDVTextField.getText();
    			String value2 = TenDVTextField.getText();
    			String value3 =	LoaiDVTextField.getText();
    			String value4 = SoLuongTextField.getText();
    			String value5 = GiaTextField.getText();
    			String value6 = TinhTrangTextField.getText();
    			String sql = "update dv set MA_DV= '"+value1+"',TENDV='"+value2+"',LOAIDV='"+value3+"',SOLUONG='"+value4+"',GIA='"+value5+"',TINHTRANG='"+value6+"' where MA_DV='"+value1+"'";
    			PreparedStatement pst = conn.prepareStatement(sql);	
    			pst.execute();
    			JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
    		}catch(Exception e) {
    			e.printStackTrace();
    			
    		}
     		Stage stage = (Stage) LuuButton.getScene().getWindow();
	        // do what you have to do
	        stage.close();
     	}
     	else if(response == JOptionPane.NO_OPTION){
     		
     	}
    }

    @FXML
    void MaDVTextFieldListener(ActionEvent event) {

    }

    @FXML
    void SoLuongTextFieldListener(ActionEvent event) {

    }
    
    @FXML
    void SuaButtonListener(ActionEvent event) {
    	MaDVTextField.setDisable(true);
    	TenDVTextField.setDisable(false);
    	SoLuongTextField.setDisable(false);
    	GiaTextField.setDisable(false);
    	TinhTrangTextField.setDisable(false);
    	LoaiDVTextField.setDisable(true);
    	LuuButton.setDisable(false);
    	HuyButton.setDisable(false);
    	SuaButton.setDisable(true);
    }
    
    public void setDichVuPV(TableDichVuPhucVu dichvuphucvu) {
    	MaDVTextField.setText(String.valueOf(dichvuphucvu.getMA_DV()));
    	TenDVTextField.setText(String.valueOf(dichvuphucvu.getTENDV()));
    	SoLuongTextField.setText(String.valueOf(dichvuphucvu.getLOAIDV()));
    	LoaiDVTextField.setText(String.valueOf(dichvuphucvu.getSOLUONG()));
    	GiaTextField.setText(String.valueOf(dichvuphucvu.getGIA()));
    	TinhTrangTextField.setText(String.valueOf(dichvuphucvu.getTINHTRANG()));
    	
    }

    @FXML
    void TenDVTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TinhTrangTextFieldListener(ActionEvent event) {

    }

   
}
