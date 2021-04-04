package LogIn;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

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
    void Login_ActionListener(ActionEvent event) {

    }

   
}
