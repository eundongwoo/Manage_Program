package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ManageController implements Initializable {

	@FXML Button user_manage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		user_manage.setOnMouseClicked(e->{
			System.out.println("�������");
			//ȸ�� ����â �����ٲ���
		});
	}

}
