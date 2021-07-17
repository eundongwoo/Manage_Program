package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController implements Initializable {

	@FXML private Hyperlink btn_register;
	@FXML private Button btn_login;
	@FXML private TextField loginid;
	@FXML private TextField loginpass;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub  
		//ȸ������â���� �̵��ϴ� �ڵ�
		btn_register.setOnAction(e->{
			try {
				Parent register=FXMLLoader.load(getClass().getResource("Register.fxml"));
				Scene scene=new Scene(register);
				Stage primaryStage=(Stage)btn_register.getScene().getWindow();
				primaryStage.setScene(scene);
			
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		//���� ����â���� �̵��ϴ� �ڵ�
		btn_login.setOnAction(e->{
			
			Parent register;
			Worker worker = new Worker(loginid.getText());
			int pass = Main.db.Login(worker);
			
			
			if(pass == Integer.parseInt(loginpass.getText()))
			{
				System.out.println("�α��� ����");
				try {
					Main.db.change_check(worker.getID(),pass);
					register = FXMLLoader.load(getClass().getResource("Manage.fxml"));
					Scene scene=new Scene(register);
					Stage primaryStage=(Stage)btn_register.getScene().getWindow();
					primaryStage.setScene(scene);	
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				System.out.println("�α��� ����");
			}
			
		});
	
	}
	

}
