package application;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class SearchController implements Initializable{
	@FXML private Button btn_search,btn_confirm;
	@FXML private AnchorPane search_form;
	@FXML private TableView<WorkerTableRowData> tableView;
	@FXML private TableColumn<WorkerTableRowData, String> name,gender,position,dname;
	@FXML private TableColumn<WorkerTableRowData, Integer>eno,salary;
	@FXML private TableColumn<WorkerTableRowData, Date> hiredate;
	boolean check=false;
	List<Worker> workers=Main.db.take_worker();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	public void btn_search()
	{
		if(check==false)
		{
			
			
			for(int i=0;i<workers.size();i++)
			{
				Worker worker=workers.get(i);
				tableView.getItems().add(new WorkerTableRowData(new SimpleIntegerProperty(worker.getEno()), new SimpleStringProperty(worker.getName()), new SimpleStringProperty(worker.getGender()),new SimpleIntegerProperty(worker.getSalary()) , new SimpleStringProperty(worker.getPosition()),new SimpleObjectProperty<>(worker.getHiredate()) ,new SimpleStringProperty(worker.getDname())));
				
			}
			
//		food.setCellValueFactory(cellData->cellData.getValue().nameProperty());
//		foodPrice.setCellValueFactory(cellData->cellData.getValue().priceProperty().asObject());
			
			eno.setCellValueFactory(cellData->cellData.getValue().getEno().asObject());
			name.setCellValueFactory(cellData->cellData.getValue().getName());
			gender.setCellValueFactory(cellData->cellData.getValue().getGender());
			salary.setCellValueFactory(cellData->cellData.getValue().getSalary().asObject());
			position.setCellValueFactory(cellData->cellData.getValue().getPosition());
			hiredate.setCellValueFactory(cellData->cellData.getValue().getHiredate());
			dname.setCellValueFactory(cellData->cellData.getValue().getDname());
			check=true;
			
		}else
		{
			tableView.getItems().remove(0, tableView.getItems().size());
			check=false;
		}
		
		
		
	}
	
	public void handleBtnConfirm()
	{
		//화면전환 코드
		StackPane root=(StackPane)btn_confirm.getScene().getRoot();
		
		search_form.setTranslateX(0);
		Timeline timeline=new Timeline();
		KeyValue keyvalue=new KeyValue(search_form.translateXProperty(), 350);
		KeyFrame keyframe=new KeyFrame(Duration.millis(800),
		e->{
			root.getChildren().remove(search_form);
		},keyvalue);
		
		timeline.getKeyFrames().add(keyframe);
		timeline.play();
		
	}

}
