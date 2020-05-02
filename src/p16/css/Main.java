package p16.css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Tian Z
 */
public class Main extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("JavaFX - Grid pane");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

//        Name label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);

//        Name input
        TextField nameInput = new TextField("Bucky");
        GridPane.setConstraints(nameInput, 1, 0);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setId("bold-label");
        GridPane.setConstraints(passwordLabel, 0, 1);

        TextField passwordInput = new TextField();
        passwordInput.setPromptText("Password placeholder");
        GridPane.setConstraints(passwordInput, 1, 1);

        Button loginBtn = new Button("Login");
        GridPane.setConstraints(loginBtn, 1, 2);

        Button signUpBtn = new Button("Sign Up");
        GridPane.setConstraints(signUpBtn, 1, 3);
        signUpBtn.getStyleClass().add("button-blue");

//        loginBtn.setOnAction(e->{
//            setUserAgentStylesheet(STYLESHEET_CASPIAN);
//        });

        gridPane.getChildren().addAll(nameLabel, nameInput, passwordLabel, passwordInput, loginBtn, signUpBtn);

        Scene scene = new Scene(gridPane, 300, 200);
        scene.getStylesheets().add(getClass().getResource("Viper.css").toString());

        window.setScene(scene);

        window.show();
    }
}
