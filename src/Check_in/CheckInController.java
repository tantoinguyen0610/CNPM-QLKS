package Check_in;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

public class CheckInController {

    @FXML
    private SplitPane SplitPane_1;

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
    private ButtonBar Bar_button1;

    @FXML
    private Button Button_DatPhong;

    @FXML
    private Button Button_Reset;

    @FXML
    private Label DKTP_Label;

    @FXML
    private ToggleButton Button_DP_Truoc;

    @FXML
    private ToggleButton Button_DP_TaiQuay;

    @FXML
    private AnchorPane AnchorPane1;

    @FXML
    private ScrollPane ScrollPane;

    @FXML
    private TableView<?> Table_Check_In;

    @FXML
    private TableColumn<?, ?> Tbl_Col_STT;

    @FXML
    private TableColumn<?, ?> Tbl_Col_KH;

    @FXML
    private TableColumn<?, ?> Tbl_Col_CMND;

    @FXML
    private TableColumn<?, ?> Tbl_Col_SDT;

    @FXML
    private TableColumn<?, ?> Tbl_Col_SNCP;

    @FXML
    private TableColumn<?, ?> Tbl_Col_MaDP;

    @FXML
    private TableColumn<?, ?> Tbl_Col_LoaiP;

    @FXML
    private TableColumn<?, ?> Tbl_Col_LoaiPhong;

    @FXML
    private TableColumn<?, ?> Tbl_Col_NgayDat;

    @FXML
    private TableColumn<?, ?> Tbl_Col_NgayNhan;

    @FXML
    private TableColumn<?, ?> Tbl_Col_SoNgayO;

}
