package NhanVien;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Check_in.ModelTable;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    private Label BangNV_Label;

    @FXML
    private Button Button_ChamCong;

    @FXML
    private Button Button_ThemNV;

    @FXML
    private Button Button_Sua;

    @FXML
    private Button Button_Xoa;
    
    ObservableList<TableNhanVien> listnv = FXCollections.observableArrayList();
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
    	HienTableNhanVien();
	}
    
    public void HienTableNhanVien() {
		 try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("select nhanvien.MANV,TENNV,CHUCVU,CA_LAM,TRANGTHAI,NGAYLAMVIEC,GIOVAO, GIORA,nhanvien.SDT "
					+ "											from nhanvien,cham_cong "
					+ "											where nhanvien.MANV=cham_cong.MANV");
			
				while (rs.next()) {	
					listnv.add(new TableNhanVien(rs.getString("MANV"),rs.getString("TENNV"),
							rs.getString("CHUCVU"),rs.getString("CA_LAM"),rs.getString("TRANGTHAI"),
							rs.getString("NGAYLAMVIEC"),rs.getString("GIOVAO"),rs.getString("GIORA"), rs.getString("SDT")));
				}
				Col_STT.setCellValueFactory(new PropertyValueFactory<>("MANV"));
			 	Col_Ten.setCellValueFactory(new PropertyValueFactory<>("TENNV"));
			 	Col_ChucVu.setCellValueFactory(new PropertyValueFactory<>("CHUCVU"));
			 	Col_CaLam.setCellValueFactory(new PropertyValueFactory<>("CA_LAM"));
			 	Col_TrangThai.setCellValueFactory(new PropertyValueFactory<>("TRANGTHAI"));
			 	Col_NgayLamViec.setCellValueFactory(new PropertyValueFactory<>("NGAYLAMVIEC"));
			 	Col_GioVao.setCellValueFactory(new PropertyValueFactory<>("GIOVAO"));
			 	Col_GioRa.setCellValueFactory(new PropertyValueFactory<>("GIORA"));
			 	Col_SDT.setCellValueFactory(new PropertyValueFactory<>("SDT"));
				
				Callback<TableColumn<TableNhanVien,String>,TableCell<TableNhanVien,String>> cellFactory=(param) ->{
					final TableCell<TableNhanVien,String> cell = new TableCell<TableNhanVien,String>(){
						public void updateItem(String item, boolean empty) {
							super.updateItem(item, empty);
							if (empty) {
								setGraphic(null);
								setText(null);
							}
							else {
								final Button btn_nhiemvu= new Button("Xem thêm");
								setGraphic(btn_nhiemvu);
								setText(null);
								
								
							}
						};
						
					};
					return cell;
				};
				Col_NhiemVu.setCellFactory((cellFactory));
				
				Callback<TableColumn<TableNhanVien,String>,TableCell<TableNhanVien,String>> cellFactory1=(param) ->{
					final TableCell<TableNhanVien,String> cell = new TableCell<TableNhanVien,String>(){
						public void updateItem(String item, boolean empty) {
							super.updateItem(item, empty);
							if (empty) {
								setGraphic(null);
								setText(null);
							}
							else {
								final Button btn_ghichu= new Button("Xem thêm");
								setGraphic(btn_ghichu);
								setText(null);
								
								
							}
						};
						
					};
					return cell;
				};
				Col_GhiChu.setCellFactory((cellFactory1));
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
    void SuaNV_ActionListener(ActionEvent event) {

    }

    @FXML
    void ThemNV_ActionListener(ActionEvent event) throws Exception {
    	Parent parent = FXMLLoader.load(
				getClass().getResource("GiaoDien_ThemNV.fxml"));
				Scene scene = new Scene(parent);
				Stage stage = new Stage();
				stage.setTitle("Thêm nhân viên");
				stage.setScene(scene);
				stage.show();
    }

    @FXML
    void XoaNV_ActionListener(ActionEvent event) {

    }

}
