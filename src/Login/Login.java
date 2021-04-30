package Login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

	public void start(Stage stage) throws Exception
	 {
	 Parent parent = FXMLLoader.load(
	 getClass().getResource("LoginController.fxml")); 
	 Scene scene = new Scene(parent);
	 scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
	 stage.setTitle("QLKS");
	stage.setScene(scene);
	 stage.show();
	 }
	
	 public static void main(String[] args)
 {
	 launch(args);
	 }

}