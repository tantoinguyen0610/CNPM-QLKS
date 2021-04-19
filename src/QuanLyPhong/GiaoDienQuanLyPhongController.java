package QuanLyPhong;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
public class GiaoDienQuanLyPhongController implements Initializable {

	@FXML
    private AnchorPane App;

    @FXML
    private Button btTatcaa;

    @FXML
    private Button btDasudungg;

    @FXML
    private Button btDangbaotrii;

    @FXML
    private Button btTrongg;

    @FXML
    private Button btSaptraa;

    @FXML
    private Button btDattruocc;

    @FXML
    private Button btDathanhtoann;

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
    private Button btnangcapphong;
    	
    @FXML
    private Button btsuachuaphong;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}
    
    @FXML
    void BaoTri_ActionListener(ActionEvent event) {
    	btphong1011.setBackground(new Background(new BackgroundFill(Color.GREEN,CornerRadii.EMPTY,Insets.EMPTY)));
    	btphong1011.setVisible(false);
    }

    @FXML
    void DaSD_ActionListener(ActionEvent event) {

    }

    @FXML
    void DaTT_ActionListener(ActionEvent event) {

    }

    @FXML
    void DatTruoc_ActionListener(ActionEvent event) {

    }

    @FXML
    void SapTra_ActionListener(ActionEvent event) {

    }

    @FXML
    void TatCa_ActionListener(ActionEvent event) {

    }

    @FXML
    void Trong_ActionListener(ActionEvent event) {

    }
    
    

    
    @FXML
    void bt11(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("Phong101.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("Chitietphongquanly.css").toExternalForm());
    	Stage stage = new Stage();   	
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void bt22(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("Phong102.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("Chitietphongquanly.css").toExternalForm());
    	Stage stage = new Stage();   	
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void bt33(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("Phong103.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("Chitietphongquanly.css").toExternalForm());
    	Stage stage = new Stage();   	
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void bt44(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("Phong104.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("Chitietphongquanly.css").toExternalForm());
    	Stage stage = new Stage();   	
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void bt55(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("Phong105.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("Chitietphongquanly.css").toExternalForm());
    	Stage stage = new Stage();   	
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void bt66(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("Phong106.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("Chitietphongquanly.css").toExternalForm());
    	Stage stage = new Stage();   	
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void actionQuanlythietbi(ActionEvent event) throws IOException  {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("QuanLyThietBi.fxml"));
    	Parent sampleParent = loader.load();
    	Scene scene = new Scene(sampleParent);
    	stage.setScene(scene);
    	
    }
    
    @FXML
    void btnangcapphongListener(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("HoaDonNangCapPhongController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void btsuachuaphongListener(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("HoaDonSuaChuaThietBiController.fxml"));
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }

	
    	
}
