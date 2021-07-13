package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class DeleteController implements Initializable {

	@FXML private TextField name,gender,position,dname;
	@FXML private Button btn_delete;
	@FXML private ComboBox<Integer> comboBox;
	@FXML private AnchorPane delete_form;
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		List<Integer> l=Main.db.take_eno();
		ObservableList<Integer> list=FXCollections.observableArrayList(l);
		comboBox.setItems(list);
		
		
	}
	
	public void checkCombo()
	{
		int check=comboBox.getValue();
		String sql="select ename, gender, position,dname from worker,dept where eno=? and worker.dno=dept.dno ";
		try {
			PreparedStatement prst=Main.db.con.prepareStatement(sql);
			prst.setInt(1, check);
			ResultSet rs=prst.executeQuery();
			if(rs.next())
			{
				name.setText(rs.getString(1));
				gender.setText(rs.getString(2));
				position.setText(rs.getString(3));
				dname.setText(rs.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void handleBtnDelete()
	{
		int check=comboBox.getValue();
		Main.db.worker_delete(check);
		
		//화면전환 코드
		StackPane root=(StackPane)btn_delete.getScene().getRoot();
		
		delete_form.setTranslateX(0);
		Timeline timeline=new Timeline();
		KeyValue keyvalue=new KeyValue(delete_form.translateXProperty(), 350);
		KeyFrame keyframe=new KeyFrame(Duration.millis(800),
		e->{
			root.getChildren().remove(delete_form);
		},keyvalue);
		
		timeline.getKeyFrames().add(keyframe);
		timeline.play();
		
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText("삭제되었습니다.");
		alert.show();
		
	}

}
