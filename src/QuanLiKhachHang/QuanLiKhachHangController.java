package QuanLiKhachHang;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

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
    void DanhGiaButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("BangDanhGiaKhachHangController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void PhieuDichVuButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("PhieuDichVuController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void SuaButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("SuaKhachHangController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void ThemButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ThemKhachHangController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void XoaButtonListener(ActionEvent event) throws IOException {

    }

    
}
