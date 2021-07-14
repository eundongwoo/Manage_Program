package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CreateController implements Initializable {

	@FXML private Button btn_insert;
	@FXML private Button jobbtn_insert;
	@FXML private GridPane create_form;
	@FXML private TextField name,salary,position,dno, jobname, location;
	@FXML private RadioButton man,woman;
	@FXML private DatePicker hiredate;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void handleBtnInsert()
	{
// 출력예제		
//		System.out.println(name.getText());
//		if(man.isSelected())
//		{
//			System.out.println(man.getText());
//		}else if(woman.isSelected())
//		{
//			System.out.println(woman.getText());
//		}
//		System.out.println(salary.getText());
//		System.out.println(position.getText());
//		System.out.println(dno.getText());
//		System.out.println(hiredate.getValue());
//		System.out.println(worker.getName());
//		
//		System.out.println(worker.getGender());
//		
//		System.out.println(worker.getSalary());
//		
//		System.out.println(worker.getPosition());
//		
//		System.out.println(worker.getHiredate());
//		
//		System.out.println(worker.getDno());
		
		String gender="";
		if(man.isSelected())
		{
			gender=man.getText();
		}else if(woman.isSelected())
		{
			gender=woman.getText();
		}
		
		Date date=Date.valueOf(hiredate.getValue());
		
		Worker worker=new Worker(name.getText(), gender,Integer.parseInt(salary.getText()), position.getText(), date, dno.getText());
		Main.db.worker_insert(worker);
		
		//화면전환 코드
		StackPane root=(StackPane)btn_insert.getScene().getRoot();
		
		create_form.setTranslateX(0);
		Timeline timeline=new Timeline();
		KeyValue keyvalue=new KeyValue(create_form.translateXProperty(), 350);
		KeyFrame keyframe=new KeyFrame(Duration.millis(800),
		e->{
			root.getChildren().remove(create_form);
		},keyvalue);
		
		timeline.getKeyFrames().add(keyframe);
		timeline.play();
	
	}
	
	public void whatthe(ActionEvent e) {
		Parent register;
		try {
			register = FXMLLoader.load(getClass().getResource("Job_Create.fxml"));
			Scene scene=new Scene(register);
			Stage primaryStage=(Stage)jobbtn_insert.getScene().getWindow();
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

}
