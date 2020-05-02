package p13.treeview;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Tian Z
 */
public class Main extends Application {
    Stage window;
    Scene scene;
    Button button;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("?");
        button = new Button("Submit");

        TreeItem<String> root, bucky, megan;

//        Root
        root = new TreeItem<>();
        root.setExpanded(true);

//        Bucky branch
        bucky = makeBranch("Bucky", root);
        makeBranch("Cod and chips", bucky);
        makeBranch("Chicken", bucky);

//        Megan branch
        megan = makeBranch("Megan", root);
        makeBranch("Glitter", megan);
        makeBranch("Makeup", megan);

//        Creat tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);

        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if (newValue != null) {
                        System.out.println(newValue.getValue());
                    }
                });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(tree);

        scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    public TreeItem<String> makeBranch(String itemName, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(itemName);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}
