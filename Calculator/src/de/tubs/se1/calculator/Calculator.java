package de.tubs.se1.calculator;

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

	private Expression expression = new CounterValue(this);
	
	public static GuiFactory factory = new GuiFactory();

	private Label errorLabel = factory.createLabel();

	private TextField inputField = new TextField();

	private Button addButton = factory.createButton("+");

	private Button subtractButton = factory.createButton("-");

	private Label resultLabel = factory.createLabel();

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("SE1 Calculator");
		errorLabel.setTextFill(Color.web("#AA0000"));

		VBox layout = new VBox(10, errorLabel, inputField, addButton, subtractButton, resultLabel);
		layout.setPadding(new Insets(20, 50, 20, 50));
		Scene scene = new Scene(layout);

		stage.setScene(scene);
		stage.show();
		addButton.setOnAction(this);
		subtractButton.setOnAction(this);
		updateGUI();
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			int newValue = Integer.parseInt(inputField.getText());
			if (event.getSource() == addButton) {
				expression = new AddWithBrackets(expression, new Value(newValue));
				Logger.getLogger().log("Add clicked");
			}
			else {
				expression = new Subtract(expression, new Value(newValue));
				Logger.getLogger().log("Subtract clicked");
			}
			updateGUI();
			inputField.requestFocus();
		} catch (NumberFormatException e) {
			errorLabel.setText("\"" + inputField.getText() + "\" is not a valid integer");
		}
	}

	void updateGUI() {
		resultLabel.setText(expression.computeEquation());
		inputField.setText("");
		errorLabel.setText("");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
