package Controlleur;

import java.net.URL;
import java.rmi.Naming;
import java.util.ResourceBundle;

import Modèles.PenduInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ctrl_pendu implements Initializable{

	@FXML
	private Text mot_cache;

	@FXML
	private Button btn_quitter;
	@FXML
	private Button btn_rejouer;

	@FXML
	private Text erreur_text;

	@FXML private Text lettrejoue_text;

	int port = 8000;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		init();		
	}
	void CdtVictoire()
	{
		try
		{
			PenduInterface obj = (PenduInterface)Naming.lookup("rmi://localhost:"+port+"/src");
			//System.out.println(obj.ConditionVictoire());
			if(obj.ConditionVictoire()==true)
			{
				System.out.println("Fin de partie");
				if(obj.GetNbErreurs() == 7)
				{

					//motdefaite.setText("Le mot était :"+obj.GetMotNormal());
					btn_rejouer.setDisable(false);
				}
				else
				{
					//motdefaite.setText("Vous avez gagné !");
					btn_rejouer.setDisable(false);
				}

			}

		}
		catch(Exception e)
		{
			System.out.println("Erreur lors de la fermeture du pendu : "+e);
		}
	}

	public void nb_erreur()
	{
		try
		{

			PenduInterface obj = (PenduInterface)Naming.lookup("rmi://localhost:"+port+"/src");
			System.out.println(obj.GetNbErreurs());
			erreur_text.setText(String.valueOf(7-obj.GetNbErreurs()));
		}
		catch(Exception e)
		{
			System.out.println("Erreur lors du calcul de nb d'erreur" + e);
		}
	}

	public void update_lettre() //tableau des lettes joues
	{
		try
		{

			PenduInterface obj = (PenduInterface)Naming.lookup("rmi://localhost:"+port+"/src");
			//System.out.println(obj.GetNbErreurs());
			lettrejoue_text.setText(String.valueOf(obj.GetListeLettre()));
		}
		catch(Exception e)
		{
			System.out.println("Erreur lors de l'update de lettre "+e);
		}
	}

	public void update_motcache()
	{
		try
		{

			PenduInterface obj = (PenduInterface)Naming.lookup("rmi://localhost:"+port+"/src");
			//System.out.println(obj.GetNbErreurs());
			System.out.println(obj.GetMotCache());
			mot_cache.setText(obj.GetMotCache());
		}
		catch(Exception e)
		{
			System.out.println("Erreur lors de la mise à jour du mot caché" +e);
		}
	}

	//
	public void joue(char c)
	{
		try
		{
			PenduInterface obj = (PenduInterface)Naming.lookup("rmi://localhost:"+port+"/src");
			System.out.println(obj.CheckLettre(c));	
			nb_erreur();
			CdtVictoire();
			update_lettre();
			update_motcache();
		}catch(Exception e)
		{
			System.out.println("Une erreur est arrivé lors de l'action du button"+e);
		}
	}

	public void Rejouer()
	{
		init();
	}
	public void Quitter()
	{
		Stage stage=(Stage) erreur_text.getScene().getWindow();
		stage.close();
	}

	public void init()
	{
		try
		{
			PenduInterface obj = (PenduInterface)Naming.lookup("rmi://localhost:"+port+"/src");
			//obj.GetMotCache();
			System.out.println(obj.LancementJeu());
			System.out.println("Le mot caché est : " + obj.GetMotCache());
			mot_cache.setText(obj.GetMotCache());
			System.out.println(obj.GetMotNormal());
			erreur_text.setText("7");
			lettrejoue_text.setText("");
			//GAGNEOUPERDU.setText("");
			btn_rejouer.setDisable(true);

		}
		catch(Exception e)
		{
			System.out.println("ERREUR Lancement du pendu : "+e);
		}
	}

	//Fonctions liées au bouton a-z
	public void action_a()
	{
		joue('a');
	}


	public void action_b()
	{
		joue('b');
	}

	public void action_c()
	{
		joue('c');
	}

	public void action_d()
	{
		joue('d');
	}

	public void action_e()
	{
		joue('e');
	}

	public void action_f()
	{

		joue('f');
	}


	public void action_g()
	{

		joue('g');
	}

	public void action_h()
	{
		joue('h');
	}


	public void action_i()
	{
		joue('i');
	}

	public void action_j()
	{
		joue('j');
	}
	public void action_k()
	{
		joue('k');
	}
	public void action_l()
	{
		joue('l');
	}
	public void action_m()
	{
		joue('m');
	}
	public void action_n()
	{
		joue('n');
	}
	public void action_o()
	{
		joue('o');
	}
	public void action_p()
	{
		joue('p');
	}
	public void action_q()
	{
		joue('q');
	}
	public void action_r()
	{
		joue('r');
	}
	public void action_s()
	{
		joue('s');
	}
	public void action_t()
	{
		joue('t');
	}
	public void action_u()
	{
		joue('u');
	}
	public void action_v()
	{
		joue('v');
	}
	public void action_w()
	{
		joue('w');
	}
	public void action_x()
	{
		joue('x');
	}
	public void action_y()
	{
		joue('y');
	}
	public void action_z()
	{
		joue('z');
	}
}
