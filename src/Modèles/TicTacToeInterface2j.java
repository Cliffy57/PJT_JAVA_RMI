package Modèles;
import java.rmi.*;
// Interface de la somme concurrente
import java.rmi.RemoteException;
public interface TicTacToeInterface2j extends Remote{
    double add (double n) throws RemoteException;	//Quand les joueurs entre un caractère
    String StartGame() throws RemoteException;		//Lance la partie
    public String printtableau() throws RemoteException, InterruptedException;//Renvoie le tableau dans la console
    int printChoix(int choix) throws RemoteException;	//Renvoie le choix de chaque joueur
    boolean estGagneJoueur1() throws RemoteException;	//Determine si le joueur1 a gagné
    boolean estGagneJoueur2() throws RemoteException;	//Determine si le joueur2 a gagné
    String[] gettableau() throws RemoteException;	//Renvoie le tableau du jeu dans la console
    Boolean StatutPartie() throws RemoteException;	//Renvoie l'état de la partie

}
