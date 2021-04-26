package TraCuuPhong;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Phong104Controller implements Initializable {

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
    private TextField SoNgChoPhep_textField;

    @FXML
    private ComboBox<String> cbTrangthai;

    @FXML
    private Button btThoat;

    @FXML
    private Button btChinhsua;

    @FXML
    private Button btLuu;

    @FXML
    private TextField SoPhong_textField;
    
    ObservableList<String> listtrangthai = FXCollections.observableArrayList("Trống","Đã sử dụng", "Sắp trả", "Đặt trước","Thanh toán");
    ObservableList<String> listhientai= FXCollections.observableArrayList("1","2","3","4");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbSonguoihientai.setItems(listhientai);
		cbTrangthai.setItems(listtrangthai);
		HienTextField();
		cbSonguoihientai.setDisable(true);
		cbTrangthai.setDisable(true);
		btLuu.setDisable(true);
		
	}
	
	 public void HienTextField() {
	    	try {
				final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
				Connection conn = DriverManager.getConnection(DB_URL,"root","");
				String query1 = "SELECT TEN_PHONG ,SOLUONGNGUOIO,SONGUOIO,TINHTRANG from phong,loai_phong WHERE phong.MA_PHONG='4' and phong.MA_LOAIPHONG=loai_phong.MA_LOAIPHONG";
				 PreparedStatement pst1 = conn.prepareStatement(query1);
				 ResultSet rs1 = pst1.executeQuery();
				 while(rs1.next()) {
					 SoPhong_textField.setText(rs1.getString("TEN_PHONG"));
					 SoNgChoPhep_textField.setText(rs1.getString("SOLUONGNGUOIO"));
					 cbSonguoihientai.setValue(rs1.getString("SONGUOIO"));
					 cbTrangthai.setValue(rs1.getString("TINHTRANG"));
				 }
			}
				catch(Exception e) {
					 JOptionPane.showMessageDialog(null, "Lỗi: "+  e);
				}
		}

    @FXML
    void btactionchinhsua(ActionEvent event) {
    	cbSonguoihientai.setDisable(false);
		cbTrangthai.setDisable(false);
		btLuu.setDisable(false);
    }

    @FXML
    void btactionluu(ActionEvent event) {
    	int response=	JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn lưu cập nhật?", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     	if(response == JOptionPane.YES_OPTION) {
     		try {
    			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
    			Connection conn = DriverManager.getConnection(DB_URL,"root","");
    			String value0 = SoPhong_textField.getText();
    			String value1 = cbSonguoihientai.getValue().toString();
    			String value2 =  cbTrangthai.getValue().toString();
    			String sql = "UPDATE `phong` SET `SONGUOIO` = '"+value1+"', `TINHTRANG` = '"+value2+"' where `TEN_PHONG`='"+value0+"' ";
    			PreparedStatement pst = conn.prepareStatement(sql);	
    			pst.execute();
    			JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
     		
     	}
     	else if(response == JOptionPane.NO_OPTION){
     		
     	}
    	
    }

    @FXML
    void btthoataction(ActionEvent event) {
    	Stage stage = (Stage) btThoat.getScene().getWindow();
	    stage.close();
    }


}
