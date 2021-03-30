package QuanLyPhong;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.*;

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

    @FXML
    private Button btThem;
    
    @FXML
    private void btThoat(){
        // get a handle to the stage
        Stage stage = (Stage) btThoat.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    @FXML
    void btThembangkiemtradinhki(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("ThemBangKTDK.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

}
