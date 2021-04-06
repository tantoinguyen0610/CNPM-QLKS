package QuanLyPhong;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;

public class BangKiemTraDinhKiController implements Initializable {

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
    private Button btThoat;

    @FXML
    private AnchorPane Ap1;

    @FXML
    private Label lbngaykiemtra;

    @FXML
    private Label lbghichu;

    @FXML
    private Label lbnvkiemtra;

    @FXML
    private Label lbGioketthuc;

    @FXML
    private Label lbGiobatdau;

    @FXML
    private Label lbTrangthaisausuachua;

    @FXML
    private Button btThem;

    @FXML
    private DatePicker dtNgaykiemtra;

    @FXML
    private TextField tfGioketthuc;

    @FXML
    private TextField tfNhanvienkiemtra;

    @FXML
    private TextField tfGhichu;

    @FXML
    private ComboBox<String> cbTrangthaisausuachua;

    @FXML
    private TextField tfGiobatdau;

    @FXML
    private Button btReset;

    @FXML
    void btReset(ActionEvent event) {

    }

    @FXML
    void btThembangkiemtradinhki(ActionEvent event) {

    }

    @FXML
    void btThoat(ActionEvent event) {

    }
    
    ObservableList<String> cb_Trangthaisausuachua = FXCollections.observableArrayList("","Bình thường", "Cần sửa chữa", "Cần thay thế");
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbTrangthaisausuachua.setItems(cb_Trangthaisausuachua);
     

    }
}
