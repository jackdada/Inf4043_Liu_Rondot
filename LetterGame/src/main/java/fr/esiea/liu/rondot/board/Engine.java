package fr.esiea.liu.rondot.board;

import java.util.ArrayList;
import java.util.Scanner;

import fr.esiea.liu.rondot.domain.Player;
import fr.esiea.liu.rondot.literature.Dictionnary;

public class Engine {

	private static CommonJar commonJar;
	private static Dictionnary dictionnary;
	private static ArrayList<Player> players;
	private static int globalCounter = 0;
	
	public static void main(String[] args) {
		commonJar = new CommonJar();
		dictionnary = new Dictionnary();
		players = new ArrayList<Player>();
		
		System.out.println("How many players?");
		Scanner in = new Scanner(System.in);
		int nbOfPlayer = in.nextInt();
		initPlayers(nbOfPlayer);
	
		for(int i = 0 ; i<players.size() ; i ++){
			System.out.println(players.get(i).getName());
		}
	}
	
	public static void initPlayers(int number){

		for(int i = 0 ; i < number ; i ++){
			globalCounter++ ;
			System.out.println("Choose name for player n° "+globalCounter);
			Scanner in = new Scanner(System.in);
			String name = in.next();
			Player player = new Player(name);
			players.add(player);
		}
	}
}
