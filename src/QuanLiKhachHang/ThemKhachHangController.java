package QuanLiKhachHang;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

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
    private TextField SDTTextField;

    @FXML
    private TextField CMNDTextField;

    @FXML
    private TextField QuocTichTextField;

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
    
    @FXML
    private DatePicker NgaySinh;

    @FXML
    private ComboBox<String> GioiTinhCMB;
    
    ObservableList<String> GioiTinh = FXCollections.observableArrayList("Nam","Nữ");
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		autoTaoMaKH();
		GioiTinhCMB.setItems(GioiTinh);
		ChuyenNguocNamThangNgay();
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
    	if ( KiemTraTenKH() & KiemTraSDT() 
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
			pst.setString(7, GioiTinhCMB.getValue().toString());
			pst.setString(8,((TextField)NgaySinh.getEditor()).getText());
			
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
    
    public void ChuyenNguocNamThangNgay()
	{
			NgaySinh.setConverter(
				   new StringConverter<LocalDate>() {
				          final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

				          @Override
				          public String toString(LocalDate date) {
				            return (date != null) ? dateFormatter.format(date) : "";
				          }

				          @Override
				          public LocalDate fromString(String string) {
				            return (string != null && !string.isEmpty())
				                ? LocalDate.parse(string, dateFormatter)
				                : null;
				          }
				        });
	}
    
    private boolean KiemTraTenKH() {
		Pattern p = Pattern.compile("[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ,\\s]+");
		Matcher m = p.matcher(TenKhTextField.getText());
		if(m.find() && m.group().equals(TenKhTextField.getText())){
			tb1Label.setText("");
			return true;
		}
		else {
			tb1Label.setText("Vui lòng điền tên hợp lệ");
			return false;
		}
	}

    private boolean KiemTraSDT() {
	
    	Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(SDTTextField.getText());
		if(m.find() && m.group().equals(SDTTextField.getText())&& SDTTextField.getText().matches("\\d{10}|\\d{11}"))
				{
			tb2Label.setText("");
			return true;
		}
		else {
			tb2Label.setText("Vui lòng điền số hợp lệ");
			return false;
		}
	}

    private boolean KiemTraCMND() {
	
    	Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(CMNDTextField.getText());
		if(m.find() && m.group().equals(CMNDTextField.getText())&& CMNDTextField.getText().matches("\\d{9}|\\d{12}"))
				{
			tb3Label.setText("");
			return true;
		}
		else {
			tb3Label.setText("Vui lòng điền số hợp lệ");
			return false;
		}
}

    private boolean KiemTraQUOCTICH() {
	
	if(QuocTichTextField.getText().isEmpty())
			
		{
		tb4Label.setText("Vui lòng nhập Quốc Tịch ");
		return false;
		}
	tb4Label.setText("");
	return true;
}

    private boolean KiemTraNgaySinh() {
    	
		if(((TextField)NgaySinh.getEditor()).getText().isEmpty())
				
			{
			tb5Label.setText("Vui lòng nhập Ngày Sinh");
			return false;
			}
		tb5Label.setText("");
		return true;
	}

private boolean KiemTraGioiTinh() {
		
		if(GioiTinhCMB.getSelectionModel().isEmpty())
			{
			tb6Label.setText("Vui lòng chọn Giới Tính");
			return false;
			}
		tb6Label.setText("");
		return true;
	}

    private boolean KiemTraDiaChi() {
	
	if(DiaChiTextField.getText().isEmpty())
			
		{
		tb7Label.setText("Vui lòng nhập Địa Chỉ ");
		return false;
		}
	tb7Label.setText("");
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
