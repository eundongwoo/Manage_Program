package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class CrudController implements Initializable {

	@FXML private Button btn_insert;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public void handleBtnInsert()
	{
		try {
			Parent insert=FXMLLoader.load(getClass().getResource("Worker_Create.fxml"));
			StackPane root=(StackPane)btn_insert.getScene().getRoot();
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