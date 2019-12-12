package de.tubs.se1.CAL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Calculator	extends Application implements EventHandler<ActionEvent> {

	private final static Value DEFAULT_VALUE = new Value(0);

	private Add addition = new Add(DEFAULT_VALUE, DEFAULT_VALUE);

	private Label errorLabel = new Label();

	private TextField inputField = new TextField();

	private Button addButton = new Button("+");

	private Label resultLabel = new Label();

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("SE1 Calculator");
		errorLabel.setTextFill(Color.web("#AA0000"));

		VBox layout = new VBox(10, errorLabel, inputField, addButton, resultLabel);
		layout.setPadding(new Insets(20, 50, 20, 50));
		Scene scene = new Scene(layout);

		stage.setScene(scene);
		stage.show();
		addButton.setOnAction(this);
		updateGUI();
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			int newValue = Integer.parseInt(inputField.getText());
			int oldResult = addition.evaluate();
			addition = new Add(new Value(oldResult), new Value(newValue));
			updateGUI();
			inputField.requestFocus();
		} catch (NumberFormatException e) {
			errorLabel.setText("\"" + inputField.getText() + "\" is not a valid integer");
		}
	}

	private void updateGUI() {
		resultLabel.setText(addition.computeEquation());
		inputField.setText("");
		errorLabel.setText("");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
