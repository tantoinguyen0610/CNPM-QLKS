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
import javafx.scene.layout.AnchorPane;


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
    private ComboBox<?> Loai_Phong_Cmb;


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
    private TableView<ModelTable> Table_Check_In;

    @FXML
    private TableColumn<ModelTable, Integer> Tbl_Col_STT;

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
    }
    
    @FXML
    void DP_TaiQuay_ActionListener(ActionEvent event) {
    	DatCoc_CheckBox.setDisable(true);
    }

    @FXML
    void DP_Truoc_ActionListener(ActionEvent event) {
    	DatCoc_CheckBox.setDisable(false);
    }

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    ResultSet rs = null;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			PreparedStatement ps = conn.prepareStatement("select MA_PT,TENKH, MA_DATPHONG, SOPHONG, NGAYDAT, NGAYNHAN, SONGAYO from phieuthuephong, khachhang");
			ResultSet rs = ps.executeQuery();
			
				while (rs.next()) {	
					oblist.add(new ModelTable(rs.getString("MA_PT"),rs.getString("TENKH"),rs.getString("MA_DATPHONG"),rs.getString("SOPHONG"),rs.getString("NGAYDAT"),rs.getString("NGAYNHAN"),rs.getString("SONGAYO")));
					
				}
			}
			catch(SQLException ex) {
				Logger.getLogger(CheckInController.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			Tbl_Col_STT.setCellValueFactory(new PropertyValueFactory<>("MA_PT"));
			Tbl_Col_KH.setCellValueFactory(new PropertyValueFactory<>("TENKH"));
			Tbl_Col_MaDP.setCellValueFactory(new PropertyValueFactory<>("MA_DATPHONG"));
			Tbl_Col_SoPhong.setCellValueFactory(new PropertyValueFactory<>("SOPHONG"));
			Tbl_Col_NgayDat.setCellValueFactory(new PropertyValueFactory<>("NGAYDAT"));
			Tbl_Col_NgayNhan.setCellValueFactory(new PropertyValueFactory<>("NGAYNHAN"));
			Tbl_Col_SoNgayO.setCellValueFactory(new PropertyValueFactory<>("SONGAYO"));
			Table_Check_In.setItems(oblist);
			
			
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
		
		
	}
    
	@FXML
    void DatPhong_ActionListener(ActionEvent event) {
		
		try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
				Connection conn = DriverManager.getConnection(DB_URL,"root","");
				String query = "insert into `phieuthuephong`(NGAYDAT,MA_DATPHONG,NGAYNHAN,SONGAYO) VALUES(?,?,?,?)";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.setString(1, ((TextField)Ngay_Dat_Phong.getEditor()).getText());
				pst.setString(2, Ma_DP_textField.getText());
				pst.setString(3, ((TextField)NgayNhanPhong.getEditor()).getText());
				pst.setString(4, SoNgayO_textField.getText());
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
    }
}
