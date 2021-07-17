package application;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ManageController implements Initializable {

	@FXML private Button user_manage;
	@FXML private Button job_manage;
	@FXML private Label name;
	@FXML private Hyperlink logout;
	String user_name;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		user_name=Main.db.user_name();
		
		name.setText(user_name);
		
		logout.setOnMouseClicked(e->{
			Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("로그아웃");
			alert.setHeaderText("로그아웃 하시겠습니까?");
			Optional<ButtonType> result=alert.showAndWait();
			if(result.get()==ButtonType.OK)
			{
				Main.db.logout();
				try {
					
					
					Parent crud=FXMLLoader.load(getClass().getResource("Login.fxml"));
					Scene scene=new Scene(crud);
					Stage primaryStage=(Stage)user_manage.getScene().getWindow();
					primaryStage.setScene(scene);
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}else
			{
				
			}
			
			
		});
		
		
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
