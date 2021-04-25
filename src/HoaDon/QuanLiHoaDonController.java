package HoaDon;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.scene.input.MouseEvent;

import javax.swing.JOptionPane;

import QuanLiDichVu.SuaDichVuThuGianController;
import QuanLiDichVu.TableDichVuAnUong;
import QuanLiDichVu.TableDichVuThuGian;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
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
    private TableView<TableHoaDonSuaThietBi> HoaDonSuaChuaThietBiTableView;

    @FXML
    private TableColumn<TableHoaDonSuaThietBi,String> MaHDSCTBColumn;

    @FXML
    private TableColumn<TableHoaDonSuaThietBi,String> TenTBColumn;

    @FXML
    private TableColumn<TableHoaDonSuaThietBi,String> SoLuongTBColumn;

    @FXML
    private TableColumn<TableHoaDonSuaThietBi,String> NgaySuaChuaColumn;

    @FXML
    private TableColumn<TableHoaDonSuaThietBi,String> TongTienSCTBColumn;

    @FXML
    private TableColumn<TableHoaDonSuaThietBi,String> ThanhToanSCTBColumn;

    @FXML
    private TableColumn<TableHoaDonSuaThietBi,String> TingTrangHDSCTBColumn;

    @FXML
    private TableColumn<TableHoaDonSuaThietBi,String> DuyetThanhToanSCTBCoLumn;

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
    private TableView<TableHoaDonNangCapPhong> HoaDonNangCapPhongTableView;

    @FXML
    private TableColumn<TableHoaDonNangCapPhong,String> MaHDNCPColumn;

    @FXML
    private TableColumn<TableHoaDonNangCapPhong,String> SoPhongNCPColumn;

    @FXML
    private TableColumn<TableHoaDonNangCapPhong,String> NgaySuaChuaNCPColumn;

    @FXML
    private TableColumn<TableHoaDonNangCapPhong,String> NgayKetThucNCPColumn;

    @FXML
    private TableColumn<TableHoaDonNangCapPhong,String> TongTienSuaChuaNCPColumn;

    @FXML
    private TableColumn<TableHoaDonNangCapPhong,String> ThanhToanNCPColumn;

    @FXML
    private TableColumn<TableHoaDonNangCapPhong,String> TinhTrangHDNCPColumn;

    @FXML
    private TableColumn<TableHoaDonNangCapPhong,String> DuyetThanhToanNCPColumn;

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
    ObservableList<TableHoaDonSuaThietBi> listhoadonsctb = FXCollections.observableArrayList();
    ObservableList<TableHoaDonNangCapPhong> listhoadonncp = FXCollections.observableArrayList();
    
    public void initialize(URL arg0, ResourceBundle arg1) {
    	HienTableHoaDonTTP();
    	HienTableHoaDonSuaChuaThietBi();
    	HienTableHoaDonNangCapPhong();
    	HienDataLenTextField();
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
    
    public void HienTableHoaDonSuaChuaThietBi() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("SELECT MA_HD,TENTB,SOLUONG,NGAYBD,CHIPHI,TONGTIEN,TINHTRANG,DUYETTHANHTOAN FROM hoa_don  "
					+ "where hoa_don.LOAI_HD ='Sữa Chữa Thiết Bị' "  );
			
				while (rs.next()) {	
					listhoadonsctb .add(new TableHoaDonSuaThietBi (rs.getString("MA_HD"),rs.getString("TENTB"),
							rs.getString("SOLUONG"),rs.getString("NGAYBD"),rs.getString("CHIPHI"),rs.getString("TONGTIEN"),
							rs.getString("TINHTRANG"),rs.getString("DUYETTHANHTOAN")));
				}
			}
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
    				MaHDSCTBColumn.setCellValueFactory(new PropertyValueFactory<>("MA_HD"));
    				TenTBColumn.setCellValueFactory(new PropertyValueFactory<>("TENTB"));
    				SoLuongTBColumn.setCellValueFactory(new PropertyValueFactory<>("SOLUONG"));
    				NgaySuaChuaColumn.setCellValueFactory(new PropertyValueFactory<>("NGAYBD"));
    				TongTienSCTBColumn.setCellValueFactory(new PropertyValueFactory<>("CHIPHI"));
    				ThanhToanSCTBColumn.setCellValueFactory(new PropertyValueFactory<>("TONGTIEN"));
    				TingTrangHDSCTBColumn.setCellValueFactory(new PropertyValueFactory<>("TINHTRANG"));
    				DuyetThanhToanSCTBCoLumn.setCellValueFactory(new PropertyValueFactory<>("DUYETTHANHTOAN"));
    				HoaDonSuaChuaThietBiTableView.setItems(listhoadonsctb);
    		
		 }
    
    public void HienTableHoaDonNangCapPhong() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("SELECT MA_HD,SOPHONG,NGAYBD,NGAYKT,CHIPHI,TONGTIEN,TINHTRANG,DUYETTHANHTOAN FROM hoa_don  "
					+ "where LOAI_HD = 'Nâng Cấp Phòng' "  );
			
				while (rs.next()) {	
					listhoadonncp .add(new TableHoaDonNangCapPhong (rs.getString("MA_HD"),rs.getString("SOPHONG"),
							rs.getString("NGAYBD"),rs.getString("NGAYKT"),rs.getString("CHIPHI"),rs.getString("TONGTIEN"),
							rs.getString("TINHTRANG"),rs.getString("DUYETTHANHTOAN")));
				}
			}
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
    				MaHDNCPColumn.setCellValueFactory(new PropertyValueFactory<>("MA_HD"));
    				SoPhongNCPColumn.setCellValueFactory(new PropertyValueFactory<>("SOPHONG"));
    				NgaySuaChuaNCPColumn.setCellValueFactory(new PropertyValueFactory<>("NGAYBD"));
    				NgayKetThucNCPColumn.setCellValueFactory(new PropertyValueFactory<>("NGAYKT"));
    				TongTienSuaChuaNCPColumn.setCellValueFactory(new PropertyValueFactory<>("CHIPHI"));
    				ThanhToanNCPColumn.setCellValueFactory(new PropertyValueFactory<>("TONGTIEN"));
    				TinhTrangHDNCPColumn.setCellValueFactory(new PropertyValueFactory<>("TINHTRANG"));
    				DuyetThanhToanNCPColumn.setCellValueFactory(new PropertyValueFactory<>("DUYETTHANHTOAN"));
    				HoaDonNangCapPhongTableView.setItems(listhoadonncp);
    		
		 }
    
    private void HienDataLenTextField() {
    	HoaDonThanhToanPhongTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		@Override
    		public void handle(MouseEvent event) {
    			TableHoaDonTTP tbl_nv = HoaDonThanhToanPhongTableView.getItems().get(HoaDonThanhToanPhongTableView.getSelectionModel().getSelectedIndex());
    			tb1TextField.setText(tbl_nv.getMA_HD_TTP());
    			
    		}
    		
    	});
    	
    	HoaDonSuaChuaThietBiTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		@Override
    		public void handle(MouseEvent event) {
    			TableHoaDonSuaThietBi tbl = HoaDonSuaChuaThietBiTableView.getItems().get(HoaDonSuaChuaThietBiTableView.getSelectionModel().getSelectedIndex());
    			tb2TextField.setText(tbl.getMA_HD());
    			
    		}
    		
    	});
    	
    	HoaDonNangCapPhongTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		@Override
    		public void handle(MouseEvent event) {
    			TableHoaDonNangCapPhong tb2 = HoaDonNangCapPhongTableView.getItems().get(HoaDonNangCapPhongTableView.getSelectionModel().getSelectedIndex());
    			tb3TextField.setText(tb2.getMA_HD());
    			
    		}
    		
    	});
}
    

    @FXML
    void DuyetThanhToanHoaDonNCPButtonListener(ActionEvent event) throws IOException {
    	try {						
   		 final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String value1 = "Đã Thanh Toán";
			String value2 = tb3TextField.getText();
			String query1 = "UPDATE hoa_don SET DUYETTHANHTOAN = '"+value1+"' WHERE MA_HD='"+value2+"' ";
			 PreparedStatement pst1 = conn.prepareStatement(query1);
			 pst1.executeUpdate();
			JOptionPane.showMessageDialog(null, "Thanh Toán Thành công!");
			 }
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
   	 UpdateTable();
    	
    }

    @FXML
    void DuyetThanhToanHoaDonSCTBButtonListener(ActionEvent event) throws IOException {
    	try {						
      		 final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
   			Connection conn = DriverManager.getConnection(DB_URL,"root","");
   			String value1 = "Đã Thanh Toán";
   			String value2 = tb2TextField.getText();
   			String query1 = "UPDATE hoa_don SET DUYETTHANHTOAN = '"+value1+"' WHERE MA_HD='"+value2+"' ";
   			 PreparedStatement pst1 = conn.prepareStatement(query1);
   			 pst1.executeUpdate();
   			JOptionPane.showMessageDialog(null, "Thanh Toán Thành công!");
   			 }
   		 catch(Exception e) {
   			JOptionPane.showMessageDialog(null, e);
   			}
      	 UpdateTable();
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
		 listhoadonsctb.clear();
		 listhoadonncp.clear();
		 HienTableHoaDonTTP();
		 HienTableHoaDonSuaChuaThietBi();
		 HienTableHoaDonNangCapPhong();
	}

    @FXML
    void XemHoaDonNCPButtonListener(ActionEvent event) throws IOException {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("ChiTietHoaDonNangCapPhongController.fxml"));
    		Parent HienHoaDonNCP = loader.load();
    		Stage stage = new Stage();
    		Scene scene = new Scene(HienHoaDonNCP);
    		TableHoaDonNangCapPhong tablehoadonncp = HoaDonNangCapPhongTableView.getSelectionModel().getSelectedItem();
    		ChiTietHoaDonNangCapPhongController controller = loader.getController();
    		controller.setNCP(tablehoadonncp);
    		stage.setTitle("Chi Tiết Hóa Đơn ");
    		stage.setScene(scene);
    		stage.show();
    		}
    		catch(Exception e) {
    			JOptionPane.showMessageDialog(null, e);
    		}
    }

    @FXML
    void XemHoaDonSCTBButtonListener(ActionEvent event) throws IOException {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("ChiTietHoaDonSuaChuaThietBiController.fxml"));
    		Parent HienHoaDonSCTB = loader.load();
    		Stage stage = new Stage();
    		Scene scene = new Scene(HienHoaDonSCTB);
    		TableHoaDonSuaThietBi tablehoadonsctb = HoaDonSuaChuaThietBiTableView.getSelectionModel().getSelectedItem();
    		ChiTietHoaDonSuaChuaThietBiController controller = loader.getController();
    		controller.setSCTB(tablehoadonsctb);
    		stage.setTitle("Chi Tiết Hóa Đơn ");
    		stage.setScene(scene);
    		stage.show();
    		}
    		catch(Exception e) {
    			JOptionPane.showMessageDialog(null, e);
    		}
    }
    
    

    @FXML
    void XoaHDTTPButtonListener(ActionEvent event) throws IOException {
    	if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá Hóa Đơn này?","Cảnh Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    		HoaDonThanhToanPhongTableView.getItems().removeAll(HoaDonThanhToanPhongTableView.getSelectionModel().getSelectedItems());
        	
        	String sql = "delete from hoadon_thanhtoanphong where MA_HD_TTP = ?";
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
    	else if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá Hóa Đơn này?","Cảnh Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION){
     		
     	}
    }

    @FXML
    void XoaHoaDonNCPButtonListener(ActionEvent event) throws IOException {
    	if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá Hóa Đơn này?","Cảnh Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    		HoaDonNangCapPhongTableView.getItems().removeAll(HoaDonNangCapPhongTableView.getSelectionModel().getSelectedItems());
        	
        	String sql = "delete from hoa_don where MA_HD = ?";
        	try {
        		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
        		Connection conn = DriverManager.getConnection(DB_URL,"root","");
        		PreparedStatement pst = conn.prepareStatement(sql);
        		pst.setString(1, tb3TextField.getText());
        		pst.execute();
        		JOptionPane.showMessageDialog(null, "Xoá Thành Công");
        	}
        	catch(Exception e) {
        		JOptionPane.showMessageDialog(null, e);
        	}
        	UpdateTable();	

    	}
    	else if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá Hóa Đơn này?","Cảnh Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION){
     		
     	}
    }

    @FXML
    void XoaHoaDonSCTBButtonListener(ActionEvent event) throws IOException {
    	if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá Hóa Đơn này?","Cảnh Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    		HoaDonSuaChuaThietBiTableView.getItems().removeAll(HoaDonSuaChuaThietBiTableView.getSelectionModel().getSelectedItems());
        	
        	String sql = "delete from hoa_don where MA_HD = ?";
        	try {
        		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
        		Connection conn = DriverManager.getConnection(DB_URL,"root","");
        		PreparedStatement pst = conn.prepareStatement(sql);
        		pst.setString(1, tb2TextField.getText());
        		pst.execute();
        		JOptionPane.showMessageDialog(null, "Xoá Thành Công");
        	}
        	catch(Exception e) {
        		JOptionPane.showMessageDialog(null, e);
        	}
        	UpdateTable();	

    	}
    	else if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá Hóa Đơn này?","Cảnh Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION){
     		
     	}
    }
    
    @FXML
    void CapNhat3Button(ActionEvent event) {
    	UpdateTable();
    }

    @FXML
    void CapNhatButtonListener(ActionEvent event) {
    	UpdateTable();
    }

    @FXML
    void CapNhat2ButtonListener(ActionEvent event) {
    	UpdateTable();
    }

   
}
