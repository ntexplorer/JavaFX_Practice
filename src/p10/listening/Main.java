package p10.listening;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tian Z
 */
public class Main extends Application {
    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Choice box - Bucky's Meat subs");

        button = new Button("Click me!");


        ChoiceBox<String> choiceBox = new ChoiceBox<>();

//        getItems returns the ObservableList object which you can add items to
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Bananas");
        choiceBox.getItems().addAll("Bacon", "Ham", "Meatballs");

        List<String> fruitList = new ArrayList<>();
        fruitList.add("Oranges");
        fruitList.add("Grapefruit");
        fruitList.add("Strawberry");
        for (String item : fruitList) {
            choiceBox.getItems().add(item);
        }
//        set a default value
        choiceBox.setValue("Apples");

//        Listen for selection changes
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            System.out.println(newValue);
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(choiceBox, button);

        scene = new Scene(layout, 300, 200);

        window.setScene(scene);
        window.show();
    }

}