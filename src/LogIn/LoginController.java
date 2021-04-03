package LogIn;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane BP1;

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private ImageView pic1;

    @FXML
    private Text QLKS_Label;

    @FXML
    private AnchorPane AnchorPane2;

    @FXML
    private ImageView pic2;

    @FXML
    private Label username_Label;

    @FXML
    private Label psw_Label;

    @FXML
    private TextField username_textField;

    @FXML
    private PasswordField password_textField;

    @FXML
    private Button Button_LogIn;

    @FXML
    private Label wronglogin;

    @FXML
    void Login_ActionListener(ActionEvent event) throws IOException {
    	
       	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
    			.configure("hibernate.cfg.xml")
    			.build();
    	Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
    	SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
    	Session session = sessionFactory.openSession();
		String hql = "FROM Taikhoan A WHERE A.USERNAME = :USERNAME and A.PSW = :PSW";
    }
    
    
   
}
