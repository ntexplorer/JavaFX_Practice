package p15.menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
        window.setTitle("Menu");
        button = new Button("Submit");

//        File Menu
        Menu fileMenu = new Menu("_File");

//        Menu Item
        MenuItem newFile = new MenuItem("New...");
        newFile.setOnAction(e -> System.out.println("Create a new file"));
        fileMenu.getItems().add(newFile);

        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit"));

//      Edit Menu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));
        editMenu.getItems().add(new MenuItem("Paste"));
        MenuItem deleteFile = new MenuItem("Delete");
        editMenu.getItems().add(deleteFile);
        deleteFile.setDisable(true);

//        Check menuItem
        CheckMenuItem autoSave = new CheckMenuItem("Autosave");
        CheckMenuItem showLineNumber = new CheckMenuItem("showLineNumber");
        showLineNumber.setOnAction(e -> {
            if (showLineNumber.isSelected()) {
                System.out.println("Line numbers displayed.");
            } else {
                System.out.println("Hiding the line numbers.");
            }
        });

        autoSave.setSelected(true);
        editMenu.getItems().addAll(autoSave, showLineNumber);

        Menu difficultyMenu = new Menu("Difficulty");
        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");
        ToggleGroup difficultyToggle = new ToggleGroup();
        difficultyToggle.getToggles().addAll(easy, medium, hard);
        difficultyMenu.getItems().addAll(easy, medium, hard);


        //        Main menubar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, difficultyMenu);

        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);

        scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }
}
