package NhanVien;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ThemNVController {

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
    private ComboBox<?> GioiTinh_cmbBox;

    @FXML
    private DatePicker NgaySinh_DatePicker;

    @FXML
    private ComboBox<?> ChucVu_cmbBox;

    @FXML
    private Button Button_ThemMoi;

    @FXML
    private Button Button_Thoat;

}
