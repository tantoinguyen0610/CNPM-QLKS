package NhanVien;


import java.io.IOException;
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

import Check_in.ModelTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import NhanVien.SuaNVController;

public class NhanVienController implements Initializable {

    @FXML
    private ScrollPane ScrollPane1;

    @FXML
    private TableView<TableNhanVien> Table_NhanVien;

    @FXML
    private TableColumn<TableNhanVien, Integer> Col_STT;

    @FXML
    private TableColumn<TableNhanVien, String> Col_Ten;

    @FXML
    private TableColumn<TableNhanVien, String> Col_ChucVu;

    @FXML
    private TableColumn<TableNhanVien, Integer> Col_CaLam;

    @FXML
    private TableColumn<TableNhanVien, String> Col_TrangThai;

    @FXML
    private TableColumn<TableNhanVien, String> Col_NgayLamViec;

    @FXML
    private TableColumn<TableNhanVien, String> Col_GioVao;

    @FXML
    private TableColumn<TableNhanVien, String> Col_GioRa;

    @FXML
    private TableColumn Col_NhiemVu;

    @FXML
    private TableColumn Col_GhiChu;
    
    @FXML
    private TableColumn<TableNhanVien, Integer> Col_SDT;
    
    @FXML
    private TableColumn<TableNhanVien, String> Col_GioiTinh;

    @FXML
    private TableColumn<TableNhanVien, String> Col_NgaySinh;

    @FXML
    private Label BangNV_Label;

    @FXML
    private Button Button_ChamCong;

    @FXML
    private Button Button_ThemNV;

    @FXML
    private Button Button_Sua;

    @FXML
    private Button Button_Xoa;
    
    @FXML
    private Button Button_Refresh;
    
    @FXML
    private Label MaNV_Label;

    @FXML
    private Label HoTenNV_Label;

    @FXML
    private Label ChucVu_Label;

    @FXML
    private Label NgayBatDau_Label;

    @FXML
    private Label GioiTinh_Label;

    @FXML
    private Label NgaySinh_Label;

    @FXML
    private TextField MaNV_textField;

    @FXML
    private TextField TenNV_textField;

    @FXML
    private DatePicker NgayBatDau_DatePicker;

    @FXML
    private ComboBox<String> GioiTinh_cmbBox;

    @FXML
    private DatePicker NgaySinh_DatePicker;

    @FXML
    private ComboBox<String> ChucVu_cmbBox;

    @FXML
    private Label CaLam_Label;

    @FXML
    private ComboBox<String> CaLam_Cmb;

    @FXML
    private Label SDT_Label;

    @FXML
    private TextField SDT_textField;

    @FXML
    private Label err_TenNV;

    @FXML
    private Label err_CaLam;

    @FXML
    private Label err_GioiTinh;

    @FXML
    private Label err_NgayBatDau;

    @FXML
    private Label err_NgaySinh;

    @FXML
    private Label err_ChucVu;

    @FXML
    private Label err_SDT;
    
    @FXML
    private Button Button_NhiemVu;

    @FXML
    private Button Button_DanhGia;
    
    @FXML
    private Label TT_Label;
    
