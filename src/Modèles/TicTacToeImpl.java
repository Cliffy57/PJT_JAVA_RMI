package Modèles;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.InputMismatchException;
import java.util.Random;

public class TicTacToeImpl extends UnicastRemoteObject implements TicTacToeInterface {

    int casesPrises=0;
    String[] board = new String[9];
    boolean EtatPartie = false; //False la partie est en cours, true la partie est fini

    public TicTacToeImpl() throws RemoteException {
    }

    public String LancementJeu() throws RemoteException {
    casesPrises=0;
    EtatPartie=false;
        this.InitGrille();
        return "Bienvenue dans le jeu du Morpion!";

    }

    public void InitGrille() {
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
    }



    public String printtableau() {


        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");
        return "|---|---|---|\n" + "| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " | \n" + "|-----------|\n" + "| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |\n" + "|-----------|\n" + "| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |\n" + "|---|---|---|\n";
    }

    public int printChoix(int choix) {
        casesPrises++;
        if (!estPrise(choix)){
            return 1;
        }
        System.out.println(choix);
        board[choix] = "X";
        if(estGagneJoueur()){
            System.out.println("Gagne");
            EtatPartie=true;
        }
        if (casesPrises<9) {
            printChoixServeur(hasardChoix());
           
        }
        if (estGagneServeur()){
            System.out.println("Perdu");
            EtatPartie=true;
        }
        return choix;
    }
    public int printChoixServeur(int choix) {
        casesPrises++;
        System.out.println(choix);
        board[choix] = "O";
        return choix;
    }

    public int hasardChoix() {
        Random rand = new Random();
        int choix;
        do {
            choix = rand.nextInt((7 - 0) + 1);
        } while (!estPrise(choix));


        return choix;
    }

    public boolean estPrise(int choix) {
        boolean disponible;
        System.out.println(choix);
        if (board[choix] == "X" || board[choix] == "O") {
            disponible = false;

        } else {
            disponible = true;
        }
        return disponible;
    }

    public boolean estGagneJoueur() {
        if((board[0]=="X"&&board[1]=="X"&&board[2]=="X")||
                (board[3]=="X"&&board[4]=="X"&&board[5]=="X")||
                (board[6]=="X"&&board[7]=="X"&&board[8]=="X")||
                (board[0]=="X"&&board[4]=="X"&&board[8]=="X")||
                (board[2]=="X"&&board[4]=="X"&&board[6]=="X")||
                (board[0]=="X"&&board[3]=="X"&&board[6]=="X")||
                (board[1]=="X"&&board[4]=="X"&&board[7]=="X")||
                (board[2]=="X"&&board[5]=="X"&&board[8]=="X")){return true;}
        else{return false;}
    }
    public boolean estGagneServeur() {
        if((board[0]=="O"&&board[1]=="O"&&board[2]=="O")||
                (board[3]=="O"&&board[4]=="O"&&board[5]=="O")||
                (board[6]=="O"&&board[7]=="O"&&board[8]=="O")||
                (board[0]=="O"&&board[4]=="O"&&board[8]=="O")||
                (board[2]=="O"&&board[4]=="O"&&board[6]=="O")||
                (board[0]=="O"&&board[3]=="O"&&board[6]=="O")||
                (board[1]=="O"&&board[4]=="O"&&board[7]=="O")||
                (board[2]=="O"&&board[5]=="O"&&board[8]=="O")){return true;}
        else{return false;}
    }

	@Override
	public String[] gettableau() throws RemoteException {
		// TODO Auto-generated method stub
		return board;
	}

	@Override
	public Boolean StatutPartie() throws RemoteException {
		// TODO Auto-generated method stub
		return EtatPartie;
	}

}
