package Check_out;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HoaDonTraPhongController {

    @FXML
    private Label HDTP_Label;

    @FXML
    private Label TTHoaDon_Label;

    
    @FXML
    private Label MaKH_Label;

    @FXML
    private Label TenKH_Label;

    @FXML
    private Label MaPhong_Label;

    @FXML
    private Label GiaPhong_Label;

    @FXML
    private Label SoNgayO_Label;

    @FXML
    private Label NgayThanhToan_Label;

    @FXML
    private Label TongTienDV_Label;

    @FXML
    private Label TongTien_Label;

    @FXML
    private TextField Ma_KH_textField;

    @FXML
    private TextField TenKH_textField;

    @FXML
    private TextField Ma_Phong_textField;

    @FXML
    private TextField Gia_textField;

    @FXML
    private TextField SoNgayO_textField;

    @FXML
    private TextField NgayThanhToan_textField;

    @FXML
    private TextField Tien_DV_textField;

    @FXML
    private TextField TongCong_textField;

    @FXML
    private Label BangDV_Label;

    @FXML
    private TableView<?> tableView_BangDV;

    @FXML
    private TableColumn<?, ?> Tbl_Col_TenDV;

    @FXML
    private TableColumn<?, ?> Tbl_Col_SoLuong;

    @FXML
    private TableColumn<?, ?> Tbl_Col_Gia;

    @FXML
    private TableColumn<?, ?> Tbl_Col_Tong;

    @FXML
    private Button Button_ThanhToan;

    @FXML
    private Button Button_Huy_ThanhToan;

}
