package QuanLiKhachHang;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ThemKhachHangController implements Initializable {

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
    private Button LuuButton;

    @FXML
    private Button HuyButton;
    
    @FXML
    private Label tb1Label;

    @FXML
    private Label tb2Label;

    @FXML
    private Label tb3Label;

    @FXML
    private Label tb4Label;

    @FXML
    private Label tb5Label;

    @FXML
    private Label tb6Label;

    @FXML
    private Label tb7Label;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		autoTaoMaKH();
		
	}

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
    	if ( KiemTraTenKhachHang() & KiemTraSDT() 
    			& KiemTraCMND() & KiemTraQUOCTICH() 
    			&  KiemTraNgaySinh() 
    			& KiemTraGioiTinh() & KiemTraDiaChi()) 	{
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
			JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
			Stage stage = (Stage) LuuButton.getScene().getWindow();
	        stage.close();
		
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
}
		autoTaoMaKH();
		
} 
    
    public void autoTaoMaKH() {
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			Statement s= conn.createStatement();
			
			ResultSet rs = s.executeQuery("select Max(MaKH) from khachhang");
			rs.next();
			rs.getString("Max(MaKH)");
			
			if(rs.getString("Max(MaKH)")== null)
			{
				 MaKHTextField.setText("1");
			}
			else
			{
				int makh = Integer.parseInt(rs.getString("Max(MaKH)"));
						makh++;
				 MaKHTextField.setText(String.format("%d",makh));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
    
private boolean KiemTraTenKhachHang() {
		
		if(TenKhTextField.getText().isEmpty())
				
			{
			tb1Label.setText(" Vui lòng nhập Tên Khách Hàng");
			return false;
			}
		return true;
	}

private boolean KiemTraSDT() {
	
	if(SDTTextField.getText().isEmpty())
			
		{
		tb2Label.setText("Vui lòng nhập Số Điện Thoại ");
		return false;
		}
	return true;
}

private boolean KiemTraCMND() {
	
	if(CMNDTextField.getText().isEmpty())
			
		{
		tb3Label.setText("Vui lòng nhập CMND ");
		return false;
		}
	return true;
}

private boolean KiemTraQUOCTICH() {
	
	if(QuocTichTextField.getText().isEmpty())
			
		{
		tb4Label.setText("Vui lòng nhập Quốc Tịch ");
		return false;
		}
	return true;
}

private boolean KiemTraNgaySinh() {
	
	if(NgaySinhTextField.getText().isEmpty())
			
		{
		tb5Label.setText("Vui lòng nhập Ngày Sinh ");
		return false;
		}
	return true;
}

private boolean KiemTraGioiTinh() {
	
	if(GTTextField.getText().isEmpty())
			
		{
		tb6Label.setText("Vui lòng nhập Giới Tính ");
		return false;
		}
	return true;
}

private boolean KiemTraDiaChi() {
	
	if(DiaChiTextField.getText().isEmpty())
			
		{
		tb7Label.setText("Vui lòng nhập Địa Chỉ ");
		return false;
		}
	return true;
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


    @FXML
    void TenKhTextFieldListener(ActionEvent event) {

    }

 
}
