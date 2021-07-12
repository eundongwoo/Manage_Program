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

public class UpdateController implements Initializable {
	
	@FXML private TextField update_data,eno;
	@FXML private Button Btn_update;
	@FXML private ComboBox<String> comboBox;
	@FXML private AnchorPane update_form;
	
	 ObservableList<String> list = FXCollections.observableArrayList("급여(월급)","직위","부서번호");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		comboBox.setItems(list);
	}
	
	public void handleBtnUpdate()
	{
		System.out.println(eno.getText());
		String option=comboBox.getValue();
		String condition=null;
		if(option.equals("급여(월급)"))
		{
			condition="salary";
			//Main.db.worker_update(condition, update_data.getText(), eno.getText());
			
		}else if(option.equals("직위"))
		{
			condition="position";
		//	Main.db.worker_update(condition, update_data.getText(), eno.getText());
			
		}else if(option.equals("부서번호"))
		{
			condition="dno";
		//	Main.db.worker_update(Integer.parseInt(update_data.getText()), eno.getText());
		}
		Main.db.worker_update(condition, update_data.getText(), eno.getText());
		
		//화면전환 코드
				StackPane root=(StackPane)Btn_update.getScene().getRoot();
				
				update_form.setTranslateX(0);
				Timeline timeline=new Timeline();
				KeyValue keyvalue=new KeyValue(update_form.translateXProperty(), 350);
				KeyFrame keyframe=new KeyFrame(Duration.millis(800),
				e->{
					root.getChildren().remove(update_form);
				},keyvalue);
				
				timeline.getKeyFrames().add(keyframe);
				timeline.play();
				
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setHeaderText("수정되었습니다.");
				alert.show();
		
	}

}
