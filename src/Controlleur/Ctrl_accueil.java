package Controlleur;

import java.net.URL;
import java.util.ResourceBundle;

import Vues.Vue_Pendu;
import Vues.Vue_alu;
import Vues.Vue_tictactoe;
import Vues.Vue_tictactoe2j;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Ctrl_accueil implements Initializable {

	@FXML
	private Button Btn_amu;
	@FXML
	private Button Btn_pendu;
	@FXML
	private Button Btn_tictactoe;
	@FXML
	private Button Btn_tictactoe2;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
	
	public void lancementjeu()	//Quand on appuie sur le bouton alu
	{
	
		try {
			new Vue_alu().start(new Stage());
		}catch(Exception e) {
			System.out.println("E" +e);
		}
	}
	public void lancementpendu()//Quand on appuie sur le bouton pendu
	{
		try {
			new Vue_Pendu().start(new Stage());
		
		}catch(Exception e) {
			System.out.println("E" +e);
		}
	}
	
	public void lancementtictactoe()//Quand on appuie sur le tic-tac-toe (Joueur/Serveur)
	{	
		try {
			new Vue_tictactoe().start(new Stage());
		}catch(Exception e) {
			System.out.println("E" +e);
		}
	}
	public void lancementtictactoe2()	//QUand on appuie sur le tic-tac-toe 2joueur( Joueur/Joueur)
	{
		
		
		try {
			new Vue_tictactoe2j().start(new Stage());
			new Vue_tictactoe2j().start(new Stage());
		}catch(Exception e) {
			System.out.println("E" +e);
		}
	}
	

}
