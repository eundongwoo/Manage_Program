package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ManageController implements Initializable {

	@FXML private Button user_manage;
	@FXML private Button job_manage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//crud 창으로 이동하는 이벤트
		user_manage.setOnMouseClicked(e->{
			try {
				Parent crud=FXMLLoader.load(getClass().getResource("Crud.fxml"));
				Scene scene=new Scene(crud);
				Stage primaryStage=(Stage)user_manage.getScene().getWindow();
				primaryStage.setScene(scene);
			
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		job_manage.setOnMouseClicked(e->{
			try {
				Parent jobcrud=FXMLLoader.load(getClass().getResource("JobCrud.fxml"));
				Scene scene=new Scene(jobcrud);
				Stage primaryStage=(Stage)user_manage.getScene().getWindow();
				primaryStage.setScene(scene);
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
	}

}
