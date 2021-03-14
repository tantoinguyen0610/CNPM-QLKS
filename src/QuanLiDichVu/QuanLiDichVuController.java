package QuanLiDichVu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class QuanLiDichVuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private TabPane DichVuTabPane;

    @FXML
    private Tab DichVuAnUongTab;

    @FXML
    private AnchorPane DichVuAnUongAnchorPane;

    @FXML
    private ScrollPane AScrollPane;

    @FXML
    private TableView<?> DichVuAnUongTableView;

    @FXML
    private TableColumn<?, ?> MaDVAnUongColumn;

    @FXML
    private TableColumn<?, ?> TenDichVuAnUongColumn;

    @FXML
    private TableColumn<?, ?> LoaiDichVuAnUongColumn;

    @FXML
    private TableColumn<?, ?> SoLuongAnUongColumn;

    @FXML
    private TableColumn<?, ?> GiaDVAnUongColumn;

    @FXML
    private TableColumn<?, ?> TinhTrangDVAnUongColumn;

    @FXML
    private Button ThemDVAnUongButton;

    @FXML
    private Button SuaDVAnUongButton;

    @FXML
    private Button XoaDVAnUongButton;

    @FXML
    private Tab DichVuGiaiTriTab;

    @FXML
    private AnchorPane DichVuGiaiTriAnchorPane;

    @FXML
    private ScrollPane BScrollPane;

    @FXML
    private TableView<?> DichVuGiaiTriTableView;

    @FXML
    private TableColumn<?, ?> MaDVGTColumn;

    @FXML
    private TableColumn<?, ?> TenDVGTColumn;

    @FXML
    private TableColumn<?, ?> GiaDVGTColumn;

    @FXML
    private TableColumn<?, ?> KhungGioGTColumn;

    @FXML
    private TableColumn<?, ?> TinhTrangColumn;

    @FXML
    private Button ThemDVGTButton;

    @FXML
    private Button SuaDVGTButton;

    @FXML
    private Button XoaDVGTButton;

    @FXML
    private Tab DichVuThuGianTab;

    @FXML
    private AnchorPane DichVuThuGianAnchorPane;

    @FXML
    private ScrollPane CScrollPane;

    @FXML
    private TableView<?> DichVuThuGianTableView;

    @FXML
    private TableColumn<?, ?> MaDVTGColumn;

    @FXML
    private TableColumn<?, ?> TenDVTGColumn;

    @FXML
    private TableColumn<?, ?> GiaDCTGColumn;

    @FXML
    private TableColumn<?, ?> SoLuongNguoiDVTGColumn;

    @FXML
    private TableColumn<?, ?> KhungGioDVTGColumn;

    @FXML
    private TableColumn<?, ?> TinhTrangDVTGColumn;

    @FXML
    private Button ThemDVTGButton;

    @FXML
    private Button SuaDVTGButton;

    @FXML
    private Button XoaDVTGButton;

    @FXML
    private Tab DichVuPhucVuTab;

    @FXML
    private AnchorPane DichVuPhucVuAnchorPane;

    @FXML
    private ScrollPane DScrollPane;

    @FXML
    private TableView<?> DIchVuPhucVuTableView;

    @FXML
    private TableColumn<?, ?> MADVPVColumn;

    @FXML
    private TableColumn<?, ?> TenDVPVColumn;

    @FXML
    private TableColumn<?, ?> SoLuongDVPVColumn;

    @FXML
    private TableColumn<?, ?> GiaDVPVCloumn;

    @FXML
    private TableColumn<?, ?> TinhTrangDVPVColumn;

    @FXML
    private Button ThemDVPVButton;

    @FXML
    private Button SuaDVPVButton;

    @FXML
    private Button XoaDVPVButton;

    @FXML
    void SuaDVAnUongButtonListener(ActionEvent event) {

    }

    @FXML
    void SuaDVGTButtonListener(ActionEvent event) {

    }

    @FXML
    void SuaDVPVButtonListener(ActionEvent event) {

    }

    @FXML
    void SuaDVTGButtonListener(ActionEvent event) {

    }

    @FXML
    void ThemDVAnUongButtonListener(ActionEvent event) {

    }

    @FXML
    void ThemDVGTButtonListener(ActionEvent event) {

    }

    @FXML
    void ThemDVPVButtonListener(ActionEvent event) {

    }

    @FXML
    void ThemDVTGButtonListener(ActionEvent event) {

    }

    @FXML
    void XoaDVAnUongButtonListener(ActionEvent event) {

    }

    @FXML
    void XoaDVGTButtonListener(ActionEvent event) {

    }

    @FXML
    void XoaDVPVButtonListener(ActionEvent event) {

    }

    @FXML
    void XoaDVTGButtonListener(ActionEvent event) {

    }

  
}
