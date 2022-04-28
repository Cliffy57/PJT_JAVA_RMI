package Mod�les;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TicTacToeInterface extends Remote {
    String LancementJeu() throws RemoteException;	//Lance le jeu

    public String printtableau() throws RemoteException;	//Renvoie le tableau dans la console

    int printChoix(int choix) throws RemoteException;	//Renvoie le choix du joueur

    int hasardChoix() throws RemoteException;	//Determine le choix de l'ordinateur de mani�re al�atoire

    int printChoixServeur(int choix) throws RemoteException;	//Renvoie le choix du serveur

    boolean estGagneJoueur() throws RemoteException;	//Determine si le joueur a gagn�

    boolean estGagneServeur() throws RemoteException;	//Determine si le server a gagn�
    
    String[] gettableau() throws RemoteException;	//Renvoie le tableau du jeu pour maj l'affichage graphique
    Boolean StatutPartie() throws RemoteException; //Renvoie l'�tat de la partie 
}

