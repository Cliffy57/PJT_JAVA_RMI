package Mod�les;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PenduInterface extends Remote{
	public String LancementJeu() throws RemoteException;	//Lance le jeu
	
	public String GetListeLettre() throws RemoteException;	//R�cup�re le tableau des lettres jou�s
	public String GetMotNormal() throws RemoteException;	//R�cup�re le mot jou�
	public String GetMotCache() throws RemoteException;		//R�cup�re le mot jou� cach�
	public int GetNbErreurs() throws RemoteException;		//Retourne le nombre d'erreurs du joueur
	
	public void setMotNormal() throws RemoteException;		//CHerche un mot � joueur 
	public void setMotCache(int taille) throws RemoteException;	//transforme le mot jou� en ____
	
	public void UpdateMotCache(char c, int i) throws RemoteException;	//Met � jour le mot cach� en fonction d'une lettre jou�
	public String CheckLettre(char c) throws RemoteException;	//Regarde si la lettre jou� n'est pas d�j� utilis� et est pr�sente dans le mot
		
	public Boolean ConditionVictoire() throws RemoteException;	//D�termine la condition de victoire
}