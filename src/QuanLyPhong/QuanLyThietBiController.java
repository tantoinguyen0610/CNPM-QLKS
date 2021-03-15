package QuanLyPhong;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class QuanLyThietBiController {

    @FXML
    private AnchorPane Ap;

    @FXML
    private TableView<?> tbview;

    @FXML
    private TableColumn<?, ?> tcSTT;

    @FXML
    private TableColumn<?, ?> tcMathietbi;

    @FXML
    private TableColumn<?, ?> tcTenthietbi;

    @FXML
    private TableColumn<?, ?> tcNgaynhapkho;

    @FXML
    private TableColumn<?, ?> tcNgayxuatkho;

    @FXML
    private TableColumn<?, ?> tcTinhtrang;

    @FXML
    private TableColumn<?, ?> tcVitri;

    @FXML
    private Label lbQuanlythietbi;

    @FXML
    private Button btLuu;

    @FXML
    private Button btThoat;

}
