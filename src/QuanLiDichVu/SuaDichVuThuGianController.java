package QuanLiDichVu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SuaDichVuThuGianController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label SuaDVThuGianLabel;

    @FXML
    private Label MaDVTGLabel;

    @FXML
    private Label TenDVTGLabel;

    @FXML
    private Label KhungGioDVTGLabel;

    @FXML
    private Label SoLuongNguoiLabel;

    @FXML
    private Label GiaLabel;

    @FXML
    private Label TinhTrangLLabel;

    @FXML
    private TextField MaDVThuGianTextField;

    @FXML
    private TextField TenDVTGTextField;

    @FXML
    private TextField KhungGioDVTGTextField;

    @FXML
    private TextField SoLuongNguoiTextField;

    @FXML
    private TextField GiaTextField;

    @FXML
    private TextField TinhTrangTextField;

    @FXML
    private Button LuuButton;

    @FXML
    private Button HuyButton;
    
    @FXML
    private Button SuaButton;

    @FXML
    void GiaTextFieldListener(ActionEvent event) {

    }

    @FXML
    void HuyButtonListener(ActionEvent event) throws IOException {
    	Stage stage = (Stage) HuyButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void KhungGioDVTGTextFieldListener(ActionEvent event) {

    }

    @FXML
    void LuuButtonListener(ActionEvent event) {

    }

    @FXML
    void MaDVThuGianTextFieldListener(ActionEvent event) {

    }

    @FXML
    void SoLuongNguoiTextFieldListener(ActionEvent event) {

    }
    
    @FXML
    void SuaButtonListener(ActionEvent event) {
    	MaDVThuGianTextField.setDisable(false);
    	TenDVTGTextField.setDisable(false);
    	KhungGioDVTGTextField.setDisable(false);
    	SoLuongNguoiTextField.setDisable(false);
    	GiaTextField.setDisable(false);
    	TinhTrangTextField.setDisable(false);
    	LuuButton.setDisable(false);
    	HuyButton.setDisable(false);
    	SuaButton.setDisable(true);
    }

    @FXML
    void TenDVTGTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TinhTrangTextFieldListener(ActionEvent event) {

    }

    
}
