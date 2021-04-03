package Check_in;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.ComboBox;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;


public class CheckInController implements Initializable {

    @FXML
    private SplitPane SplitPane_1;

    @FXML
    private Label TenKH_Label;

    @FXML
    private Label CMND_Label;

    @FXML
    private Label SDT_Label;

    @FXML
    private Label SoNg1Phong_Label;

    @FXML
    private Label Ma_DP_Label;

    @FXML
    private Label Ngay_DP_Label;

    @FXML
    private Label NgayNhanPhong_Label;

    @FXML
    private Label LoaiPhong_Label;

    @FXML
    private Label SoNgayO_Label;

    @FXML
    private Label err_TenKH;

    @FXML
    private Label err_CMND;

    @FXML
    private Label err_SDT;

    @FXML
    private Label err_SoNguoi1Phong;

    @FXML
    private Label err_MaDP;

    @FXML
    private Label err_LoaiPhong;

    @FXML
    private Label err_SoPhong;

    @FXML
    private Label err_NgayDP;

    @FXML
    private Label err_NgayNhanPhong;

    @FXML
    private Label err_SoNgayO;
    
    @FXML
    private TextField TenKH_textField;

    @FXML
    private TextField CMND_textField;

    @FXML
    private TextField SDT_textField;
    

    @FXML
    private TextField SoNgayO_textField;

    @FXML
    private DatePicker Ngay_Dat_Phong;

    @FXML
    private DatePicker NgayNhanPhong;

    @FXML
    private ChoiceBox<String> SoNguoiCung1Phong;
    

    @FXML
    private TextField Ma_DP_textField;

    @FXML
    private ComboBox<String> Loai_Phong_Cmb;


    @FXML
    private Label Sophong_Label;
    
    @FXML
    private ComboBox<?> SoPhong_Cmb;

    
    @FXML
    private CheckBox DatCoc_CheckBox;

    @FXML
    private ButtonBar Bar_button1;

    @FXML
    private Button Button_DatPhong;

    @FXML
    private Button Button_Reset;

    @FXML
    private Label DKTP_Label;

    @FXML
    private ToggleButton Button_DP_TaiQuay;

    @FXML
    private ToggleGroup fgh;

    @FXML
    private ToggleButton Button_DP_Truoc;

    @FXML
    private AnchorPane AnchorPane1;

    @FXML
    private ScrollPane ScrollPane;

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
    
ObservableList<String> list_lp = FXCollections.observableArrayList();
ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
ObservableList<String> List_SoNguoi1Phong = FXCollections.observableArrayList("1", "2","3","4");
ObservableList<String> List_SoPhong = FXCollections.observableArrayList("101", "102","103","104","105","106");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		HienComboboxLoaiPhong();
		
		ChuyenNguocNamThangNgay();
		
		Chon1Trong2LoaiPhieu();
		
		DisableTextFields();
		
