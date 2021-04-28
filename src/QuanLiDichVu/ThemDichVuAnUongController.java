package QuanLiDichVu;

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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ThemDichVuAnUongController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ThemDVAnUongLabel;

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

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	autoTaoMADV();
    	LoaiDVAnUongTextField.setText("ăn uống");
    	LoaiDVAnUongTextField.setDisable(true);
	}
    
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
    	if ( KiemTraTenDichVu() & KiemTraSoLuong() 
    			& KiemTraGia() & KiemTraTinhTrang() )
    			 	{
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query = "insert into `dv`(MA_DV,TENDV,LOAIDV,SOLUONG,GIA,TINHTRANG) VALUES(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,MaDVAnUongTextField.getText());
			pst.setString(2,TenDVAnUongTextField.getText());
			pst.setString(3,LoaiDVAnUongTextField.getText());
			pst.setString(4,SoLuongTextField.getText());		
			pst.setString(5,GiaTextField.getText());
			pst.setString(6,TinhTrangTextField.getText());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
    	autoTaoMADV();
    	Stage stage = (Stage) LuuButton.getScene().getWindow();
        // do what you have to do
        stage.close();	
    }
}
    
    public void autoTaoMADV() {
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			Statement s= conn.createStatement();
			
			ResultSet rs = s.executeQuery("select Max(Ma_DV) from dv");
			rs.next();
			rs.getString("Max(Ma_DV)");
			
			if(rs.getString("Max(Ma_DV)")== null)
			{
				MaDVAnUongTextField.setText("1");
			}
			else
			{
				int madv = Integer.parseInt(rs.getString("Max(Ma_DV)"));
				madv++;
				MaDVAnUongTextField.setText(String.format("%d",madv));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
    

    
    private boolean KiemTraTenDichVu() {
		
		if(TenDVAnUongTextField.getText().isEmpty())
				
			{
			tb2Label.setText(" Vui lòng nhập Tên Dịch Vụ");
			return false;
			}
		tb2Label.setText("");
		return true;
	}
    


    private boolean KiemTraSoLuong() {
		
		if(SoLuongTextField.getText().isEmpty())
				
			{
			tb4Label.setText(" Vui lòng nhập Số Lượng");
			return false;
			}
		tb4Label.setText("");
		return true;
	}
 
    private boolean KiemTraGia() {
		
		if(GiaTextField.getText().isEmpty())
				
			{
			tb5Label.setText(" Vui lòng nhập Giá");
			return false;
			}
		tb5Label.setText("");
		return true;
	}
 
 private boolean KiemTraTinhTrang() {
		
		if(TinhTrangTextField.getText().isEmpty())
				
			{
			tb6Label.setText(" Vui lòng nhập Tình Trạng");
			return false;
			}
		tb6Label.setText("");
		return true;
	}

    @FXML
    void MaDVAnUongTextFieldListener(ActionEvent event) {

    }

    @FXML
    void SoLuongTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TenDVAnUongTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TinhTrangTextFieldListener(ActionEvent event) {

    }

   
}
