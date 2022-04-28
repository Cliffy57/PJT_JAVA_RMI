package Modèles;
import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javafx.application.Platform;

	

	public class TicTacToe2jImpl extends UnicastRemoteObject implements TicTacToeInterface2j {
	    @Serial
	    private static final long serialVersionUID = 1L;
	    private static final int nb_Clients = 2;
	    String[] tbl = new String[9];
	    private final ArrayList<Double> nombres = new ArrayList<>(nb_Clients);
	    private double dernierRes = 0;
	    private int counter;
	    boolean EtatPartie = false;


	    public TicTacToe2jImpl() throws RemoteException {
	        super();
	    }

	    public String StartGame() throws RemoteException {
	        int casesPrises = 0;
	        EtatPartie=false;
	        this.InitGrille();
	        return "Bienvenue dans le jeu du Morpion!";

	    }

	    public synchronized String printtableau() throws InterruptedException {

	        System.out.println("|---|---|---|");
	        System.out.println("| " + tbl[0] + " | "
	                + tbl[1] + " | " + tbl[2]
	                + " |");
	        System.out.println("|-----------|");
	        System.out.println("| " + tbl[3] + " | "
	                + tbl[4] + " | " + tbl[5]
	                + " |");
	        System.out.println("|-----------|");
	        System.out.println("| " + tbl[6] + " | "
	                + tbl[7] + " | " + tbl[8]
	                + " |");
	        System.out.println("|---|---|---|");

	        return "|---|---|---|\n" + "| " + tbl[0] + " | "
	                + tbl[1] + " | " + tbl[2]
	                + " | \n" + "|-----------|\n" + "| " + tbl[3] + " | "
	                + tbl[4] + " | " + tbl[5]
	                + " |\n" + "|-----------|\n" + "| " + tbl[6] + " | "
	                + tbl[7] + " | " + tbl[8]
	                + " |\n" + "|---|---|---|\n";

	    }

	    public void InitGrille() {
	        for (int a = 0; a < 9; a++) {
	            tbl[a] = String.valueOf(a + 1);
	        }
	    }
	        public int printChoix(int choix) throws RemoteException {
	            if (!estPrise(choix)) {
	                return 0;// a modif
	            }else
	                System.out.println(choix);
	                counter++;
	            if ( counter % 2 == 0 ){
	                tbl[choix] = "X";}
	            else{
	                tbl[choix] = "O";}
	            if (estGagneJoueur1()) {
	                System.out.println("Joueur 1 Gagne");
	                EtatPartie=true;
	            }
	            if (estGagneJoueur2()) {
	                System.out.println("Joueur 2 Gagne");
	                EtatPartie=true;
	            }
	                return choix;
	        }
	        //Envoyer deux clients choix effectués
	        private int addChoix(double choice) throws RemoteException {
	                int choix = 0;
	                synchronized (nombres) {
	                        nombres.add(choice);
	                        nombres.add(choice);
	                        if (nombres.size() == nb_Clients) {

	                                printChoix((int) choice);
	                                nombres.clear();
	                                nombres.notifyAll();
	                                return nombres.size();
	                        }
	                }
	                return (int) choice;
	        }
	        //Envoyer et attendre que le client un joue avant l'autre
	        public double add(double choice) throws RemoteException {
	                int res = addChoix(choice);
	                if (res == 0) {
	                        synchronized (nombres) {
							        System.out.println(nombres.size());
							        Platform.runLater(new Runnable() {
							            @Override
							            public void run() {
							                try {
												nombres.wait();
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
							            }
							        });
							        System.out.println(nombres.size());
							}
	                }
	                return dernierRes;
	        }

	    public boolean estGagneJoueur1() {
	        return (tbl[0] == "X" && tbl[1] == "X" && tbl[2] == "X") ||
	                (tbl[3] == "X" && tbl[4] == "X" && tbl[5] == "X") ||
	                (tbl[6] == "X" && tbl[7] == "X" && tbl[8] == "X") ||
	                (tbl[0] == "X" && tbl[4] == "X" && tbl[8] == "X") ||
	                (tbl[2] == "X" && tbl[4] == "X" && tbl[6] == "X") ||
	                (tbl[0] == "X" && tbl[3] == "X" && tbl[6] == "X") ||
	                (tbl[1] == "X" && tbl[4] == "X" && tbl[7] == "X") ||
	                (tbl[2] == "X" && tbl[5] == "X" && tbl[8] == "X");
	    }

	    public boolean estGagneJoueur2() {
	        return (tbl[0] == "O" && tbl[1] == "O" && tbl[2] == "O") ||
	                (tbl[3] == "O" && tbl[4] == "O" && tbl[5] == "O") ||
	                (tbl[6] == "O" && tbl[7] == "O" && tbl[8] == "O") ||
	                (tbl[0] == "O" && tbl[4] == "O" && tbl[8] == "O") ||
	                (tbl[2] == "O" && tbl[4] == "O" && tbl[6] == "O") ||
	                (tbl[0] == "O" && tbl[3] == "O" && tbl[6] == "O") ||
	                (tbl[1] == "O" && tbl[4] == "O" && tbl[7] == "O") ||
	                (tbl[2] == "O" && tbl[5] == "O" && tbl[8] == "O");
	    }

	    public boolean estPrise(int choix) {
	        boolean disponible;
	       /* System.out.println(choix);*/
	        if ( tbl[choix] != "X" && tbl[choix] != "O"){
	            disponible=true;
	            System.out.println("DISPO");
	        }else  disponible=false;

	        return disponible;
	    }
	    
	   
	    
	    @Override
		public String[] gettableau() throws RemoteException {
			// TODO Auto-generated method stub
			return tbl;
		}

		@Override
		public Boolean StatutPartie() throws RemoteException {
			// TODO Auto-generated method stub
			return EtatPartie;
		}
		
		
	

	    /*public double add(double nb) throws RemoteException {
	        Double res = addNombres(nb);
	        if (res == null) {
	            try {
	                synchronized (nombres) {
	                    System.out.println(nombres.size());
	                    nombres.wait();
	                    System.out.println(nombres.size());
	                }
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	                return 0;
	            }
	        }
	        return dernierRes;
	    }*/

	   /* private Double addNombres(double nb) {
	        Double res = null;
	// semaphore sur la liste de nombre
	        synchronized (nombres) {
	            nombres.add(nb);
	            if (nombres.size() == nb_Clients) {
	// res = nombres.stream().mapToDouble(n -> n).sum();
	                double r = 0;
	                for (Double nombre : nombres) r = r + nombre;
	                res = r;
	                dernierRes = res;
	                nombres.clear();
	                nombres.notifyAll();
	            }
	        }
	        return res;
	    }*/
	}

