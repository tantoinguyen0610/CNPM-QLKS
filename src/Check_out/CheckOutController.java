package Check_out;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Check_in.ModelTable;
import HoaDon.ChiTietHoaDonThanhToanPhongController;
import HoaDon.TableHoaDonTTP;
import QuanLiDichVu.TableDichVuAnUong;
import QuanLiKhachHang.PhieuDV;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CheckOutController implements Initializable {

    @FXML
    private Button Button_TraPhong;

    @FXML
    private Label CO_Label;

    @FXML
	public TableView<ModelTable> Table_Check_In;

    @FXML
    private TableColumn<ModelTable, Integer> Tbl_Col_STT;
    
    @FXML
    private TableColumn<ModelTable, String> Tbl_Col_CMND;

    @FXML
    private TableColumn<ModelTable, Integer> Tbl_Col_SDT;
    
    @FXML
    private TableColumn<ModelTable, String> Tbl_Col_SoNguoi1Phong;

    @FXML
    private TableColumn<ModelTable, String> Tbl_Col_LoaiPhong;
    
    @FXML
    private TableColumn<ModelTable, String> Tbl_Col_KH;

    @FXML
    private TableColumn<ModelTable, String> Tbl_Col_MaDP;

    @FXML
    private TableColumn<ModelTable, String> Tbl_Col_SoPhong;

    @FXML
    private TableColumn<ModelTable, String> Tbl_Col_NgayDat;

    @FXML
    private TableColumn<ModelTable, String> Tbl_Col_NgayNhan;

    @FXML
    private TableColumn<ModelTable, String> Tbl_Col_SoNgayO;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
  
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		HienTableCheckIn();
		Button_TraPhong.setDisable(true);
		 HienDataLenTextField();
	}
	
	private void HienDataLenTextField() {
		Table_Check_In.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		@Override
    		public void handle(MouseEvent event) {
    			
    			Button_TraPhong.setDisable(false);
    		}
    		
    	});
	}
	
	public void HienTableCheckIn() {
		 try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("select MA_PT,TENKH,CMND,SDT,SONGUOI1PHONG,LOAIPHONG,SOPHONG,NGAYDAT, NGAYNHAN, SONGAYO, MA_DATPHONG "
					+ "from phieuthuephong, khachhang "
					+ "where khachhang.MAKH=phieuthuephong.MA_PT");
			
				while (rs.next()) {	
					oblist.add(new ModelTable(rs.getString("MA_PT"),rs.getString("TENKH"),
							rs.getString("CMND"),rs.getString("SDT"),rs.getString("SONGUOI1PHONG"),
							rs.getString("LOAIPHONG"),rs.getString("SOPHONG"),rs.getString("NGAYDAT"),
							rs.getString("NGAYNHAN"),rs.getString("SONGAYO"),rs.getString("MA_DATPHONG")));
				}
			}
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
		 	Tbl_Col_STT.setCellValueFactory(new PropertyValueFactory<>("MA_PT"));
			Tbl_Col_KH.setCellValueFactory(new PropertyValueFactory<>("TENKH"));
			Tbl_Col_CMND.setCellValueFactory(new PropertyValueFactory<>("CMND"));
			Tbl_Col_SDT.setCellValueFactory(new PropertyValueFactory<>("SDT"));
			Tbl_Col_SoNguoi1Phong.setCellValueFactory(new PropertyValueFactory<>("SONGUOI1PHONG"));
			Tbl_Col_LoaiPhong.setCellValueFactory(new PropertyValueFactory<>("LOAIPHONG"));
			Tbl_Col_SoPhong.setCellValueFactory(new PropertyValueFactory<>("SOPHONG"));
			Tbl_Col_NgayDat.setCellValueFactory(new PropertyValueFactory<>("NGAYDAT"));
			Tbl_Col_NgayNhan.setCellValueFactory(new PropertyValueFactory<>("NGAYNHAN"));
			Tbl_Col_SoNgayO.setCellValueFactory(new PropertyValueFactory<>("SONGAYO"));
			Tbl_Col_MaDP.setCellValueFactory(new PropertyValueFactory<>("MA_DATPHONG"));
			Table_Check_In.setItems(oblist);
	}
	
	@FXML
    void TraPhong_ActionListener(ActionEvent event) throws IOException {
		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GiaoDien_HoaDonTraPhong.fxml"));
			Parent HienLenTextFieldHoaDon = loader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(HienLenTextFieldHoaDon);
			ModelTable selected = Table_Check_In.getSelectionModel().getSelectedItem();
			HoaDonTraPhongController controller = loader.getController();
			controller.setHoaDonTraPhong(selected);
			stage.setTitle("Hoa Don Thanh Toan");
			stage.setScene(scene);
			stage.show();
			
    }
	
}
