package QuanLiKhachHang;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Check_in.CheckInController;
import Check_in.ModelTable;
import NhanVien.TableNhanVien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PhieuDichVuController implements Initializable {

    @FXML
    private Label PhieuDichVuLabel;
    
    @FXML
    private TableView<PhieuDV> tbl_PDV;

    @FXML
    private TableColumn<Integer, PhieuDV> col_MaPhieu;

    @FXML
    private TableColumn<String, PhieuDV> col_SoPhong;

    @FXML
    private TableColumn<String, PhieuDV> col_TenDV;

    @FXML
    private TableColumn<String, PhieuDV> col_GiaTien;

    @FXML
    private TableColumn<String, PhieuDV> col_SoLuong;

    @FXML
    private TableColumn<String, PhieuDV> col_TongTien;

    @FXML
    private Button LuuButton;

    @FXML
    private Button Xoa_Button;

    @FXML
    private Button HuyBotton;

    @FXML
    private Button Reset_Button;

    @FXML
    private Button Sua_Button;

    @FXML
    private TextField SL_textField;

    @FXML
    private ComboBox<String> TenDV_cmb;

    @FXML
    private Label err_TenDV;

    @FXML
    private Label err_SL;

    @FXML
    private TextField MaPhieuDV_textField;

    @FXML
    private TextField Gia_textField;

    @FXML
    private TextField TT_textField;

    @FXML
    private ComboBox<String> SoPhong_cmb;

    @FXML
    private Label err_SoPhong;
    
    ObservableList<String> list_tendv = FXCollections.observableArrayList();
    ObservableList<String> list_sophong = FXCollections.observableArrayList("101","102","103","104","105","106");
    ObservableList<PhieuDV> phieudv = FXCollections.observableArrayList();
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	HienComboboxTenDV();
    	HienTablePhieuDV();
    	 autoTaoMaPDV();
    	 SoPhong_cmb.setItems(list_sophong);
    	 Sua_Button.setDisable(true);
    	 Xoa_Button.setDisable(true);
    	 HienDataLenTextField() ;
	}
    
    public void HienComboboxTenDV() {
		 
		 try {
			 final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			 Connection conn = DriverManager.getConnection(DB_URL,"root","");
			 String query = "select TENDV from dv";
			 PreparedStatement pst = conn.prepareStatement(query);
			 ResultSet rs = pst.executeQuery();
			 while (rs.next())
			 {
				 list_tendv.add(rs.getString("TENDV"));
				 TenDV_cmb.setItems(list_tendv);
			 }
			 pst.close();
			 rs.close();
		 }
		 catch(SQLException ex)
		 {
			 Logger.getLogger(CheckInController.class.getName()).log(Level.SEVERE,null,ex);
		 }
	 }
    
    public void HienTablePhieuDV() {
		 try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("select MAPHIEUDV,SOPHONG,dv.TENDV,GIA,phieu_dv.SOLUONG,TONGTIENDV from phieu_dv,dv where dv.TENDV=phieu_dv.TENDV ORDER by phieu_dv.MAPHIEUDV ASC");
			
				while (rs.next()) {	
					phieudv.add(new PhieuDV(rs.getString("MAPHIEUDV"),rs.getString("SOPHONG"),rs.getString("TENDV"),
							rs.getString("GIA"),rs.getString("SOLUONG"),rs.getString("TONGTIENDV")));
				}
			}
		 catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
		 col_MaPhieu.setCellValueFactory(new PropertyValueFactory<>("MAPHIEUDV"));
		 col_SoPhong.setCellValueFactory(new PropertyValueFactory<>("SOPHONG"));
		 col_TenDV.setCellValueFactory(new PropertyValueFactory<>("TENDV"));
		 col_GiaTien.setCellValueFactory(new PropertyValueFactory<>("GIA"));
		 col_SoLuong.setCellValueFactory(new PropertyValueFactory<>("SOLUONG"));
		 col_TongTien.setCellValueFactory(new PropertyValueFactory<>("TONGTIENDV"));
		 tbl_PDV.setItems(phieudv);
	}

    @FXML
    void HuyBottonListener(ActionEvent event) {
    	Stage stage = (Stage) HuyBotton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void LuuButtonListener(ActionEvent event) {
    	if(KiemTraTenDV()&KiemTraSL()&KiemTraSoPhong()) {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query = "insert into phieu_dv(MAPHIEUDV,SOPHONG,TENDV,SOLUONG,TONGTIENDV) "
							+ "VALUES(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, MaPhieuDV_textField.getText());
			pst.setString(2, SoPhong_cmb.getValue().toString());
			pst.setString(3, TenDV_cmb.getValue().toString());
			pst.setString(4, SL_textField.getText());
			Double tongtien=0.0;
			tongtien=tongtien + (Double.valueOf(Gia_textField.getText()) * Double.valueOf(SL_textField.getText()));
			TT_textField.setText(tongtien+"");
			pst.setString(5, TT_textField.getText());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
		}
	catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}}
    	UpdateTable();
    	TenDV_cmb.getSelectionModel().clearSelection();
    	SL_textField.setText("");
    	Gia_textField.setText("");
    	TT_textField.setText("");
    	err_TenDV.setText("");
    	err_SL.setText("");
    	 autoTaoMaPDV();
    	 XoaCanhBao();
    }
    
    public void UpdateTable() {
    	phieudv.clear();
    	HienTablePhieuDV();
    	 Sua_Button.setDisable(true);
    	 Xoa_Button.setDisable(true);
	}
    
