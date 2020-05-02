package p03.alertandconfirmbox;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Tian Z
 */
public class Main extends Application {

    Button button;
    Button button2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Practice 3");

        button = new Button();
        button.setText("Click me");
        button.setOnAction(e -> AlertBox.display("Warning", "Close it!"));

        button2 = new Button();
        button2.setText("Confirm the answer");
        button2.setOnAction(e -> {
            boolean result = ConfirmBox.display("Answer confirmation", "Which one is the answer?");
            System.out.println(result);
        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(button, button2);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
