package QuanLiDichVu;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import QuanLiKhachHang.TableKhachHang;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SuaDichVuAnUongController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label SuaDVAnUongLabel;

    @FXML
    private Label MaDVAnUongLabel;

    @FXML
    private Label TenDVAnUongLabel;

    @FXML
    private Label LoaiDVAnUongLabel;

    @FXML
    private Label SoLuongLabel;

    @FXML
    private Label GiaLabel;

    @FXML
    private Label TinhTrangLLabel;

    @FXML
    private TextField MaDVAnUongTextField;

    @FXML
    private TextField TenDVAnUongTextField;

    @FXML
    private TextField LoaiDVAnUongTextField;

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
    void GiaTextFieldListener(ActionEvent event) {

    }

    @FXML
    void HuyButtonListener(ActionEvent event) throws IOException {
    	Stage stage = (Stage) HuyButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void LoaiDVAnUongTextFieldListener(ActionEvent event) {

    }

    @FXML
    void LuuButtonListener(ActionEvent event) {
    	int response=	JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn lưu cập nhật?", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     	if(response == JOptionPane.YES_OPTION) {
     		try {
    			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
    			Connection conn = DriverManager.getConnection(DB_URL,"root","");
    			String value0 = MaDVAnUongTextField.getText();
    			String value1 = TenDVAnUongTextField.getText();
    			String value2 =	LoaiDVAnUongTextField.getText();
    			String value3 =SoLuongTextField.getText();
    			String value4 =GiaTextField.getText();
    			String value5 =TinhTrangTextField.getText();
    			String sql = "update dv set MA_DV= '"+value0+"',TENDV='"+value1+"',LOAIDV='"+value2+"',SOLUONG='"+value3+"',GIA='"+value4+"',TINHTRANG='"+value5+"' where MA_DV='"+value0+"'";
    			PreparedStatement pst = conn.prepareStatement(sql);	
    			pst.execute();
    			JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
     	}
     	else if(response == JOptionPane.NO_OPTION){
     		
     	}
} 
  

    @FXML
    void MaDVAnUongTextFieldListener(ActionEvent event) {

    }

    @FXML
    void SoLuongTextFieldListener(ActionEvent event) {

    }
    
    @FXML
    void SuaButtonListener(ActionEvent event) {
    	 MaDVAnUongTextField.setDisable(true);
    	 TenDVAnUongTextField.setDisable(false);
    	 LoaiDVAnUongTextField.setDisable(false);
    	 SoLuongTextField.setDisable(false);
    	 GiaTextField.setDisable(false);
    	 TinhTrangTextField.setDisable(false);
    	 LuuButton.setDisable(false);
    	 HuyButton.setDisable(false);
    	 SuaButton.setDisable(true);
    	 
    }

    public void setDichVuAnUong(TableDichVuAnUong dvanuong) {
    	MaDVAnUongTextField.setText(String.valueOf(dvanuong.getMA_DV()));
    	TenDVAnUongTextField.setText(String.valueOf(dvanuong.getTENDV()));
    	LoaiDVAnUongTextField.setText(String.valueOf(dvanuong.getLOAIDV()));
    	SoLuongTextField.setText(String.valueOf(dvanuong.getSOLUONG()));
    	GiaTextField.setText(String.valueOf(dvanuong.getGIA()));
    	TinhTrangTextField.setText(String.valueOf(dvanuong.getTINHTRANG()));
    }
    
    
    @FXML
    void TenDVAnUongTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TinhTrangTextFieldListener(ActionEvent event) {

    }

    
}
