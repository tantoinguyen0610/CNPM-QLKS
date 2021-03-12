package QuanLiKhachHang;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class QuanLiKhachHangController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label DanhSachKhachHangLabel;

    @FXML
    private TableView<?> DanhSachKHTableView;

    @FXML
    private TableColumn<?, ?> MaKHColumn;

    @FXML
    private TableColumn<?, ?> TenKHLabel;

    @FXML
    private TableColumn<?, ?> NgaySinhColumn;

    @FXML
    private TableColumn<?, ?> GTColumn;

    @FXML
    private TableColumn<?, ?> ĐiaChiColumn;

    @FXML
    private TableColumn<?, ?> QuocTichColumn;

    @FXML
    private TableColumn<?, ?> SDTColumn;

    @FXML
    private TableColumn<?, ?> CMNDColumn;

    @FXML
    private TableColumn<?, ?> NgayCheck_inColumn;

    @FXML
    private TableColumn<?, ?> SoNgayOColumn;

    @FXML
    private Button ThemButton;

    @FXML
    private Button XoaButton;

    @FXML
    private Button SuaButton;

    @FXML
    private Button PhieuDichVuButton;

    @FXML
    private Button DanhGiaButton;

    @FXML
    void DanhGiaButtonListener(ActionEvent event) {

    }

    @FXML
    void PhieuDichVuButtonListener(ActionEvent event) {

    }

    @FXML
    void SuaButtonListener(ActionEvent event) {

    }

    @FXML
    void ThemButtonListener(ActionEvent event) {

    }

    @FXML
    void XoaButtonListener(ActionEvent event) {

    }

    
}
