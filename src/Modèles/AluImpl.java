package Modèles;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AluImpl extends UnicastRemoteObject implements AluInterface{
	int  nb_alu = 0;	//Nombre d'alumettes
	int Min=5;			//Mini nb d'alu
	int Max=31;			//Max nb d'alu
	boolean gagnant = false; //false => Ordi a gagné, true => Joueur a gagne
	boolean partie = false;	//Statut de la partie
	int cmpt_j = 0;   //Compteur du joueur
	int cmpt_serv = 0;//Compteur du serveur
			
	
	public AluImpl () throws RemoteException{
		super();	
	}

	@Override
	public String ConsoleLog() throws RemoteException {
			//Boucle

		String valeur = ""+nb_alu;
	
		return valeur;
	}

	

	@Override
	public int Nombre() throws RemoteException { //Renvoie un nombre d'alumentaire impair
		int nombreAleatoire;
		do
		{
			nombreAleatoire = GenererAleatoire();
			
		}
		while(nombreAleatoire % 2 != 1);
		
		
		return nb_alu = nombreAleatoire;
	}

	@Override
	public int ChoixOrdi() throws RemoteException {	//Renvoie le coup de l'ordinateur
		// TODO Auto-generated method stub
	
		int valeur =  1 + (int)(Math.random() * ((2-1)+1));
		if(valeur == 0) valeur = 1;
		cmpt_serv=cmpt_serv+valeur;
		return nb_alu = nb_alu - valeur;
	}

	@Override
	public int DeterminePremierJoueur() throws RemoteException {
		// TODO Auto-generated method stub
		return 1 + (int)(Math.random() * ((2-1)+1)); //Renvoie 1 ou 2 , si 1 => Joueur sinon le serveur
	}
	
		//Permet de générer un nb aléatoire
	public int GenererAleatoire()
	{
		return Min + (int)(Math.random() * ((Max - Min) + 1));
	}

	@Override
	public int ChoixJoueur(int valeur_joue) throws RemoteException {
		// TODO Auto-generated method stub
		cmpt_j=cmpt_j+valeur_joue;
		return nb_alu =  nb_alu - valeur_joue;
	}

	@Override
	public boolean  Findepartie() throws RemoteException {
		// TODO Auto-generated method stub
		
		if(nb_alu == 0 || nb_alu == -1)	//Cas ou la partie est terminée
			{
			partie=true;
			if(determinegagnant() == true) System.out.println("Le joueur a gagné");
			else 
				System.out.println("Le serveur a gagné");
			}
		return partie;
		
		
	}

	@Override
	public boolean resetbool() throws RemoteException {
		// TODO Auto-generated method stub
		return partie = false;
	}
	
	public boolean determinegagnant() {
		if(cmpt_j >= cmpt_serv && cmpt_j % 0 == 1) gagnant=true;	//Si le joueur a plus de pts et son compteur est impair
		return gagnant;
	}

	@Override
	public String affgagnant() throws RemoteException {
		// TODO Auto-generated method stub
		if(determinegagnant() == true)
		{
			return "Le gagnant est le joueur";
		}
		else return "Le gagnant est le serveur";
	}
	
	

	
	
	
	
	
	
}
