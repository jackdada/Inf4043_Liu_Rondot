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
		System.out.println("How many players?");	
	}
	
	public Engine() {
		commonJar = new CommonJar();
		dictionnary = new Dictionnary();
		players = new ArrayList<Player>();
		mapOfPlayersTurn = new HashMap<Player,Integer>();
	}
	
	public static void firstRound(){
		System.out.println("The first draw letters :");
		for(int i = 0 ; i < players.size() ; i ++){
			commonJar.drawLetter(1);
			players.get(i).setFirstLetter(commonJar.getLetter(i));
		}
		for(int i = 0 ; i<players.size() ; i ++){
			System.out.print(players.get(i).getName() + "\t");
		}
		System.out.println();
		for(int i = 0 ; i<players.size() ; i ++){
			System.out.print(players.get(i).getFirstLetter()+ "\t");
		}
		System.out.println();
		System.out.println();
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
		System.out.println("New players order:");
		for(int i = 0 ; i<players.size() ; i ++){
			System.out.print(players.get(i).getName() + "\t");
		}
		System.out.println();
		for(int i = 0 ; i<players.size() ; i ++){
			System.out.print(players.get(i).getFirstLetter()+ "\t");
		}
		System.out.println();
		System.out.println();
	}
	
	public static void initPlayers(int number){
		for(int i = 0 ; i < number ; i ++){
			globalCounter++ ;
			System.out.println("Choose name for player n° "+globalCounter);
			String name = enterAString();
			Player player = new Player(name);
			addPlayers(player);
		} 
		for(int i = 0 ; i<players.size() ; i ++){
			System.out.print(players.get(i).getName() + "\t");
		}		
		System.out.println();
		System.out.println();
	}
	
	public static void addPlayers(Player player){
		players.add(player);
		mapOfPlayersTurn.put(player, 0);
	}
	
	public static String enterAString(){
		Scanner in = new Scanner(System.in);
		String string = in.next();
		in.close();
		return string;
	}
	
	public static int enterAnInteger(){
		Scanner in = new Scanner(System.in);
		int integer = in.nextInt();
		in.close();
		return integer;
	}
}
