package QuanLiHoaDon;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    void DenNgayDatePickerListener(ActionEvent event) throws IOException {
    	
    }

    @FXML
    void DenNgayNCPDatePickerListener(ActionEvent event) throws IOException {

    }

    @FXML
    void DenNgaySCTBDatePickerListener(ActionEvent event) throws IOException {

    }

    @FXML
    void DuyetThanhToanHoaDonNCPButtonListener(ActionEvent event) throws IOException {
    	
    }

    @FXML
    void DuyetThanhToanHoaDonSCTBButtonListener(ActionEvent event) throws IOException {

    }

    @FXML
    void TuNgayDatePickerListener(ActionEvent event) throws IOException {

    }

    @FXML
    void TuNgayNCPDatePickerListener(ActionEvent event) throws IOException {

    }

    @FXML
    void TuNgaySCTBDatePickerListener(ActionEvent event) throws IOException {

    }

    @FXML
    void XemChiTietHDTTPButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ChiTietHoaDonThanhToanPhongController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void XemHoaDonNCPButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ChiTietHoaDonNangCapPhongController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void XemHoaDonSCTBButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ChiTietHoaDonSuaChuaThietBiController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void XoaHDTTPButtonListener(ActionEvent event) throws IOException {

    }

    @FXML
    void XoaHoaDonNCPButtonListener(ActionEvent event) throws IOException {

    }

    @FXML
    void XoaHoaDonSCTBButtonListener(ActionEvent event) throws IOException {

    }

   
}
