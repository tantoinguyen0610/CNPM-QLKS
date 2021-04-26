package QuanLyPhong;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class HoaDonNangCapPhongController implements Initializable {

    @FXML
    private Label ThongTinHoaDonNCPLabel;

    @FXML
    private Label SoPhongLabel;

    @FXML
    private Label LiDoNangCapLabel;

    @FXML
    private Label NgayBatDauLabel;

    @FXML
    private Label NgayKetThucLabel;

    @FXML
    private Label TinhTrangNangCapLabel;

    @FXML
    private Label ChiPhiNangCapLabel;

    @FXML
    private Label TongTienLabel;

    @FXML
    private TextField LiDoNangCapTextField;

    @FXML
    private TextField TinhTrangNangCapTextField;

    @FXML
    private TextField ChiPhiNangCapTextField;

    @FXML
    private TextField TongTienTextField;

    @FXML
    private Button DongButton;

    @FXML
    private Button LuuButton;

    @FXML
    private TextField MaHD_textField;

    @FXML
    private ComboBox<String> SoPhong_cmb;

    @FXML
    private DatePicker NgayBD;

    @FXML
    private DatePicker NgayKT;

    @FXML
    private Label err_SoPhong;

    @FXML
    private Label err_LiDoNangCap;

    @FXML
    private Label err_NgayBD;

    @FXML
    private Label err_NgayKT;

    @FXML
    private Label err_TinhTrang;

    @FXML
    private Label err_ChiPhi;

    @FXML
    private Label err_TongTien;
    
    ObservableList<String> listsophong = FXCollections.observableArrayList("101", "102","103","104","105","106");

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	SoPhong_cmb.setItems(listsophong);
    	ChuyenNguocNamThangNgay();
	}
    
    @FXML
    void DongButtonListener(ActionEvent event) {
    	Stage stage = (Stage) DongButton.getScene().getWindow();
	    stage.close();
    }
    

    @FXML
    void LuuButtonListener(ActionEvent event) {
    	if(KiemTraSoPhong() & KiemTraLiDo() & KiemTraNgayBD() & KiemTraNgayKT() & KiemTraTinhTrang()&KiemTraChiPhi()&KiemTraTongTien()) {
        	try {
    			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
    			Connection conn = DriverManager.getConnection(DB_URL,"root","");
    			String query = "insert into hoa_don (MA_HD,LOAI_HD,SOPHONG,LIDONANGCAP,NGAYBD,NGAYKT,TINHTRANG,CHIPHI,TONGTIEN,DUYETTHANHTOAN) "
    							+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
    			PreparedStatement pst = conn.prepareStatement(query);
    			pst.setString(1,MaHD_textField.getText() );
    			pst.setString(2, "Nâng Cấp Phòng");
    			pst.setString(3, SoPhong_cmb.getValue().toString());
    			pst.setString(4,LiDoNangCapTextField.getText());
    			pst.setString(5,((TextField)NgayBD.getEditor()).getText() );
    			pst.setString(6, ((TextField)NgayKT.getEditor()).getText());
    			pst.setString(7,TinhTrangNangCapTextField.getText());
    			pst.setString(8, ChiPhiNangCapTextField.getText());
    			pst.setString(9, TongTienTextField.getText());
    			pst.setString(10, "Chưa Thanh Toán");
    			pst.executeUpdate();
    			
    			JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
    		}
    	catch(Exception e) {
    			JOptionPane.showMessageDialog(null, "Lỗi!" + e);
    		}
        	
        	}
    }
    
    private boolean KiemTraSoPhong() {
    	if(SoPhong_cmb.getSelectionModel().isEmpty())
		{
		err_SoPhong.setText("Vui lòng chọn số phòng");
		return false;
		}
	return true;
    }
    
    private boolean KiemTraLiDo() {
    	
    	if(LiDoNangCapTextField.getText().isEmpty())
    		{
    		err_SoPhong.setText("Vui lòng nhập lí do");
    		return false;
    		}
    	return true;
    }
    
    private boolean KiemTraNgayBD() {
    	
		if(((TextField)NgayBD.getEditor()).getText().isEmpty())
				
			{
			err_NgayBD.setText("Vui lòng nhập ngày bắt đầu hợp lệ");
			return false;
			}
		return true;
	}
    
    
    
 private boolean KiemTraNgayKT() {
    	
		if(((TextField)NgayKT.getEditor()).getText().isEmpty())
				
			{
			err_NgayKT.setText("Vui lòng nhập ngày kết thúc hợp lệ");
			return false;
			}
		return true;
	}
    
 private boolean KiemTraTinhTrang() {
		Pattern p = Pattern.compile("^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+$");
		Matcher m = p.matcher(TinhTrangNangCapTextField.getText());
		if(m.find() && m.group().equals(TinhTrangNangCapTextField.getText())){
			return true;
		}
		else {
			err_TinhTrang.setText("Vui lòng điền tên hợp lệ");
			return false;
		}
	}
 
 private boolean KiemTraChiPhi() {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(ChiPhiNangCapTextField.getText());
		if(m.find() && m.group().equals(ChiPhiNangCapTextField.getText())){
			return true;
		}
		else {
			err_ChiPhi.setText("Vui lòng điền số ngày ở hợp lệ");
			return false;
		}
	}
 
 private boolean KiemTraTongTien() {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(TongTienTextField.getText());
		if(m.find() && m.group().equals(TongTienTextField.getText())){
			return true;
		}
		else {
			err_TongTien.setText("Vui lòng điền số ngày ở hợp lệ");
			return false;
		}
	}
    
    public void ChuyenNguocNamThangNgay()
    {
    	NgayBD.setConverter(
    			   new StringConverter<LocalDate>() {
    			          final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    			          @Override
    			          public String toString(LocalDate date) {
    			            return (date != null) ? dateFormatter.format(date) : "";
    			          }

    			          @Override
    			          public LocalDate fromString(String string) {
    			            return (string != null && !string.isEmpty())
    			                ? LocalDate.parse(string, dateFormatter)
    			                : null;
    			          }
    			        });
    	
    	NgayKT.setConverter(
 			   new StringConverter<LocalDate>() {
 			          final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

 			          @Override
 			          public String toString(LocalDate date) {
 			            return (date != null) ? dateFormatter.format(date) : "";
 			          }

 			          @Override
 			          public LocalDate fromString(String string) {
 			            return (string != null && !string.isEmpty())
 			                ? LocalDate.parse(string, dateFormatter)
 			                : null;
 			          }
 			        });
    }


	

}
