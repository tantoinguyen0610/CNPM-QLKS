package NhanVien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.LocalDate;

import NhanVien.NhanVienController;

public class SuaNVController extends NhanVienController {

    @FXML
    private Label SuaNV_Label;

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
    private ComboBox<?> GioiTinh_cmbBox;

    @FXML
    private DatePicker NgaySinh_DatePicker;

    @FXML
    private ComboBox<String> ChucVu_cmbBox;

    @FXML
    private Button Button_Sua;

    @FXML
    private Button Button_Thoat;

    @FXML
    private Label CaLam_Label;

    @FXML
    private ComboBox<String> CaLam_Cmb;

    @FXML
    private Label SDT_Label;

    @FXML
    private TextField SDT_textField;

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
    private Button Button_NhiemVu;

    @FXML
    private Button Button_DanhGia;
    
    @FXML
    private Label TT_Label;

    @FXML
    private ComboBox<String> TrangThai_cmb;

    
    
    private TableNhanVien nguoiduocchon;
   
    
    @FXML
    void SuaNV_ActionListener(ActionEvent event) {
    	
    }

    @FXML
    void Thoat_ActionListener(ActionEvent event) {
    	 Stage stage = (Stage) Button_Thoat.getScene().getWindow();
 	    stage.close();
    }

    public void initData(TableNhanVien nhanvien)
    {
    	nguoiduocchon = nhanvien;
    	TenNV_textField.setText(nguoiduocchon.getTENNV());
    	ChucVu_cmbBox.setValue(nguoiduocchon.getCHUCVU());
    	CaLam_Cmb.setValue(nguoiduocchon.getCA_LAM());
    	TrangThai_cmb.setValue(nguoiduocchon.getTRANGTHAI());
    	((TextField)NgayBatDau_DatePicker.getEditor()).setText(nguoiduocchon.getNGAYLAMVIEC());
    	
    }
    
}
