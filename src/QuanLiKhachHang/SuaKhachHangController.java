package QuanLiKhachHang;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Check_in.ModelTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SuaKhachHangController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane SuaKhachHangAnchorPane;

    @FXML
    private Label SuaKHLabel;

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
    private TextField SoNgayOTextField;

    @FXML
    private Button LuuButton;

    @FXML
    private Button HuyButton;

    @FXML
    private Button SuaButton;

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
    	int response=	JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn lưu cập nhật?", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     	if(response == JOptionPane.YES_OPTION) {
     		try {
    			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
    			Connection conn = DriverManager.getConnection(DB_URL,"root","");
    			String value0 = MaKHTextField.getText();
    			String value1 = TenKhTextField.getText();
    			String value2 =NgaySinhTextField.getText();
    			String value3 =GTTextField.getText();
    			String value4 =DiaChiTextField.getText();
    			String value5 =QuocTichTextField.getText();
    			String value6 =SDTTextField.getText();
    			String value7 =CMNDTextField.getText();
    			String sql = "update khachhang set MAKH= '"+value0+"',TENKH='"+value1+"',NGAYSINH='"+value2+"',GIOITINH='"+value3+"',DIACHI='"+value4+"',QUOCTICH='"+value5+"',SDT='"+value6+"',CMND='"+value7+"'";
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
    void MaKHTextFieldListener(ActionEvent event) {

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

    
    public void setKhachHang(TableKhachHang khachhang) {
    	MaKHTextField.setText(String.valueOf(khachhang.getMAKH()));
    	TenKhTextField.setText(String.valueOf(khachhang.getTENKH()));
    	NgaySinhTextField.setText(String.valueOf(khachhang.getNGAYSINH()));
    	GTTextField.setText(String.valueOf(khachhang.getGIOITINH()));
    	DiaChiTextField.setText(String.valueOf(khachhang.getDIACHI()));
    	QuocTichTextField.setText(String.valueOf(khachhang.getQUOCTICH()));
    	SDTTextField.setText(String.valueOf(khachhang.getSDT()));
    	CMNDTextField.setText(String.valueOf(khachhang.getCMND()));
    }

    @FXML
    void SuaButtonListener(ActionEvent event) {
    	MaKHTextField.setDisable(false);
    	TenKhTextField.setDisable(false);
    	GTTextField.setDisable(false);
    	SDTTextField.setDisable(false);
    	CMNDTextField.setDisable(false);
    	QuocTichTextField.setDisable(false);
    	NgaySinhTextField.setDisable(false);
    	DiaChiTextField.setDisable(false);
    	SoNgayOTextField.setDisable(false);
    	LuuButton.setDisable(false);
    	HuyButton.setDisable(false);
    	SuaButton.setDisable(true);
    	
    }

    @FXML
    void TenKhTextFieldListener(ActionEvent event) {

    }

  
}
