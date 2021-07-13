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

	@FXML private Button btn_insert,btn_update,btn_delete;

	
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
	
	public void handleBtnUpdate()
	{
		try {
			Parent update=FXMLLoader.load(getClass().getResource("Worker_Update.fxml"));
			StackPane root=(StackPane)btn_update.getScene().getRoot();
			root.getChildren().add(update);
			
			update.setTranslateX(350);
			
			Timeline timeline=new Timeline();
			KeyValue keyvalue=new KeyValue(update.translateXProperty(), 0);
			KeyFrame keyframe=new KeyFrame(Duration.millis(800), keyvalue);
			timeline.getKeyFrames().add(keyframe);
			timeline.play();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void handleBtnDelete()
	{
		try {
			Parent delete=FXMLLoader.load(getClass().getResource("Worker_Delete.fxml"));
			StackPane root=(StackPane)btn_delete.getScene().getRoot();
			root.getChildren().add(delete);
			
			delete.setTranslateX(350);
			
			Timeline timeline=new Timeline();
			KeyValue keyvalue=new KeyValue(delete.translateXProperty(), 0);
			KeyFrame keyframe=new KeyFrame(Duration.millis(800), keyvalue);
			timeline.getKeyFrames().add(keyframe);
			timeline.play();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
