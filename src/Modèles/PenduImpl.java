package Modèles;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PenduImpl extends UnicastRemoteObject implements PenduInterface{
	char [] ListeLettre = new char [26];
	String MotNormal;
	char [] MotCache;
	int nbErreurs=0;
	int nbLettres=0;
	int nbJuste=0;
	Boolean victoire;
	
	public PenduImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String LancementJeu() throws RemoteException {
		// TODO Auto-generated method stub
		nbErreurs=0;
		nbJuste=0;
		nbLettres=0;
		victoire=false;
	for(int i =0; i < 26; i++)ListeLettre[i] = ' ';
		setMotNormal();
		
		return "Joyeux Hunger Games, et puisse le sort vous être favorable!" ;
	}

	
	@Override
	public String GetMotNormal() throws RemoteException {
		return MotNormal;
	}
	
	@Override
	public String GetMotCache() throws RemoteException {	
		return String.valueOf(MotCache);
	}

	@Override
	public void setMotNormal() throws RemoteException {
		
		String listemots[] = { "bonjour" , "salut" , "coucou" , "a" , "ambidextre","jouabilite","content","logique","hippopotomonstrosesquippedaliophobie"};
		
		int nombreAleatoire = (int)(Math.random() * ((listemots.length - 1) +1));
		MotNormal = listemots[nombreAleatoire];
		
		setMotCache(MotNormal.length());
	}

	@Override
	public void setMotCache(int taille) throws RemoteException {
		
		MotCache = new char[taille];
		
		for (int i = 0; i < taille ; i++) {
			MotCache[i] = '_';
		}
	}

	@Override
	public String CheckLettre(char c) throws RemoteException {
		
		for ( int i = 0 ; i < 26 ; i++) {
			if (c == ListeLettre[i]) {
				return " non ";
			}
		}
		
		ListeLettre[nbLettres] = c;
		nbLettres++;
		
		int verifErreur=0;
		for ( int i = 0 ; i < MotNormal.length() ; i++) {
			if (c == MotNormal.charAt(i)) {
				verifErreur++;
				UpdateMotCache(c ,i );
			}
		}
		
		if (verifErreur==0) {
			nbErreurs++;
		}
		
		return "oui";
	}

	@Override
	public void UpdateMotCache(char c, int i) throws RemoteException {
		
		MotCache[i] = c;
		
		nbJuste++;
		
	}

	@Override
	public Boolean ConditionVictoire() throws RemoteException {
		
		if ((nbJuste==MotNormal.length()) ||(nbErreurs == 7) ) {
			victoire = true;
		}else {
			victoire = false;
		}
		return victoire;
	}

	@Override
	public int GetNbErreurs() throws RemoteException{
		return nbErreurs;
	}

	@Override
	public String GetListeLettre() throws RemoteException {
		return String.valueOf(ListeLettre);
	}

}
