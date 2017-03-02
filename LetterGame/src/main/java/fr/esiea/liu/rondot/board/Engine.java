package fr.esiea.liu.rondot.board;

import java.util.*;

import fr.esiea.liu.rondot.domain.Player;
import fr.esiea.liu.rondot.literature.Dictionnary;
import fr.esiea.liu.rondot.literature.Word;
import org.jetbrains.annotations.Nullable;

public class Engine {

	private static CommonJar commonJar;
	private static Dictionnary dictionnary;
	private static ArrayList<Player> players;
	private static int globalCounter = 0;
	
	public static void run(String[] args){
		System.out.println("How many players?");	
		int numberOfPlayers = enterAnInteger();
		initPlayers(numberOfPlayers);
		initOrder();
		do{
			int i=0;
			printPlayersWords();
			commonJar.printCommonJar();
			aPlayersTurn(players.get(i));
			if(i < players.size()-1) {
				i++;
			}else {
				i = 0;
			}
		}while(!aPlayerWon());
		Player winer = returnWinner();
		endOfGame(winer);

	}


	public Engine() {
		commonJar = new CommonJar();
		dictionnary = new Dictionnary();
		players = new ArrayList<>();
	}

	public static void initPlayers(int number){
		for(int i = 0 ; i < number ; i ++){
			globalCounter++ ;
			String name;
			do {
				System.out.println("Choose name for player n° " + globalCounter);
				name = enterAString();
				name = name.substring(0, 10);
			}while(existedName(name) == true);
			Player player = new Player(name);
			addPlayers(player);
		}

		for(int i = 0 ; i<players.size() ; i ++){
			System.out.print(players.get(i).getName() + "\t");
		}
	}

	public static boolean existedName(String name){
		for(int i=0; i<players.size(); i++){
			if(players.get(i).getName().equals(name)){
				System.out.println("Player name " + name + " is already used. Choose another one");
				return true;
			}
		}
		return false;
	}
	public static void addPlayers(Player player){
		players.add(player);
	}

	public static String enterAString(){
		Scanner in = new Scanner(System.in);
		String string = in.next();
		return string;
	}

	public static void initOrder(){
		for(int i = 0 ; i < players.size() ; i ++){
			commonJar.drawLetter(1);
			players.get(i).setFirstLetter(commonJar.getLetter(i));
		}
		sortPlayers();
	}

	public static void sortPlayers(){
		boolean sorted = false;
		int size = players.size();
		while (!sorted){
			sorted = true;
			for(int i = 0; i < size-1; i++){
				if(players.get(i).getFirstLetter() > players.get(i+1).getFirstLetter()){
					Collections.swap(players, i, i+1);
					sorted = false;
				}
			}
			size--;
		}
	}

	public static int enterAnInteger(){
		Scanner in = new Scanner(System.in);
		int integer = in.nextInt();
		return integer;
	}
	
	public static Player returnWinner(){
		for(int i = 0 ; i < players.size() ; i ++){
			if(players.get(i).isWinner()){
				return players.get(i);
			}
		}
		return null;
	}
	
	public static boolean aPlayerWon(){
		for(int i = 0 ; i < players.size() ; i ++){
			if(players.get(i).isWinner()){
				return true;
			}
		}
		return false;
	}

	public static void endOfGame(Player player){
		System.out.println("The winner is: " + player.getName());
		System.out.println("His word: " + player.showWords());
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
	
	public static void aPlayersTurn(Player player){
		boolean end = false;
		System.out.println(player.getName() + "'s turn");
		commonJar.drawLetter(2);
		do {
			System.out.println("What do you want to do ?");
			System.out.println("q: end your turn | n: enter a new word | s: steal a word from other players");
			String option = enterAString();
			switch (option) {
				case "n":
					newWord(player);
					break;
				case "s":
					stealWord(player);
					break;
				case "q":
					end = true;
					break;
				default:
					System.out.println("Please select an appropriate option");
			}
		}while (end == false || player.getScore()==10);
	}
	
	public static void newWord(Player player){
		System.out.println("Enter a new Word from common jar");
		String in = enterAString();
		Word word = new Word(in);
		if(commonJar.containsLetter(word) && word.isWord(dictionnary)){
			System.out.println(word  + " is a word ! You win 1 point");
			player.addWord(word);
			commonJar.removeLetterFromWord(word);
			commonJar.drawLetter(1);
		}
		else{
			System.out.println(word + " is not in dictionary or there is not enough letter in common jar");
		}
	}
	
	public static void stealWord(Player player){
		Player stolenPlayer = null;
		do {
			System.out.println("From whom you want to steal a word ?");
			String name = enterAString();
			name = name.substring(0, 10);
				stolenPlayer = existedPlayer(name);
		}while (stolenPlayer != null);

		System.out.println("You want to steal a word from "+ stolenPlayer.getName() +"!\nWhich word you want to steal ?");
		int stolenWordIndex = selectStolenWordIndex(stolenPlayer);
		System.out.println("You want to steal the word '" + stolenPlayer.getWords().get(stolenWordIndex)+ "'\nEnter the new word from stolen word ?");
		String word = enterAString();
		Word newWord = new Word(word);
	}

	public static int selectStolenWordIndex(Player player){
		do {
			player.showWords();
			int stolenWordIndex = enterAnInteger();
			if(stolenWordIndex > 0 && stolenWordIndex < player.getWords().size()){
				return stolenWordIndex;
			}
			System.out.println("Invalid number!\nWhich word you want to steal ?");
		}while(true);

	}

	@Nullable
	public static Player existedPlayer(String name){
		for(int i; i<players.size(); i++){
			if(players.get(i).getName().equals(name)){
				return players.get(i);
			}
		}
		return null;
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
