package QuanLiKhachHang;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Check_in.ModelTable;
import NhanVien.TableNhanVien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class QuanLiKhachHangController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label DanhSachKhachHangLabel;

    @FXML
    private TableView<?> DanhSachKHTableView;

    @FXML
    private TableColumn<?, ?> MaKHColumn;

    @FXML
    private TableColumn<?, ?> TenKHLabel;

    @FXML
    private TableColumn<?, ?> NgaySinhColumn;

    @FXML
    private TableColumn<?, ?> GTColumn;

    @FXML
    private TableColumn<?, ?> ĐiaChiColumn;

    @FXML
    private TableColumn<?, ?> QuocTichColumn;

    @FXML
    private TableColumn<?, ?> SDTColumn;

    @FXML
    private TableColumn<?, ?> CMNDColumn;

    @FXML
    private TableColumn<?, ?> NgayCheck_inColumn;

    @FXML
    private TableColumn<?, ?> SoNgayOColumn;

    @FXML
    private Button ThemButton;

    @FXML
    private Button XoaButton;

    @FXML
    private Button SuaButton;

    @FXML
    private Button PhieuDichVuButton;

    @FXML
    private Button DanhGiaButton;

    ObservableList<TableKhachHang> listkh = FXCollections.observableArrayList();
    
    public void initialize(URL arg0, ResourceBundle arg1) {
    	HienTableKhachHang();
    	
	}
    
    public void HienTableKhachHang() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("select MA_PT,TENKH,CMND,SDT,SONGUOI1PHONG,LOAIPHONG,SOPHONG,NGAYDAT, NGAYNHAN, SONGAYO, MA_DATPHONG "
					+ "from phieuthuephong, khachhang "
					+ "where khachhang.MAKH=phieuthuephong.MA_PT");
			
				while (rs.next()) {	
					listkh.add(new TableKhachHang(rs.getString("MAKH"),rs.getString("TENKH"),
							rs.getString("NGAYSINH"),rs.getString("GIOITINH"),rs.getString("DIACHI"),
							rs.getString("QUOCTICH"), 
							rs.getString("SDT"),rs.getString("CMND"),rs.getString("NGAYCHECK_IN"),rs.getString("SONGAYO")));
				}
			}
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
    	 MaKHColumn.setCellValueFactory(new PropertyValueFactory<>("MAKH"));
		 TenKHLabel.setCellValueFactory(new PropertyValueFactory<>("TENKH"));
		 NgaySinhColumn.setCellValueFactory(new PropertyValueFactory<>("NGAYSINH"));
		 GTColumn.setCellValueFactory(new PropertyValueFactory<>("GIOITINH"));
		 ĐiaChiColumn.setCellValueFactory(new PropertyValueFactory<>("DIACHI"));
		 QuocTichColumn.setCellValueFactory(new PropertyValueFactory<>("QUOCTICH"));
		 SDTColumn.setCellValueFactory(new PropertyValueFactory<>("SDT"));
		 CMNDColumn.setCellValueFactory(new PropertyValueFactory<>("CMND"));
		 NgayCheck_inColumn.setCellValueFactory(new PropertyValueFactory<>("NGAYCHECK_IN"));
		 SoNgayOColumn.setCellValueFactory(new PropertyValueFactory<>("SONGAYO"));
		 }
    
    @FXML
    void DanhGiaButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("BangDanhGiaKhachHangController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void PhieuDichVuButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("PhieuDichVuController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void SuaButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("SuaKhachHangController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void ThemButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ThemKhachHangController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void XoaButtonListener(ActionEvent event) throws IOException {

    }

    
}
