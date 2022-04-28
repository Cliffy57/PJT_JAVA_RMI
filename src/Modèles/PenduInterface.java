package Modèles;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PenduInterface extends Remote{
	public String LancementJeu() throws RemoteException;	//Lance le jeu
	
	public String GetListeLettre() throws RemoteException;	//Récupère le tableau des lettres joués
	public String GetMotNormal() throws RemoteException;	//Récupère le mot joué
	public String GetMotCache() throws RemoteException;		//Récupère le mot joué caché
	public int GetNbErreurs() throws RemoteException;		//Retourne le nombre d'erreurs du joueur
	
	public void setMotNormal() throws RemoteException;		//CHerche un mot à joueur 
	public void setMotCache(int taille) throws RemoteException;	//transforme le mot joué en ____
	
	public void UpdateMotCache(char c, int i) throws RemoteException;	//Met à jour le mot caché en fonction d'une lettre joué
	public String CheckLettre(char c) throws RemoteException;	//Regarde si la lettre joué n'est pas déjà utilisé et est présente dans le mot
		
	public Boolean ConditionVictoire() throws RemoteException;	//Détermine la condition de victoire
}