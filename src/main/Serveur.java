package main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


import Modèles.AluImpl;
import Modèles.PenduImpl;
import Modèles.TicTacToe2jImpl;
import Modèles.TicTacToeImpl;

public class Serveur {

	public static void main(String[] argv)
	{
		try
		{
			//int port=8000;	//Pendu
			//int port1=8001; //Amu
			//int port2=8002; //Tic-tac-toe
			//int port3=8003;	//Tic-tac-toe-2j
		
			
		LocateRegistry.createRegistry(Integer.parseInt(argv[0]));//Pendu
		LocateRegistry.createRegistry(Integer.parseInt(argv[1]));//Amu
		LocateRegistry.createRegistry(Integer.parseInt(argv[2]));//Morpion Joueur vs Serveur
		LocateRegistry.createRegistry(Integer.parseInt(argv[3]));//Morpion 2joueurs
		
		
		
			Naming.rebind("rmi://localhost:"+Integer.parseInt(argv[0])+"/src", new PenduImpl());
			System.out.println("Statut du serveur Pendu lancé sur le port : "+Integer.parseInt(argv[0]));
			
			Naming.rebind("rmi://localhost:"+Integer.parseInt(argv[1])+"/src", new AluImpl());
			System.out.println("Statut du serveur AMU lancé sur le port : "+Integer.parseInt(argv[1]));
			
			Naming.rebind("rmi://localhost:"+Integer.parseInt(argv[2])+"/src", new TicTacToeImpl());
			System.out.println("Statut du serveur Pendu lancé sur le port : "+Integer.parseInt(argv[2]));
			
			Naming.rebind("rmi://localhost:"+Integer.parseInt(argv[3])+"/src", new TicTacToe2jImpl());
			System.out.println("Statut du serveur Pendu lancé sur le port : "+Integer.parseInt(argv[3]));
			
		}
		

		catch(Exception e)
		{
			
			System.out.println("Erreur serveur : "+e);
		}
	}
}
