package QuanLiKhachHang;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BangDanhGiaKhachHangController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label BangDanhGiaCuaKhachHangLabel;

    @FXML
    private Button DongButton;

    @FXML
    private TableView<?> BangDanhGiaKhachHangTableView;

    @FXML
    private TableColumn<?, ?> MAPDGColumn;

    @FXML
    private TableColumn<?, ?> TenKHColumn;

    @FXML
    private TableColumn<?, ?> TenDanhGiaColumn;

    @FXML
    private TableColumn<?, ?> DanhGiaColumn;

    @FXML
    private TableColumn<?, ?> NhanXetColumn;

    @FXML
    void DongButtonListener(ActionEvent event) {

    }

   
    
}
