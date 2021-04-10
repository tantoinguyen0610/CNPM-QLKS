package NhanVien;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NhanVien extends Application {

	public void start(Stage stage) throws Exception
	 {
	 Parent parent = FXMLLoader.load(
	 getClass().getResource("GiaoDien_NhanVien.fxml"));
	 Scene scene = new Scene(parent);
	 stage.setTitle("Giao dien Nhan vien");
	stage.setScene(scene);
	 stage.show();
	 }
	
	 public static void main(String[] args)
 {
	 launch(args);
	 }

}
