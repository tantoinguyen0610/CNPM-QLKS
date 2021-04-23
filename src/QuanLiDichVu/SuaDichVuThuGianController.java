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


public class SuaDichVuThuGianController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label SuaDVThuGianLabel;

    @FXML
    private Label MaDVTGLabel;

    @FXML
    private Label TenDVTGLabel;

    @FXML
    private Label KhungGioDVTGLabel;

    @FXML
    private Label LoaiDVLabel;

    @FXML
    private Label GiaLabel;

    @FXML
    private Label TinhTrangLLabel;

    @FXML
    private TextField MaDVThuGianTextField;

    @FXML
    private TextField TenDVTGTextField;

    @FXML
    private TextField KhungGioDVTGTextField;

    @FXML
    private TextField LoaiDVTextField;

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
    void KhungGioDVTGTextFieldListener(ActionEvent event) {

    }

    @FXML
    void LuuButtonListener(ActionEvent event) {
    	int response=	JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn lưu cập nhật?", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     	if(response == JOptionPane.YES_OPTION) {
     		try {
    			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
    			Connection conn = DriverManager.getConnection(DB_URL,"root","");
    			String value0 = MaDVThuGianTextField.getText();
    			String value1 = TenDVTGTextField.getText();
    			String value2 =	KhungGioDVTGTextField.getText();
    			String value3 =LoaiDVTextField.getText();
    			String value4 =GiaTextField.getText();
    			String value5 =TinhTrangTextField.getText();
    			String sql = "update dv set MA_DV= '"+value0+"',TENDV='"+value1+"',KHUNGGIO='"+value2+"',LOAIDV='"+value3+"',GIA='"+value4+"',TINHTRANG='"+value5+"' where MA_DV='"+value0+"'";
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
    void MaDVThuGianTextFieldListener(ActionEvent event) {

    }

    
    @FXML
    void SuaButtonListener(ActionEvent event) {
    	MaDVThuGianTextField.setDisable(true);
    	TenDVTGTextField.setDisable(false);
    	KhungGioDVTGTextField.setDisable(false);
    	LoaiDVTextField.setDisable(true);
    	GiaTextField.setDisable(false);
    	TinhTrangTextField.setDisable(false);
    	LuuButton.setDisable(false);
    	HuyButton.setDisable(false);
    	SuaButton.setDisable(true);
    }

    @FXML
    void TenDVTGTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TinhTrangTextFieldListener(ActionEvent event) {

    }

	public void setDichVuTG(TableDichVuThuGian dvthugian) {
		MaDVThuGianTextField.setText(String.valueOf(dvthugian.getMA_DV()));
		TenDVTGTextField.setText(String.valueOf(dvthugian.getTENDV()));
		KhungGioDVTGTextField.setText(String.valueOf(dvthugian.getKHUNGGIO()));
		LoaiDVTextField.setText(String.valueOf(dvthugian.getLOAIDV()));
		GiaTextField.setText(String.valueOf(dvthugian.getGIA()));
		TinhTrangTextField.setText(String.valueOf(dvthugian.getTINHTRANG()));
	}

    
}
