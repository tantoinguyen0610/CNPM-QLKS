package TraCuuPhong;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GiaoDienTraCuuPhongController implements Initializable{

    @FXML
    private AnchorPane Ap;

    @FXML
    private Button btDasudung;

    @FXML
    private Button btDangbaotri;

    @FXML
    private Button btTrong;

    @FXML
    private Button btDattruoc;

    @FXML
    private Button btphong1055;

    @FXML
    private Button btphong1066;

    @FXML
    private Button btphong1022;

    @FXML
    private Button btphong1033;

    @FXML
    private Button btphong1011;

    @FXML
    private Button btphong1044;
    
    @FXML
    private Button Load_Button;

    @FXML
    void Load_ActionListener(ActionEvent event) {
    	DoiMauPhong101();
    	DoiMauPhong102();
    	DoiMauPhong103();
    	DoiMauPhong104();
    	DoiMauPhong105();
    	DoiMauPhong106();
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	DoiMauPhong101();
    	DoiMauPhong102();
    	DoiMauPhong103();
    	DoiMauPhong104();
    	DoiMauPhong105();
    	DoiMauPhong106();
	}

    
    public void DoiMauPhong101() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query1 = "SELECT TINHTRANG "
						+ "from phong "
						+ "WHERE MA_PHONG='1'";
			 PreparedStatement pst1 = conn.prepareStatement(query1);
			 ResultSet rs1 = pst1.executeQuery();
			 rs1.next();
			 rs1.getString("TINHTRANG");
			if(rs1.getString("TINHTRANG").equals("Đã sử dụng")) {
				btphong1011.setStyle("-fx-background-color: #ff0000; ");
				
			}
			else if(rs1.getString("TINHTRANG").equals("Trống")) {
				btphong1011.setStyle("-fx-background-color: #26ff00; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đã thanh toán")) {
				btphong1011.setStyle("-fx-background-color: #788276; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đang bảo trì")) {
				btphong1011.setStyle("-fx-background-color: #ffffff; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Sắp trả")) {
				btphong1011.setStyle("-fx-background-color: #fbff24; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đặt trước")) {
				btphong1011.setStyle("-fx-background-color: #FF9933; ");
			}
		}
			catch(Exception e) {
				 JOptionPane.showMessageDialog(null, "Lỗi: "+  e);
			}
	}
    
    public void DoiMauPhong102() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query1 = "SELECT TINHTRANG "
						+ "from phong "
						+ "WHERE MA_PHONG='2'";
			 PreparedStatement pst1 = conn.prepareStatement(query1);
			 ResultSet rs1 = pst1.executeQuery();
			 rs1.next();
			 rs1.getString("TINHTRANG");
			if(rs1.getString("TINHTRANG").equals("Đã sử dụng")) {
				btphong1022.setStyle("-fx-background-color: #ff0000; ");
				
			}
			else if(rs1.getString("TINHTRANG").equals("Trống")) {
				btphong1022.setStyle("-fx-background-color: #26ff00; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đã thanh toán")) {
				btphong1022.setStyle("-fx-background-color: #788276; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đang bảo trì")) {
				btphong1022.setStyle("-fx-background-color: #ffffff; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Sắp trả")) {
				btphong1022.setStyle("-fx-background-color: #fbff24; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đặt trước")) {
				btphong1022.setStyle("-fx-background-color: #FF9933; ");
			}
		}
			catch(Exception e) {
				 JOptionPane.showMessageDialog(null, "Lỗi: "+  e);
			}
	}
    
    public void DoiMauPhong103() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query1 = "SELECT TINHTRANG "
						+ "from phong "
						+ "WHERE MA_PHONG='3'";
			 PreparedStatement pst1 = conn.prepareStatement(query1);
			 ResultSet rs1 = pst1.executeQuery();
			 rs1.next();
			 rs1.getString("TINHTRANG");
			if(rs1.getString("TINHTRANG").equals("Đã sử dụng")) {
				btphong1033.setStyle("-fx-background-color: #ff0000; ");
				
			}
			else if(rs1.getString("TINHTRANG").equals("Trống")) {
				btphong1033.setStyle("-fx-background-color: #26ff00; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đã thanh toán")) {
				btphong1033.setStyle("-fx-background-color: #788276; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đang bảo trì")) {
				btphong1033.setStyle("-fx-background-color: #ffffff; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Sắp trả")) {
				btphong1033.setStyle("-fx-background-color: #fbff24; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đặt trước")) {
				btphong1033.setStyle("-fx-background-color: #FF9933; ");
			}
		}
			catch(Exception e) {
				 JOptionPane.showMessageDialog(null, "Lỗi: "+  e);
			}
	}
    
    public void DoiMauPhong104() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query1 = "SELECT TINHTRANG "
						+ "from phong "
						+ "WHERE MA_PHONG='4'";
			 PreparedStatement pst1 = conn.prepareStatement(query1);
			 ResultSet rs1 = pst1.executeQuery();
			 rs1.next();
			 rs1.getString("TINHTRANG");
			if(rs1.getString("TINHTRANG").equals("Đã sử dụng")) {
				btphong1044.setStyle("-fx-background-color: #ff0000; ");
				
			}
			else if(rs1.getString("TINHTRANG").equals("Trống")) {
				btphong1044.setStyle("-fx-background-color: #26ff00; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đã thanh toán")) {
				btphong1044.setStyle("-fx-background-color: #788276; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đang bảo trì")) {
				btphong1044.setStyle("-fx-background-color: #ffffff; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Sắp trả")) {
				btphong1044.setStyle("-fx-background-color: #fbff24; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đặt trước")) {
				btphong1044.setStyle("-fx-background-color: #FF9933; ");
			}
		}
			catch(Exception e) {
				 JOptionPane.showMessageDialog(null, "Lỗi: "+  e);
			}
	}
    
    public void DoiMauPhong105() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query1 = "SELECT TINHTRANG "
						+ "from phong "
						+ "WHERE MA_PHONG='5'";
			 PreparedStatement pst1 = conn.prepareStatement(query1);
			 ResultSet rs1 = pst1.executeQuery();
			 rs1.next();
			 rs1.getString("TINHTRANG");
			if(rs1.getString("TINHTRANG").equals("Đã sử dụng")) {
				btphong1055.setStyle("-fx-background-color: #ff0000; ");
				
			}
			else if(rs1.getString("TINHTRANG").equals("Trống")) {
				btphong1055.setStyle("-fx-background-color: #26ff00; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đã thanh toán")) {
				btphong1055.setStyle("-fx-background-color: #788276; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đang bảo trì")) {
				btphong1055.setStyle("-fx-background-color: #ffffff; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Sắp trả")) {
				btphong1055.setStyle("-fx-background-color: #fbff24; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đặt trước")) {
				btphong1055.setStyle("-fx-background-color: #FF9933; ");
			}
		}
			catch(Exception e) {
				 JOptionPane.showMessageDialog(null, "Lỗi: "+  e);
			}
	}
    
    public void DoiMauPhong106() {
    	try {
			final String DB_URL = "jdbc:mysql://localhost:3306/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
			String query1 = "SELECT TINHTRANG "
						+ "from phong "
						+ "WHERE MA_PHONG='6'";
			 PreparedStatement pst1 = conn.prepareStatement(query1);
			 ResultSet rs1 = pst1.executeQuery();
			 rs1.next();
			 rs1.getString("TINHTRANG");
			if(rs1.getString("TINHTRANG").equals("Đã sử dụng")) {
				btphong1066.setStyle("-fx-background-color: #ff0000; ");
				
			}
			else if(rs1.getString("TINHTRANG").equals("Trống")) {
				btphong1066.setStyle("-fx-background-color: #26ff00; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đã thanh toán")) {
				btphong1066.setStyle("-fx-background-color: #788276; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đang bảo trì")) {
				btphong1066.setStyle("-fx-background-color: #ffffff; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Sắp trả")) {
				btphong1066.setStyle("-fx-background-color: #fbff24; ");
			}
			else if(rs1.getString("TINHTRANG").equals("Đặt trước")) {
				btphong1066.setStyle("-fx-background-color: #FF9933; ");
			}
		}
			catch(Exception e) {
				 JOptionPane.showMessageDialog(null, "Lỗi: "+  e);
			}
	}

    @FXML
    void bt11(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("Phong101.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("chitietphong.css").toExternalForm());
    	Stage stage = new Stage();   	
    	stage.setScene(scene);
    	stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
    	stage.show();
    }
    
    @FXML
    void bt22(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("Phong102.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("chitietphong.css").toExternalForm());
    	Stage stage = new Stage();   	
    	stage.setScene(scene);
    	stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
    	stage.show();
    }
    
    @FXML
    void bt33(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("Phong103.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("chitietphong.css").toExternalForm());
    	Stage stage = new Stage();   	
    	stage.setScene(scene);
    	stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
    	stage.show();
    }
    
    @FXML
    void bt44(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("Phong104.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("chitietphong.css").toExternalForm());
    	Stage stage = new Stage();   	
    	stage.setScene(scene);
    	stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
    	stage.show();
    }
    
    @FXML
    void bt55(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("Phong105.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("chitietphong.css").toExternalForm());
    	Stage stage = new Stage();   	
    	stage.setScene(scene);
    	stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
    	stage.show();
    }
    
    @FXML
    void bt66(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("Phong106.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("chitietphong.css").toExternalForm());
    	Stage stage = new Stage();   	
    	stage.setScene(scene);
    	stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((Node) event.getSource()).getScene().getWindow());
    	stage.show();
    }
    
    
	
}
