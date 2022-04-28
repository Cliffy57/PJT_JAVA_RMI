package Controlleur;

import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import Modèles.AluInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Ctrl_alu implements Initializable {
	@FXML
	private Label valeur;

	@FXML
	private Label Gagnant;//Label de gagnant
	@FXML
	private Button btn_un;
	@FXML
	private Button btn_deux;

	@FXML
	private Button btn_rejouer;
	@FXML
	private Button btn_quitter;

	int port=8001;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lancementpartie();
	}

	public void joueur_action_un()
	{
		try
		{
			AluInterface obj = (AluInterface)Naming.lookup("rmi://localhost:"+port+"/src");
			Controle(obj.Findepartie());

			//System.out.println(obj.ChoixJoueur(1));
			CoupJoueur(1);
			Controle(obj.Findepartie());
			CoupOrdi();
			Controle(obj.Findepartie());
		}catch(Exception e) {
			System.out.println("E" +e);
		}
	}
	public void joueur_action_deux()
	{
		try
		{
			AluInterface obj = (AluInterface)Naming.lookup("rmi://localhost:"+port+"/src");

			Controle(obj.Findepartie());
			CoupJoueur(2);

			Controle(obj.Findepartie());
			CoupOrdi();

			Controle(obj.Findepartie());
		}catch(Exception e) {
			System.out.println("E" +e);
		}

	}
			//Contrôle l'état de la partie
	void Controle(boolean statut)
	{
		if(statut == true) 
		{
			System.out.println("FIN DE PARTIE");
			btn_un.setDisable(true);
			btn_deux.setDisable(true);
			//Stage stage=(Stage) valeur.getScene().getWindow();
			//stage.close();
			try {
				AluInterface obj = (AluInterface)Naming.lookup("rmi://localhost:"+port+"/src");
				obj.resetbool();
				Gagnant.setText(obj.affgagnant());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

	void CoupOrdi()
	{
		try
		{
			AluInterface obj = (AluInterface)Naming.lookup("rmi://localhost:"+port+"/src");
			obj.ChoixOrdi();
			System.out.println("L'ordi a joué : " + obj.ConsoleLog());
			valeur.setText(String.valueOf( obj.ConsoleLog()));
		}catch(Exception e)
		{
			System.out.println("Erreur : " +e);
		}

	}

	void CoupJoueur(int coup)
	{
		try {
			AluInterface obj = (AluInterface)Naming.lookup("rmi://localhost:"+port+"/src");
			obj.ChoixJoueur(coup);
			System.out.println(obj.ConsoleLog());
			valeur.setText(String.valueOf( obj.ConsoleLog()));
		}
		catch(Exception e)
		{
			System.out.println("Erreur : "+e);
		}
	}

	public void quitter()
	{
		Stage stage=(Stage) btn_un.getScene().getWindow();
		stage.close();
	}

	public void rejouer()
	{
		lancementpartie();
		btn_un.setDisable(false);
		btn_deux.setDisable(false);
	}

	void lancementpartie()
	{
		try
		{

			AluInterface obj = (AluInterface)Naming.lookup("rmi://localhost:"+port+"/src");
			obj.Nombre();
			valeur.setText(String.valueOf( obj.Nombre()));
			Gagnant.setText("");
		}
		catch(Exception e)
		{

			System.out.println("Erreur client ALU : "+e);
		}
	}
}
