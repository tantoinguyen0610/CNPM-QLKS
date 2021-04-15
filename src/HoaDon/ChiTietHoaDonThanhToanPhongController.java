package HoaDon;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChiTietHoaDonThanhToanPhongController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ThongTinHoaDonThanhToanPhongLabel;

    @FXML
    private Label TenKhachHangLabel;

    @FXML
    private Label SoPhongLabel;

    @FXML
    private Label GiaPhongLabel;

    @FXML
    private Label SoNgayOLabel;

    @FXML
    private Label TinhTrangLabel;

    @FXML
    private Label NgayThanhToanLabel;

    @FXML
    private Label TongTienDichVuLabel;

    @FXML
    private Label ThanhToanLabel;

    @FXML
    private TextField TenKhachHangTextField;

    @FXML
    private TextField SoPhongTextField;

    @FXML
    private TextField GiaPhongTextField;

    @FXML
    private TextField SoNgayOTextField;

    @FXML
    private TextField TinhTrangTextField;

    @FXML
    private TextField NgayThanhToanTextField;

    @FXML
    private TextField TongTienDichVuTextField;


    @FXML
    private TextField ThanhToanTextField;

    @FXML
    private Button DongHDTTPButton;

    @FXML
    void GiaPhongTextFieldListener(ActionEvent event) {

    }

    @FXML
    void SoNgayOTextFieldListener(ActionEvent event) {

    }

    @FXML
    void SoPhongTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TenKhachHangTextFieldListener(ActionEvent event) {

    }

    @FXML
    void ThanhToanTextFieldListener(ActionEvent event) {

    }


    @FXML
    void TinhTrangTextFieldListener(ActionEvent event) {

    }
    
    

    @FXML
    void DongHDTTPButtonListener(ActionEvent event) throws IOException {
    	Stage stage = (Stage) DongHDTTPButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    
    public void setHDTTP(TableHoaDonTTP tablehoadon) {
    	TenKhachHangTextField.setText(tablehoadon.getTENKH());
    	SoPhongTextField.setText(String.valueOf(tablehoadon.getSOPHONG()));
    	GiaPhongTextField.setText(String.valueOf(tablehoadon.getGIAPHONG()));
    	SoNgayOTextField.setText(String.valueOf(tablehoadon.getSONGAYO()));
    	TinhTrangTextField.setText(tablehoadon.getTINHTRANG());
    	NgayThanhToanTextField.setText(String.valueOf(tablehoadon.getNGAYTHANHTOAN()));
    	TongTienDichVuTextField.setText(String.valueOf(tablehoadon.getTONGTIENDV()));
    	ThanhToanTextField.setText(String.valueOf(tablehoadon.getTHANHTOAN()));
    }

   
}
