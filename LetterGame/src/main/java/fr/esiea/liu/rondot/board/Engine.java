package fr.esiea.liu.rondot.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import fr.esiea.liu.rondot.domain.Player;
import fr.esiea.liu.rondot.literature.Dictionnary;
import fr.esiea.liu.rondot.literature.Word;

public class Engine {

	private static CommonJar commonJar;
	private static Dictionnary dictionnary;
	private static ArrayList<Player> players;
	private static int globalCounter = 0;
	
	public static void run(String[] args) {
		System.out.println("How many players?");	
		int numberOfPlayers = enterAnInteger();
		initPlayers(numberOfPlayers);
		firstRound();
		while(!aPlayerWon()){
			for(int i = 0 ; i < players.size() ; i++){
				printPlayersWords();
				commonJar.printCommonJar();
				aPlayersTurn(players.get(i));
			}
		}
	}
	
	public Engine() {
		commonJar = new CommonJar();
		dictionnary = new Dictionnary();
		players = new ArrayList<Player>();
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
		for(int i = 0 ; i < players.size() ; i++){
			for(int j = 0 ; j < players.size()-1 ; j++){
				if(players.get(j).getFirstLetter() > players.get(j+1).getFirstLetter()){
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
	}
	
	public static String enterAString(){
		Scanner in = new Scanner(System.in);
		String string = in.next();
		return string;
	}
	
	public static int enterAnInteger(){
		Scanner in = new Scanner(System.in);
		int integer = in.nextInt();
		return integer;
	}
	
	public static Player returnWinner(){
		Player player = new Player("");
		for(int i = 0 ; i < players.size() ; i ++){
			if(players.get(i).isWinner()){
				player = players.get(i);
			}
		}
		return player;
	}
	
	public static boolean aPlayerWon(){
		boolean aPlayerWon = false;
		for(int i = 0 ; i < players.size() ; i ++){
			if(players.get(i).isWinner()){
				aPlayerWon = true;
			}
			else{
				aPlayerWon =  false; 
			}
		}
		return aPlayerWon;
	}
	
	public static void printPlayersWords(){
		for(int i = 0 ; i < players.size() ; i ++){
			System.out.print(players.get(i).getName() + "'s words: ");
			for(int j = 0 ; j < players.get(i).getWords().size() ; i ++){
				System.out.print(players.get(i).getWords().get(j) + "  ");
			}
		}
		System.out.println();
	}
	
	public static String aPlayersTurn(Player player){
		String a = "";
		System.out.println(player.getName() + "'s turn");
		System.out.println("What do you want to do ?");
		System.out.println("q: pass your turn | n: enter a new word | s: steal a word from other players");
		String option = enterAString();
		if(option.equals("n")){
			newWord(player);
		}
		if(option.equals("s")){
			stealWord(player);
		}
		if(option.equals("q")){
			a = "q";
		}
		else{
			System.out.println("Please select an appropriate option");
			aPlayersTurn(player);
		}
		return a;
	}
	
	public static void newWord(Player player){
		System.out.println("Enter a new Word from common Jar");
		String in = enterAString();
		Word word = new Word(in);
		if(commonJar.letterContains(word)){
			System.out.println(word  + " is a word ! You win 1 point");
			player.addWord(word);
			commonJar.removeLetterFromWord(word);
		}
		else{
			System.out.println(word + " is not an appropiate word");
			aPlayersTurn(player);
		}
	}
	
	public static void stealWord(Player player){
		System.out.println("From whom you want to steal a word ?");
		String name = enterAString();
		if(players.contains(name)){
			Player p = players.get(getIndexOfPlayer(name));
			System.out.println("You want to steal a word from "+ name +"!\nWhich word you want to steal ?");
			for(int i = 0 ; i < p.getWords().size() ; i++){
				System.out.print(i + ": " +p.getWords().get(i) + "  ");
			}
			int stolenWordIndex = enterAnInteger();
			if(stolenWordIndex > 0 && stolenWordIndex < p.getWords().size()){
				System.out.println("You want to steal the word '" + p.getWords().get(stolenWordIndex)+ "'\nEnter the new word from stolen word ?");
				String word = enterAString();
				Word newWord = new Word(word);
				if(commonJar.letterContains(newWord) && word.contains(p.getWords().get(stolenWordIndex).toString())){
					System.out.println(newWord  + " is a word ! You win 1 point");
					player.addWord(newWord);
					p.getWords().remove(stolenWordIndex);
				}
				else{
					System.out.println(newWord + " is not an appropiate word");
					aPlayersTurn(player);
				}
			}
		}
		else{
			System.out.println(name + " is not playing this game !");
			aPlayersTurn(player);
		}
	}
	
	public static int getIndexOfPlayer(String name){
		int index = 0;
		for(int i = 0 ; i < players.size() ; i ++){
			if(players.get(i).getName().equals(name)){
				index = i;
			}
		}
		return index;
	}
}
