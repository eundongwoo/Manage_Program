package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController implements Initializable{
	@FXML private Button rgbutton;
	@FXML private TextField rgpassword;
	@FXML private TextField rgename;
	@FXML private TextField rgposition;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	public void rgbuttonhandler(ActionEvent e) {
		Worker worker = new Worker(rgpassword.getText(), rgename.getText());
		Main.db.Register_insert(worker);
		Parent register;
		try {
			register = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene=new Scene(register);
			Stage primaryStage=(Stage)rgbutton.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
