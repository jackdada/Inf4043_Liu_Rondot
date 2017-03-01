package fr.esiea.liu.rondot.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import fr.esiea.liu.rondot.domain.Player;
import fr.esiea.liu.rondot.literature.Dictionnary;

public class Engine {

	private static CommonJar commonJar;
	private static Dictionnary dictionnary;
	private static ArrayList<Player> players;
	private static int globalCounter = 0;
	private static HashMap<Player,Integer> mapOfPlayersTurn;
	
	public static void run(String[] args) {
		commonJar = new CommonJar();
		dictionnary = new Dictionnary();
		players = new ArrayList<Player>();
		mapOfPlayersTurn = new HashMap<Player,Integer>();
		
		System.out.println("How many players?");
		Scanner in = new Scanner(System.in);
		int nbOfPlayer = in.nextInt();
		initPlayers(nbOfPlayer);
	
		for(int i = 0 ; i<players.size() ; i ++){
			System.out.println(players.get(i).getName());
		}
	}
	
	public static void firstRound(){
		for(int i = 0 ; i < players.size() ; i ++){
			commonJar.drawLetter(1);
			players.get(i).setFirstLetter(commonJar.getLetter(i));
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
			mapOfPlayersTurn.put(player, 0);
		} 
	}
	
	public static void initiatePlayersOrder(){
		int index=0;
		for(int i = 0 ; i < players.size()-1 ; i++){
			if(players.get(i).getFirstLetter() < players.get(i+1).getFirstLetter()){
				mapOfPlayersTurn.put(players.get(i), index);
				index++;
			}
			else{
				mapOfPlayersTurn.put(players.get(i+1), index);
				index++;
			}
		}
		for(int i = 0 ; i < players.size() ; i++){
			for(int j = 0 ; j < players.size()-1 ; j++){
				if(mapOfPlayersTurn.get(players.get(j)) < mapOfPlayersTurn.get(players.get(j+1))){
					Collections.swap(players, j, j+1);
				}
			}
		}
	}
}
