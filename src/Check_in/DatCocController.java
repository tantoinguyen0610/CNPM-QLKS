package Check_in;

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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class DatCocController implements Initializable {

    @FXML
    private Label DatCoc_Label;

    @FXML
    private Label SoTienDatCOc_Label;

    @FXML
    private Label SoTienKhachDC_Label;

    @FXML
    private Label NgayDC_Label;
    
    @FXML
    private Label MaDC_Label;

    @FXML
    private TextField MaDC_textField;

    @FXML
    private Button Button_XacNhan;

    @FXML
    private Button Button_Huy;

    @FXML
    private TextField datCoc_textField;

    @FXML
    private TextField SoTienKhachDatCoc_textField;

    @FXML
    private DatePicker NgayDatCoc_textField;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ChuyenNguocNamThangNgay();
		autoTaoMaDatCoc();
	}
    
    public void ChuyenNguocNamThangNgay()
	{
    	NgayDatCoc_textField.setConverter(
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
    void Huy_AcitonListener(ActionEvent event) {
    	
    }
    
    @FXML
    void XacNhan_ActionListener(ActionEvent event) {
    	
    	try {
			
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query = "insert into datcoc(SOTIENKHACHDATCOC,SOTIENCANDATCOC,NGAYDATCOC) VALUES(?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, datCoc_textField.getText());
			pst.setString(2, SoTienKhachDatCoc_textField.getText());
			pst.setString(3, ((TextField)NgayDatCoc_textField.getEditor()).getText());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Thêm Thành Công!"); 
    	
    } catch(SQLException e)
    	{
    	JOptionPane.showMessageDialog(null, e);
    	}
    	autoTaoMaDatCoc();
}
    
    public void autoTaoMaDatCoc() {
		try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			Statement s= conn.createStatement();
			
			ResultSet rs = s.executeQuery("select Max(MA_PT) from phieuthuephong");
			rs.next();
			rs.getString("Max(MA_PT)");
			
			if(rs.getString("Max(MA_PT)")== null)
			{
				MaDC_textField.setText("1");
			}
			else
			{
				int madc = Integer.parseInt(rs.getString("Max(MA_PT)"));
				madc++;
				MaDC_textField.setText(String.format("%d",madc));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
}

