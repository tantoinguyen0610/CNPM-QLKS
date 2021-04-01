package Check_in;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fillComboBox();
		Loai_Phong_Cmb.setItems(list_lp);
		 ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
		// TODO Auto-generated method stub
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
			
			
		ObservableList<String> list = FXCollections.observableArrayList("1", "2","3","4");
		SoNguoiCung1Phong.setItems(list);
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
    void DatCocActionListener(ActionEvent event)throws Exception {

    	if (DatCoc_CheckBox.isSelected()) {
    		 Parent parent = FXMLLoader.load(
    				 getClass().getResource("GiaoDien_DatCoc.fxml"));
    				 // Build the scene graph.
    				 Scene scene = new Scene(parent);
    				Stage stage = new Stage();
    				 // Display our window, using the scene graph.
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
    }
    
    @FXML
    void DP_TaiQuay_ActionListener(ActionEvent event) {
    	DatCoc_CheckBox.setDisable(true);
    }

    @FXML
    void DP_Truoc_ActionListener(ActionEvent event) {
    	DatCoc_CheckBox.setDisable(false);
    }

   
    
	 public void fillComboBox() {
		 
		 try {final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			 String query = "select TEN_lOAIPHONG from loai_phong";
			 PreparedStatement pst = conn.prepareStatement(query);
			 ResultSet rs = pst.executeQuery();
			 while (rs.next())
			 {
				 list_lp.add(rs.getString("TEN_lOAIPHONG"));
				 
			 }
			 pst.close();
			 rs.close();
		 }
		 catch(SQLException ex)
		 {
			 Logger.getLogger(CheckInController.class.getName()).log(Level.SEVERE,null,ex);
		 }
	 }
	
	@FXML
    void DatPhong_ActionListener(ActionEvent event) {
		
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
				//pst.setString(6, SoNgayO_textField.getText());
				pst.executeUpdate();
				
				String query1 = "INSERT INTO khachhang (TENKH,SDT,CMND) VALUES(?,?,?)";
			
				PreparedStatement pst1 = conn.prepareStatement(query1);
				pst1.setString(1, TenKH_textField.getText());
				pst1.setString(2, SDT_textField.getText());
				pst1.setString(3, CMND_textField.getText());
				pst1.executeUpdate();
				JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
				
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			UpdateTable();
    }
	public void UpdateTable() {
		 ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
		 oblist.clear();
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
	
}
