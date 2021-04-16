package Check_out;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Check_in.ModelTable;
import HoaDon.TableHoaDonTTP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private Label MaHD_Label;

    @FXML
    private TextField MaHD_textField;

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
    private DatePicker NgayThanhToan_textField;

    @FXML
    private TextField Tien_DV_textField;

    @FXML
    private TextField TongCong_textField;
    
    @FXML
    private Label MaPT_Label;

    @FXML
    private TextField MaPT_textField;

    @FXML
    private Label LoaiPhong_Label;

    @FXML
    private TextField LoaiPhong_textField;

    @FXML
    private Label BangDV_Label;

    @FXML
    private TableView<?> tableView_BangDV;

    @FXML
    private TableColumn<?, ?> Tbl_Col_TenDV;

    @FXML
    private TableColumn<?, ?> Tbl_Col_SoLuong;

    @FXML
    private TableColumn<?, ?> Tbl_Col_Gia;

    @FXML
    private TableColumn<?, ?> Tbl_Col_Tong;
    
    

    @FXML
    private Button Button_ThanhToan;

    @FXML
    private Button Button_Huy_ThanhToan;

    @FXML
    private TableView<TableHoaDon> Table_HoaDon;

    @FXML
    private TableColumn<Integer, TableHoaDon> Tbl_Col_MaHD;

    @FXML
    private TableColumn<Integer, TableHoaDon> Tbl_Col_MaKH;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_TenKH;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_MaPhong;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_GiaPhongNgay;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_NgayNhanPhong;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_NgayThanhToan;

    @FXML
    private TableColumn<String, TableHoaDon> Tbl_Col_TinhTrang;
    
    @FXML
    private TableColumn<Integer, TableHoaDon> Tbl_Col_TongTien;
    
    ObservableList<TableHoaDon> hoadon = FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		HienTableHoaDon();
	}
	
	public void setHoaDonTraPhong(ModelTable traphong) {
		MaHD_textField.setText(String.valueOf(traphong.getMA_PT()));
		MaPT_textField.setText(String.valueOf(traphong.getMA_PT()));
		Ma_KH_textField.setText(String.valueOf(traphong.getMA_PT()));
		TenKH_textField.setText(traphong.getTENKH());
		SoPhong_textField.setText(String.valueOf(traphong.getSOPHONG()));
		SoNgayO_textField.setText(String.valueOf(traphong.getSONGAYO()));
		HienThiTextFieldConLai();
		TinhTongTextField();
    }
	
	public void TinhTongTextField() {
		Double tongtien=0.0;
		tongtien=tongtien + Double.valueOf(Gia_textField.getText());
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
				 JOptionPane.showMessageDialog(null, "Lỗi");
			}
	}
	
	public void HienTableHoaDon() {
		 try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("select MA_HD_TTP,phieuthuephong.MAKH,khachhang.TENKH,SOPHONG,GIATIEN,NGAYNHAN,NGAYTHANHTOAN,TINHTRANG "
																+ "from phieuthuephong, khachhang, hoadon_thanhtoanphong,loai_phong "
																+ "where hoadon_thanhtoanphong.MA_HD_TTP=phieuthuephong.MA_PT");
			
				while (rs.next()) {	
					hoadon.add(new TableHoaDon(rs.getString("MA_HD_TTP"),rs.getString("MAKH"),
							rs.getString("TENKH"),rs.getString("SOPHONG"),rs.getString("GIATIEN"),
							rs.getString("NGAYNHAN"),rs.getString("NGAYTHANHTOAN"),
							rs.getString("TINHTRANG"),rs.getString("TONGTIEN")));
				}
			}
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
		 Tbl_Col_MaHD.setCellValueFactory(new PropertyValueFactory<>("MA_HD_TTP"));
		 Tbl_Col_MaKH.setCellValueFactory(new PropertyValueFactory<>("MAKH"));
		 Tbl_Col_TenKH.setCellValueFactory(new PropertyValueFactory<>("TENKH"));
		 Tbl_Col_MaPhong.setCellValueFactory(new PropertyValueFactory<>("SOPHONG"));
		 Tbl_Col_GiaPhongNgay.setCellValueFactory(new PropertyValueFactory<>("GIATIEN"));
		 Tbl_Col_NgayNhanPhong.setCellValueFactory(new PropertyValueFactory<>("NGAYNHAN"));
		 Tbl_Col_NgayThanhToan.setCellValueFactory(new PropertyValueFactory<>("NGAYTHANHTOAN"));
		 Tbl_Col_TinhTrang.setCellValueFactory(new PropertyValueFactory<>("TINHTRANG"));
		 Table_HoaDon.setItems(hoadon);
	}
	
	
}
