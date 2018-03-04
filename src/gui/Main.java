package gui;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
	public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("renovating_app.fxml"));
        primaryStage.getIcons().add(new Image("ak_logo_tp.png"));
        primaryStage.setTitle("A&K HOUSE Kft. - \"Szívvel újitunk!\"");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
