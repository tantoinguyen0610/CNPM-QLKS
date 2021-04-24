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

public class ChiTietHoaDonSuaChuaThietBiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ThongTinHoaDonSCTBLabel;

    @FXML
    private Label TênTBLabel;

    @FXML
    private Label SoLuongLabel;

    @FXML
    private Label NgayBatDauLabel;

    @FXML
    private Label DuyetThanhToanLabel;

    @FXML
    private Label TinhTrangSuaLabel;

    @FXML
    private Label ChiPhiSuaChuaLabel;

    @FXML
    private Label TongTienLabel;

    @FXML
    private TextField TenTBTextField;

    @FXML
    private TextField SoLuongTextField;

    @FXML
    private TextField NgayBatDauTextField;

    @FXML
    private TextField DuyetThanhToanTextField;

    @FXML
    private TextField TìnhTrangSuaTextField;

    @FXML
    private TextField ChiPhiSuaChuaTextField;

    @FXML
    private TextField TongTienTextField;

    @FXML
    private Button DongButton;
    
    @FXML
    private Label MAHDLabel;

    @FXML
    private TextField MAHDSCTBTextField;

    @FXML
    void ChiPhiSuaChuaTextFieldListener(ActionEvent event) {

    }

    @FXML
    void DongButtonListener(ActionEvent event) throws IOException {
    	Stage stage = (Stage) DongButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void NgayBatDauTextFieldListener(ActionEvent event) {

    }


    @FXML
    void TenTBTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TongTienTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TìnhTrangSuaTextFieldListener(ActionEvent event) {

    }


}
