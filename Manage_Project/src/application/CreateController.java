package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class CreateController implements Initializable {

	@FXML private Button btn_insert;
	@FXML private GridPane create_form;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void handleBtnInsert()
	{
		System.out.println("등록되었습니다.");
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

}