private boolean KiemTraTenDV() {
		
		if(TenDV_cmb.getSelectionModel().isEmpty())
			{
			err_TenDV.setText("Vui lòng chọn Dịch Vụ!");
			return false;
			}
		return true;
	}

private boolean KiemTraSoPhong() {
	
	if(SoPhong_cmb.getSelectionModel().isEmpty())
		{
		err_SoPhong.setText("Vui lòng chọn Số phòng!");
		return false;
		}
	return true;
}
    
    private boolean KiemTraSL() {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(SL_textField.getText());
		if(m.find() && m.group().equals(SL_textField.getText())){
			return true;
		}
		else {
			err_SL.setText("Vui lòng điền số lượng hợp lệ");
			return false;
		}
	}
    
    public void HienThiTextFieldGiaTien() {
    	 try {
			 final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			 Connection conn = DriverManager.getConnection(DB_URL,"root","");
			 String	tendv =(String) TenDV_cmb.getSelectionModel().getSelectedItem();
			 String query = "SELECT GIA from dv WHERE TENDV ='"+tendv+"' ";
			 ResultSet rs = conn.createStatement().executeQuery(query);
			 while (rs.next())
			 {
				 Gia_textField.setText(rs.getString(1));
			 }
		 }
		 catch(SQLException ex)
		 {
			 Logger.getLogger(CheckInController.class.getName()).log(Level.SEVERE,null,ex);
		 }
	}		
    
    @FXML
    void TenDV_ActionListener(ActionEvent event) {
    	HienThiTextFieldGiaTien();
    }
    
    @FXML
    void Sua_ActionListener(ActionEvent event) {
    	if(JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa phiếu DV này?","Cảnh Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String value0 = MaPhieuDV_textField.getText();
			String value1 =  SoPhong_cmb.getValue().toString();
			String value2 = TenDV_cmb.getValue().toString();
			String value3 = SL_textField.getText();
			String value4 = TT_textField.getText();
			
			String sql = "update phieu_dv set SOPHONG= '"+value1+"',TENDV='"+value2+"', SOLUONG='"+value3+"', TONGITENDV='"+value4+"' where MAPHIEUDV='"+value0+"'";
			PreparedStatement pst = conn.prepareStatement(sql);	
			pst.execute();
			JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
		}catch(Exception e) {
			e.printStackTrace();
		}}
else if(JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa phiếu DV này?","Cảnh Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION){
     		
     	}
    }

    @FXML
    void Reset_ActionListener(ActionEvent event) {
    	TenDV_cmb.getSelectionModel().clearSelection();
    	SL_textField.setText("");
    	Gia_textField.setText("");
    	TT_textField.setText("");
    	err_TenDV.setText("");
    	err_SL.setText("");
    	UpdateTable();
    }
    public void XoaCanhBao() {
    	err_TenDV.setText("");
    	err_SL.setText("");
    }
    
    private void HienDataLenTextField() {
    	tbl_PDV.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		@Override
    		public void handle(MouseEvent event) {
    			PhieuDV tbl_nv = tbl_PDV.getItems().get(tbl_PDV.getSelectionModel().getSelectedIndex());
    			MaPhieuDV_textField.setText(tbl_nv.getMAPHIEUDV());
    			SoPhong_cmb.setValue(tbl_nv.getSOPHONG());
    			TenDV_cmb.setValue(tbl_nv.getTENDV());
    			Gia_textField.setText(tbl_nv.getGIATIEN());
    			SL_textField.setText(tbl_nv.getSOLUONG());
    			TT_textField.setText(tbl_nv.getTONGTIENDV());
    			Xoa_Button.setDisable(false);
    			 Sua_Button.setDisable(false);
    	    	
    		}
    		
    	});
    }

    @FXML
    void Xoa_ActionListener(ActionEvent event) {
    	int response=	JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn lưu cập nhật?", "xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     	if(response == JOptionPane.YES_OPTION) {
    		tbl_PDV.getItems().removeAll(tbl_PDV.getSelectionModel().getSelectedItems());
        	
        	String sql = "delete from phieu_dv where MAPHIEUDV = ?";
        	try {
        		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
        		Connection conn = DriverManager.getConnection(DB_URL,"root","");
        		PreparedStatement pst = conn.prepareStatement(sql);
        		pst.setString(1, MaPhieuDV_textField.getText());
        		pst.execute();
        		JOptionPane.showMessageDialog(null, "Xoá Thành Công");
        	}
        	catch(Exception e) {
        		JOptionPane.showMessageDialog(null, e);
        	}
        	UpdateTable();	
        	autoTaoMaPDV();
    	}
else if(response == JOptionPane.NO_OPTION){
     		
     	}
    }

    public void TinhTongTextField() {
    	
		Double tongtien=0.0;
		
		
			tongtien=tongtien + (Double.valueOf(Gia_textField.getText()) * Double.valueOf(SL_textField.getText()));
		TT_textField.setText(tongtien+"");
	}
    
    public void autoTaoMaPDV() {
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			Statement s= conn.createStatement();
			
			ResultSet rs = s.executeQuery("select Max(MAPHIEUDV) from phieu_dv");
			rs.next();
			rs.getString("Max(MAPHIEUDV)");
			
			if(rs.getString("Max(MAPHIEUDV)")== null)
			{
				MaPhieuDV_textField.setText("1");
			}
			else
			{
				int mapt = Integer.parseInt(rs.getString("Max(MAPHIEUDV)"));
				mapt++;
				MaPhieuDV_textField.setText(String.format("%d",mapt));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
