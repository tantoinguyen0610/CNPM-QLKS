package TraCuuPhong;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;
public class Phong103 extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Phong103.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Demo giao diện");
		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}
