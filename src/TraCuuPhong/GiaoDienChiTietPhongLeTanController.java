package TraCuuPhong;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.event.*;
import javafx.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.*;



import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class GiaoDienChiTietPhongLeTanController implements Initializable {
	
	
	
	@FXML
    private AnchorPane Ap;

    @FXML
    private Label lbSonguoichophep;

    @FXML
    private Label lbSonguoihientai;

    @FXML
    private Label lbTrangthai;

    @FXML
    private Label lbPhong;

    @FXML
    private ComboBox<String> cbSonguoihientai;

    @FXML
    private TextField tfSonguoichophep;

    @FXML
    private ComboBox<String> cbTrangthai;

    @FXML
    private Button btchecklist;

    @FXML
    private Button btThoat;

    @FXML
    private Button btCapnhat;

    @FXML
    private Button btChinhsua;
    
    @FXML
    private Button btLuu;
    
    @FXML
    private void btthoataction(){
        // get a handle to the stage
        Stage stage = (Stage) btThoat.getScene().getWindow();
        // do what you have to do
        stage.close();

    }
    

    ObservableList<String> listsonguoihientai = FXCollections.observableArrayList("","1", "2", "3","4");
    ObservableList<String> listtrangthai = FXCollections.observableArrayList("","Đang sử dụng", "Sắp trả", "Đặt trước","Thanh toán");
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbSonguoihientai.setItems(listsonguoihientai);
        cbTrangthai.setItems(listtrangthai);
        tfSonguoichophep.setEditable(false);
        cbTrangthai.setDisable(true);
        cbSonguoihientai.setDisable(true);
        
        
        
    }
   
    public void comboBoxChanged (ActionEvent event) {
    	//cbSonguoihientai.setVisible(false);
        
    }
    
    public void comboBoxChanged1(ActionEvent event) {
    	
    }
    
   
    public void btactionchinhsua(ActionEvent event) {
    	tfSonguoichophep.setEditable(false);
        cbTrangthai.setDisable(false);
        cbSonguoihientai.setDisable(false);
    }
    
    
    public void btactionluu(ActionEvent event) {
    	tfSonguoichophep.setEditable(false);
        cbTrangthai.setDisable(true);
        cbSonguoihientai.setDisable(true);
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query = "insert into `phong`(SONGUOIHIENTAI,TINHTRANG) VALUES(?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			String value = cbSonguoihientai.getValue().toString();
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

    
    
    
    @FXML
    void btchecklist(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("CheckListPhong.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }
    
    
    
}
	
