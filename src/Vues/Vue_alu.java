package Vues;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Vue_alu extends Application {
    @Override
    public void start(Stage fenetre)  {
        try {
            // TODO Auto-generated method stub

            Parent root = FXMLLoader.load(getClass().getResource("/fx/interfacealu.fxml"));
            Scene scene = new Scene(root, 600,400);
            fenetre.setScene(scene);
            fenetre.setTitle("Jeu des petits batons ");
            fenetre.show();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

	
}
