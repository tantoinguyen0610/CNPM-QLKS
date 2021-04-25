package Check_out;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Check_in.ModelTable;
import HoaDon.TableHoaDonTTP;
import QuanLiKhachHang.PhieuDV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class HoaDonTraPhongController implements Initializable {
	@FXML
    private Label HDTP_Label;

    @FXML
    private Label TTHoaDon_Label;

    @FXML
    private Label MaKH_Label;

    @FXML
    private Label TenKH_Label;

    @FXML
    private Label SoPhong_Label;

    @FXML
    private Label GiaPhong_Label;

    @FXML
    private Label SoNgayO_Label;

    @FXML
    private Label NgayThanhToan_Label;

    @FXML
    private Label TongTienDV_Label;

    @FXML
    private Label TongTien_Label;

    @FXML
    private TextField Ma_KH_textField;

    @FXML
    private TextField TenKH_textField;

    @FXML
    private TextField SoPhong_textField;

    @FXML
    private TextField Gia_textField;

    @FXML
    private TextField SoNgayO_textField;

    @FXML
    private TextField Tien_DV_textField;

    @FXML
    private TextField TongCong_textField;

    @FXML
    private Label BangDV_Label;

    @FXML
    private Button Button_TaoHD;

    @FXML
    private Button Button_ThanhToan;

    @FXML
    private Button Button_In;

    @FXML
    private Button Button_Huy;

    @FXML
    private Label MaHD_Label;

    @FXML
    private TextField MaHD_textField;

    @FXML
    private Label MaPT_Label;

    @FXML
    private TextField MaPT_textField;

    @FXML
    private DatePicker NgayThanhToan_textField;

    @FXML
    private Label err_NgayTT;

    @FXML
    private Label MaPhieuDV_Label;

    @FXML
    private TextField MaPhieuDV_textField;

    @FXML
    private TableView<TableHoaDon> Table_HoaDon;

    @FXML
    private TableColumn<Integer, TableHoaDon> Tbl_Col_MaHD;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_MaPT;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_MaPhieuDV;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_MaKH;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_TenKH;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_NgayThanhToan;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_TienPhongNgay;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_TienDV;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_TongTien;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_TinhTrang;

    @FXML
    private TableView<PhieuDV> tbl_PDV;

    @FXML
    private TableColumn<Integer, PhieuDV> col_MaPhieu;

    @FXML
    private TableColumn<String, PhieuDV> col_SoPhong;

    @FXML
    private TableColumn<String, PhieuDV> col_TenDV;

    @FXML
    private TableColumn<String, PhieuDV> col_GiaTien;

    @FXML
    private TableColumn<String, PhieuDV> col_SoLuong;

    @FXML
    private TableColumn<String, PhieuDV> col_TongTien;
    
    @FXML
    private Button Load_Button;
    
    
ObservableList<TableHoaDon> hoadon = FXCollections.observableArrayList();
ObservableList<PhieuDV> phieudv = FXCollections.observableArrayList();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		HienTableHoaDon();
		ChuyenNguocNamThangNgay();
	}
	
	public void setHoaDonTraPhong(ModelTable traphong) {
		MaHD_textField.setText(String.valueOf(traphong.getMA_PT()));
		MaPT_textField.setText(String.valueOf(traphong.getMA_PT()));
		Ma_KH_textField.setText(String.valueOf(traphong.getMA_PT()));
		MaPhieuDV_textField.setText(String.valueOf(traphong.getMA_PT()));
		TenKH_textField.setText(traphong.getTENKH());
		SoPhong_textField.setText(String.valueOf(traphong.getSOPHONG()));
		SoNgayO_textField.setText(String.valueOf(traphong.getSONGAYO()));
		Tien_DV_textField.setText("0");
		HienThiTextFieldConLai();
	   	
		
    }
	public void TinhTongTextField() {
		Double tongtien=0.0;
		tongtien=tongtien + (Double.valueOf(Gia_textField.getText()) * Double.valueOf(SoNgayO_textField.getText())+Double.valueOf(Tien_DV_textField.getText()));
		TongCong_textField.setText(tongtien+"");
	}
	
	public void HienThiTextFieldConLai() {
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query1 = "SELECT GIATIEN "
						+ "from loai_phong, phieuthuephong "
						+ "WHERE phieuthuephong.LOAIPHONG= loai_phong.TEN_lOAIPHONG and phieuthuephong.MA_PT=? ";
			 PreparedStatement pst1 = conn.prepareStatement(query1);
			 pst1.setString(1,MaPT_textField.getText());
			 ResultSet rs1 = pst1.executeQuery();
			 while(rs1.next()) {
				 Gia_textField.setText(rs1.getString("GIATIEN"));
			 }
		}
			catch(Exception e) {
				 JOptionPane.showMessageDialog(null, "Lỗi: "+  e);
			}
	}		
	//HienTextFieldTienDV();
	
	public void HienTextFieldTienDV() {
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			Statement s= conn.createStatement();
			String	value1 =SoPhong_textField.getText() ;
			ResultSet rs1 = s.executeQuery("SELECT sum(TONGTIENDV) as TONGDV FROM phieu_dv WHERE SOPHONG='"+value1+"'");	
			rs1.next();
			rs1.getString("TONGDV");
			if(rs1.getString("TONGDV")==null) {
				
				Tien_DV_textField.setText("0");
			
			}
			else  {
				Tien_DV_textField.setText(rs1.getString("TONGDV"));
			}
			 
			 }
			catch(Exception e) {
				 JOptionPane.showMessageDialog(null, "Lỗi: "+  e);
			}
		}			
	
	@FXML
    void Load_ActionListener(ActionEvent event) {
		 try {
				final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
				Connection conn = DriverManager.getConnection(DB_URL,"root","");
				String value1= SoPhong_textField.getText();
				String query = "select MAPHIEUDV,SOPHONG,dv.TENDV,GIA,phieu_dv.SOLUONG,TONGTIENDV from phieu_dv,dv where dv.TENDV=phieu_dv.TENDV and phieu_dv.SOPHONG=? ";
				 PreparedStatement pst1 = conn.prepareStatement(query);
				 pst1.setString(1,SoPhong_textField.getText());
				 ResultSet rs = pst1.executeQuery();
				
				//ResultSet rs = conn.createStatement().executeQuery("select MAPHIEUDV,SOPHONG,dv.TENDV,GIA,phieu_dv.SOLUONG,TONGTIENDV from phieu_dv,dv where dv.TENDV=phieu_dv.TENDV and phieu_dv.SOPHONG='104' ORDER by phieu_dv.MAPHIEUDV ASC");
					while (rs.next()) {	
						phieudv.add(new PhieuDV(rs.getString("MAPHIEUDV"),rs.getString("SOPHONG"),rs.getString("TENDV"),
								rs.getString("GIA"),rs.getString("SOLUONG"),rs.getString("TONGTIENDV")));
					}
				}
			 catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi phieudv"+e);
				}
			 col_MaPhieu.setCellValueFactory(new PropertyValueFactory<>("MAPHIEUDV"));
			 col_SoPhong.setCellValueFactory(new PropertyValueFactory<>("SOPHONG"));
			 col_TenDV.setCellValueFactory(new PropertyValueFactory<>("TENDV"));
			 col_GiaTien.setCellValueFactory(new PropertyValueFactory<>("GIA"));
			 col_SoLuong.setCellValueFactory(new PropertyValueFactory<>("SOLUONG"));
			 col_TongTien.setCellValueFactory(new PropertyValueFactory<>("TONGTIENDV"));
			 tbl_PDV.setItems(phieudv);
			 HienTextFieldTienDV();
			 TinhTongTextField();
			
    }
	
	
									
	public void HienTableHoaDon() {	
		 try {						
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("select * from hoadon_thanhtoanphong");		
				while (rs.next()) {	
					hoadon.add(new TableHoaDon(rs.getString("MA_HD_TTP"),rs.getString("MA_PT"),
							rs.getString("MAPHIEUDV"),rs.getString("MAKH"),rs.getString("TENKH"),
							rs.getString("NGAYTHANHTOAN"),rs.getString("TIENPHONG"),
							rs.getString("TONGTIENDV"),rs.getString("TONGTIEN"),rs.getString("TINHTRANG")));
				}
			}
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
		 Tbl_Col_MaHD.setCellValueFactory(new PropertyValueFactory<>("MA_HD_TTP"));
		 Tbl_Col_MaPT.setCellValueFactory(new PropertyValueFactory<>("MA_PT"));
		 Tbl_Col_MaPhieuDV.setCellValueFactory(new PropertyValueFactory<>("MAPHIEUDV"));
		 Tbl_Col_MaKH.setCellValueFactory(new PropertyValueFactory<>("MAKH"));
		 Tbl_Col_TenKH.setCellValueFactory(new PropertyValueFactory<>("TENKH"));
		 Tbl_Col_NgayThanhToan.setCellValueFactory(new PropertyValueFactory<>("NGAYTHANHTOAN"));
		 Tbl_Col_TienPhongNgay.setCellValueFactory(new PropertyValueFactory<>("TIENPHONG"));
		 Tbl_Col_TienDV.setCellValueFactory(new PropertyValueFactory<>("TONGTIENDV"));
		 Tbl_Col_TongTien.setCellValueFactory(new PropertyValueFactory<>("TONGTIEN"));
		 Tbl_Col_TinhTrang.setCellValueFactory(new PropertyValueFactory<>("TINHTRANG"));
		 Table_HoaDon.setItems(hoadon);
	}
	

	@FXML
    void Huy_ActionListener(ActionEvent event) {
		Stage stage = (Stage) Button_Huy.getScene().getWindow();
	    stage.close();
    }

    @FXML
    void In_ActionListener(ActionEvent event) {

    	try {
    		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			InputStream in = new FileInputStream(new File("C:\\Users\\Asus\\git\\repository\\Tester\\src\\Check_out\\InHoaDon.jrxml"));
			JasperDesign jd = JRXmlLoader.load(in);
			String sql= "SELECT MA_HD_TTP,TENKH,SOPHONG,GIATIEN,TIENPHONG,SONGAYO,TONGTIENDV,TONGTIEN,NGAYTHANHTOAN from hoadon_thanhtoanphong,phieuthuephong,loai_phong WHERE	MA_HD_TTP='"+MaHD_textField.getText()+"' AND phieuthuephong.MA_PT='"+MaPT_textField.getText()+"' AND phieuthuephong.LOAIPHONG=loai_phong.TEN_lOAIPHONG";
			JRDesignQuery newQuery = new JRDesignQuery();
			newQuery.setText(sql);
			jd.setQuery(newQuery);
			JasperReport jr = JasperCompileManager.compileReport(jd);
			HashMap<String,Object> para = new HashMap<>();
    		para.put("MA_HD_TTP",MaHD_textField.getText());
    		JasperPrint j = JasperFillManager.fillReport(jr, para,conn);
    		JasperViewer.viewReport(j,false);
    		OutputStream os = new FileOutputStream(new File("C:\\Users\\Asus\\Desktop\\New folder"));
    		JasperExportManager.exportReportToPdfStream(j,os);
			
			//    		JasperDesign jasdi=JRXmlLoader.load("C:\\Users\\Asus\\git\\repository\\Tester\\src\\Check_out\\Blank_A4.jrxml");
//    		String sql = "SELECT MA_HD_TTP,TENKH,SOPHONG,TIENPHONG,SONGAYO,TONGTIENDV,TONGTIEN,NGAYTHANHTOAN from hoadon_thanhtoanphong,phieuthuephong WHERE MA_HD_TTP='"+MaHD_textField.getText()+"' AND phieuthuephong.MA_PT='"+MaPT_textField+"'";
//    		JRDesignQuery newQuery = new JRDesignQuery();
//    		newQuery.setText(sql);
//    		jasdi.setQuery(newQuery);
//    		HashMap<String,Object> para = new HashMap<>();
//    		para.put("MaHD",MaHD_textField.getText());
//    		
//    		JasperReport js = JasperCompileManager.compileReport(jasdi);
//    		JasperPrint jp = JasperFillManager.fillReport(js, para,conn);
//    		JasperViewer.viewReport(jp);
    		
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Lỗi"+ e);
    	}
    	
    }

    @FXML
    void TaoHD_ActionListener(ActionEvent event) {
    	if( KiemTraNgayThanhToan()) {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query = "insert into `hoadon_thanhtoanphong`(MA_HD_TTP,MA_PT,MAPHIEUDV,MAKH,TENKH,NGAYTHANHTOAN,TIENPHONG,TONGTIENDV,TONGTIEN,TINHTRANG) "
							+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, MaHD_textField.getText());
			pst.setString(2, MaPT_textField.getText());
			pst.setString(3, MaPhieuDV_textField.getText());
			pst.setString(4, Ma_KH_textField.getText());
			pst.setString(5, TenKH_textField.getText());
			pst.setString(6, ((TextField)NgayThanhToan_textField.getEditor()).getText());
			pst.setString(7, Gia_textField.getText());
			pst.setString(8, Tien_DV_textField.getText());
			pst.setString(9, TongCong_textField.getText());
			pst.setString(10, "Chưa Thanh Toán");
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
			err_NgayTT.setText("");
		}
	catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi: Hoá đơn bạn nhập có thể bị trùng!");
		}
    	
    	}

    	UpdateTable();
    	HienTextFieldTienDV();
}

   

    @FXML
    void ThanhToan_ActionListener(ActionEvent event) {
    	 try {						
    		 final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
 			Connection conn = DriverManager.getConnection(DB_URL,"root","");
 			String value1 = "Đã Thanh Toán";
 			String value2 = MaPT_textField.getText();
 			String query1 = "UPDATE hoadon_thanhtoanphong SET TINHTRANG = '"+value1+"' WHERE MA_HD_TTP='"+value2+"' ";
 			 PreparedStatement pst1 = conn.prepareStatement(query1);
 			 pst1.executeUpdate();
 			JOptionPane.showMessageDialog(null, "Thanh Toán Thành công!");
 			CapNhatTinhTrangPhong();
 			 }
 		 catch(Exception e) {
 			JOptionPane.showMessageDialog(null, e);
 			}
    	 UpdateTable();
    	 
    	
    }
    
    public void CapNhatTinhTrangPhong() {
		 try {						
   		 final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String value1 = "Trống";
			String value2 = SoPhong_textField.getText().toString();
			String query1 = "UPDATE phong SET TINHTRANG = '"+value1+"' WHERE TEN_PHONG='"+value2+"' ";
			 PreparedStatement pst1 = conn.prepareStatement(query1);
			 pst1.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cập Nhật Phòng Trống Thành công!");
			 }
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
	}
    
    public void UpdateTable() {
		 hoadon.clear();
		 HienTableHoaDon();
	}
    
private boolean KiemTraNgayThanhToan() {
		
		if(((TextField)NgayThanhToan_textField.getEditor()).getText().isEmpty())
			{
			err_NgayTT.setText("Vui lòng nhập ngày thanh toán!");
			return false;
			}
		return true;
	}

public void ChuyenNguocNamThangNgay()
{
	NgayThanhToan_textField.setConverter(
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
