package QuanLiKhachHang;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Check_in.ModelTable;
import Check_out.HoaDonTraPhongController;
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
    private TableView<TableKhachHang> DanhSachKHTableView;

    @FXML
    private TableColumn<TableKhachHang, String> MaKHColumn;

    @FXML
    private TableColumn<TableKhachHang, String> TenKHLabel;

    @FXML
    private TableColumn<TableKhachHang, String> NgaySinhColumn;

    @FXML
    private TableColumn<TableKhachHang, String> GTColumn;

    @FXML
    private TableColumn<TableKhachHang, String> ĐiaChiColumn;

    @FXML
    private TableColumn<TableKhachHang, String> QuocTichColumn;

    @FXML
    private TableColumn<TableKhachHang, String> SDTColumn;

    @FXML
    private TableColumn<TableKhachHang, String> CMNDColumn;

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
			ResultSet rs = conn.createStatement().executeQuery("select * from khachhang ");
			
				while (rs.next()) {	
					listkh.add(new TableKhachHang(rs.getString("MAKH"),rs.getString("TENKH"),
							rs.getString("NGAYSINH"),rs.getString("GIOITINH"),rs.getString("DIACHI"),
							rs.getString("QUOCTICH"), 
							rs.getString("SDT"),rs.getString("CMND")));
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
		 DanhSachKHTableView.setItems(listkh);
		 }
    
    public void UpdateTable() {
		 listkh.clear();
		 HienTableKhachHang();
	}
    
    @FXML
    void DanhGiaButtonListener(ActionEvent event) throws IOException {
    	UpdateTable();
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
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("SuaKhachHangController.fxml"));
    		Parent HienDanhSachSuaKhachHang = loader.load();
    		Stage stage = new Stage();
    		Scene scene = new Scene(HienDanhSachSuaKhachHang);
    		TableKhachHang selected = DanhSachKHTableView.getSelectionModel().getSelectedItem();
    		SuaKhachHangController controller = loader.getController();
    		controller.setKhachHang(selected);
    		stage.setTitle("Khách Hàng");
    		stage.setScene(scene);
    		stage.show();
    		}
    		catch(Exception e) {
    			JOptionPane.showMessageDialog(null, e);
    		}
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
