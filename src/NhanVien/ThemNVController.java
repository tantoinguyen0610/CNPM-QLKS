package NhanVien;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Check_in.ModelTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class ThemNVController implements Initializable {

    @FXML
    private Label ThemNV_Label;

    @FXML
    private Label MaNV_Label;

    @FXML
    private Label HoTenNV_Label;

    @FXML
    private Label ChucVu_Label;

    @FXML
    private Label NgayBatDau_Label;

    @FXML
    private Label GioiTinh_Label;

    @FXML
    private Label NgaySinh_Label;
    
    @FXML
    private Label err_TenNV;

    @FXML
    private Label err_CaLam;

    @FXML
    private Label err_GioiTinh;

    @FXML
    private Label err_NgayBatDau;

    @FXML
    private Label err_NgaySinh;

    @FXML
    private Label err_ChucVu;

    @FXML
    private Label err_SDT;

    @FXML
    private TextField MaNV_textField;

    @FXML
    private TextField TenNV_textField;

    @FXML
    private DatePicker NgayBatDau_DatePicker;

    @FXML
    private ComboBox<String> GioiTinh_cmbBox;

    @FXML
    private DatePicker NgaySinh_DatePicker;

    @FXML
    private ComboBox<String> ChucVu_cmbBox;

    @FXML
    private Button Button_ThemMoi;

    @FXML
    private Button Button_Thoat;

    @FXML
    private Label SDT_Label;

    @FXML
    private TextField SDT_textField;
    
    @FXML
    private Label CaLam_Label;

    @FXML
    private ComboBox<String> CaLam_Cmb;
    
    

    ObservableList<String> list_gioitinh = FXCollections.observableArrayList("Nam","Nữ");
    ObservableList<String> list_chucvu = FXCollections.observableArrayList("Quản Lý","Kế Toán","Lễ Tân");
    ObservableList<String> list_calam = FXCollections.observableArrayList("1", "2","3");
    ObservableList<String> list_trangthai = FXCollections.observableArrayList("Online","Offline");
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	GioiTinh_cmbBox.setItems(list_gioitinh);
    	ChucVu_cmbBox.setItems(list_chucvu);
    	CaLam_Cmb.setItems(list_calam);
    	ChuyenNguocNamThangNgay();
    	autoTaoMaNV();
		
	}
    
    
    
    @FXML
    void ThemNV_ActionListener(ActionEvent event) {
    	if(KiemTraTenNV() & KiemTraChucVu() & 
    			KiemTraGioiTinh() & KiemTraSDT() &
    			KiemTraCaLam() & KiemTraBatDauLam() & 
    			KiemTraNgaySinh()) {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query = "insert into `nhanvien`(MaNV,TENNV,CHUCVU,GIOITINH,SDT,CA_LAM,NGAYLAMVIEC,NGAYSINH) "
							+ "VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, MaNV_textField.getText());
			pst.setString(2, TenNV_textField.getText());
			pst.setString(3, ChucVu_cmbBox.getValue().toString());
			pst.setString(4, GioiTinh_cmbBox.getValue().toString());
			pst.setString(5, SDT_textField.getText());
			pst.setString(6, CaLam_Cmb.getValue().toString());
			pst.setString(7,((TextField)NgayBatDau_DatePicker.getEditor()).getText());
			pst.setString(8,((TextField)NgaySinh_DatePicker.getEditor()).getText());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
			autoTaoMaNV();
		}
	catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
    	}
    	
    }

    @FXML
    void Thoat_ActionListener(ActionEvent event) {
    	 Stage stage = (Stage) Button_Thoat.getScene().getWindow();
    	    stage.close();
    }
    
    private boolean KiemTraTenNV() {
		Pattern p = Pattern.compile("^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+$");
		Matcher m = p.matcher(TenNV_textField.getText());
		if(m.find() && m.group().equals(TenNV_textField.getText())){
			return true;
		}
		else {
			err_TenNV.setText("Vui lòng điền tên hợp lệ");
			return false;
		}
	}
    
    private boolean KiemTraChucVu() {
		
		if(ChucVu_cmbBox.getSelectionModel().isEmpty())
			{
			err_ChucVu.setText("Vui lòng chọn chức vụ");
			return false;
			}
		return true;
	}
    
    private boolean KiemTraGioiTinh() {
		
		if(GioiTinh_cmbBox.getSelectionModel().isEmpty())
			{
			err_GioiTinh.setText("Vui lòng chọn giới tính");
			return false;
			}
		return true;
	}
    
    private boolean KiemTraSDT() {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(SDT_textField.getText());
		if(m.find() && m.group().equals(SDT_textField.getText())){
			return true;
		}
		else {
			err_SDT.setText("Vui lòng điền số hợp lệ");
			return false;
		}
	}
    
    private boolean KiemTraCaLam() {
		
		if(CaLam_Cmb.getSelectionModel().isEmpty())
			{
			err_CaLam.setText("Vui lòng chọn ca làm");
			return false;
			}
		return true;
	}
    
    private boolean KiemTraBatDauLam() {
    	
		if(((TextField)NgayBatDau_DatePicker.getEditor()).getText().isEmpty())
				
			{
			err_NgayBatDau.setText("Vui lòng nhập ngày bắt đầu hợp lệ");
			return false;
			}
		return true;
	}
    
    private boolean KiemTraNgaySinh() {
    	
		if(((TextField)NgaySinh_DatePicker.getEditor()).getText().isEmpty())
				
			{
			err_NgaySinh.setText("Vui lòng nhập ngày sinh hợp lệ");
			return false;
			}
		return true;
	}
    
    
    

    public void ChuyenNguocNamThangNgay()
	{
    	NgayBatDau_DatePicker.setConverter(
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
    	NgaySinh_DatePicker.setConverter(
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
	
    public void autoTaoMaNV() {
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			Statement s= conn.createStatement();
			
			ResultSet rs = s.executeQuery("select Max(MANV) from nhanvien");
			rs.next();
			rs.getString("Max(MANV)");
			
			if(rs.getString("Max(MANV)")== null)
			{
				MaNV_textField.setText("1");
			}
			else
			{
				int mapt = Integer.parseInt(rs.getString("Max(MANV)"));
				mapt++;
				MaNV_textField.setText(String.format("%d",mapt));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    

}
