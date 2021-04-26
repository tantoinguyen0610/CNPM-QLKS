package QuanLyPhong;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;

public class GiaoDienQuanLyPhong extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("GiaoDienQuanLyPhong.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("quanlyphong.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Giao diện Quản lý phòng");
		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}