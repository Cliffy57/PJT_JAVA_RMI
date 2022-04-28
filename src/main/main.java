package main;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class main extends Application{




	@Override
	public void start(Stage primaryStage) {
		try {
			URL fxmlURL=getClass().getResource("/fx/interfaceaccueil.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((Parent) root, 600,400);



			primaryStage.setScene(scene);
			primaryStage.setTitle("Application");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}

