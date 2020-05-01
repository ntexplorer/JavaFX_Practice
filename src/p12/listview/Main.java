package p12.listview;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Tian Z
 */
public class Main extends Application {
    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("List View");
        button = new Button("Submit");

        listView = new ListView<>();
        listView.getItems().addAll(
                "Iron Man",
                "Titanic",
                "Contact",
                "Surrogates"
        );
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        button.setOnAction(e -> buttonClicks());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(listView, button);

        scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private void buttonClicks() {
        String message = "";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();
        for (String m: movies){
            message += m + "\n";
        }
        System.out.println(message);
    }
}
