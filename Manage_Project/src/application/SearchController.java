package application;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SearchController implements Initializable{
	@FXML private Button btn_search;
	@FXML private TableView<WorkerTableRowData> tableView;
	@FXML private TableColumn<WorkerTableRowData, String> name,gender,position,dname;
	@FXML private TableColumn<WorkerTableRowData, Integer>eno,salary;
	@FXML private TableColumn<WorkerTableRowData, Date> hiredate;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void btn_search()
	{
		List<Worker> workers=Main.db.take_worker();
		
		for(int i=0;i<workers.size();i++)
		{
			Worker worker=workers.get(i);
			System.out.println("이름:"+worker.getName());
			System.out.println("입사일:"+worker.getHiredate());
			tableView.getItems().add(new WorkerTableRowData(new SimpleIntegerProperty(worker.getEno()), new SimpleStringProperty(worker.getName()), new SimpleStringProperty(worker.getGender()),new SimpleIntegerProperty(worker.getSalary()) , new SimpleStringProperty(worker.getPosition()),new SimpleObjectProperty<>(worker.getHiredate()) ,new SimpleStringProperty(worker.getDname())));
		}
	}

}
