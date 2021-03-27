package QuanLyPhong;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.event.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
public class GiaoDienQuanLyPhongController /*implements Initializable*/ {

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

    
    /*ObservableList<String> list = FXCollections.observableArrayList("Deluxe", "Double Room", "Single Room");
    
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        //cbLoaiPhong.setItems(list);
    }
    public void comboBoxChanged (ActionEvent event){
        //ta1.setText(cbLoaiPhong.getValue());
        
    }*/
    @FXML
    void bt11(ActionEvent event) throws IOException  {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("ChitietPhongQuanLy.fxml"));
    	Parent sampleParent = loader.load();
    	Scene scene = new Scene(sampleParent);
    	stage.setScene(scene);
    }
    
    @FXML
    void bt22(ActionEvent event) throws IOException  {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("ChitietPhongQuanLy.fxml"));
    	Parent sampleParent = loader.load();
    	Scene scene = new Scene(sampleParent);
    	stage.setScene(scene);
    }
    
    @FXML
    void bt33(ActionEvent event) throws IOException  {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("ChitietPhongQuanLy.fxml"));
    	Parent sampleParent = loader.load();
    	Scene scene = new Scene(sampleParent);
    	stage.setScene(scene);
    }
    
    @FXML
    void bt44(ActionEvent event) throws IOException  {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("ChitietPhongQuanLy.fxml"));
    	Parent sampleParent = loader.load();
    	Scene scene = new Scene(sampleParent);
    	stage.setScene(scene);
    }
    
    @FXML
    void bt55(ActionEvent event) throws IOException  {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("ChitietPhongQuanLy.fxml"));
    	Parent sampleParent = loader.load();
    	Scene scene = new Scene(sampleParent);
    	stage.setScene(scene);
    }
    
    @FXML
    void bt66(ActionEvent event) throws IOException  {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("ChitietPhongQuanLy.fxml"));
    	Parent sampleParent = loader.load();
    	Scene scene = new Scene(sampleParent);
    	stage.setScene(scene);
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
    

    	
}
