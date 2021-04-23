package QuanLiDichVu;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import QuanLiKhachHang.SuaKhachHangController;
import QuanLiKhachHang.TableKhachHang;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class QuanLiDichVuController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private TabPane DichVuTabPane;

    @FXML
    private Tab DichVuAnUongTab;

    @FXML
    private AnchorPane DichVuAnUongAnchorPane;

    @FXML
    private ScrollPane AScrollPane;

    @FXML
    private TableView<TableDichVuAnUong> DichVuAnUongTableView;

    @FXML
    private TableColumn<TableDichVuAnUong , String > MaDVAnUongColumn;

    @FXML
    private TableColumn<TableDichVuAnUong , String> TenDichVuAnUongColumn;

    @FXML
    private TableColumn<TableDichVuAnUong , String> LoaiDichVuAnUongColumn;

    @FXML
    private TableColumn<TableDichVuAnUong , String> SoLuongAnUongColumn;

    @FXML
    private TableColumn<TableDichVuAnUong , String> GiaDVAnUongColumn;

    @FXML
    private TableColumn<TableDichVuAnUong , String> TinhTrangDVAnUongColumn;

    @FXML
    private Button ThemDVAnUongButton;

    @FXML
    private Button SuaDVAnUongButton;

    @FXML
    private Button XoaDVAnUongButton;
    
    @FXML
    private Button CapNhatDVAnUongButton;

    @FXML
    private Tab DichVuGiaiTriTab;

    @FXML
    private AnchorPane DichVuGiaiTriAnchorPane;

    @FXML
    private ScrollPane BScrollPane;

    @FXML
    private TableView<TableDichVuGiaiTri> DichVuGiaiTriTableView;

    @FXML
    private TableColumn<TableDichVuGiaiTri, String> MaDVGTColumn;

    @FXML
    private TableColumn<TableDichVuGiaiTri, String> TenDVGTColumn;

    @FXML
    private TableColumn<TableDichVuGiaiTri, String> LoaiDVGTColumn;

    @FXML
    private TableColumn<TableDichVuGiaiTri, String> KhungGioGTColumn;

    @FXML
    private TableColumn<TableDichVuGiaiTri, String> TinhTrangColumn;

    @FXML
    private TableColumn<TableDichVuGiaiTri, String> GiaDVGTColumn;

    @FXML
    private Button ThemDVGTButton;

    @FXML
    private Button SuaDVGTButton;

    @FXML
    private Button XoaDVGTButton;
    
    @FXML
    private Button CapNhatDVGTButton;

    @FXML
    private Tab DichVuThuGianTab;

    @FXML
    private AnchorPane DichVuThuGianAnchorPane;

    @FXML
    private ScrollPane CScrollPane;

    @FXML
    private TableView<TableDichVuThuGian> DichVuThuGianTableView;

    @FXML
    private TableColumn<TableDichVuThuGian, String> MaDVTGColumn;

    @FXML
    private TableColumn<TableDichVuThuGian, String> TenDVTGColumn;

    @FXML
    private TableColumn<TableDichVuThuGian, String> LoaiDVTGColumn;

    @FXML
    private TableColumn<TableDichVuThuGian, String> SoLuongNguoiDVTGColumn;

    @FXML
    private TableColumn<TableDichVuThuGian, String> KhungGioDVTGColumn;

    @FXML
    private TableColumn<TableDichVuThuGian, String> TinhTrangDVTGColumn;

    @FXML
    private TableColumn<TableDichVuThuGian, String> GiaDVTGColumn;

    @FXML
    private Button ThemDVTGButton;

    @FXML
    private Button SuaDVTGButton;

    @FXML
    private Button XoaDVTGButton;
    
    @FXML
    private Button CapNhatDVTGButton;

    @FXML
    private Tab DichVuPhucVuTab;

    @FXML
    private AnchorPane DichVuPhucVuAnchorPane;

    @FXML
    private ScrollPane DScrollPane;

    @FXML
    private TableView<TableDichVuPhucVu> DIchVuPhucVuTableView;

    @FXML
    private TableColumn<TableDichVuPhucVu, String> MADVPVColumn;

    @FXML
    private TableColumn<TableDichVuPhucVu, String> TenDVPVColumn;

    @FXML
    private TableColumn<TableDichVuPhucVu, String> SoLuongDVPVColumn;

    @FXML
    private TableColumn<TableDichVuPhucVu, String> LoaiDVPVColumn;

    @FXML
    private TableColumn<TableDichVuPhucVu, String> TinhTrangDVPVColumn;

    @FXML
    private TableColumn<TableDichVuPhucVu, String> GiaDVPVColumn;

    @FXML
    private Button ThemDVPVButton;

    @FXML
    private Button SuaDVPVButton;

    @FXML
    private Button XoaDVPVButton;
    
    @FXML
    private Button CapNhatDVPVButton;


  
    
    ObservableList<TableDichVuAnUong> listdvanuong = FXCollections.observableArrayList();
    ObservableList<TableDichVuGiaiTri> listdvgt = FXCollections.observableArrayList();
    ObservableList<TableDichVuThuGian> listdvtg = FXCollections.observableArrayList();
    ObservableList<TableDichVuPhucVu> listdvpv = FXCollections.observableArrayList();
    
    public void initialize(URL arg0, ResourceBundle arg1) {
    	HienTableDichVuAnUong();
    	HienTableDichVuGiaiTri();
    	HienTableDichVuThuGian();
    	HienTableDichVuPhucVu();
    	
	}



	public void HienTableDichVuAnUong() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("select MA_DV,TENDV,LOAIDV,SOLUONG,GIA,TINHTRANG from dv "
					+ "where dv.LOAIDV = 'ăn uống' ");
			
				while (rs.next()) {	
					listdvanuong.add(new TableDichVuAnUong(rs.getString("MA_DV"),rs.getString("TENDV"),
							rs.getString("LOAIDV"),rs.getString("SOLUONG"),rs.getString("GIA"),
							rs.getString("TINHTRANG")));
				}
			}
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
    			MaDVAnUongColumn.setCellValueFactory(new PropertyValueFactory<>("MA_DV"));
    			TenDichVuAnUongColumn.setCellValueFactory(new PropertyValueFactory<>("TENDV"));
    			LoaiDichVuAnUongColumn.setCellValueFactory(new PropertyValueFactory<>("LOAIDV"));
    			SoLuongAnUongColumn.setCellValueFactory(new PropertyValueFactory<>("SOLUONG"));
    			GiaDVAnUongColumn.setCellValueFactory(new PropertyValueFactory<>("GIA"));
    			TinhTrangDVAnUongColumn.setCellValueFactory(new PropertyValueFactory<>("TINHTRANG"));
    			DichVuAnUongTableView.setItems(listdvanuong);
    			
		 }

	
	public void HienTableDichVuGiaiTri() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("select MA_DV,TENDV,LOAIDV,KHUNGGIO,TINHTRANG,GIA from dv "
					+ "where dv.LOAIDV = 'Giải Trí' ");
			
				while (rs.next()) {	
					listdvgt.add(new TableDichVuGiaiTri(rs.getString("MA_DV"),rs.getString("TENDV"),
							rs.getString("LOAIDV"),rs.getString("KHUNGGIO"),rs.getString("TINHTRANG"),
							rs.getString("GIA")));
				}
			}
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
    			MaDVGTColumn.setCellValueFactory(new PropertyValueFactory<>("MA_DV"));
    			TenDVGTColumn.setCellValueFactory(new PropertyValueFactory<>("TENDV"));
    			LoaiDVGTColumn.setCellValueFactory(new PropertyValueFactory<>("LOAIDV"));
    			KhungGioGTColumn.setCellValueFactory(new PropertyValueFactory<>("KHUNGGIO"));
    			TinhTrangColumn.setCellValueFactory(new PropertyValueFactory<>("TINHTRANG"));
    			GiaDVGTColumn.setCellValueFactory(new PropertyValueFactory<>("GIA"));
    			DichVuGiaiTriTableView.setItems(listdvgt);
    			
		 }
	
	public void HienTableDichVuThuGian() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("select MA_DV,TENDV,LOAIDV,SONGUOITHAMGIA,KHUNGGIO,TINHTRANG,GIA from dv "
					+ "where dv.LOAIDV = 'Thư Giản' ");
			
				while (rs.next()) {	
					listdvtg.add(new TableDichVuThuGian(rs.getString("MA_DV"),rs.getString("TENDV"),
							rs.getString("LOAIDV"),rs.getString("SONGUOITHAMGIA"),rs.getString("KHUNGGIO"),rs.getString("TINHTRANG"),
							rs.getString("GIA")));
				}
			}
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
    			MaDVTGColumn.setCellValueFactory(new PropertyValueFactory<>("MA_DV"));
    			TenDVTGColumn.setCellValueFactory(new PropertyValueFactory<>("TENDV"));
    			LoaiDVTGColumn.setCellValueFactory(new PropertyValueFactory<>("LOAIDV"));
    			SoLuongNguoiDVTGColumn.setCellValueFactory(new PropertyValueFactory<>("SONGUOITHAMGIA"));
    			KhungGioDVTGColumn.setCellValueFactory(new PropertyValueFactory<>("KHUNGGIO"));
    			TinhTrangDVTGColumn.setCellValueFactory(new PropertyValueFactory<>("TINHTRANG"));
    			GiaDVTGColumn.setCellValueFactory(new PropertyValueFactory<>("GIA"));
    			DichVuThuGianTableView.setItems(listdvtg);
    			
		 }
	
	public void HienTableDichVuPhucVu() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("select MA_DV,TENDV,SOLUONG,LOAIDV,TINHTRANG,GIA from dv "
					+ "where dv.LOAIDV = 'Phục Vụ' ");
			
				while (rs.next()) {	
					listdvpv .add(new TableDichVuPhucVu(rs.getString("MA_DV"),rs.getString("TENDV"),
							rs.getString("LOAIDV"),rs.getString("SOLUONG"),rs.getString("TINHTRANG"),
							rs.getString("GIA")));
				}
			}
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
    			MADVPVColumn.setCellValueFactory(new PropertyValueFactory<>("MA_DV"));
    			TenDVPVColumn.setCellValueFactory(new PropertyValueFactory<>("TENDV"));
    			SoLuongDVPVColumn.setCellValueFactory(new PropertyValueFactory<>("LOAIDV"));
    			LoaiDVPVColumn.setCellValueFactory(new PropertyValueFactory<>("SOLUONG"));
    			TinhTrangDVPVColumn.setCellValueFactory(new PropertyValueFactory<>("TINHTRANG"));
    			GiaDVPVColumn.setCellValueFactory(new PropertyValueFactory<>("GIA"));
    			DIchVuPhucVuTableView.setItems(listdvpv);
    			
		 }
	
    
    public void UpdateTable() {
		 listdvanuong.clear();
		 listdvgt.clear();
		 listdvtg.clear();
		 listdvpv.clear();
		 HienTableDichVuAnUong();
		 HienTableDichVuGiaiTri();
		 HienTableDichVuThuGian();
		 HienTableDichVuPhucVu();
	}
    
    @FXML
    void SuaDVAnUongButtonListener(ActionEvent event) throws IOException {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("SuaDichVuAnUongController.fxml"));
    		Parent HienDanhSachSuaDVANUONG = loader.load();
    		Stage stage = new Stage();
    		Scene scene = new Scene(HienDanhSachSuaDVANUONG);
    		TableDichVuAnUong selected =DichVuAnUongTableView.getSelectionModel().getSelectedItem();
    		SuaDichVuAnUongController controller = loader.getController();
    		controller.setDichVuAnUong(selected);
    		stage.setTitle("Sửa Dịch Vụ");
    		stage.setScene(scene);
    		stage.show();
    		}
    		catch(Exception e) {
    			JOptionPane.showMessageDialog(null, e);
    		}
        }
    
    @FXML
    void SuaDVGTButtonListener(ActionEvent event) throws IOException {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("SuaDichVuGiaiTriController.fxml"));
    		Parent HienDanhSachSuaDVGT = loader.load();
    		Stage stage = new Stage();
    		Scene scene = new Scene(HienDanhSachSuaDVGT);
    		TableDichVuGiaiTri dvgiaitri = DichVuGiaiTriTableView.getSelectionModel().getSelectedItem();
    		SuaDichVuGiaiTriController controller = loader.getController();
    		controller.setDichVuGiaiTri(dvgiaitri);
    		stage.setTitle("Sửa Dịch Vụ");
    		stage.setScene(scene);
    		stage.show();
    		}
    		catch(Exception e) {
    			JOptionPane.showMessageDialog(null, e);
    		}
    }

    @FXML
    void SuaDVPVButtonListener(ActionEvent event) throws IOException {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("SuaDichVuPhucVuController.fxml"));
    		Parent HienDanhSachSuaDVPV = loader.load();
    		Stage stage = new Stage();
    		Scene scene = new Scene(HienDanhSachSuaDVPV);
    		TableDichVuPhucVu dichvuphucvu =DIchVuPhucVuTableView.getSelectionModel().getSelectedItem();
    		SuaDichVuPhucVuController controller = loader.getController();
    		controller.setDichVuPV(dichvuphucvu);
    		stage.setTitle("Sửa Dịch Vụ");
    		stage.setScene(scene);
    		stage.show();
    		}
    		catch(Exception e) {
    			JOptionPane.showMessageDialog(null, e);
    		}
    }

    @FXML
    void SuaDVTGButtonListener(ActionEvent event) throws IOException {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("SuaDichVuThuGianController.fxml"));
    		Parent HienDanhSachSuaDVPV = loader.load();
    		Stage stage = new Stage();
    		Scene scene = new Scene(HienDanhSachSuaDVPV);
    		TableDichVuThuGian selected =DichVuThuGianTableView.getSelectionModel().getSelectedItem();
    		SuaDichVuAnUongController controller = loader.getController();
    		controller.setDichVuTG(selected);
    		stage.setTitle("Sửa Dịch Vụ");
    		stage.setScene(scene);
    		stage.show();
    		}
    		catch(Exception e) {
    			JOptionPane.showMessageDialog(null, e);
    		}
    }

    @FXML
    void ThemDVAnUongButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ThemDichVuAnUongController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void ThemDVGTButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ThemDichVuGiaiTriController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void ThemDVPVButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ThemDichVuPhucVuController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void ThemDVTGButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ThemDichVuThuGianController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void XoaDVAnUongButtonListener(ActionEvent event) throws IOException {
    	
    }

    @FXML
    void XoaDVGTButtonListener(ActionEvent event) throws IOException {

    }

    @FXML
    void XoaDVPVButtonListener(ActionEvent event) throws IOException {

    }

    @FXML
    void XoaDVTGButtonListener(ActionEvent event) throws IOException {

    }
    
    @FXML
    void CapNhatDVAnUongButtonListener(ActionEvent event) throws IOException {
    	UpdateTable();
    }

    @FXML
    void CapNhatDVGTButtonListener(ActionEvent event) throws IOException {
    	UpdateTable();
    }

    @FXML
    void CapNhatDVPVButtonListener(ActionEvent event) throws IOException {
    	UpdateTable();
    }

    @FXML
    void CapNhatDVTGButtonListener(ActionEvent event) throws IOException {
    	UpdateTable();
    }

  
}
