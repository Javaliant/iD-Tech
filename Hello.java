/* Author: Luigi Vincent
Simple introductory "Hello World" parallel application.
Enter the name and click the button (or press enter), to get a greeting.
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hello extends Application {
    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-weight: bold;");

        TextField entry = new TextField();
        entry.setPromptText("Enter your name");
        entry.requestFocus();

        HBox layout = new HBox(5);

        Button hello = new Button("Greeting");
        hello.setOnAction(e -> {
            greet(layout, entry);
            stage.setTitle("Welcome to Java");
        });
        hello.setDefaultButton(true);

        layout.getChildren().addAll(nameLabel, entry, hello);
        layout.setPadding(new Insets(2, 12, 2, 12));
        layout.setAlignment(Pos.CENTER);

        scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("Good morning");
        stage.show();
    }

    public void greet(HBox layout, TextField entry) {
        String name = entry.getText();
        Label greeting = new Label();
        greeting.setText(name.isEmpty() ? "Hey camper!" : "How's it going, " + name + "?");

        Button reset = new Button("reset");
        reset.setOnAction(e -> {
            scene.setRoot(layout);
        });
        reset.setTooltip(new Tooltip("Click me!"));

        HBox result = new HBox(5);
        result.setAlignment(Pos.CENTER);
        result.getChildren().addAll(greeting, reset);
        scene.setRoot(result);
    }
}
