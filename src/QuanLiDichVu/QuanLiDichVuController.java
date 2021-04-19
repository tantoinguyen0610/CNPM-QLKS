package QuanLiDichVu;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
    private Tab DichVuGiaiTriTab;

    @FXML
    private AnchorPane DichVuGiaiTriAnchorPane;

    @FXML
    private ScrollPane BScrollPane;

    @FXML
    private TableView<?> DichVuGiaiTriTableView;

    @FXML
    private TableColumn<?, ?> MaDVGTColumn;

    @FXML
    private TableColumn<?, ?> TenDVGTColumn;

    @FXML
    private TableColumn<?, ?> GiaDVGTColumn;

    @FXML
    private TableColumn<?, ?> KhungGioGTColumn;

    @FXML
    private TableColumn<?, ?> TinhTrangColumn;

    @FXML
    private Button ThemDVGTButton;

    @FXML
    private Button SuaDVGTButton;

    @FXML
    private Button XoaDVGTButton;

    @FXML
    private Tab DichVuThuGianTab;

    @FXML
    private AnchorPane DichVuThuGianAnchorPane;

    @FXML
    private ScrollPane CScrollPane;

    @FXML
    private TableView<?> DichVuThuGianTableView;

    @FXML
    private TableColumn<?, ?> MaDVTGColumn;

    @FXML
    private TableColumn<?, ?> TenDVTGColumn;

    @FXML
    private TableColumn<?, ?> GiaDCTGColumn;

    @FXML
    private TableColumn<?, ?> SoLuongNguoiDVTGColumn;

    @FXML
    private TableColumn<?, ?> KhungGioDVTGColumn;

    @FXML
    private TableColumn<?, ?> TinhTrangDVTGColumn;

    @FXML
    private Button ThemDVTGButton;

    @FXML
    private Button SuaDVTGButton;

    @FXML
    private Button XoaDVTGButton;

    @FXML
    private Tab DichVuPhucVuTab;

    @FXML
    private AnchorPane DichVuPhucVuAnchorPane;

    @FXML
    private ScrollPane DScrollPane;

    @FXML
    private TableView<?> DIchVuPhucVuTableView;

    @FXML
    private TableColumn<?, ?> MADVPVColumn;

    @FXML
    private TableColumn<?, ?> TenDVPVColumn;

    @FXML
    private TableColumn<?, ?> SoLuongDVPVColumn;

    @FXML
    private TableColumn<?, ?> GiaDVPVCloumn;

    @FXML
    private TableColumn<?, ?> TinhTrangDVPVColumn;

    @FXML
    private Button ThemDVPVButton;

    @FXML
    private Button SuaDVPVButton;

    @FXML
    private Button XoaDVPVButton;
    
    ObservableList<TableDichVuAnUong> listdvanuong = FXCollections.observableArrayList();
    
    public void initialize(URL arg0, ResourceBundle arg1) {
    	HienTableDichVuAnUong();
    	
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

	
	
	
    
    public void UpdateTable() {
		 listdvanuong.clear();
		 HienTableDichVuAnUong();
	}
    
    @FXML
    void SuaDVAnUongButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("SuaDichVuAnUongController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void SuaDVGTButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("SuaDichVuGiaiTriController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void SuaDVPVButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("SuaDichVuPhucVuController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void SuaDVTGButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("SuaDichVuThuGianController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
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

  
}
