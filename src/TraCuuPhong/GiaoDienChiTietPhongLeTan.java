package TraCuuPhong;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;

public class GiaoDienChiTietPhongLeTan extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		//Load FXML file
		Parent root = FXMLLoader.load(getClass().getResource("ChitietPhong.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("");
		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	
	
}