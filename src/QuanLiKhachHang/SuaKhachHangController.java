package QuanLiKhachHang;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Check_in.ModelTable;
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
    
    public void setKhachHang(TableKhachHang khachhang) {
    	MaKHTextField.setText(String.valueOf(khachhang.getMAKH()));
    	TenKhTextField.setText(String.valueOf(khachhang.getTENKH()));
    	NgaySinhTextField.setText(String.valueOf(khachhang.getNGAYSINH()));
    	GTTextField.setText(String.valueOf(khachhang.getGIOITINH()));
    	DiaChiTextField.setText(String.valueOf(khachhang.getDIACHI()));
    	QuocTichTextField.setText(String.valueOf(khachhang.getQUOCTICH()));
    	SDTTextField.setText(String.valueOf(khachhang.getSDT()));
    	CMNDTextField.setText(String.valueOf(khachhang.getCMND()));
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
    	SoNgayOTextField.setDisable(false);
    	LuuButton.setDisable(false);
    	HuyButton.setDisable(false);
    	SuaButton.setDisable(true);
    	
    }

    @FXML
    void TenKhTextFieldListener(ActionEvent event) {

    }

  
}
