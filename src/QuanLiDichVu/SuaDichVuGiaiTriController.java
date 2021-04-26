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

public class SuaDichVuGiaiTriController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane SuaDichVuGiaiTriAnchorPane;

    @FXML
    private Label SuaDichVuGIaiTriLabel;

    @FXML
    private Label MaDVAnUongLabel;

    @FXML
    private Label TenDVAnUongLabel;

    @FXML
    private Label KhungGioLabel;

    @FXML
    private Label GiaLabel;

    @FXML
    private Label TinhTrangLLabel;

    @FXML
    private TextField MaDVAnUongTextField;

    @FXML
    private TextField TenDVAnUongTextField;

    @FXML
    private TextField KhungGioTextField;

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
    void KhungGioTextFieldListener(ActionEvent event) {

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
    			String value2 =	KhungGioTextField.getText();
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
    void MaDVAnUongTextFieldListener(ActionEvent event) {

    }
    
    @FXML
    void SuaButtonListener(ActionEvent event) {
    	MaDVAnUongTextField.setDisable(true);
    	TenDVAnUongTextField.setDisable(false);
    	KhungGioTextField.setDisable(false);
    	LoaiDVTextField.setDisable(true);
    	GiaTextField.setDisable(false);
    	TinhTrangTextField.setDisable(false);
    	LuuButton.setDisable(false);
    	HuyButton.setDisable(false);
    	SuaButton.setDisable(true);
    }

    @FXML
    void TenDVAnUongTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TinhTrangTextFieldListener(ActionEvent event) {

    }

	public void setDichVuGiaiTri(TableDichVuGiaiTri dvgiaitri) {
		MaDVAnUongTextField.setText(String.valueOf(dvgiaitri.getMA_DV()));
		TenDVAnUongTextField.setText(String.valueOf(dvgiaitri.getTENDV()));
		KhungGioTextField.setText(String.valueOf(dvgiaitri.getKHUNGGIO()));
		LoaiDVTextField.setText(String.valueOf(dvgiaitri.getLOAIDV()));
		GiaTextField.setText(String.valueOf(dvgiaitri.getGIA()));
		TinhTrangTextField.setText(String.valueOf(dvgiaitri.getTINHTRANG()));
		
		
	}

    
}
