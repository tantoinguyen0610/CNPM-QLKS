package QuanLyPhong;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;

public class ChiTietThietBi extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ChiTietThietBi.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Thiết bị");
		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	
	
}