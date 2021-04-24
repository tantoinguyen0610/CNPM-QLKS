package HoaDon;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import QuanLiDichVu.SuaDichVuThuGianController;
import QuanLiDichVu.TableDichVuThuGian;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class QuanLiHoaDonController implements Initializable {

    @FXML
    private TabPane QuanLiHoaDonTabPane;

    @FXML
    private Tab HoaDonThanhToanPhongTab;

    @FXML
    private AnchorPane a;

    @FXML
    private ScrollPane thanhcuon1;
    
    @FXML
    private TableView<TableHoaDonTTP> HoaDonThanhToanPhongTableView;

    @FXML
    private TableColumn<String, TableHoaDonTTP> MaHDTTPColumn;

    @FXML
    private TableColumn<String, TableHoaDonTTP> TenKhachColumn;

    @FXML
    private TableColumn<String, TableHoaDonTTP> SoPhongTTPColumn;

    @FXML
    private TableColumn<String, TableHoaDonTTP> NgayThanhToanPhongColumn;

    @FXML
    private TableColumn<String, TableHoaDonTTP> TienPhongColumn;

    @FXML
    private TableColumn<String, TableHoaDonTTP> TienDichVuColumn;

    @FXML
    private TableColumn<String, TableHoaDonTTP> TongTienColumn;

    @FXML
    private TableColumn<String, TableHoaDonTTP> TinhTrangColumn;

    @FXML
    private Button XemChiTietHDTTPButton;

    @FXML
    private Button XoaHDTTPButton;

    @FXML
    private Label tb1Label;

    @FXML
    private TextField tb1TextField;

    @FXML
    private Button CapNhatButton;

    @FXML
    private Tab HoaDonSuaChuaThietBiTab;

    @FXML
    private AnchorPane b;

    @FXML
    private TableView<?> HoaDonSuaChuaThietBiTableView;

    @FXML
    private TableColumn<?, ?> MaHDSCTBColumn;

    @FXML
    private TableColumn<?, ?> TenTBColumn;

    @FXML
    private TableColumn<?, ?> SoLuongTBColumn;

    @FXML
    private TableColumn<?, ?> NgaySuaChuaColumn;

    @FXML
    private TableColumn<?, ?> TongTienSCTBColumn;

    @FXML
    private TableColumn<?, ?> ThanhToanSCTBColumn;

    @FXML
    private TableColumn<?, ?> TingTrangHDSCTBColumn;

    @FXML
    private TableColumn<?, ?> DuyetThanhToanSCTBCoLumn;

    @FXML
    private Button XemHoaDonSCTBButton;

    @FXML
    private Button XoaHoaDonSCTBButton;

    @FXML
    private Button DuyetThanhToanHoaDonSCTBButton;

    @FXML
    private Label tb2Label;

    @FXML
    private TextField tb2TextField;

    @FXML
    private Button CapNhat2Button;

    @FXML
    private Tab HoaDonNangCapPhongTab;

    @FXML
    private AnchorPane c;

    @FXML
    private TableView<?> HoaDonNangCapPhongTableView;

    @FXML
    private TableColumn<?, ?> MaHDNCPColumn;

    @FXML
    private TableColumn<?, ?> SoPhongNCPColumn;

    @FXML
    private TableColumn<?, ?> NgaySuaChuaNCPColumn;

    @FXML
    private TableColumn<?, ?> NgayKetThucNCPColumn;

    @FXML
    private TableColumn<?, ?> TongTienSuaChuaNCPColumn;

    @FXML
    private TableColumn<?, ?> ThanhToanNCPColumn;

    @FXML
    private TableColumn<?, ?> TinhTrangHDNCPColumn;

    @FXML
    private TableColumn<?, ?> DuyetThanhToanNCPColumn;

    @FXML
    private Button XemHoaDonNCPButton;

    @FXML
    private Button XoaHoaDonNCPButton;

    @FXML
    private Button DuyetThanhToanHoaDonNCPButton;

    @FXML
    private Button CapNhat3Button;

    @FXML
    private Label tb3Label;

    @FXML
    private TextField tb3TextField;
    
    ObservableList<TableHoaDonTTP> listhoadonttp = FXCollections.observableArrayList();
    
    public void initialize(URL arg0, ResourceBundle arg1) {
    	HienTableHoaDonTTP();
 
	}
    
    public void HienTableHoaDonTTP() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("select MA_HD_TTP,khachhang.TENKH,phieuthuephong.SOPHONG,NGAYTHANHTOAN,TIENPHONG,TONGTIENDV,TONGTIEN,TINHTRANG from hoadon_thanhtoanphong,khachhang,phieuthuephong "
					+ "where hoadon_thanhtoanphong.MA_HD_TTP = phieuthuephong.MA_PT AND khachhang.MAKH= phieuthuephong.MA_PT "  );
			
				while (rs.next()) {	
					listhoadonttp .add(new TableHoaDonTTP (rs.getString("MA_HD_TTP"),rs.getString("TENKH"),
							rs.getString("SOPHONG"),rs.getString("NGAYTHANHTOAN"),rs.getString("TIENPHONG"),rs.getString("TONGTIENDV"),
							rs.getString("TONGTIEN"),rs.getString("TINHTRANG")));
				}
			}
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
    			MaHDTTPColumn.setCellValueFactory(new PropertyValueFactory<>("MA_HD_TTP"));
    			TenKhachColumn.setCellValueFactory(new PropertyValueFactory<>("TENKH"));
    			SoPhongTTPColumn.setCellValueFactory(new PropertyValueFactory<>("SOPHONG"));
    			NgayThanhToanPhongColumn.setCellValueFactory(new PropertyValueFactory<>("NGAYTHANHTOAN"));
    			TienPhongColumn.setCellValueFactory(new PropertyValueFactory<>("TIENPHONG"));
    			TienDichVuColumn.setCellValueFactory(new PropertyValueFactory<>("TONGTIENDV"));
    			TongTienColumn.setCellValueFactory(new PropertyValueFactory<>("TONGTIEN"));
    			TinhTrangColumn.setCellValueFactory(new PropertyValueFactory<>("TINHTRANG"));
    			HoaDonThanhToanPhongTableView.setItems(listhoadonttp);
    		
		 }
    
    

    @FXML
    void DuyetThanhToanHoaDonNCPButtonListener(ActionEvent event) throws IOException {
    	
    }

    @FXML
    void DuyetThanhToanHoaDonSCTBButtonListener(ActionEvent event) throws IOException {

    }

    @FXML
    void XemChiTietHDTTPButtonListener(ActionEvent event) throws IOException {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("ChiTietHoaDonThanhToanPhongController.fxml"));
    		Parent HienHoaDonTTP = loader.load();
    		Stage stage = new Stage();
    		Scene scene = new Scene(HienHoaDonTTP);
    		TableHoaDonTTP tablehoadonttp = HoaDonThanhToanPhongTableView.getSelectionModel().getSelectedItem();
    		ChiTietHoaDonThanhToanPhongController controller = loader.getController();
    		controller.setHDTTP(tablehoadonttp);
    		stage.setTitle("Chi Tiết Hóa Đơn ");
    		stage.setScene(scene);
    		stage.show();
    		}
    		catch(Exception e) {
    			JOptionPane.showMessageDialog(null, e);
    		}
    }
    
    public void UpdateTable() {
		 listhoadonttp.clear();
		 HienTableHoaDonTTP();
	}

    @FXML
    void XemHoaDonNCPButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ChiTietHoaDonNangCapPhongController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void XemHoaDonSCTBButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ChiTietHoaDonSuaChuaThietBiController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void XoaHDTTPButtonListener(ActionEvent event) throws IOException {

    }

    @FXML
    void XoaHoaDonNCPButtonListener(ActionEvent event) throws IOException {

    }

    @FXML
    void XoaHoaDonSCTBButtonListener(ActionEvent event) throws IOException {

    }
    
    @FXML
    void CapNhat3Button(ActionEvent event) {

    }

    @FXML
    void CapNhatButtonListener(ActionEvent event) {
    	UpdateTable();
    }

    @FXML
    void CapNhat2ButtonListener(ActionEvent event) {

    }

   
}
