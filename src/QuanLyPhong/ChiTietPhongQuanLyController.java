package QuanLyPhong;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;

public class ChiTietPhongQuanLyController implements Initializable {

	@FXML
    private AnchorPane Ap;

    @FXML
    private Label lbThietbi;

    @FXML
    private Label lbKiemtradinhki;

    @FXML
    private Label lbTrangthai;

    @FXML
    private Label lbPhong;

    @FXML
    private ComboBox<String> cbSonguoichophep;

    @FXML
    private ComboBox<String> cbTrangthai;

    @FXML
    private Button btThoat;

    @FXML
    private Label lbSonguoichophep;

    @FXML
    private Button btThietbi;

    @FXML
    private Button btKiemtradinhki;

    @FXML
    private Button btChinhsua;

    @FXML
    private Button btLuu;


    @FXML
    private void btthoat() {
    	// get a handle to the stage
        Stage stage = (Stage) btThoat.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    
    ObservableList<String> listsonguoichophep = FXCollections.observableArrayList("","1", "2", "3","4");
    ObservableList<String> listtrangthai = FXCollections.observableArrayList("","Đang sử dụng", "Sắp trả", "Đặt trước","Thanh toán");
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbSonguoichophep.setItems(listsonguoichophep);
        cbTrangthai.setItems(listtrangthai);
        cbSonguoichophep.setDisable(true);
        cbTrangthai.setDisable(true);
        btThietbi.setDisable(true);
        btKiemtradinhki.setDisable(true);
        btLuu.setDisable(true);
        
 
    }
    @FXML
    void btactionthietbi() throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("ChiTietThietBi.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }
    @FXML
    void btactiondinhki() throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("BangKiemTraDinhKi.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }
    
    public void btchinhsua(ActionEvent event) {
    	cbSonguoichophep.setDisable(false);
        cbTrangthai.setDisable(false);
        btChinhsua.setDisable(true);
        btThietbi.setDisable(false);
        btKiemtradinhki.setDisable(false);
        btLuu.setDisable(false);
    }
    
    public void btactionLuu(ActionEvent event) {
    	cbSonguoichophep.setDisable(true);
        cbTrangthai.setDisable(true);
        btChinhsua.setDisable(false);
        btThietbi.setDisable(true);
        btKiemtradinhki.setDisable(true);
        btLuu.setDisable(true);
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query = "insert into `phong`(SONGUOIO,TINHTRANG) VALUES(?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			String value = cbSonguoichophep.getValue().toString();
			pst.setString(1, value);
			String value1 = cbTrangthai.getValue().toString();
			pst.setString(2, value1);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Lưu Thành Công!"); 
        }
        catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
    }
    
}
