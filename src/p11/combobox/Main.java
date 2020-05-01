package p11.combobox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Tian Z
 */
public class Main extends Application {
    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Combobox");
        button = new Button("Submit");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Good Will Hunting",
                "St. Vincent",
                "Blackhat"
        );

        comboBox.setPromptText("What is your favorite movie?");

        comboBox.setEditable(true);

        comboBox.setOnAction(e -> System.out.println("User selected: " + comboBox.getValue()));
        button.setOnAction(e -> printMovie());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(comboBox, button);

        scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private void printMovie() {
        System.out.println(comboBox.getValue());
    }
}
