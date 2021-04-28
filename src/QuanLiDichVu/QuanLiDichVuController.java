package QuanLiDichVu;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.scene.input.MouseEvent;

import javax.swing.JOptionPane;

import QuanLiKhachHang.TableKhachHang;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
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
    private Label tb1Label;

    @FXML
    private TextField tb1TextField;


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
    private Label tb2Label;

    @FXML
    private TextField tb2TextField;

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
    private Label tb3Label;

    @FXML
    private TextField tb3TextField;

 
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

    @FXML
    private Label tb4Label;

    @FXML
    private TextField tb4TextField;

  
    
    ObservableList<TableDichVuAnUong> listdvanuong = FXCollections.observableArrayList();
    ObservableList<TableDichVuGiaiTri> listdvgt = FXCollections.observableArrayList();
    ObservableList<TableDichVuThuGian> listdvtg = FXCollections.observableArrayList();
    ObservableList<TableDichVuPhucVu> listdvpv = FXCollections.observableArrayList();
    
    public void initialize(URL arg0, ResourceBundle arg1) {
    	BatTatNut();
    	HienTableDichVuAnUong();
    	HienTableDichVuGiaiTri();
    	HienTableDichVuThuGian();
    	HienTableDichVuPhucVu();
    	HienDataLenTextField();
  
    	
	}
    public void BatTatNut() {
    	SuaDVAnUongButton.setDisable(true);
    	XoaDVAnUongButton.setDisable(true);
    	
    	SuaDVGTButton.setDisable(true);
    	XoaDVTGButton.setDisable(true);
    	
    	SuaDVTGButton.setDisable(true);
    	XoaDVTGButton.setDisable(true);
    	
    	SuaDVPVButton.setDisable(true);
    	XoaDVPVButton.setDisable(true);
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
		 BatTatNut();
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
    		stage.initModality(Modality.WINDOW_MODAL);
    		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
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
    		stage.initModality(Modality.WINDOW_MODAL);
    		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
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
    		stage.initModality(Modality.WINDOW_MODAL);
    		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
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
    		Parent HienDanhSachSuaDVTG = loader.load();
    		Stage stage = new Stage();
    		Scene scene = new Scene(HienDanhSachSuaDVTG);
    		TableDichVuThuGian dvthugian =DichVuThuGianTableView.getSelectionModel().getSelectedItem();
    		SuaDichVuThuGianController controller = loader.getController();
    		controller.setDichVuTG(dvthugian);
    		stage.setTitle("Sửa Dịch Vụ");
    		stage.setScene(scene);
    		stage.initModality(Modality.WINDOW_MODAL);
    		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
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
    	stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
    	stage.show();
    }

    @FXML
    void ThemDVGTButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ThemDichVuGiaiTriController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
    	stage.show();
    }

    @FXML
    void ThemDVPVButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ThemDichVuPhucVuController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
    	stage.show();
    }

    @FXML
    void ThemDVTGButtonListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ThemDichVuThuGianController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
    	stage.show();
    }

    private void HienDataLenTextField() {
    	DichVuAnUongTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		@Override
    		public void handle(MouseEvent event) {
    			TableDichVuAnUong tbl_nv = DichVuAnUongTableView.getItems().get(DichVuAnUongTableView.getSelectionModel().getSelectedIndex());
    			tb1TextField.setText(tbl_nv.getMA_DV());
    			XoaDVAnUongButton.setDisable(false);
    			SuaDVAnUongButton.setDisable(false);
    	  
    		}
    		
    	});
    
    	DichVuGiaiTriTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		@Override
    		public void handle(MouseEvent event) {
    			TableDichVuGiaiTri tb1 = DichVuGiaiTriTableView.getItems().get(DichVuGiaiTriTableView.getSelectionModel().getSelectedIndex());
    			tb2TextField.setText(tb1.getMA_DV());
    			XoaDVGTButton.setDisable(false);
    			SuaDVGTButton.setDisable(false);
    	  
    		}
    		
    	});
    	DichVuThuGianTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		@Override
    		public void handle(MouseEvent event) {
    			TableDichVuThuGian tbl_nv = DichVuThuGianTableView.getItems().get(DichVuThuGianTableView.getSelectionModel().getSelectedIndex());
    			tb3TextField.setText(tbl_nv.getMA_DV());
    			XoaDVTGButton.setDisable(false);
    			SuaDVTGButton.setDisable(false);
    	    	
    		}
    		
    	}); 
    	DIchVuPhucVuTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		@Override
    		public void handle(MouseEvent event) {
    			TableDichVuPhucVu tbl_nv = DIchVuPhucVuTableView.getItems().get(DIchVuPhucVuTableView.getSelectionModel().getSelectedIndex());
    			tb4TextField.setText(tbl_nv.getMA_DV());
    			XoaDVPVButton.setDisable(false);
    			SuaDVPVButton.setDisable(false);
    	    	
    		}
    		
    	});
    }
    
    @FXML
    void XoaDVAnUongButtonListener(ActionEvent event) throws IOException {
    	int response=	JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa Hóa Đơn Này?", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     	if(response == JOptionPane.YES_OPTION) {
    		DichVuAnUongTableView.getItems().removeAll(DichVuAnUongTableView.getSelectionModel().getSelectedItems());
        	
        	String sql = "delete from dv where MA_DV = ?";
        	try {
        		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
        		Connection conn = DriverManager.getConnection(DB_URL,"root","");
        		PreparedStatement pst = conn.prepareStatement(sql);
        		pst.setString(1, tb1TextField.getText());
        		pst.execute();
        		JOptionPane.showMessageDialog(null, "Xoá Thành Công");
        	}
        	catch(Exception e) {
        		JOptionPane.showMessageDialog(null, e);
        	}
        	UpdateTable();	

    	}
     	else if(response == JOptionPane.NO_OPTION){
     		
     	}
    }
    

    @FXML
    void XoaDVGTButtonListener(ActionEvent event) throws IOException {
    	int response=	JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa Hóa Đơn Này?", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     	if(response == JOptionPane.YES_OPTION) {
    		DichVuGiaiTriTableView.getItems().removeAll(DichVuGiaiTriTableView.getSelectionModel().getSelectedItems());
        	
        	String sql = "delete from dv where MA_DV = ?";
        	try {
        		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
        		Connection conn = DriverManager.getConnection(DB_URL,"root","");
        		PreparedStatement pst = conn.prepareStatement(sql);
        		pst.setString(1, tb1TextField.getText());
        		pst.execute();
        		JOptionPane.showMessageDialog(null, "Xoá Thành Công");
        	}
        	catch(Exception e) {
        		JOptionPane.showMessageDialog(null, e);
        	}
        	UpdateTable();	

    	}
    	else if(response == JOptionPane.NO_OPTION){
     		
     	}
    }

    @FXML
    void XoaDVPVButtonListener(ActionEvent event) throws IOException {
    	int response=	JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa Hóa Đơn Này?", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     	if(response == JOptionPane.YES_OPTION) {
    		DIchVuPhucVuTableView.getItems().removeAll(DIchVuPhucVuTableView.getSelectionModel().getSelectedItems());
        	
        	String sql = "delete from dv where MA_DV = ?";
        	try {
        		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
        		Connection conn = DriverManager.getConnection(DB_URL,"root","");
        		PreparedStatement pst = conn.prepareStatement(sql);
        		pst.setString(1, tb1TextField.getText());
        		pst.execute();
        		JOptionPane.showMessageDialog(null, "Xoá Thành Công");
        	}
        	catch(Exception e) {
        		JOptionPane.showMessageDialog(null, e);
        	}
        	UpdateTable();	

    	}
     	else if(response == JOptionPane.NO_OPTION){
     		
     	}
    }

    @FXML
    void XoaDVTGButtonListener(ActionEvent event) throws IOException {
    	int response=	JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa Hóa Đơn Này?", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     	if(response == JOptionPane.YES_OPTION) {
    		DichVuThuGianTableView.getItems().removeAll(DichVuThuGianTableView.getSelectionModel().getSelectedItems());
        	String sql = "delete from dv where MA_DV = ?";
        	try {
        		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
        		Connection conn = DriverManager.getConnection(DB_URL,"root","");
        		PreparedStatement pst = conn.prepareStatement(sql);
        		pst.setString(1, tb1TextField.getText());
        		pst.execute();
        		JOptionPane.showMessageDialog(null, "Xoá Thành Công");
        	}
        	catch(Exception e) {
        		JOptionPane.showMessageDialog(null, e);
        	}
        	UpdateTable();	

    	}
     	else if(response == JOptionPane.NO_OPTION){
     		
     	}
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
