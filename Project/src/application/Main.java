package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("ProjectDesign.fxml"));
			Scene scene = new Scene(root);
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		primaryStage.setMinWidth(340);
		primaryStage.setMinHeight(580);
		
		primaryStage.setTitle("Hospital Management System");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}