    @FXML
    private ComboBox<String> TrangThai_cmb;


    
    ObservableList<TableNhanVien> listnv = FXCollections.observableArrayList();
    ObservableList<String> list_gioitinh = FXCollections.observableArrayList("Nam","Nữ");
    ObservableList<String> list_chucvu = FXCollections.observableArrayList("Quản Lý","Kế Toán","Lễ Tân");
    ObservableList<String> list_calam = FXCollections.observableArrayList("1", "2","3");
    ObservableList<String> list_trangthai = FXCollections.observableArrayList("Online","Offline");
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
    	HienTableNhanVien();
    	GioiTinh_cmbBox.setItems(list_gioitinh);
    	ChucVu_cmbBox.setItems(list_chucvu);
    	CaLam_Cmb.setItems(list_calam);
    	TrangThai_cmb.setItems(list_trangthai);
    	ChuyenNguocNamThangNgay();
    	autoTaoMaNV();
    	HienDataLenTextField();
    	Button_Xoa.setDisable(true);
	}
    
    public void HienTableNhanVien() {
		 try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("select * from nhanvien ");
					
				while (rs.next()) {	
					listnv.add(new TableNhanVien(rs.getString("MANV"),rs.getString("TENNV"),
							rs.getString("CHUCVU"),rs.getString("CA_LAM"),rs.getString("TRANGTHAI"),
							rs.getString("NGAYLAMVIEC"), rs.getString("SDT"),rs.getString("GIOITINH"),rs.getString("NGAYSINH")));
				}
				Col_STT.setCellValueFactory(new PropertyValueFactory<>("MANV"));
			 	Col_Ten.setCellValueFactory(new PropertyValueFactory<>("TENNV"));
			 	Col_ChucVu.setCellValueFactory(new PropertyValueFactory<>("CHUCVU"));
			 	Col_CaLam.setCellValueFactory(new PropertyValueFactory<>("CA_LAM"));
			 	Col_TrangThai.setCellValueFactory(new PropertyValueFactory<>("TRANGTHAI"));
			 	Col_NgayLamViec.setCellValueFactory(new PropertyValueFactory<>("NGAYLAMVIEC"));
			 	Col_SDT.setCellValueFactory(new PropertyValueFactory<>("SDT"));
				Col_GioiTinh.setCellValueFactory(new PropertyValueFactory<>("GIOITINH"));
				Col_NgaySinh.setCellValueFactory(new PropertyValueFactory<>("NGAYSINH"));
				Table_NhanVien.setItems(listnv);
		 }
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
		 	
	}

    @FXML
    void ChamCong_ActionListener(ActionEvent event) {

    }

    @FXML
    void SuaNV_ActionListener(ActionEvent event) throws Exception {
				try {
					final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
					Connection conn = DriverManager.getConnection(DB_URL,"root","");
					String value0 = MaNV_textField.getText();
					String value1 = TenNV_textField.getText();
					String value2 = ChucVu_cmbBox.getValue().toString();
					String value3 = GioiTinh_cmbBox.getValue().toString();
					String value4 = SDT_textField.getText();
					String value5 = CaLam_Cmb.getValue().toString();
					String value6 = ((TextField)NgayBatDau_DatePicker.getEditor()).getText();
					String value7 = ((TextField)NgaySinh_DatePicker.getEditor()).getText();
					String value8 = TrangThai_cmb.getValue().toString();
					
					String sql = "update nhanvien set TENNV= '"+value1+"',CHUCVU='"+value2+"', GIOITINH='"+value3+"', SDT='"+value4+"', CA_LAM='"+value5+"', NGAYLAMVIEC='"+value6+"', NGAYSINH='"+value7+"', TRANGTHAI= '"+value8+"' where MANV='"+value0+"'";
					PreparedStatement pst = conn.prepareStatement(sql);	
					pst.execute();
					JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
				}catch(Exception e) {
					e.printStackTrace();
				}
    }

    @FXML
    void ThemNV_ActionListener(ActionEvent event) throws Exception {
    	if(KiemTraTenNV() & KiemTraChucVu() & 
    			KiemTraGioiTinh() & KiemTraSDT() &
    			KiemTraCaLam() & KiemTraBatDauLam() & 
    			KiemTraNgaySinh()) {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query = "insert into `nhanvien`(MaNV,TENNV,CHUCVU,GIOITINH,SDT,CA_LAM,NGAYLAMVIEC,NGAYSINH,TRANGTHAI) "
							+ "VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, MaNV_textField.getText());
			pst.setString(2, TenNV_textField.getText());
			pst.setString(3, ChucVu_cmbBox.getValue().toString());
			pst.setString(4, GioiTinh_cmbBox.getValue().toString());
			pst.setString(5, SDT_textField.getText());
			pst.setString(6, CaLam_Cmb.getValue().toString());
			pst.setString(7,((TextField)NgayBatDau_DatePicker.getEditor()).getText());
			pst.setString(8,((TextField)NgaySinh_DatePicker.getEditor()).getText());
			pst.setString(9, TrangThai_cmb.getValue().toString());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
			autoTaoMaNV();
		}
	catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
    	listnv.clear();
    	HienTableNhanVien();
    	}
    }

    @FXML
    void XoaNV_ActionListener(ActionEvent event) {
    	if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá nhân viên này?","Cảnh Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    	Table_NhanVien.getItems().removeAll(Table_NhanVien.getSelectionModel().getSelectedItems());
    	
    	String sql = "delete from nhanvien where MANV = ?";
    	try {
    		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
    		Connection conn = DriverManager.getConnection(DB_URL,"root","");
    		PreparedStatement pst = conn.prepareStatement(sql);
    		pst.setString(1, MaNV_textField.getText());
    		pst.execute();
    		JOptionPane.showMessageDialog(null, "Xoá Thành Công");
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    	}
    	else {
    		listnv.clear();
        	HienTableNhanVien();
        	autoTaoMaNV();
    	}
    }
    
    @FXML
    void Refresh_ActionListener(ActionEvent event) {
    	listnv.clear();
    	HienTableNhanVien();
    	ResetTextField();
    	autoTaoMaNV();
    }
    
    private boolean KiemTraTenNV() {
		Pattern p = Pattern.compile("^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+$");
		Matcher m = p.matcher(TenNV_textField.getText());
		if(m.find() && m.group().equals(TenNV_textField.getText())){
			return true;
		}
		else {
			err_TenNV.setText("Vui lòng điền tên hợp lệ");
			return false;
		}
	}
    
    private boolean KiemTraChucVu() {
		
		if(ChucVu_cmbBox.getSelectionModel().isEmpty())
			{
			err_ChucVu.setText("Vui lòng chọn chức vụ");
			return false;
			}
		return true;
	}
    
    private boolean KiemTraGioiTinh() {
		
		if(GioiTinh_cmbBox.getSelectionModel().isEmpty())
			{
			err_GioiTinh.setText("Vui lòng chọn giới tính");
			return false;
			}
		return true;
	}
    
    private boolean KiemTraSDT() {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(SDT_textField.getText());
		if(m.find() && m.group().equals(SDT_textField.getText())){
			return true;
		}
		else {
			err_SDT.setText("Vui lòng điền số hợp lệ");
			return false;
		}
	}
    
    private boolean KiemTraCaLam() {
		
		if(CaLam_Cmb.getSelectionModel().isEmpty())
			{
			err_CaLam.setText("Vui lòng chọn ca làm");
			return false;
			}
		return true;
	}
    
    private boolean KiemTraBatDauLam() {
    	
		if(((TextField)NgayBatDau_DatePicker.getEditor()).getText().isEmpty())
				
			{
			err_NgayBatDau.setText("Vui lòng nhập ngày bắt đầu hợp lệ");
			return false;
			}
		return true;
	}
    
    private boolean KiemTraNgaySinh() {
    	
		if(((TextField)NgaySinh_DatePicker.getEditor()).getText().isEmpty())
				
			{
			err_NgaySinh.setText("Vui lòng nhập ngày sinh hợp lệ");
			return false;
			}
		return true;
	}
    
    
    

    public void ChuyenNguocNamThangNgay()
	{
    	NgayBatDau_DatePicker.setConverter(
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
    	NgaySinh_DatePicker.setConverter(
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
	
    public void autoTaoMaNV() {
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			Statement s= conn.createStatement();
			
			ResultSet rs = s.executeQuery("select Max(MANV) from nhanvien");
			rs.next();
			rs.getString("Max(MANV)");
			
			if(rs.getString("Max(MANV)")== null)
			{
				MaNV_textField.setText("1");
			}
			else
			{
				int mapt = Integer.parseInt(rs.getString("Max(MANV)"));
				mapt++;
				MaNV_textField.setText(String.format("%d",mapt));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    private void HienDataLenTextField() {
    	Table_NhanVien.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		@Override
    		public void handle(MouseEvent event) {
    			TableNhanVien tbl_nv = Table_NhanVien.getItems().get(Table_NhanVien.getSelectionModel().getSelectedIndex());
    			MaNV_textField.setText(tbl_nv.getMANV());
    			TenNV_textField.setText(tbl_nv.getTENNV());
    			ChucVu_cmbBox.setValue(tbl_nv.getCHUCVU());
    			CaLam_Cmb.setValue(tbl_nv.getCA_LAM());
    			TrangThai_cmb.setValue(tbl_nv.getTRANGTHAI());
    			((TextField)NgayBatDau_DatePicker.getEditor()).setText(tbl_nv.getNGAYLAMVIEC());
    			SDT_textField.setText(tbl_nv.getSDT());
    			GioiTinh_cmbBox.setValue(tbl_nv.getGIOITINH());
    			((TextField)NgaySinh_DatePicker.getEditor()).setText(tbl_nv.getNGAYSINH());
    			Button_Xoa.setDisable(false);
    		}
    		
    	});
    }
    
    public void ResetTextField() {
    	TenNV_textField.setText("");
		ChucVu_cmbBox.getSelectionModel().clearSelection();
		CaLam_Cmb.getSelectionModel().clearSelection();
		TrangThai_cmb.getSelectionModel().clearSelection();
		NgayBatDau_DatePicker.getEditor().clear();
		SDT_textField.setText("");
		GioiTinh_cmbBox.getSelectionModel().clearSelection();
		NgaySinh_DatePicker.getEditor().clear();
    }
    
    
    
}
