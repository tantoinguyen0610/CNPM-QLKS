package TraCuuPhong;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CheckListPhongController {

    @FXML
    private AnchorPane Ap;

    @FXML
    private CheckBox cb2;

    @FXML
    private CheckBox cb8;

    @FXML
    private CheckBox cb12;

    @FXML
    private CheckBox cb1;

    @FXML
    private CheckBox cb3;

    @FXML
    private CheckBox cb4;

    @FXML
    private CheckBox cb13;

    @FXML
    private CheckBox cb5;

    @FXML
    private CheckBox cb7;

    @FXML
    private CheckBox cb6;

    @FXML
    private CheckBox cb10;

    @FXML
    private CheckBox cb11;

    @FXML
    private CheckBox cb9;

    @FXML
    private CheckBox cb14;

    @FXML
    private Label lbBangchecklist;

    @FXML
    private Button btXacnhan;

    @FXML
    private Button btHuy;
    
    @FXML
    private void btthoatchecklist(){
        // get a handle to the stage
        Stage stage = (Stage) btHuy.getScene().getWindow();
        // do what you have to do
        stage.close();

    }

}
