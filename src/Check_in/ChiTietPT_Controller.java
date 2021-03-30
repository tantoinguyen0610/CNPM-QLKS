package Check_in;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChiTietPT_Controller {

    @FXML
    private Label TenKH_Label;

    @FXML
    private Label CMND_Label;

    @FXML
    private Label SDT_Label;

    @FXML
    private Label SoNg1Phong_Label;

    @FXML
    private Label Ma_DP_Label;

    @FXML
    private Label Ngay_DP_Label;

    @FXML
    private Label NgayNhanPhong_Label;

    @FXML
    private Label LoaiPhong_Label;

    @FXML
    private Label SoNgayO_Label;

    @FXML
    private TextField TenKH_textField;

    @FXML
    private TextField CMND_textField;

    @FXML
    private TextField SDT_textField;

    @FXML
    private TextField SoNgayO_textField;

    @FXML
    private DatePicker Ngay_Dat_Phong;

    @FXML
    private DatePicker NgayNhanPhong;

    @FXML
    private ChoiceBox<?> SoNguoiCung1Phong;

    @FXML
    private TextField Ma_DP_textField;

    @FXML
    private ChoiceBox<?> Loai_Phong;

    @FXML
    private CheckBox DatCoc_CheckBox;

    @FXML
    private Label DKTP_Label;

    @FXML
    void DatCocActionListener(ActionEvent event) {

    }

    @FXML
    void ThoatChiTietPT_ActionListener(ActionEvent event) {

    }

}
