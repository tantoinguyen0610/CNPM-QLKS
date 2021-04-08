package NhanVien;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

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
    private Label CaLam_Label;
    
    @FXML
    private Label SDT_Label;

    @FXML
    private TextField SDT_textField;


    @FXML
    private ComboBox<String> CaLam_Cmb;

    ObservableList<String> list_gioitinh = FXCollections.observableArrayList("Nam","Nữ");
    ObservableList<String> list_chucvu = FXCollections.observableArrayList("Quản Lý","Kế Toán","Lễ Tân");
    ObservableList<String> list_calam = FXCollections.observableArrayList("1", "2","3");
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	GioiTinh_cmbBox.setItems(list_gioitinh);
    	ChucVu_cmbBox.setItems(list_chucvu);
    	CaLam_Cmb.setItems(list_calam);
		
	}
    
    @FXML
    void ThemNV_ActionListener(ActionEvent event) {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query = "insert into `nhanvien`(MaNV,TENNV,CHUCVU,GIOITINH,SDT,CA_LAM,TRANGTHAI,NGAYLAMVIEC) "
							+ "VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, MaNV_textField.getText());
			pst.setString(2, TenNV_textField.getText());
			pst.setString(3, ((TextField)Ngay_Dat_Phong.getEditor()).getText());
			pst.setString(4, Ma_DP_textField.getText());
			pst.setString(5, ((TextField)NgayNhanPhong.getEditor()).getText());
			pst.setString(6, SoNgayO_textField.getText());
			String value = Loai_Phong_Cmb.getValue().toString();
			pst.setString(7, value);
			String value1 = SoPhong_Cmb.getValue().toString();
			pst.setString(8, value1);
			String value2 = SoNguoiCung1Phong.getValue().toString();
			pst.setString(9, value2);
			pst.executeUpdate();
			
			String query1 = "INSERT INTO khachhang (TENKH,SDT,CMND) VALUES(?,?,?)";
			PreparedStatement pst1 = conn.prepareStatement(query1);
			pst1.setString(1, TenKH_textField.getText());
			pst1.setString(2, SDT_textField.getText());
			pst1.setString(3, CMND_textField.getText());
			pst1.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
		}
	catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
    	
    	
    }
    

    
    @FXML
    void Thoat_ActionListener(ActionEvent event) {

    }

	

}
