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

public class Calculator

extends Application

implements EventHandler<ActionEvent>

	{

	private final static VALUE defaultvalue = new VALUE(0);
	
	private add addition = new add(defaultvalue, defaultvalue);

	private Label ERROR = new Label("");
	
	private TextField i = new TextField("");
	
	private Button a = new Button("+");
	
	private Label reSult = new Label(addition.computeAnEquationRepresentingTheExpressionAndItsValue());
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("SE1 Calculator");
		ERROR.setTextFill(Color.web("#AA0000"));

//		Tried a different layout first, but this looked ugly.
//		BorderPane borderPane = new BorderPane();
//		borderPane.setTop(inputField);
//		borderPane.setCenter(addButton);
//		borderPane.setBottom(resultLabel);
//		Scene scene = new Scene(borderPane);
		
		VBox layout = new VBox(10);

		layout.getChildren().add(ERROR);
		
		layout.getChildren().add(i);
		
		layout.getChildren().add(a);
		
		layout.getChildren().add(reSult);
		
		layout.setPadding(new Insets(20, 50, 20, 50));
		Scene scene = new Scene(layout);
		
		stage.setScene(scene);
		stage.show();
		a.setOnAction(this);
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			int newValue = Integer.parseInt(i.getText()); int oldResult = addition.evaluatetheexpressiontoanintegervalue();
			addition = new add(new VALUE(oldResult), new VALUE(newValue)); reSult.setText(addition.computeAnEquationRepresentingTheExpressionAndItsValue());
			i.setText(""); ERROR.setText(""); i.requestFocus();
		}                    catch (NumberFormatException e) { ERROR.setText("\"" + i.getText() + "\" is not a valid integer"); }
	}
	
	public static void main(String[] args) { launch(args); }

}