		HienTableCheckIn();		
		//combobox so nguoi 1 phong
		SoNguoiCung1Phong.setItems(List_SoNguoi1Phong);
		
		
	}
	
	public void HienComboboxLoaiPhong() {
		 
		 try {
			 final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			 Connection conn = DriverManager.getConnection(DB_URL,"root","");
			 String query = "select TEN_lOAIPHONG from loai_phong";
			 PreparedStatement pst = conn.prepareStatement(query);
			 ResultSet rs = pst.executeQuery();
			 while (rs.next())
			 {
				 list_lp.add(rs.getString("TEN_lOAIPHONG"));
				 Loai_Phong_Cmb.setItems(list_lp);
				 
			 }
			 pst.close();
			 rs.close();
		 }
		 catch(SQLException ex)
		 {
			 Logger.getLogger(CheckInController.class.getName()).log(Level.SEVERE,null,ex);
		 }
	 }
    
	public void ChuyenNguocNamThangNgay()
	{
			Ngay_Dat_Phong.setConverter(
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
				NgayNhanPhong.setConverter(
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
	
	public void HienTableCheckIn() {
		 try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			ResultSet rs = conn.createStatement().executeQuery("select MA_PT,TENKH,CMND,SDT,SONGUOI1PHONG,LOAIPHONG,SOPHONG,NGAYDAT, NGAYNHAN, SONGAYO, MA_DATPHONG from phieuthuephong, khachhang where khachhang.MAKH=phieuthuephong.MA_PT");
			
				while (rs.next()) {	
					oblist.add(new ModelTable(rs.getString("MA_PT"),rs.getString("TENKH"),rs.getString("CMND"),rs.getString("SDT"),rs.getString("SONGUOI1PHONG"),rs.getString("LOAIPHONG"),rs.getString("SOPHONG"),rs.getString("NGAYDAT"),rs.getString("NGAYNHAN"),rs.getString("SONGAYO"),rs.getString("MA_DATPHONG")));
					
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
	
	private boolean KiemTraTexFieldTrong() {
		
		if(		CMND_textField.getText().isEmpty()|
				SoPhong_Cmb.getSelectionModel().isEmpty()|
				Loai_Phong_Cmb.getSelectionModel().isEmpty()|
				SoNguoiCung1Phong.getSelectionModel().isEmpty()|
				((TextField)Ngay_Dat_Phong.getEditor()).getText().isEmpty() |
				((TextField)NgayNhanPhong.getEditor()).getText().isEmpty() )
			{
			err_CMND.setText("Vui lòng nhập CMND");
			err_SoPhong.setText("Vui lòng chọn số phòng");
			err_LoaiPhong.setText("Vui lòng chọn loại phòng");
			err_NgayDP.setText("Vui lòng nhập ngày đặt phòng");
			err_NgayNhanPhong.setText("Vui lòng nhập ngày nhận phòng");
			err_SoNgayO.setText("Vui lòng nhập số ngày ở");
			err_SoNguoi1Phong.setText("Vui lòng chọn số người cùng 1 phòng");
			return false;
			}
		return true;
	}
	
	private boolean KiemTraSDT() {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(SDT_textField.getText());
		if(m.find() && m.group().equals(SDT_textField.getText())){
			return true;
		}
		else {
			err_SDT.setText("Vui lòng điền số hợp lệ");
			return false;
		}
		
	}
	
	private boolean KiemTraSoNgayO() {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(SoNgayO_textField.getText());
		if(m.find() && m.group().equals(SoNgayO_textField.getText())){
			return true;
		}
		else {
			err_SoNgayO.setText("Vui lòng điền số ngày ở hợp lệ");
			return false;
		}
		
	}
	
	private boolean KiemTraMaDP() {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(Ma_DP_textField.getText());
		if(m.find() && m.group().equals(Ma_DP_textField.getText())){
			return true;
		}
		else {
			err_MaDP.setText("Vui lòng điền mã phòng hợp lệ");
			return false;
		}
		
	}
	
	private boolean KiemTraTenKH() {
		Pattern p = Pattern.compile("[a-zA-Z]+");
		Matcher m = p.matcher(TenKH_textField.getText());
		if(m.find() && m.group().equals(TenKH_textField.getText())){
			return true;
		}
		else {
			err_TenKH.setText("Vui lòng điền tên hợp lệ");
			return false;
		}
		
	}
	
	public void Chon1Trong2LoaiPhieu() {
		boolean isDisabled = (Button_DP_TaiQuay.isSelected()== false);
		TenKH_textField.setDisable(isDisabled);
    	CMND_textField.setDisable(isDisabled);
    	SDT_textField.setDisable(isDisabled);
    	SoNgayO_textField.setDisable(isDisabled);
    	Ngay_Dat_Phong.setDisable(isDisabled);
    	NgayNhanPhong.setDisable(isDisabled);
    	SoNguoiCung1Phong.setDisable(isDisabled);
    	Ma_DP_textField.setDisable(isDisabled);
    	Loai_Phong_Cmb.setDisable(isDisabled);
    	DatCoc_CheckBox.setDisable(isDisabled);
    	Button_DatPhong.setDisable(isDisabled);
    	Button_Reset.setDisable(isDisabled);
				
	}
	
	public void DisableTextFields() {
		TenKH_textField.setDisable(true);
    	CMND_textField.setDisable(true);
    	SDT_textField.setDisable(true);
    	SoNgayO_textField.setDisable(true);
    	Ngay_Dat_Phong.setDisable(true);
    	NgayNhanPhong.setDisable(true);
    	SoNguoiCung1Phong.setDisable(true);
    	Ma_DP_textField.setDisable(true);
    	SoPhong_Cmb.setDisable(true);
    	Loai_Phong_Cmb.setDisable(true);
    	DatCoc_CheckBox.setDisable(true);
    	Button_DatPhong.setDisable(true);
    	Button_Reset.setDisable(true);
	}
	
    @FXML
    void DatCocActionListener(ActionEvent event)throws Exception {

    	if (DatCoc_CheckBox.isSelected()) {
    		 		Parent parent = FXMLLoader.load(
    				getClass().getResource("GiaoDien_DatCoc.fxml"));
    				Scene scene = new Scene(parent);
    				Stage stage = new Stage();
    				stage.setTitle("DatCoc");
    				stage.setScene(scene);
    				stage.show();
    	}
    }
    
    @FXML
    void ResetActionListener(ActionEvent event) {
    	TenKH_textField.setText("");
    	CMND_textField.setText("");
    	SDT_textField.setText("");
    	SoNgayO_textField.setText("");
    	Ngay_Dat_Phong.getEditor().clear();
    	NgayNhanPhong.getEditor().clear();
    	SoNguoiCung1Phong.getSelectionModel().clearSelection();
    	Ma_DP_textField.setText("");
    	Loai_Phong_Cmb.getSelectionModel().clearSelection();
    	UpdateTable();
    	XoaCanhBao();
    }
    
    @FXML
    void DP_TaiQuay_ActionListener(ActionEvent event) {
    	DatCoc_CheckBox.setDisable(true);
    	Ma_DP_textField.setDisable(true);
    	Ma_DP_textField.setText("");
    	err_MaDP.setText("");
    	SoPhong_Cmb.setDisable(false);
    	TenKH_textField.setDisable(false);
    	CMND_textField.setDisable(false);
    	SDT_textField.setDisable(false);
    	SoNgayO_textField.setDisable(false);
    	Ngay_Dat_Phong.setDisable(false);
    	NgayNhanPhong.setDisable(false);
    	SoNguoiCung1Phong.setDisable(false);
    	Loai_Phong_Cmb.setDisable(false);
    	Button_DatPhong.setDisable(false);
    	Button_Reset.setDisable(false);
    }

    @FXML
    void DP_Truoc_ActionListener(ActionEvent event) {
    	DatCoc_CheckBox.setDisable(false);
    	Ma_DP_textField.setDisable(false);
    	TenKH_textField.setDisable(false);
    	CMND_textField.setDisable(false);
    	SDT_textField.setDisable(false);
    	SoNgayO_textField.setDisable(false);
    	Ngay_Dat_Phong.setDisable(false);
    	NgayNhanPhong.setDisable(false);
    	SoNguoiCung1Phong.setDisable(false);
    	SoPhong_Cmb.setDisable(false);
    	Loai_Phong_Cmb.setDisable(false);
    	Button_DatPhong.setDisable(false);
    	Button_Reset.setDisable(false);
    	
    	if(Ma_DP_textField.getText().isEmpty())
    	{
    		err_MaDP.setText("Vui lòng nhập phiếu đặt phòng");
    	}
    }
	
	@FXML
    void DatPhong_ActionListener(ActionEvent event) {
	if (KiemTraTexFieldTrong() & KiemTraSDT() & KiemTraTenKH() & KiemTraSoNgayO() )	{
		try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
				Connection conn = DriverManager.getConnection(DB_URL,"root","");
				String query = "insert into `phieuthuephong`(NGAYDAT,MA_DATPHONG,NGAYNHAN,SONGAYO,LOAIPHONG,SONGUOI1PHONG) VALUES(?,?,?,?,?,?)";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.setString(1, ((TextField)Ngay_Dat_Phong.getEditor()).getText());
				pst.setString(2, Ma_DP_textField.getText());
				pst.setString(3, ((TextField)NgayNhanPhong.getEditor()).getText());
				pst.setString(4, SoNgayO_textField.getText());
				String value = Loai_Phong_Cmb.getValue().toString();
				pst.setString(5, value);
				String value1 = SoNguoiCung1Phong.getValue().toString();
				pst.setString(6, value1);
				pst.executeUpdate();
				
				String query1 = "INSERT INTO khachhang (TENKH,SDT,CMND) VALUES(?,?,?)";
				PreparedStatement pst1 = conn.prepareStatement(query1);
				pst1.setString(1, TenKH_textField.getText());
				pst1.setString(2, SDT_textField.getText());
				pst1.setString(3, CMND_textField.getText());
				pst1.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
				XoaCanhBao();	
			}
		catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
	}
		
		UpdateTable();
    }
	
	public void XoaCanhBao() {
		err_TenKH.setText(""); 
		err_CMND.setText("");
		err_SDT.setText("");
		err_MaDP.setText("");
		err_SoPhong.setText("");
		err_NgayDP.setText("");
		err_NgayNhanPhong.setText("");
		err_SoNgayO.setText("");
		err_SoNguoi1Phong.setText("");
		err_LoaiPhong.setText("");
	}
	
	public void UpdateTable() {
		 
		 oblist.clear();
		 
		 HienTableCheckIn();
	}
	
}
