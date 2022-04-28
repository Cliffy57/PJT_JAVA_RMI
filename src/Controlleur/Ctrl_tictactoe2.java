package Controlleur;

import java.net.URL;
import java.rmi.Naming;
import java.util.ResourceBundle;

import Modèles.TicTacToeInterface2j;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Ctrl_tictactoe2 implements Initializable {


	//J1 Croix et J2 Rond
	boolean joueur1_joue=true;	//true => il doit jouer, false => il a fini de jouer
	boolean joueur2_joue=false;
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

	int port = 8003;

	String tbl[];


	public void rejouer()
	{
		try
		{
			TicTacToeInterface2j obj = (TicTacToeInterface2j) Naming.lookup("rmi://localhost:" + port + "/src");
			obj.StartGame();
			resetbtn();
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
		//btn_un.setPrefHeight(35);

		btn_rejouer.setDisable(true);
		try
		{
			TicTacToeInterface2j obj = (TicTacToeInterface2j) Naming.lookup("rmi://localhost:" + port + "/src");
			obj.StartGame();
			obj.printtableau();


			tbl = obj.gettableau();


		}catch(Exception e)
		{
			System.out.println(e);
		}


	}

	public void case1() {
		try {
			TicTacToeInterface2j obj = (TicTacToeInterface2j) Naming.lookup("rmi://localhost:" + port + "/src");
			String[] tbl2 = obj.gettableau();
			//if(id == true)

			if(joueur1_joue == true)
			{
				affichage_croix(btn_un);
				//
				obj.printChoix(0);
				controlestatut();
				tbl=obj.gettableau();
				joueur1_joue=false;
				joueur2_joue=true;
				obj.add(0);
				//btn_un.setTextOverrun(obj.gettableau());

			}else
			{
				affichage_rond(btn_un);
				//
				obj.printChoix(0);
				controlestatut();
				tbl=obj.gettableau();
				joueur1_joue=true;
				joueur2_joue=false;
				obj.add(0);
			}



			// obj.printtableau();
			System.out.printf("J1"+joueur1_joue+"J2"+joueur2_joue);
		}catch(Exception e)
		{
			System.out.println(e);
		}




	}

	public void case2() {

		try
		{
			TicTacToeInterface2j obj = (TicTacToeInterface2j) Naming.lookup("rmi://localhost:" + port + "/src");

			String[] tbl2 = obj.gettableau();

			if(joueur1_joue == true)
			{
				affichage_croix(btn_deux);
				//
				obj.printChoix(1);
				controlestatut();
				tbl=obj.gettableau();
				joueur1_joue=false;
				joueur2_joue=true;
			}
			else
			{
				affichage_rond(btn_deux);
				//
				obj.printChoix(1);
				controlestatut();
				tbl=obj.gettableau();
				joueur1_joue=true;
				joueur2_joue=false;
			}




			//	if(obj.StatutPartie() == false)	//	grilleordichoixmaj(tbl,tbl2);
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public void case3() {
		try {
			TicTacToeInterface2j obj = (TicTacToeInterface2j) Naming.lookup("rmi://localhost:" + port + "/src");
			String[] tbl2 = obj.gettableau();

			if(joueur1_joue ==true)
			{
				affichage_croix(btn_trois);
				//
				obj.printChoix(2);
				controlestatut();
				tbl=obj.gettableau();
				joueur1_joue=false;
				joueur2_joue=true;
			}
			else
			{
				affichage_rond(btn_trois);
				//
				obj.printChoix(2);
				controlestatut();
				tbl=obj.gettableau();
				joueur1_joue=true;
				joueur2_joue=false;
			}


			obj.printtableau();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public void case4() {
		try {
			TicTacToeInterface2j obj = (TicTacToeInterface2j) Naming.lookup("rmi://localhost:" + port + "/src");

			//String[] tbl2 = obj.gettableau();

			affichage_croix(btn_quatre);
			//
			obj.printChoix(3);
			controlestatut();
			tbl=obj.gettableau();


			if(obj.StatutPartie() == false)	//grilleordichoixmaj(tbl,tbl2);

				obj.printtableau();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public void case5() {
		try {
			TicTacToeInterface2j obj = (TicTacToeInterface2j) Naming.lookup("rmi://localhost:" + port + "/src");

			String[] tbl2 = obj.gettableau();

			affichage_croix(btn_cinq);
			//
			obj.printChoix(4);
			controlestatut();
			tbl=obj.gettableau();


			if(obj.StatutPartie() == false)	//	grilleordichoixmaj(tbl,tbl2);
				obj.printtableau();

		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public void case6() {
		try {
			TicTacToeInterface2j obj = (TicTacToeInterface2j) Naming.lookup("rmi://localhost:" + port + "/src");

			String[] tbl2 = obj.gettableau();

			affichage_croix(btn_six);
			//
			obj.printChoix(5);
			controlestatut();
			tbl=obj.gettableau();


			if(obj.StatutPartie() == false)	//grilleordichoixmaj(tbl,tbl2);
				obj.printtableau();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public void case7() {
		try {
			TicTacToeInterface2j obj = (TicTacToeInterface2j) Naming.lookup("rmi://localhost:" + port + "/src");

			String[] tbl2 = obj.gettableau();

			affichage_croix(btn_sept);
			//
			obj.printChoix(6);
			controlestatut();
			tbl=obj.gettableau();


			if(obj.StatutPartie() == false)	//grilleordichoixmaj(tbl,tbl2);
				obj.printtableau();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public void case8() {
		try {
			TicTacToeInterface2j obj = (TicTacToeInterface2j) Naming.lookup("rmi://localhost:" + port + "/src");

			String[] tbl2 = obj.gettableau();

			affichage_croix(btn_huit);
			//
			obj.printChoix(7);
			controlestatut();
			tbl=obj.gettableau();


			if(obj.StatutPartie() == false)	//grilleordichoixmaj(tbl,tbl2);
				obj.printtableau();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void case9() {
		try {
			TicTacToeInterface2j obj = (TicTacToeInterface2j) Naming.lookup("rmi://localhost:" + port + "/src");

			String[] tbl2 = obj.gettableau();

			affichage_croix(btn_neuf);
			//
			obj.printChoix(8);
			controlestatut();
			tbl=obj.gettableau();


			if(obj.StatutPartie() == false)//grilleordichoixmaj(tbl,tbl2);


				obj.printtableau();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}


	//Controle l'état de partie en récup le boolean du serveur
	public void controlestatut()
	{
		try
		{

			TicTacToeInterface2j obj = (TicTacToeInterface2j) Naming.lookup("rmi://localhost:" + port + "/src");
			System.out.println(obj.StatutPartie());
			if(obj.StatutPartie() == true)
			{
				btn_rejouer.setDisable(false);
				resetbtn();

			}
		}catch(Exception e)
		{
			System.out.println("e");
		}
	}

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

	public void  affichage_croix(Button btn)
	{
		Image img = new Image("/images/croix.png");
		ImageView view = new ImageView(img);
		view.setFitHeight(20);
		view.setPreserveRatio(true);
		btn.setGraphic(view);
		btn.setDisable(true);
	}


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

