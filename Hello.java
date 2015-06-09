/* Author: Luigi Vincent
Simple introductory "Hello World" parallel application.
Enter the name and click the button (or press enter), to get a greeting.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Hello extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		TextField entry = new TextField();
		entry.setPromptText("Enter your name");

		Button hello = new Button("Greeting");
		hello.setOnAction(e -> {
			stage.setScene(getGreeting(entry));
			stage.sizeToScene();
		});
		hello.setDefaultButton(true);
		hello.setTooltip(new Tooltip("Click me!"));

		HBox layout = new HBox();
		layout.getChildren().addAll(entry, hello);

		stage.setScene(new Scene(layout));
		stage.setTitle("Welcome to Java");

		stage.show();
		hello.requestFocus();
	}

	public Scene getGreeting(TextField entry) {
		String name = entry.getText();
		Label label = name.isEmpty() ? new Label("Hey camper!") : new Label("How's it going, " + name + "?");
		return new Scene(label);
	}
}
