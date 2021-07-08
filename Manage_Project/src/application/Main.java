package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	static DBManager db;
	
	FXMLLoader loader;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		loader=new FXMLLoader(getClass().getResource("Login.fxml"));
		Parent p=loader.load();
		primaryStage.setScene(new Scene(p));
		primaryStage.setTitle("·Î±×ÀÎ");
		primaryStage.show();
		
	}
<<<<<<< Updated upstream
	// gittest
=======
	// mainsadsdfsdf
>>>>>>> Stashed changes
	public static void main(String[] args) {
		db=new DBManager();
		launch(args);
		
	}

}
