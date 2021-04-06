package Check_in;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DatCoc extends Application {

	public void start(Stage stage) throws Exception
	 {
	 Parent parent = FXMLLoader.load(
	 getClass().getResource("GiaoDien_DatCoc.fxml"));
	 Scene scene = new Scene(parent);
	 stage.setTitle("DatCoc");
	stage.setScene(scene);
	 stage.show();
	 }
	
	 public static void main(String[] args)
 {
	 launch(args);
	 }

}
