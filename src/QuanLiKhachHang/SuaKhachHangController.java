package QuanLiKhachHang;

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

public class SuaKhachHangController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane SuaKhachHangAnchorPane;

    @FXML
    private Label SuaKHLabel;

    @FXML
    private Label MaKHLabel;

    @FXML
    private Label TenKHLabel;

    @FXML
    private Label GTLabel;

    @FXML
    private Label SDTLabel;

    @FXML
    private Label CMNDLabel;

    @FXML
    private Label QuocTichLabel;

    @FXML
    private Label NgaySinhLabel;

    @FXML
    private Label DiaChiLabel;

    @FXML
    private Label NgayCheck_inLabel;

    @FXML
    private Label SoNgayOLabel;

    @FXML
    private TextField MaKHTextField;

    @FXML
    private TextField TenKhTextField;

    @FXML
    private TextField GTTextField;

    @FXML
    private TextField SDTTextField;

    @FXML
    private TextField CMNDTextField;

    @FXML
    private TextField QuocTichTextField;

    @FXML
    private TextField NgaySinhTextField;

    @FXML
    private TextField DiaChiTextField;

    @FXML
    private TextField NgayCheck_inTextField;

    @FXML
    private TextField SoNgayOTextField;

    @FXML
    private Button LuuButton;

    @FXML
    private Button HuyButton;

    @FXML
    private Button SuaButton;

    @FXML
    void CMNDTextFieldListener(ActionEvent event) {

    }

    @FXML
    void DiaChiTextFieldListener(ActionEvent event) {

    }

    @FXML
    void GTTextFieldListener(ActionEvent event) {

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
    void MaKHTextFieldListener(ActionEvent event) {

    }

    @FXML
    void NgayCheck_inTextFieldListener(ActionEvent event) {

    }

    @FXML
    void NgaySinhTextFieldListener(ActionEvent event) {

    }

    @FXML
    void QuocTichTextFieldListener(ActionEvent event) {

    }

    @FXML
    void SDTTextFieldListener(ActionEvent event) {

    }

    @FXML
    void SoNgayOTextFieldListener(ActionEvent event) {

    }

    @FXML
    void SuaButtonListener(ActionEvent event) {
    	MaKHTextField.setDisable(false);
    	TenKhTextField.setDisable(false);
    	GTTextField.setDisable(false);
    	SDTTextField.setDisable(false);
    	CMNDTextField.setDisable(false);
    	QuocTichTextField.setDisable(false);
    	NgaySinhTextField.setDisable(false);
    	DiaChiTextField.setDisable(false);
    	NgayCheck_inTextField.setDisable(false);
    	SoNgayOTextField.setDisable(false);
    	LuuButton.setDisable(false);
    	HuyButton.setDisable(false);
    	
    }

    @FXML
    void TenKhTextFieldListener(ActionEvent event) {

    }

  
}
