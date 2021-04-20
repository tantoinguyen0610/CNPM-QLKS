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

public class SuaDichVuAnUongController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label SuaDVAnUongLabel;

    @FXML
    private Label MaDVAnUongLabel;

    @FXML
    private Label TenDVAnUongLabel;

    @FXML
    private Label LoaiDVAnUongLabel;

    @FXML
    private Label SoLuongLabel;

    @FXML
    private Label GiaLabel;

    @FXML
    private Label TinhTrangLLabel;

    @FXML
    private TextField MaDVAnUongTextField;

    @FXML
    private TextField TenDVAnUongTextField;

    @FXML
    private TextField LoaiDVAnUongTextField;

    @FXML
    private TextField SoLuongTextField;

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
    void LoaiDVAnUongTextFieldListener(ActionEvent event) {

    }

    @FXML
    void LuuButtonListener(ActionEvent event) {

    }

    @FXML
    void MaDVAnUongTextFieldListener(ActionEvent event) {

    }

    @FXML
    void SoLuongTextFieldListener(ActionEvent event) {

    }
    
    @FXML
    void SuaButtonListener(ActionEvent event) {
    	 MaDVAnUongTextField.setDisable(false);
    	 TenDVAnUongTextField.setDisable(false);
    	 LoaiDVAnUongTextField.setDisable(false);
    	 SoLuongTextField.setDisable(false);
    	 GiaTextField.setDisable(false);
    	 TinhTrangTextField.setDisable(false);
    	 LuuButton.setDisable(false);
    	 HuyButton.setDisable(false);
    	 SuaButton.setDisable(true);
    	 
    }

    @FXML
    void TenDVAnUongTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TinhTrangTextFieldListener(ActionEvent event) {

    }

    
}
