package p04.closewindow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import p03.alertandconfirmbox.ConfirmBox;

/**
 * @author Tian Z
 */
public class Main extends Application {
    Stage window;
    Button button;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("JavaFX - Tutorial");
        button = new Button("Close Program");

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        button.setOnAction(e -> closeProgram());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 500, 300);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
        if (answer) {
            System.out.println("Window closed!");
            window.close();
        }
    }
}
