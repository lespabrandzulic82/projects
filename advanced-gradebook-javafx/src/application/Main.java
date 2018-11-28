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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class Main extends Application {
	
		private TextField tfNumberStudents = new TextField();
		private TextField tfStudentFirstName = new TextField();
		private TextField tfStudentLastName = new TextField();
		private TextField tfStudentGrade = new TextField();
		
		private Label labelNumberStudents = new Label("Enter number of student's: ");
		private Label labelStudentName = new Label("Enter student first name: ");
		private Label labelStudentSurname = new Label("Enter student surname: ");
		private Label labelStudentGrade = new Label("Enter student grade: ");
		
		private Button btSubmit = new Button("Submit");
		
		GridPane gridPaneRaport = new GridPane();
		
		private Label label = new Label();
	    private Label lbAvgGrade = new Label();
		private Label lbMax = new Label();
		private Label lbMin = new Label();
		
		int totalNumberStudents = 0;
		String [] names;
		String [] surnames;
		int [] grades;
		int totalGrades = 0;
		double avgGrade = 0.0;
		int i = 0;
		
		private Button btAddStudent = new Button("Add Student");
		private Button btQuitApp = new Button("Quit");
		private Button btRunRaport = new Button("Run Raport");
		
		private StringProperty messNumStudent = new SimpleStringProperty();
		private StringProperty messRaport = new SimpleStringProperty();
		private StringProperty messMax = new SimpleStringProperty();
		private StringProperty messMin = new SimpleStringProperty();
		private StringProperty messAvgGrade = new SimpleStringProperty();




		
	

		@Override
		public void start(Stage stage) throws Exception {
			try {
			GridPane gridPane = new GridPane();
			
			gridPane.setVgap(15);
			gridPane.setHgap(10);
			gridPane.setAlignment(Pos.CENTER);
			
			gridPane.add(labelNumberStudents, 0, 0);
			gridPane.add(tfNumberStudents, 1, 0);
			gridPane.add(btSubmit,2,0);
			gridPane.add(labelStudentName, 0, 1);
			gridPane.add(tfStudentFirstName, 1, 1);
			gridPane.add(labelStudentSurname, 0, 2);
			gridPane.add(tfStudentLastName, 1, 2);
			gridPane.add(labelStudentGrade, 0, 3);
			gridPane.add(tfStudentGrade, 1, 3);
			gridPane.add(btAddStudent, 1, 4);
			gridPane.add(btQuitApp, 0, 5);
			gridPane.add(btRunRaport, 1, 5);
			
			
			label.textProperty().bind(messNumStudent);
			
			gridPane.add(label, 0, 6);
			
			
			gridPane.add(gridPaneRaport, 0, 7);
			//lbRaport.textProperty().bind(messName);
			
			
			
			
			lbMax.textProperty().bind(messMax);
			gridPane.add(lbMax, 0, 8);
			
			
			lbMin.textProperty().bind(messMin);
			gridPane.add(lbMin, 0, 9);
			
			
			lbAvgGrade.textProperty().bind(messAvgGrade);
			gridPane.add(lbAvgGrade, 0, 10);
			
			// ---------------------------------------
			
			btSubmit.setOnAction(evt -> getNumberOfStudents());
			btAddStudent.setOnAction(evt -> getAddingStudentData());
			btRunRaport.setOnAction(evt -> getRunRaport());
			btQuitApp.setOnAction(evt -> getQuitApplication());
		    //---------------------------------------
			
			Scene scene = new Scene(gridPane ,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		
		public static void main(String[] args) {
			launch(args);
		}
		
		public void getNumberOfStudents() {
			
			try {
				
				totalNumberStudents = Integer.parseInt(tfNumberStudents.getText());
				names = new String[totalNumberStudents];
				surnames = new String[totalNumberStudents];
				grades = new int [totalNumberStudents];
				
				messNumStudent.set("Number of student's is " + Integer.toString(totalNumberStudents) + " .");
							
				
			}
			catch(Exception e) {
				
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Invalid values");
				alert.setContentText("You nedd to enter positive number.");
				alert.showAndWait();
			}
		}
		
		public void getAddingStudentData() {
			
			boolean successName = false;
			try {
				names[i] = tfStudentFirstName.getText();
			
				if(names[i].matches("[a-zA-Z]+")) {
					successName = true;
							
				}else {
				 throw new Exception();
				}
			}
			catch(Exception e) {
				
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Invalid values");
				alert.setContentText("Student's name can contains only letters.");
				alert.showAndWait();
				
			}
			
				boolean successSurname = false;
				try {
				surnames[i] = tfStudentLastName.getText();
				   if(surnames[i].matches("[a-zA-Z]+")) {
					    successSurname = true;
				   }
				   else {
					   throw new Exception();
				   }
				}
				catch(Exception e) {
					
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Invalid values");
					alert.setContentText("Student's surname can contains only letters.");
					alert.showAndWait();
				}
				
			int temporaryGrade;
			
						
			try {
				temporaryGrade = Integer.parseInt(tfStudentGrade.getText());
				if(temporaryGrade < 5) {
					
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Invalid Grade");
					alert.setContentText("The grade has to be beetvetn 4 and 11");
					alert.showAndWait();
					
				}
				else {
					
					grades[i] = temporaryGrade;
					i++;
				}
			}
			catch(Exception e) {
				
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Invalid Grade");
				alert.setContentText("The grade has to be beetvetn 4 and 11");
				alert.showAndWait();
							
			}
			
			tfStudentFirstName.clear();
			tfStudentLastName.clear();
			tfStudentGrade.clear();
			
			if (i == totalNumberStudents) {
				
				btAddStudent.setDisable(true);
			}
			
			
		}
		
		public void getRunRaport() {
			
			for(int i = 0; i < totalNumberStudents; i++) {
				
				int j = i + 1;
				Label lbRaport = new Label();
				
				lbRaport.setText( j +". Student " + names[i] + " " +surnames[i] + " has grade " + Integer.toString(grades[i]) + ".");
				gridPaneRaport.add(lbRaport, 0, i);
				
				totalGrades += grades[i];
				
			}
			
			// average grade
			avgGrade = (double)totalGrades / totalNumberStudents;
			
			// max and min grade
			
			int maxGrade = grades[0];
			int minGrade = grades[0];
			
			for (int i = 0; i < grades.length; i++) {
				
				
				if(grades[i] < minGrade) {
					minGrade = grades[i];
				}
				 if(grades[i] > maxGrade) {
					 
					 maxGrade = grades[i];					 
				 }
				
			}
			
			messMax.set("Maximum grade of all student's is " + Integer.toString(maxGrade));
			messMin.set("Minimum grade of all student's is " + Integer.toString(minGrade));
			messAvgGrade.set("Average grade of all student's is " + Double.toString(avgGrade));
			
		}
		
		public void getQuitApplication() {
			
			Platform.exit();
		}
		
		
}
