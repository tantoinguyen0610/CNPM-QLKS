package QuanLyPhong;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import NhanVien.TableNhanVien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class QuanLyThietBiController implements Initializable {

    @FXML
    private AnchorPane Ap;
    
    @FXML
    private TableView<TableQLTB> TableTB;

    @FXML
    private TableColumn<Integer, TableQLTB> tcMathietbi;

    @FXML
    private TableColumn<String, TableQLTB> tcTenthietbi;

    @FXML
    private TableColumn<String, TableQLTB> tcNgaynhapkho;

    @FXML
    private TableColumn<String, TableQLTB> tcNgayxuatkho;

    @FXML
    private TableColumn<String, TableQLTB> tcTinhtrang;

    @FXML
    private TableColumn<String, TableQLTB> tcVitri;

    @FXML
    private Label lbQuanlythietbi;

    @FXML
    private TextField TenTB_textField;

    @FXML
    private DatePicker NgayNhapKho;

    @FXML
    private DatePicker NgayXuatKho;

    @FXML
    private ComboBox<String> TinhTrang_cmb;

    @FXML
    private Button btThoat1;

    @FXML
    private Button btThem;

    @FXML
    private Button btReset;
    
    @FXML
    private Button Button_Sua;

    @FXML
    private Button Button_Xoa;

    @FXML
    private Label err_TenTB;

    @FXML
    private Label err_NgayNhapKho;

    @FXML
    private Label err_NgayXuatKho;

    @FXML
    private Label err_TinhTrang;

    @FXML
    private Label err_ViTri;
    
    @FXML
    private TextField ViTri_textField;
    
    @FXML
    private TextField MaTB_textField;
    
    ObservableList<String> tinhtrang = FXCollections.observableArrayList("Bình thường", "Cần bảo trì");
    ObservableList<TableQLTB> table_qltb = FXCollections.observableArrayList();
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	TinhTrang_cmb.setItems(tinhtrang);
    	HienTableQLTB();
    	ChuyenNguocNamThangNgay();
    	autoTaoMaTB();
    	HienDataLenTextField();
    	Button_Xoa.setDisable(true);
	}

    @FXML
    void btReset(ActionEvent event) {
    	XoaCanhBao();
    	TenTB_textField.setText("");
    	NgayNhapKho.getEditor().clear();
    	NgayXuatKho.getEditor().clear();
    	TinhTrang_cmb.getSelectionModel().clearSelection();
    	ViTri_textField.setText("");
    	UpdateTable();
    }

    @FXML
    void btThembangkiemtradinhki(ActionEvent event) {
    	if(KiemTraViTri()&KiemTraTen()&KiemTraNgayNhapKho()&KiemTraNgayXuatKho()&KiemTraTinhtrang()) {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query = "insert into thiet_bi (MA_THIETBI,TEN_THIETBI,NGAY_NHAP,NGAY_XUAT,TINHTRANG,VI_TRI) "
							+ "VALUES(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, MaTB_textField.getText());
			pst.setString(2,TenTB_textField.getText());
			pst.setString(3,((TextField)NgayNhapKho.getEditor()).getText() );
			pst.setString(4, ((TextField)NgayXuatKho.getEditor()).getText());
			pst.setString(5, TinhTrang_cmb.getValue().toString());
			pst.setString(6, ViTri_textField.getText());
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
		}
	catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi!" + e);
		}
    	}
    	UpdateTable();
    	XoaCanhBao();
    	autoTaoMaTB();
    	}
    
    private void HienDataLenTextField() {
    	TableTB.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		@Override
    		public void handle(MouseEvent event) {
    			TableQLTB tbl_nv = TableTB.getItems().get(TableTB.getSelectionModel().getSelectedIndex());
    			MaTB_textField.setText(tbl_nv.getMA_THIETBI());
    			TenTB_textField.setText(tbl_nv.getTEN_THIETBI());
    			((TextField)NgayNhapKho.getEditor()).setText(tbl_nv.getNGAY_NHAP());
    			((TextField)NgayXuatKho.getEditor()).setText(tbl_nv.getNGAY_XUAT());
    			TinhTrang_cmb.setValue(tbl_nv.getTINHTRANG());
    			ViTri_textField.setText(tbl_nv.getVI_TRI());
    			Button_Xoa.setDisable(false);
    		}
    		
    	});
    }
    

    public void XoaCanhBao() {
		err_TenTB.setText(""); 
		err_NgayNhapKho.setText("");
		err_NgayXuatKho.setText("");
		err_TinhTrang.setText("");
		err_ViTri.setText("");
	}
    
	public void HienTableQLTB() {
	 try {
		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
		Connection conn = DriverManager.getConnection(DB_URL,"root","");
		ResultSet rs = conn.createStatement().executeQuery("select * from thiet_bi ");
		
			while (rs.next()) {	
				table_qltb.add(new TableQLTB(rs.getString("MA_THIETBI"),rs.getString("TEN_THIETBI"),
						rs.getString("NGAY_NHAP"),rs.getString("NGAY_XUAT"),rs.getString("TINHTRANG"),
						rs.getString("VI_TRI")));
			}
		}
	 catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
		}
	 tcMathietbi.setCellValueFactory(new PropertyValueFactory<>("MA_THIETBI"));
	 tcTenthietbi.setCellValueFactory(new PropertyValueFactory<>("TEN_THIETBI"));
	 tcNgaynhapkho.setCellValueFactory(new PropertyValueFactory<>("NGAY_NHAP"));
	 tcNgayxuatkho.setCellValueFactory(new PropertyValueFactory<>("NGAY_XUAT"));
	 tcTinhtrang.setCellValueFactory(new PropertyValueFactory<>("TINHTRANG"));
	 tcVitri.setCellValueFactory(new PropertyValueFactory<>("VI_TRI"));
	 TableTB.setItems(table_qltb);
}
	public void UpdateTable() {
    	table_qltb.clear();
    	HienTableQLTB();
	}

    @FXML
    void btThoat(ActionEvent event) {
    	Stage stage = (Stage) btThoat1.getScene().getWindow();
	    stage.close();
    }

    @FXML
    void Sua_ActionListener(ActionEvent event) {
    	 int response=	JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn lưu cập nhật?", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     	if(response == JOptionPane.YES_OPTION) {
     		try {
    			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
    			Connection conn = DriverManager.getConnection(DB_URL,"root","");
    			String value0 = TenTB_textField.getText();
    			String value1 = ((TextField)NgayNhapKho.getEditor()).getText();
    			String value2 = ((TextField)NgayXuatKho.getEditor()).getText();
    			String value3 = TinhTrang_cmb.getValue().toString();
    			String value4 = ViTri_textField.getText();
    			String value5 = MaTB_textField.getText();
    			String sql = "update thiet_bi set TEN_THIETBI= '"+value0+"',NGAY_NHAP='"+value1+"', NGAY_XUAT='"+value2+"', TINHTRANG='"+value3+"', VI_TRI='"+value4+"' where MA_THIETBI = '"+value5+"'";
    			PreparedStatement pst = conn.prepareStatement(sql);	
    			pst.execute();
    			JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
     		UpdateTable();
     	}
     	else if(response == JOptionPane.NO_OPTION){
     		
     	}
    	
    }

    @FXML
    void Xoa_ActionListener(ActionEvent event) {
    	if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá thiết bị này?","Cảnh Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    		TableTB.getItems().removeAll(TableTB.getSelectionModel().getSelectedItems());
        	
        	String sql = "delete from thiet_bi where MA_THIETBI = ?";
        	try {
        		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
        		Connection conn = DriverManager.getConnection(DB_URL,"root","");
        		PreparedStatement pst = conn.prepareStatement(sql);
        		pst.setString(1, MaTB_textField.getText());
        		pst.execute();
        		JOptionPane.showMessageDialog(null, "Xoá Thành Công");
        	}
        	catch(Exception e) {
        		JOptionPane.showMessageDialog(null, e);
        	}
        	UpdateTable();	
    	}
    	else if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá thiết bị này?","Cảnh Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION){
     		
     	}
    }
    
