package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JobCrudController implements Initializable{
	@FXML private Button jobbtn_insert,jobbtn_update,jobbtn_delete,jobbtn_search;
	@FXML private TextField name,salary,position,dno, jobname, location;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
		public void whatthe(ActionEvent e) {
			Parent register;
			try {
				register = FXMLLoader.load(getClass().getResource("Job_Create.fxml"));
				Scene scene=new Scene(register);
				Stage primaryStage=(Stage)jobbtn_update.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		public void jobhandleBtnInsert(ActionEvent e) {
			Job job = new Job(jobname.getText(), location.getText());
			Main.db.job_insert(job);
			Parent register;
			try {
				register = FXMLLoader.load(getClass().getResource("JobCrud.fxml"));
				Scene scene=new Scene(register);
				Stage primaryStage=(Stage)jobbtn_insert.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		
	}
		public void jobhandleBtnUpdate() {
			try {
				Parent insert=FXMLLoader.load(getClass().getResource("job_update.fxml"));
				StackPane root=(StackPane)jobbtn_update.getScene().getRoot();
				root.getChildren().add(insert);
				
				insert.setTranslateX(350);
				
				Timeline timeline=new Timeline();
				KeyValue keyvalue=new KeyValue(insert.translateXProperty(), 0);
				KeyFrame keyframe=new KeyFrame(Duration.millis(800), keyvalue);
				timeline.getKeyFrames().add(keyframe);
				timeline.play();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
