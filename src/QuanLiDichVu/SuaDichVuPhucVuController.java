package QuanLiDichVu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SuaDichVuPhucVuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane SuaDichVuGiaiTriAnchorPane;

    @FXML
    private Label SuaDichVuPhucVuLabel;

    @FXML
    private Label MaDVLabel;

    @FXML
    private Label TenDVLabel;

    @FXML
    private Label SoLuongLabel;

    @FXML
    private Label GiaLabel;

    @FXML
    private Label TinhTrangLLabel;

    @FXML
    private TextField MaDVTextField;

    @FXML
    private TextField TenDVTextField;

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
    void LuuButtonListener(ActionEvent event) {

    }

    @FXML
    void MaDVTextFieldListener(ActionEvent event) {

    }

    @FXML
    void SoLuongTextFieldListener(ActionEvent event) {

    }
    
    @FXML
    void SuaButtonListener(ActionEvent event) {
    	MaDVTextField.setDisable(true);
    	TenDVTextField.setDisable(false);
    	SoLuongTextField.setDisable(false);
    	GiaTextField.setDisable(false);
    	TinhTrangTextField.setDisable(false);
    	LuuButton.setDisable(false);
    	HuyButton.setDisable(false);
    	SuaButton.setDisable(true);
    }

    @FXML
    void TenDVTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TinhTrangTextFieldListener(ActionEvent event) {

    }

   
}