private boolean KiemTraViTri() {
		
  		if(ViTri_textField.getText().isEmpty())
  			{
  			err_ViTri.setText("Vui lòng nhập vị trí hợp lệ!");
  			return false;
  			}
  		return true;
  	}
    
    private boolean KiemTraTen() {
		
  		if(TenTB_textField.getText().isEmpty())
  			{
  			err_TenTB.setText("Vui lòng nhập tên TB hợp lệ!");
  			return false;
  			}
  		return true;
  	}
    private boolean KiemTraNgayNhapKho() {
    	
		if(((TextField)NgayNhapKho.getEditor()).getText().isEmpty())
				
			{
			err_NgayNhapKho.setText("Vui lòng nhập ngày nhập kho");
			return false;
			}
		return true;
	}

	private boolean KiemTraNgayXuatKho() {
	
	if(((TextField)NgayXuatKho.getEditor()).getText().isEmpty())
			
		{
		err_NgayXuatKho.setText("Vui lòng nhập ngày xuất kho");
		return false;
		}
	return true;
}
	
	private boolean KiemTraTinhtrang() {
		
		if( TinhTrang_cmb.getSelectionModel().isEmpty())
			{
			err_TinhTrang.setText("Vui lòng chọn tình trạng TB");
			return false;
			}
		return true;
	}
	
	 public void ChuyenNguocNamThangNgay()
		{
	    	NgayNhapKho.setConverter(
					   new StringConverter<LocalDate>() {
					          final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

					          @Override
					          public String toString(LocalDate date) {
					            return (date != null) ? dateFormatter.format(date) : "";
					          }

					          @Override
					          public LocalDate fromString(String string) {
					            return (string != null && !string.isEmpty())
					                ? LocalDate.parse(string, dateFormatter)
					                : null;
					          }
					        });
	    	NgayXuatKho.setConverter(
							   new StringConverter<LocalDate>() {
							          final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

							          @Override
							          public String toString(LocalDate date) {
							            return (date != null) ? dateFormatter.format(date) : "";
							          }

							          @Override
							          public LocalDate fromString(String string) {
							            return (string != null && !string.isEmpty())
							                ? LocalDate.parse(string, dateFormatter)
							                : null;
							          }
							        });
		}
	 
	 public void autoTaoMaTB() {
			try {
				final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
				Connection conn = DriverManager.getConnection(DB_URL,"root","");
				Statement s= conn.createStatement();
				
				ResultSet rs = s.executeQuery("select Max(MA_THIETBI) from thiet_bi");
				rs.next();
				rs.getString("Max(MA_THIETBI)");
				
				if(rs.getString("Max(MA_THIETBI)")== null)
				{
					MaTB_textField.setText("1");
				}
				else
				{
					int matb = Integer.parseInt(rs.getString("Max(MA_THIETBI)"));
					matb++;
					MaTB_textField.setText(String.format("%d",matb));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
