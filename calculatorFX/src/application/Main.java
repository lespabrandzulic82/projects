package application;
	
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Main extends Application {
	
	private TextField textField = new TextField();
	private Button btMC = new Button("MC");
	private Button btMplus = new Button("M+");
	private Button btMminus = new Button("M-");
	private Button btMR = new Button("MR");
	private Button btC = new Button("C");
	private Button btPlusMinus = new Button("+-");
	private Button btDivided = new Button("/");
	private Button btMultiplication = new Button("*");
	private Button bt7 = new Button("7");
	private Button bt8 = new Button("8");
	private Button bt9 = new Button("9");
	private Button btSubtraction = new Button("-");
	private Button bt4 = new Button("4");
	private Button bt5 = new Button("5");
	private Button bt6 = new Button("6");
	private Button btAdding = new Button("+");
	private Button bt1 = new Button("1");
	private Button bt2 = new Button("2");
	private Button bt3 = new Button("3");
	private Button bt0 = new Button("0");
	private Button btEqual = new Button("=");
	private Button btPoint = new Button(".");
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
		
			GridPane calculator = new GridPane();
			
			calculator.setVgap(15);
			calculator.setHgap(10);
			calculator.setAlignment(Pos.CENTER);
			
			calculator.add(textField, 0, 0);
			calculator.add(btMC, 0, 1);
			
			Scene scene = new Scene(calculator,500,400);
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
