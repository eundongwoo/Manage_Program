package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class JobUpdateController implements Initializable{
	@FXML private ComboBox<String> jobcomboBox;
	@FXML private TextField jobupdate_data, dno;
	@FXML private Button jobBtn_update;
	@FXML private AnchorPane jobupdate_form;
	ObservableList<String> list = FXCollections.observableArrayList("부서명", "위치");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		jobcomboBox.setItems(list);
		
	}
	public void jobhandleBtnUpdate() {
		System.out.println(dno.getText());
		String option = jobcomboBox.getValue();
		String condition = null;
		
		if(option.equals("부서명")) {
			condition = "dname";
		}else if(option.equals("위치")) {
			condition = "location";
		} 
		
		Main.db.job_update(condition ,jobupdate_data.getText(), dno.getText());
			
		StackPane root=(StackPane)jobBtn_update.getScene().getRoot();
		
		jobupdate_form.setTranslateX(0);
		Timeline timeline=new Timeline();
		KeyValue keyvalue=new KeyValue(jobupdate_form.translateXProperty(), 350);
		KeyFrame keyframe=new KeyFrame(Duration.millis(800),
		e->{
			root.getChildren().remove(jobupdate_form);
		},keyvalue);
		
		timeline.getKeyFrames().add(keyframe);
		timeline.play();
		
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("수정되었습니다.");
		alert.show();
	}
}
