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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChiTietHoaDonNangCapPhongController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane ThongTinHoaDonNangCapPhong;

    @FXML
    private Label ThongTinHoaDonNCPLabel;

    @FXML
    private Label SoPhongLabel;

    @FXML
    private Label LiDoNangCapLabel;

    @FXML
    private Label NgayBatDauLabel;

    @FXML
    private Label NgayKetThucLabel;

    @FXML
    private Label TinhTrangNangCapLabel;

    @FXML
    private Label ChiPhiNangCapLabel;

    @FXML
    private Label TongTienLabel;

    @FXML
    private TextField SoPhongTextField;

    @FXML
    private TextField LiDoNangCapTextField;

    @FXML
    private TextField NgayBatDauTextField;

    @FXML
    private TextField NgayKetThucTextField;

    @FXML
    private TextField TìnhTrangNangCapTextField;

    @FXML
    private TextField ChiPhiNangCapTextField;

    @FXML
    private TextField TongTienTextField;

    @FXML
    private Button DongButton;

    @FXML
    void ChiPhiNangCapTextFieldListener(ActionEvent event) {

    }

    @FXML
    void DongButtonListener(ActionEvent event) throws IOException {
    	Stage stage = (Stage) DongButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void LiDoNangCapTextFieldListener(ActionEvent event) {

    }

    @FXML
    void NgayBatDauTextFieldListener(ActionEvent event) {

    }

    @FXML
    void NgayKetThucTextFieldListener(ActionEvent event) {

    }

    @FXML
    void SoPhongTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TongTienTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TìnhTrangNangCapTextFieldListener(ActionEvent event) {

    }

  
}
