package QuanLyPhong;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;

public class BangKiemTraDinhKi extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		//Load FXML file
		Parent root = FXMLLoader.load(getClass().getResource("BangKiemTraDinhKi.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Bảng KT Định Kì");
		stage.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}