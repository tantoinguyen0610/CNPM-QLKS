package QuanLiHoaDon;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class QuanLiHoaDonController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TabPane QuanLiHoaDonTabPane;

    @FXML
    private Tab HoaDonThanhToanPhongTab;

    @FXML
    private AnchorPane a;

    @FXML
    private TableView<?> HoaDonThanhToanPhongTableView;

    @FXML
    private TableColumn<?, ?> MaHDTTPColumn;

    @FXML
    private TableColumn<?, ?> TenKhachColumn;

    @FXML
    private TableColumn<?, ?> SoPhongTTPColumn;

    @FXML
    private TableColumn<?, ?> NgayThanhToanPhongColumn;

    @FXML
    private TableColumn<?, ?> TongTienColumn;

    @FXML
    private TableColumn<?, ?> TongTienThanhToanColumn;

    @FXML
    private TableColumn<?, ?> TinhTrangColumn;

    @FXML
    private DatePicker TuNgayDatePicker;

    @FXML
    private DatePicker DenNgayDatePicker;

    @FXML
    private Label TuNgayLabel;

    @FXML
    private Label DenNgayLabel;

    @FXML
    private Button XemChiTietHDTTPButton;

    @FXML
    private Button XoaHDTTPButton;

    @FXML
    private Tab HoaDonSuaChuaThietBiTab;

    @FXML
    private AnchorPane b;

    @FXML
    private TableView<?> HoaDonSuaChuaThietBiTableView;

    @FXML
    private TableColumn<?, ?> MaHDSCTBColumn;

    @FXML
    private TableColumn<?, ?> TenTBColumn;

    @FXML
    private TableColumn<?, ?> SoLuongTBColumn;

    @FXML
    private TableColumn<?, ?> NgaySuaChuaColumn;

    @FXML
    private TableColumn<?, ?> TongTienSCTBColumn;

    @FXML
    private TableColumn<?, ?> ThanhToanSCTBColumn;

    @FXML
    private TableColumn<?, ?> TingTrangHDSCTBColumn;

    @FXML
    private TableColumn<?, ?> DuyetThanhToanSCTBCoLumn;

    @FXML
    private DatePicker TuNgaySCTBDatePicker;

    @FXML
    private DatePicker DenNgaySCTBDatePicker;

    @FXML
    private Label TuNgaySCTBLabel;

    @FXML
    private Label DenNgaySCTBLabel;

    @FXML
    private Button XemHoaDonSCTBButton;

    @FXML
    private Button XoaHoaDonSCTBButton;

    @FXML
    private Button DuyetThanhToanHoaDonSCTBButton;

    @FXML
    private Tab HoaDonNangCapPhongTab;

    @FXML
    private AnchorPane c;

    @FXML
    private TableView<?> HoaDonNangCapPhongTableView;

    @FXML
    private TableColumn<?, ?> MaHDNCPColumn;

    @FXML
    private TableColumn<?, ?> SoPhongNCPColumn;

    @FXML
    private TableColumn<?, ?> NgaySuaChuaNCPColumn;

    @FXML
    private TableColumn<?, ?> NgayKetThucNCPColumn;

    @FXML
    private TableColumn<?, ?> TongTienSuaChuaNCPColumn;

    @FXML
    private TableColumn<?, ?> ThanhToanNCPColumn;

    @FXML
    private TableColumn<?, ?> TinhTrangHDNCPColumn;

    @FXML
    private TableColumn<?, ?> DuyetThanhToanNCPColumn;

    @FXML
    private DatePicker TuNgayNCPDatePicker;

    @FXML
    private DatePicker DenNgayNCPDatePicker;

    @FXML
    private Button XemHoaDonNCPButton;

    @FXML
    private Button XoaHoaDonNCPButton;

    @FXML
    private Button DuyetThanhToanHoaDonNCPButton;

    @FXML
    void DenNgayDatePickerListener(ActionEvent event) {

    }

    @FXML
    void DenNgayNCPDatePickerListener(ActionEvent event) {

    }

    @FXML
    void DenNgaySCTBDatePickerListener(ActionEvent event) {

    }

    @FXML
    void DuyetThanhToanHoaDonNCPButtonListener(ActionEvent event) {

    }

    @FXML
    void DuyetThanhToanHoaDonSCTBButtonListener(ActionEvent event) {

    }

    @FXML
    void TuNgayDatePickerListener(ActionEvent event) {

    }

    @FXML
    void TuNgayNCPDatePickerListener(ActionEvent event) {

    }

    @FXML
    void TuNgaySCTBDatePickerListener(ActionEvent event) {

    }

    @FXML
    void XemChiTietHDTTPButtonListener(ActionEvent event) {

    }

    @FXML
    void XemHoaDonNCPButtonListener(ActionEvent event) {

    }

    @FXML
    void XemHoaDonSCTBButtonListener(ActionEvent event) {

    }

    @FXML
    void XoaHDTTPButtonListener(ActionEvent event) {

    }

    @FXML
    void XoaHoaDonNCPButtonListener(ActionEvent event) {

    }

    @FXML
    void XoaHoaDonSCTBButtonListener(ActionEvent event) {

    }

   
}
