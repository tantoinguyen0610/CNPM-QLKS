package QuanLyPhong;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class BangKiemTraDinhKiController {

    @FXML
    private AnchorPane Ap;

    @FXML
    private TableView<?> tbview1;

    @FXML
    private TableColumn<?, ?> tcSTT;

    @FXML
    private TableColumn<?, ?> tcNgaykiemtra;

    @FXML
    private TableColumn<?, ?> tcGiobatdau;

    @FXML
    private TableColumn<?, ?> tcGioketthuc;

    @FXML
    private TableColumn<?, ?> tcTrangthaisausuachua;

    @FXML
    private TableColumn<?, ?> tcGhichu;

    @FXML
    private TableColumn<?, ?> tcNhanvienkiemtra;

    @FXML
    private Label lbbangkiemtradinhki;

    @FXML
    private Button btLuu;

    @FXML
    private Button btThoat;

}
