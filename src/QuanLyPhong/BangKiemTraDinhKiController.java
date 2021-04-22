package QuanLyPhong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.DocFlavor.URL;
import javax.swing.JOptionPane;

import Check_in.ModelTable;
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

public class BangKiemTraDinhKiController implements Initializable {

    @FXML
    private AnchorPane Ap;

    @FXML
    private TableView<TableKTDK> tbview1;

    @FXML
    private TableColumn<Integer, TableKTDK> tcMaKT;

    @FXML
    private TableColumn<Integer, TableKTDK> tcPhong;

    @FXML
    private TableColumn<String, TableKTDK> tcNgayKT;

    @FXML
    private TableColumn<String, TableKTDK> tcGiobatdau;

    @FXML
    private TableColumn<String, TableKTDK> tcGioketthuc;

    @FXML
    private TableColumn<String, TableKTDK> tcTinhTrangSauKT;

    @FXML
    private TableColumn<String, TableKTDK> tcGhichu;

    @FXML
    private Label lbbangkiemtradinhki;

    @FXML
    private Button btThoat;

    @FXML
    private Label lbngaykiemtra;

    @FXML
    private Label lbghichu;

    @FXML
    private Label lbGioketthuc;

    @FXML
    private Label lbGiobatdau;

    @FXML
    private Label lbTrangthaisausuachua;

    @FXML
    private Button btThem;

    @FXML
    private DatePicker dtNgaykiemtra;

    @FXML
    private TextField tfGioketthuc;

    @FXML
    private TextField tfGhichu;

    @FXML
    private ComboBox<String> cbTrangthaisausuachua;

    @FXML
    private TextField tfGiobatdau;

    @FXML
    private Button btReset;

    @FXML
    private Label err_SoPhong;

    @FXML
    private Label err_NgayKT;

    @FXML
    private Label err_GioBD;

    @FXML
    private Label err_GioKT;

    @FXML
    private Label err_SauKT;
    
    @FXML
    private Label SoPhong_Label;

    @FXML
    private ComboBox<String> SoPhong_cmb;
    
    @FXML
    private Button Button_Sua;

    @FXML
    private Button Button_Xoa;
    
    @FXML
    private TextField MaKT_textField;


