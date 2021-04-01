package Check_in;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Check_in.CheckInController;

public class ChiTietPT_Controller extends CheckInController implements Initializable {

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
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	onEdit();
    }
    public void onEdit() {
        // check the table's selected item and get selected item
        if (Table_Check_In.getSelectionModel().getSelectedItem() != null) {
            ModelTable selectedPerson = Table_Check_In.getSelectionModel().getSelectedItem();
            TenKH_textField.setText(selectedPerson.getTENKH());
            //addressTextField.setText(selectedPerson.getAddress());
        }}
    
    @FXML
    void ThoatChiTietPT_ActionListener(ActionEvent event) {

    }

}
