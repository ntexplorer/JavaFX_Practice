package p19.fxml;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {

    public Button button;

    public void handleButtonClick(ActionEvent actionEvent) {
        button.setText("Stop touching me!");
        System.out.println("Run some code the user doesn't see");
    }
}
