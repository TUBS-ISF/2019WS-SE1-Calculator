package de.tubs.se1.calculator;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GuiFactory {
	
	public Label createLabel() {
		Label label = new Label();
		label.setStyle("-fx-font: 24 arial;");
		return label;
	}

	public Button createButton(String title) {
		Button button = new Button(title);
		button.setStyle("-fx-font: 32 arial;");
		return button;
	}

}
