package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	static DBManager db;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent p=FXMLLoader.load(getClass().getResource("Login.fxml"));
		primaryStage.setScene(new Scene(p));
		primaryStage.setTitle("·Î±×ÀÎ");
		primaryStage.show();
		
	}
	// main ssdfsdfdagrfwtgresdfsader
	public static void main(String[] args) {
		db=new DBManager();
		launch(args);
		
	}

}
