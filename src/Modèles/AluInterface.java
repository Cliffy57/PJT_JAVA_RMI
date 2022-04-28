package Modèles;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AluInterface extends Remote{
	public String ConsoleLog() throws RemoteException;	//Renvoie la valeur du nb d'alummettes dans la console
	public int ChoixJoueur(int valeur_joue) throws RemoteException; //CHoix du joueur entre 1 et 2
	public int Nombre() throws RemoteException; //Init le nb de d'anu
	public int ChoixOrdi() throws RemoteException; // Choix de l'ordi entre un et deux (aléatoire)
	public int DeterminePremierJoueur() throws RemoteException; // Determine si le joueur et l'ordi qui joue en premier
	public boolean Findepartie() throws RemoteException;//Calcule si la partie est finie 
	public boolean resetbool() throws RemoteException;	//Met à false le boolean de statut de la partie
	public String affgagnant() throws RemoteException;	//Renvoie le gagnant en string
}
