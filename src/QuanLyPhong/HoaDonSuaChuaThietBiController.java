package QuanLyPhong;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class HoaDonSuaChuaThietBiController implements Initializable {

    @FXML
    private Label ThongTinHoaDonSCTBLabel;

    @FXML
    private Label TênTBLabel;

    @FXML
    private Label SoLuongLabel;

    @FXML
    private Label NgayBatDauLabel;

    @FXML
    private Label NgayKetThucLabel;

    @FXML
    private Label TinhTrangSuaLabel;

    @FXML
    private Label ChiPhiSuaChuaLabel;

    @FXML
    private Label TongTienLabel;

    @FXML
    private TextField TenTBTextField;

    @FXML
    private TextField SoLuongTextField;

    @FXML
    private TextField TinhTrang_textField;

    @FXML
    private TextField ChiPhiSuaChuaTextField;

    @FXML
    private TextField TongTienTextField;

    @FXML
    private Button DongButton;

    @FXML
    private Button LuuButton;

    @FXML
    private TextField HD_textField;
    
    @FXML
    private TextField MaTB_textField;


    @FXML
    private DatePicker NgayBD;

    @FXML
    private DatePicker NgayKT;

    @FXML
    private Label err_TenTB;

    @FXML
    private Label err_SoLuong;

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
    
    @FXML
    private Label err_MaTB;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	autoTaoMaHD();
    	ChuyenNguocNamThangNgay();
	}

    @FXML
    void ChiPhiSuaChuaTextFieldListener(ActionEvent event) {

    }

    @FXML
    void DongButtonListener(ActionEvent event) {
    	Stage stage = (Stage) DongButton.getScene().getWindow();
	    stage.close();
    }

    @FXML
    void LuuButtonListener(ActionEvent event) {
    	if(KiemTraTenTB() & KiemTraSoLuong() & KiemTraNgayBD() & KiemTraNgayKT() & KiemTraTinhTrang()&KiemTraChiPhi()&KiemTraTongTien()&KiemTraMaTB()) {
        	try {
    			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
    			Connection conn = DriverManager.getConnection(DB_URL,"root","");
    			String query = "insert into hoa_don (MA_HD,MA_TB,TENTB,LOAI_HD,SOLUONG,NGAYBD,NGAYKT,TINHTRANG,CHIPHI,TONGTIEN,DUYETTHANHTOAN) "
    							+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    			PreparedStatement pst = conn.prepareStatement(query);
    			pst.setString(1,HD_textField.getText() );
    			pst.setString(2, MaTB_textField.getText());
    			pst.setString(3, TenTBTextField.getText());
    			pst.setString(4,"Sửa Chữa Thiết Bị");
    			pst.setString(5,SoLuongTextField.getText() );
    			pst.setString(6,((TextField)NgayBD.getEditor()).getText());
    			pst.setString(7,((TextField)NgayKT.getEditor()).getText());
    			pst.setString(8, TinhTrang_textField.getText());
    			pst.setString(9, ChiPhiSuaChuaTextField.getText());
    			pst.setString(10, TongTienTextField.getText());
    			pst.setString(11, "Chưa Thanh Toán");
    			pst.executeUpdate();
    			
    			JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
    		}
    	catch(Exception e) {
    			JOptionPane.showMessageDialog(null, "Lỗi!" + e);
    		}
        	autoTaoMaHD();
        	}
    }
    private boolean KiemTraMaTB() {
    	Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(MaTB_textField.getText());
		if(m.find() && m.group().equals(MaTB_textField.getText())){
			return true;
		}
		else {
			err_MaTB.setText("Vui lòng điền mã thiết bị!");
			return false;
		}
    }
    
    private boolean KiemTraTenTB() {
    	if(TenTBTextField.getText().isEmpty())
		{
		err_TenTB.setText("Vui lòng nhập tên thiết bị");
		return false;
		}
	return true;
    }
    
    private boolean KiemTraSoLuong() {
    	Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(SoLuongTextField.getText());
		if(m.find() && m.group().equals(SoLuongTextField.getText())){
			return true;
		}
		else {
			err_SoLuong.setText("Vui lòng điền số lượng hợp lệ");
			return false;
		}
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
		Matcher m = p.matcher(TinhTrang_textField.getText());
		if(m.find() && m.group().equals(TinhTrang_textField.getText())){
			return true;
		}
		else {
			err_TinhTrang.setText("Vui lòng điền tình trạng hợp lệ");
			return false;
		}
	}
 
 private boolean KiemTraChiPhi() {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(ChiPhiSuaChuaTextField.getText());
		if(m.find() && m.group().equals(ChiPhiSuaChuaTextField.getText())){
			return true;
		}
		else {
			err_ChiPhi.setText("Vui lòng điền chi phí hợp lệ");
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


    @FXML
    void TenTBTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TongTienTextFieldListener(ActionEvent event) {

    }

    @FXML
    void TìnhTrangSuaTextFieldListener(ActionEvent event) {

    }

    public void autoTaoMaHD() {
    	try {
    		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
    		Connection conn = DriverManager.getConnection(DB_URL,"root","");
    		Statement s= conn.createStatement();
    		
    		ResultSet rs = s.executeQuery("select Max(MA_HD) from hoa_don");
    		rs.next();
    		rs.getString("Max(MA_HD)");
    		
    		if(rs.getString("Max(MA_HD)")== null)
    		{
    			HD_textField.setText("1");
    		}
    		else
    		{
    			int matb = Integer.parseInt(rs.getString("Max(MA_HD)"));
    			matb++;
    			HD_textField.setText(String.format("%d",matb));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }


}
