/* Author: Luigi Vincent
Simple introductory "Hello World" parallel application.
Enter the name and click the button (or press enter), to get a greeting.
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Hello extends Application {
	Scene scene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		TextField entry = new TextField();
		entry.setPromptText("Enter your name");

		Button hello = new Button("Greeting");
		hello.setOnAction(e -> greet(entry));
		hello.setDefaultButton(true);
		hello.setTooltip(new Tooltip("Click me!"));

		HBox layout = new HBox();
		layout.getChildren().addAll(entry, hello);
		layout.setPadding(new Insets(2, 12, 2, 12));

		scene = new Scene(layout);

		stage.setScene(scene);
		stage.setTitle("Welcome to Java");
		stage.show();
		hello.requestFocus();
	}

	public void greet(TextField entry) {
		String name = entry.getText();
		Label label = name.isEmpty() ? new Label("Hey camper!") : new Label("How's it going, " + name + "?");
		scene.setRoot(label);
	}
}
