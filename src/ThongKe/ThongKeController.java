package ThongKe;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ThongKeController implements Initializable {
	

    @FXML
    private TextField CI_textField;

    @FXML
    private TextField CO_textField;

    @FXML
    private TextField DT_textField;

    @FXML
    private TextField SC_textField;

    @FXML
    private TextField NCP_textField;
    @FXML
    private Button Button_Thoat;

    @FXML
    private BarChart<String,Double> BarChart_KHRaVao;
    
    @FXML
    private BarChart<String,Double> BarChart_DoanhThu;
    
    @FXML
    private BarChart<String,Number> BarChart_LoaiPhong;
    
    @FXML
    private BarChart<String, Double> BarChart_SCNCPhong;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadChartKHRaVao();
		loadChartDoanhThu();
		loadChartPhongStandard();
		loadChartPhongDeluxe();
		loadChartPhongSuperior();
		loadChartHoaDon_SCNCPhong();
	}
    
    @FXML
    private void loadChartKHRaVao() {
		
		String query = "SELECT SUM(SONGUOI1PHONG), MONTH(NGAYNHAN) FROM phieuthuephong ORDER BY MONTH(NGAYNHAN) ASC";
    	XYChart.Series<String, Double> series = new XYChart.Series<>();
    	series.setName("Lượng Khách Hàng Check-In");
		try {Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
		Connection conn = DriverManager.getConnection(DB_URL,"root","");
    		ResultSet rs = conn.createStatement().executeQuery(query);
    		
    		rs.next();
	 		if(rs.getString("MONTH(NGAYNHAN)")== null) {
				series.getData().add(new XYChart.Data<>("",0.0));
			}
			else {
				series.getData().add(new XYChart.Data<>(rs.getString(2),rs.getDouble(1)));
    			CI_textField.setText(rs.getString("SUM(SONGUOI1PHONG)"));
			}
    		
    		BarChart_KHRaVao.getData().add(series);
    	}catch(Exception ex) {
    		JOptionPane.showMessageDialog(null, ex);
    	}
    	
		
		String query1 = "SELECT COUNT(*), MONTH(NGAYTHANHTOAN) FROM hoadon_thanhtoanphong";
    	XYChart.Series<String, Double> series1 = new XYChart.Series<>();
    	series1.setName("Lượng Khách Hàng Check-Out");
		try {Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
		Connection conn = DriverManager.getConnection(DB_URL,"root","");
    		ResultSet rs = conn.createStatement().executeQuery(query1);
    		
    		
    		rs.next();
	 		if(rs.getString("MONTH(NGAYTHANHTOAN)")== null) {
				series.getData().add(new XYChart.Data<>("",0.0));
			}
			else {
				series1.getData().add(new XYChart.Data<>(rs.getString(2),rs.getDouble(1)));
    			CO_textField.setText(rs.getString("COUNT(*)"));
			}
    		
    		
    		BarChart_KHRaVao.getData().add(series1);
    	}catch(Exception ex) {
    		JOptionPane.showMessageDialog(null, ex);
    	}
		
    }

 private void loadChartDoanhThu() {
		
		String query = "SELECT SUM(TONGTIEN),MONTH(NGAYTHANHTOAN) FROM hoadon_thanhtoanphong ORDER by MONTH(NGAYTHANHTOAN) ASC";
    	XYChart.Series<String, Double> series = new XYChart.Series<>();
    	series.setName("Doanh Thu Trong Tháng");
		try {Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
		Connection conn = DriverManager.getConnection(DB_URL,"root","");
    		ResultSet rs = conn.createStatement().executeQuery(query);
    		
	 		rs.next();
	 		if(rs.getString("MONTH(NGAYTHANHTOAN)")== null) {
				series.getData().add(new XYChart.Data<>("",0.0));
			}
			else {
				series.getData().add(new XYChart.Data<>(rs.getString(2),rs.getDouble(1)));
    			DT_textField.setText(rs.getString("SUM(TONGTIEN)"));
			}

    		BarChart_DoanhThu.getData().add(series);
    	}catch(Exception ex) {
    		JOptionPane.showMessageDialog(null, ex);
    	}
 }
 
 private void loadChartPhongStandard() {
		
		String query = "SELECT COUNT(LOAIPHONG), MONTH(NGAYNHAN) FROM phieuthuephong WHERE LOAIPHONG='Standard' ORDER by MONTH(NGAYNHAN) ASC";
 	XYChart.Series<String, Number> series = new XYChart.Series<>();
 	series.setName("Phòng Standard");
		try {Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
		Connection conn = DriverManager.getConnection(DB_URL,"root","");
 		ResultSet rs = conn.createStatement().executeQuery(query);
 		
 		rs.next();
 		if(rs.getString("MONTH(NGAYNHAN)")== null) {
			series.getData().add(new XYChart.Data<>("",0));
		}
		else {
			series.getData().add(new XYChart.Data<>(rs.getString(2),rs.getDouble(1)));
		}

 		BarChart_LoaiPhong.getData().add(series);
 	}catch(Exception ex) {
 		JOptionPane.showMessageDialog(null, ex);
 	}
		
		
		
		
}
 
 public void loadChartPhongDeluxe() {
	 String query = "SELECT COUNT(LOAIPHONG), MONTH(NGAYNHAN) FROM phieuthuephong WHERE LOAIPHONG='Deluxe' ORDER by MONTH(NGAYNHAN) ASC";
	 	XYChart.Series<String, Number> series = new XYChart.Series<>();
	 	series.setName("Phòng Deluxe");
			try {Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
	 		ResultSet rs = conn.createStatement().executeQuery(query);
	 		
	 		rs.next();
	 		if(rs.getString("MONTH(NGAYNHAN)")== null) {
				series.getData().add(new XYChart.Data<>("",0));
			}
			else {
				series.getData().add(new XYChart.Data<>(rs.getString(2),rs.getDouble(1)));
			}
	 		BarChart_LoaiPhong.getData().add(series);
	 	}catch(Exception ex) {
	 		JOptionPane.showMessageDialog(null, ex);
	 	}
 }
 
 public void loadChartPhongSuperior() {
	 String query = "SELECT COUNT(LOAIPHONG), MONTH(NGAYNHAN) FROM phieuthuephong WHERE LOAIPHONG='Superior' ORDER by MONTH(NGAYNHAN) ASC";
	 	XYChart.Series<String, Number> series = new XYChart.Series<>();
	 	series.setName("Phòng Superior");
			try {Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
	 		ResultSet rs = conn.createStatement().executeQuery(query);
//	 		Statement s= conn.createStatement();
//			ResultSet rs = s.executeQuery(query);
			rs.next();
			if(rs.getString("MONTH(NGAYNHAN)")== null) {
				series.getData().add(new XYChart.Data<>("",0));
			}
			else {
				series.getData().add(new XYChart.Data<>(rs.getString(2),rs.getDouble(1)));
			}
	 		BarChart_LoaiPhong.getData().add(series);
	 	}catch(Exception ex) {
	 		JOptionPane.showMessageDialog(null, ex);
	 	}
 }
 
 private void loadChartHoaDon_SCNCPhong() {
		
		String query = "SELECT SUM(TONGTIEN), MONTH(NGAYKT) FROM hoa_don WHERE LOAI_HD='Sửa Chữa Thiết Bị' and DUYETTHANHTOAN = 'Đã Thanh Toán' ORDER BY MONTH(NGAYKT) ASC";
 	XYChart.Series<String, Double> series = new XYChart.Series<>();
 	series.setName("Chi Phí Sửa Chữa Thiết Bị");
		try {Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
		Connection conn = DriverManager.getConnection(DB_URL,"root","");
 		ResultSet rs = conn.createStatement().executeQuery(query);
 		rs.next();
 		
 		if(rs.getString("MONTH(NGAYKT)")== null) {
			series.getData().add(new XYChart.Data<>("",0.0));
		}
		else {
			series.getData().add(new XYChart.Data<>(rs.getString(2),rs.getDouble(1)));
 			SC_textField.setText(rs.getString("SUM(TONGTIEN)"));
		}
 		
 		BarChart_SCNCPhong.getData().add(series);
 	}catch(Exception ex) {
 		JOptionPane.showMessageDialog(null, ex);
 	}
 	
		
		String query1 = "SELECT SUM(TONGTIEN), MONTH(NGAYKT) FROM hoa_don WHERE LOAI_HD='Nâng Cấp Phòng' and DUYETTHANHTOAN = 'Đã Thanh Toán' ORDER BY MONTH(NGAYKT) ASC";
 	XYChart.Series<String, Double> series1 = new XYChart.Series<>();
 	series1.setName("Chi Phí Nâng Cấp Phòng");
		try {Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
		Connection conn = DriverManager.getConnection(DB_URL,"root","");
 		ResultSet rs = conn.createStatement().executeQuery(query1);
 		
 			rs.next();
 		if(rs.getString("MONTH(NGAYKT)")== null) {
 			series1.getData().add(new XYChart.Data<>("",0.0));
		}
		else {
			series1.getData().add(new XYChart.Data<>(rs.getString(2),rs.getDouble(1)));
 			NCP_textField.setText(rs.getString("SUM(TONGTIEN)"));
		}
 		BarChart_SCNCPhong.getData().add(series1);
 	}catch(Exception ex) {
 		JOptionPane.showMessageDialog(null, ex);
 	}
		
 }
 
 @FXML
 void Thoat_ActionListener(ActionEvent event) {
	 Stage stage = (Stage) Button_Thoat.getScene().getWindow();
	    stage.close();
 }


}