    ObservableList<String> cb_sophong  = FXCollections.observableArrayList("101","102","103","104","105","106");
    ObservableList<TableKTDK> table_ktdk = FXCollections.observableArrayList();
    ObservableList<String> cb_Trangthaisausuachua = FXCollections.observableArrayList("","Bình thường", "Cần sửa chữa", "Cần thay thế");
    @Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		cbTrangthaisausuachua.setItems(cb_Trangthaisausuachua);
		SoPhong_cmb.setItems(cb_sophong);
		HienTableKTDK();
		ChuyenNguocNamThangNgay();
		Button_Xoa.setDisable(true);
		HienDataLenTextField();
		autoTaoMaKT();
	}
    
    private void HienDataLenTextField() {
    	tbview1.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		@Override
    		public void handle(MouseEvent event) {
    			TableKTDK tbl_nv = tbview1.getItems().get(tbview1.getSelectionModel().getSelectedIndex());
    			MaKT_textField.setText(tbl_nv.getMA_KTDK());
    			SoPhong_cmb.setValue(tbl_nv.getTEN_PHONG());
    			((TextField)dtNgaykiemtra.getEditor()).setText(tbl_nv.getNGAY_KT());
    			tfGiobatdau.setText(tbl_nv.getGIO_BD());
    			tfGioketthuc.setText(tbl_nv.getGIO_KT());
    			cbTrangthaisausuachua.setValue(tbl_nv.getTRANGTHAISAUKT());
    			tfGhichu.setText(tbl_nv.getGHI_CHU());
    			Button_Xoa.setDisable(false);
    		}
    		
    	});
    }

    @FXML
    void btReset(ActionEvent event) {
    	SoPhong_cmb.getSelectionModel().clearSelection();
    	dtNgaykiemtra.getEditor().clear();
    	tfGiobatdau.setText("");
    	tfGioketthuc.setText("");
    	cbTrangthaisausuachua.getSelectionModel().clearSelection();
    	tfGhichu.setText("");
    	XoaCanhBao();
    	UpdateTable();
    }
    
    public void XoaCanhBao() {
		err_SoPhong.setText(""); 
		err_NgayKT.setText("");
		err_GioBD.setText("");
		err_GioKT.setText("");
		err_SoPhong.setText("");
		err_SauKT.setText("");
	}

    @FXML
    void btThembangkiemtradinhki(ActionEvent event) {
    	if(KiemTraNgayKT() & KiemTraGioBD() & KiemTraGioKT() & KiemTraSoPhong() & KiemTraTrangThai()) {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query = "insert into bang_kiem_tra_dinh_ki (MA_KTDK,TEN_PHONG,NGAY_KT,GIO_BD,GIO_KT,TRANGTHAISAUKT,GHI_CHU) "
							+ "VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,MaKT_textField.getText() );
			pst.setString(2, SoPhong_cmb.getValue().toString());
			pst.setString(3,((TextField)dtNgaykiemtra.getEditor()).getText());
			pst.setString(4,tfGiobatdau.getText() );
			pst.setString(5, tfGioketthuc.getText());
			pst.setString(6, cbTrangthaisausuachua.getValue().toString());
			pst.setString(7, tfGhichu.getText());
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
		}
	catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi!" + e);
		}
    	UpdateTable();
    	XoaCanhBao();
    	autoTaoMaKT();
    	}
    	
    }
    
   

    @FXML
    void btThoat(ActionEvent event) {
    	 Stage stage = (Stage) btThoat.getScene().getWindow();
    	    stage.close();
    }
    
    @FXML
    void Sua_ActionListener(ActionEvent event) {
    	 int response=	JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn lưu cập nhật?", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
      	if(response == JOptionPane.YES_OPTION) {
      		try {
     			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
     			Connection conn = DriverManager.getConnection(DB_URL,"root","");
     			String value0 = SoPhong_cmb.getValue().toString();
     			String value1 = ((TextField)dtNgaykiemtra.getEditor()).getText();
     			String value2 = tfGiobatdau.getText();
     			String value3 = tfGioketthuc.getText();
     			String value4 = cbTrangthaisausuachua.getValue().toString();
     			String value5 = tfGhichu.getText();
     			String value6 = MaKT_textField.getText();
     			String sql = "update bang_kiem_tra_dinh_ki set TEN_PHONG= '"+value0+"',NGAY_KT='"+value1+"', GIO_BD='"+value2+"',GIO_KT='"+value3+"', TRANGTHAISAUKT='"+value4+"', GHI_CHU='"+value5+"' where bang_kiem_tra_dinh_ki.MA_KTDK = '"+value6+"' ";
     			PreparedStatement pst = conn.prepareStatement(sql);	
     			pst.execute();
     			JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
     		}catch(Exception e) {
     			JOptionPane.showMessageDialog(null, e);
     		}
      		
      		UpdateTable();
      	}
      	else if(response == JOptionPane.NO_OPTION){
      		
      	}
     	
    }

    @FXML
    void Xoa_ActionListener(ActionEvent event) {
    	if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá phiếu KTDK này?","Cảnh Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    		tbview1.getItems().removeAll(tbview1.getSelectionModel().getSelectedItems());
        	
        	String sql = "delete from bang_kiem_tra_dinh_ki where MA_KTDK = ?";
        	try {
        		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
        		Connection conn = DriverManager.getConnection(DB_URL,"root","");
        		PreparedStatement pst = conn.prepareStatement(sql);
        		pst.setString(1, MaKT_textField.getText());
        		pst.execute();
        		JOptionPane.showMessageDialog(null, "Xoá Thành Công");
        	}
        	catch(Exception e) {
        		JOptionPane.showMessageDialog(null, e);
        	}
        	UpdateTable();	
        	autoTaoMaKT();
    	}
    	else if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá phiếu KTDK này?","Cảnh Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION){
     		
     	}
    }

    public void HienTableKTDK() {
		 try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("select MA_KTDK,TEN_PHONG,NGAY_KT,GIO_BD,GIO_KT,TRANGTHAISAUKT,GHI_CHU from bang_kiem_tra_dinh_ki ");
			
				while (rs.next()) {	
					table_ktdk.add(new TableKTDK(rs.getString("MA_KTDK"),rs.getString("TEN_PHONG"),
							rs.getString("NGAY_KT"),rs.getString("GIO_BD"),rs.getString("GIO_KT"),
							rs.getString("TRANGTHAISAUKT"),rs.getString("GHI_CHU")));
				}
			}
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
		 	tcMaKT.setCellValueFactory(new PropertyValueFactory<>("MA_KTDK"));
		 	tcPhong.setCellValueFactory(new PropertyValueFactory<>("TEN_PHONG"));
		 	tcNgayKT.setCellValueFactory(new PropertyValueFactory<>("NGAY_KT"));
		 	tcGiobatdau.setCellValueFactory(new PropertyValueFactory<>("GIO_BD"));
		 	 tcGioketthuc.setCellValueFactory(new PropertyValueFactory<>("GIO_KT"));
		 	tcTinhTrangSauKT.setCellValueFactory(new PropertyValueFactory<>("TRANGTHAISAUKT"));
		 	tcGhichu.setCellValueFactory(new PropertyValueFactory<>("GHI_CHU"));
		 	tbview1.setItems(table_ktdk);
	}
    
    public void UpdateTable() {
    	table_ktdk.clear();
    	HienTableKTDK();
	}
    
    private boolean KiemTraNgayKT() {
    	
		if(((TextField)dtNgaykiemtra.getEditor()).getText().isEmpty())
				
			{
			err_NgayKT.setText("Vui lòng nhập ngày KT");
			return false;
			}
		return true;
	}
    
    private boolean KiemTraGioBD() {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(tfGiobatdau.getText());
		if(m.find() && m.group().equals(tfGiobatdau.getText())){
			return true;
		}
		else {
			err_GioBD.setText("Vui lòng nhập giờ BĐ hợp lệ!");
			return false;
		}
	}
    private boolean KiemTraGioKT() {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(tfGioketthuc.getText());
		if(m.find() && m.group().equals(tfGioketthuc.getText())){
			return true;
		}
		else {
			err_GioKT.setText("Vui lòng nhập giờ KT hợp lệ!");
			return false;
		}
	}

private boolean KiemTraSoPhong() {
	
	if(SoPhong_cmb.getSelectionModel().isEmpty())
		{
		err_SoPhong.setText("Vui lòng chọn số phòng");
		return false;
		}
	return true;
}

private boolean KiemTraTrangThai() {
	
	if(cbTrangthaisausuachua.getSelectionModel().isEmpty())
		{
		err_SauKT.setText("Vui lòng chọn tình trạng phòng");
		return false;
		}
	return true;
}

public void ChuyenNguocNamThangNgay()
{
	dtNgaykiemtra.setConverter(
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

public void autoTaoMaKT() {
	try {
		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
		Connection conn = DriverManager.getConnection(DB_URL,"root","");
		Statement s= conn.createStatement();
		
		ResultSet rs = s.executeQuery("select Max(MA_KTDK) from bang_kiem_tra_dinh_ki");
		rs.next();
		rs.getString("Max(MA_KTDK)");
		
		if(rs.getString("Max(MA_KTDK)")== null)
		{
			MaKT_textField.setText("1");
		}
		else
		{
			int matb = Integer.parseInt(rs.getString("Max(MA_KTDK)"));
			matb++;
			MaKT_textField.setText(String.format("%d",matb));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

}
