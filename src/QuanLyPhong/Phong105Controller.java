package QuanLyPhong;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Phong105Controller implements Initializable {

	 @FXML
	    private AnchorPane Ap;

	    @FXML
	    private Label lbThietbi;

	    @FXML
	    private Label lbTrangthai;

	    @FXML
	    private Label lbPhong;

	    @FXML
	    private ComboBox<String> cbTrangthai;

	    @FXML
	    private Label lbSonguoichophep;

	    @FXML
	    private Button btThietbi;


	    @FXML
	    private Label SoPhong_Label;

	    @FXML
	    private TextField SoPhong_textField;

	    @FXML
	    private Button btLuu;

	    @FXML
	    private Button btChinhsua;

	    @FXML
	    private Button btThoat;

	    @FXML
	    private TextField cbSonguoichophep;
    
    ObservableList<String> listtrangthai = FXCollections.observableArrayList("Trống","Đã sử dụng", "Sắp trả", "Đặt trước","Thanh toán");
    
    @Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
    	
         cbTrangthai.setItems(listtrangthai);
         cbSonguoichophep.setDisable(true);
         cbTrangthai.setDisable(true);
         btThietbi.setDisable(true);
         
         btLuu.setDisable(true);
         HienTextField();
		
    }
    
    public void HienTextField() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query1 = "SELECT TEN_PHONG ,SONGUOIO,TINHTRANG "
						+ "from phong "
						+ "WHERE MA_PHONG='5'";
			 PreparedStatement pst1 = conn.prepareStatement(query1);
			 ResultSet rs1 = pst1.executeQuery();
			 while(rs1.next()) {
				 SoPhong_textField.setText(rs1.getString("TEN_PHONG"));
				 cbSonguoichophep.setText(rs1.getString("SONGUOIO"));
				 cbTrangthai.setValue(rs1.getString("TINHTRANG"));
			 }
		}
			catch(Exception e) {
				 JOptionPane.showMessageDialog(null, "Lỗi: "+  e);
			}
	}
   

    @FXML
    void btactionLuu(ActionEvent event) {
    	try {						
   		 final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String value1 = cbTrangthai.getValue().toString();
			String value2 = cbSonguoichophep.getText();
			String value3 = SoPhong_textField.getText();
			String query1 = "UPDATE phong SET TINHTRANG = '"+value1+"', SONGUOIO = '"+value2+"' WHERE TEN_PHONG='"+value3+"' ";
			 PreparedStatement pst1 = conn.prepareStatement(query1);
			 pst1.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
			 }
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
    	Stage stage = (Stage) btLuu.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void btactiondinhki(ActionEvent event) {

    }

    @FXML
    void btactionthietbi(ActionEvent event)throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("TB105.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();   	
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void btchinhsua(ActionEvent event) {
    	cbSonguoichophep.setDisable(false);
        cbTrangthai.setDisable(false);
        btChinhsua.setDisable(true);
        btThietbi.setDisable(false);
       
        btLuu.setDisable(false);
    }

    @FXML
    void btthoat(ActionEvent event) {
    	Stage stage = (Stage) btThoat.getScene().getWindow();
	    stage.close();
    }

	
}
