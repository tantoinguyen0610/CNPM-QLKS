package NhanVien;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BangNhiemVu extends Application {

	public void start(Stage stage) throws Exception
	 {
	 // Load the FXML file.
	 Parent parent = FXMLLoader.load(
	 getClass().getResource("GiaoDien_BangNhiemVu.fxml"));
	
	 // Build the scene graph.
	 Scene scene = new Scene(parent);
	
	 // Display our window, using the scene graph.
	 stage.setTitle("Giao dien them nhan vien");
	stage.setScene(scene);
	 stage.show();
	 }
	
	 public static void main(String[] args)
 {
	 // Launch the application.
	 launch(args);
	 }

}
