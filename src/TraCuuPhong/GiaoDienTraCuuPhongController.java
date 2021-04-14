package TraCuuPhong;

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
public class GiaoDienTraCuuPhongController /*implements Initializable*/ {

	 @FXML
	    private AnchorPane Ap;

	    @FXML
	    private Button btTatca;

	    @FXML
	    private Button btDasudung;

	    @FXML
	    private Button btDangbaotri;

	    @FXML
	    private Button btTrong;

	    @FXML
	    private Button btSaptra;

	    @FXML
	    private Button btDattruoc;

	    @FXML
	    private Button btDathanhtoan;

	    @FXML
	    private Button btphong105;

	    @FXML
	    private Button btphong106;

	    @FXML
	    private Button btphong102;

	    @FXML
	    private Button btphong103;

	    @FXML
	    private Button btphong101;

	    @FXML
	    private Button btphong104;

    
    /*ObservableList<String> list = FXCollections.observableArrayList("Deluxe", "Double Room", "Single Room");
    
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        //cbLoaiPhong.setItems(list);
    }
    public void comboBoxChanged (ActionEvent event){
        //ta1.setText(cbLoaiPhong.getValue());
        
    }*/
    @FXML
    void bt1(ActionEvent event) throws IOException  {
//    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//    	FXMLLoader loader = new FXMLLoader();
//    	loader.setLocation(getClass().getResource("ChitietPhong.fxml"));
//    	Parent sampleParent = loader.load();
//    	Scene scene = new Scene(sampleParent);
//    	stage.setScene(scene);
    	
    	Parent root = FXMLLoader.load(getClass().getResource("ChitietPhongDeluxe.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("chitietphong.css").toExternalForm());
    	Stage stage = new Stage();   	
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void bt2(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("ChitietPhongSup.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("chitietphong.css").toExternalForm());
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void bt3(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("ChitietPhongStandard.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("chitietphong.css").toExternalForm());
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void bt4(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("ChitietPhongStandard.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("chitietphong.css").toExternalForm());
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void bt5(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("ChitietPhongDeluxe.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("chitietphong.css").toExternalForm());
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    void bt6(ActionEvent event) throws IOException  {
    	Parent root = FXMLLoader.load(getClass().getResource("ChitietPhongSup.fxml"));
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add(getClass().getResource("chitietphong.css").toExternalForm());
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    }
    

    	
}
