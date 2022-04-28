package Controlleur;

import java.net.URL;
import java.rmi.Naming;
import java.util.ResourceBundle;

import Modèles.TicTacToeInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Ctrl_tictactoe implements Initializable {


	@FXML
	private Button btn_retour;
	@FXML
	private Button btn_rejouer;
	@FXML
	private Button btn_un;
	@FXML
	private Button btn_deux;
	@FXML
	private Button btn_trois;
	@FXML
	private Button btn_quatre;
	@FXML
	private Button btn_cinq;
	@FXML
	private Button btn_six;
	@FXML
	private Button btn_sept;
	@FXML
	private Button btn_huit;
	@FXML
	private Button btn_neuf;

	@FXML
	private Label statut_partie;

	int port = 8002;

	String tbl[];	//Tableaud de comparaison


	public void rejouer()
	{
		try
		{
			TicTacToeInterface obj = (TicTacToeInterface) Naming.lookup("rmi://localhost:" + port + "/src");
			obj.LancementJeu();
			resetbtn();
			statut_partie.setText("");
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
	//Action du bouton retour
	public void retour()
	{
		Stage stage=(Stage) btn_un.getScene().getWindow();
		stage.close();	
	}




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// TODO Auto-generated method stub


		btn_rejouer.setDisable(true);	//Bloque le bouton rejouer
		statut_partie.setText("");
		try
		{
			TicTacToeInterface obj = (TicTacToeInterface) Naming.lookup("rmi://localhost:" + port + "/src");
			obj.LancementJeu();
			obj.printtableau();


			tbl = obj.gettableau();


		}catch(Exception e)
		{
			System.out.println(e);
		}


	}
			//Fonctions qui gère les cases 1 à 9 du tableau du tic-tac-toe
	public void case1() {
		try {
			TicTacToeInterface obj = (TicTacToeInterface) Naming.lookup("rmi://localhost:" + port + "/src");
			String[] tbl2 = obj.gettableau();

			{
				//
				obj.printChoix(0);
				controlestatut();

				tbl=obj.gettableau();

				affichage_croix(btn_un);

				if(obj.StatutPartie() == false)grilleordichoixmaj(tbl,tbl2);

				controlestatut();
			}

			obj.printtableau();
		}catch(Exception e)
		{
			System.out.println(e);
		}




	}

	public void case2() {
		try
		{
			TicTacToeInterface obj = (TicTacToeInterface) Naming.lookup("rmi://localhost:" + port + "/src");

			String[] tbl2 = obj.gettableau();


			affichage_croix(btn_deux);
			//
			obj.printChoix(1);
			controlestatut();
			tbl=obj.gettableau();


			if(obj.StatutPartie() == false)		grilleordichoixmaj(tbl,tbl2);
			controlestatut();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public void case3() {
		try {
			TicTacToeInterface obj = (TicTacToeInterface) Naming.lookup("rmi://localhost:" + port + "/src");
			String[] tbl2 = obj.gettableau();

			affichage_croix(btn_trois);
			//
			obj.printChoix(2);
			controlestatut();
			tbl=obj.gettableau();


			if(obj.StatutPartie() == false)			grilleordichoixmaj(tbl,tbl2);
			obj.printtableau();
			controlestatut();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public void case4() {
		try {
			TicTacToeInterface obj = (TicTacToeInterface) Naming.lookup("rmi://localhost:" + port + "/src");

			String[] tbl2 = obj.gettableau();

			affichage_croix(btn_quatre);
			//
			obj.printChoix(3);
			controlestatut();
			tbl=obj.gettableau();


			if(obj.StatutPartie() == false)	grilleordichoixmaj(tbl,tbl2);

			obj.printtableau();
			controlestatut();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public void case5() {
		try {
			TicTacToeInterface obj = (TicTacToeInterface) Naming.lookup("rmi://localhost:" + port + "/src");

			String[] tbl2 = obj.gettableau();

			affichage_croix(btn_cinq);
			//
			obj.printChoix(4);
			controlestatut();
			tbl=obj.gettableau();


			if(obj.StatutPartie() == false)		grilleordichoixmaj(tbl,tbl2);
			controlestatut();
			obj.printtableau();

		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public void case6() {
		try {
			TicTacToeInterface obj = (TicTacToeInterface) Naming.lookup("rmi://localhost:" + port + "/src");

			String[] tbl2 = obj.gettableau();

			affichage_croix(btn_six);
			//
			obj.printChoix(5);
			controlestatut();
			tbl=obj.gettableau();


			if(obj.StatutPartie() == false)	grilleordichoixmaj(tbl,tbl2);
			obj.printtableau();
			controlestatut();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public void case7() {
		try {
			TicTacToeInterface obj = (TicTacToeInterface) Naming.lookup("rmi://localhost:" + port + "/src");

			String[] tbl2 = obj.gettableau();
			controlestatut();
			affichage_croix(btn_sept);
			//
			obj.printChoix(6);
			controlestatut();
			tbl=obj.gettableau();


			if(obj.StatutPartie() == false)	grilleordichoixmaj(tbl,tbl2);
			obj.printtableau();
			controlestatut();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public void case8() {
		try {
			TicTacToeInterface obj = (TicTacToeInterface) Naming.lookup("rmi://localhost:" + port + "/src");

			String[] tbl2 = obj.gettableau();

			affichage_croix(btn_huit);
			//
			obj.printChoix(7);
			controlestatut();
			tbl=obj.gettableau();


			if(obj.StatutPartie() == false)	grilleordichoixmaj(tbl,tbl2);
			obj.printtableau();
			controlestatut();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void case9() {
		try {
			TicTacToeInterface obj = (TicTacToeInterface) Naming.lookup("rmi://localhost:" + port + "/src");

			String[] tbl2 = obj.gettableau();

			affichage_croix(btn_neuf);
			//
			obj.printChoix(8);
			controlestatut();
			tbl=obj.gettableau();


			if(obj.StatutPartie() == false)grilleordichoixmaj(tbl,tbl2);


			obj.printtableau();
			controlestatut();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

	public void grilleordichoixmaj(String[] tbl1, String[] tbl2) {	//Compare les deux tableaux sans effacer les choix des joueurs au niveau de l'affichage
		for(int i = 0; i<= 10 ; i++)
		{
			if(tbl1[i].equals(tbl2[i]) == false && tbl1[i].equals("X")==false)	//Tbl1 <=> tbl du choix joueur, tbl2 <=> tableau joué lors de l'ordinateur
			{
				switch(i) {
				case 0: affichage_rond(btn_un);break;
				case 1:affichage_rond(btn_deux);break;
				case 2:affichage_rond(btn_trois);break;
				case 3:affichage_rond(btn_quatre);break;
				case 4:affichage_rond(btn_cinq);break;
				case 5:affichage_rond(btn_six);break;
				case 6:affichage_rond(btn_sept);break;
				case 7:affichage_rond(btn_huit);break;
				case 8:affichage_rond(btn_neuf);break;
				default : break;
				}
			}}



	}
	//Controle l'état de partie en récup le boolean du serveur
	public void controlestatut()
	{
		try
		{
			TicTacToeInterface obj = (TicTacToeInterface) Naming.lookup("rmi://localhost:" + port + "/src");
			System.out.println(obj.StatutPartie());
			if(obj.StatutPartie() == true)
			{
				btn_rejouer.setDisable(false);
				statut_partie.setText("Partie Terminée !");
				// resetbtn();
			}
		}catch(Exception e)
		{
			System.out.println("e");
		}
	}

		//Remet les boutons activables et supprime les X et les O dans les boutons
	public void resetbtn()
	{
		btn_un.setDisable(false);
		btn_deux.setDisable(false);
		btn_trois.setDisable(false);
		btn_quatre.setDisable(false);
		btn_cinq.setDisable(false);
		btn_six.setDisable(false);
		btn_sept.setDisable(false);
		btn_huit.setDisable(false);
		btn_neuf.setDisable(false);
		btn_un.setGraphic(null);
		btn_deux.setGraphic(null);
		btn_trois.setGraphic(null);
		btn_quatre.setGraphic(null);
		btn_cinq.setGraphic(null);
		btn_six.setGraphic(null);
		btn_sept.setGraphic(null);
		btn_huit.setGraphic(null);
		btn_neuf.setGraphic(null);

	}
	//Affiche une croix sur un bouton
	public void  affichage_croix(Button btn)
	{
		Image img = new Image("/images/croix.png");
		ImageView view = new ImageView(img);
		view.setFitHeight(20);
		view.setPreserveRatio(true);
		btn.setGraphic(view);
		btn.setDisable(true);
	}

	//Affiche un rond sur un bouton
	public void  affichage_rond(Button btn)
	{
		Image img = new Image("/images/rond.png");
		ImageView view = new ImageView(img);
		view.setFitHeight(20);
		view.setPreserveRatio(true);
		btn.setGraphic(view);
		btn.setDisable(true);
	}


}

