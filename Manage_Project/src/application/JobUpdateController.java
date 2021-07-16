package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class JobUpdateController implements Initializable{
	@FXML private ComboBox<String> jobcomboBox;
	@FXML private TextField jobupdate_data;
	@FXML private Button jobBtn_update;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
