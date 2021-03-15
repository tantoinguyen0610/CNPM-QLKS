package Check_out;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class CheckOutController {

    @FXML
    private TableView<?> Table_CheckOut;

    @FXML
    private TableColumn<?, ?> Tbl_Col_MaKH;

    @FXML
    private TableColumn<?, ?> Tbl_Col_TenKH;

    @FXML
    private TableColumn<?, ?> Tbl_Col_NgayDen;

    @FXML
    private TableColumn<?, ?> Tbl_Col_MaPhong;

    @FXML
    private TableColumn<?, ?> Tbl_Col_GiaPhongNgay;

    @FXML
    private TableColumn<?, ?> Tbl_Col_TrangThai;

    @FXML
    private Label MaKH_Label;

    @FXML
    private Label TenKH_Label;

    @FXML
    private Label SoNgayO_Label;

    @FXML
    private Label MaPhong_Label;

    @FXML
    private Label TienBoiThuong_Label;

    @FXML
    private Label NgayDen_Label;

    @FXML
    private Label NgayHienTai_Label;

    @FXML
    private Label Gia_Label;

    @FXML
    private Label TongTienDV_Label;

    @FXML
    private Label TongCong_Label;

    @FXML
    private TextField Ma_KH_textField;

    @FXML
    private TextField TenKH_textField;

    @FXML
    private TextField SoNgayO_textField;

    @FXML
    private TextField Ma_Phong_textField;

    @FXML
    private TextField TienBoiThuong_textField;

    @FXML
    private TextField Gia_textField;

    @FXML
    private TextField Tien_DV_textField;

    @FXML
    private TextField TongCong_textField;

    @FXML
    private Button Button_TraPhong;

    @FXML
    private Label CO_Label;

    @FXML
    private DatePicker NgayDen_textField;

    @FXML
    private DatePicker Ngay_HienTai_textField;

}

