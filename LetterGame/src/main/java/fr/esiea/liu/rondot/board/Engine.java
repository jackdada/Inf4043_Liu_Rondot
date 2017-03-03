package fr.esiea.liu.rondot.board;

import java.util.*;

import fr.esiea.liu.rondot.domain.Player;
import fr.esiea.liu.rondot.literature.Dictionnary;
import fr.esiea.liu.rondot.literature.Word;

public class Engine {

	private static CommonJar commonJar;
	private static Dictionnary dictionnary;
	private static ArrayList<Player> players;
	private static int globalCounter = 0;

	public Engine() {
		commonJar = new CommonJar();
		dictionnary = new Dictionnary();
		players = new ArrayList<>();
	}

	public static void run(){
		System.out.println("How many players?");	
		int numberOfPlayers = setNumberOfPlayers();
		System.out.println(numberOfPlayers + " players created");
		initPlayers(numberOfPlayers);
		initOrder();
		int playerIndex=0;
		do{
			aPlayersTurn(players.get(playerIndex));
			playerIndex++;
			if(playerIndex == players.size()) {
				playerIndex=0;
			}

		}while(!aPlayerWon());
		Player winer = returnWinner();
		endOfGame(winer);
	}
	public static void main(String[] args){
		commonJar = new CommonJar();
		dictionnary = new Dictionnary();
		players = new ArrayList<>();
		run();
	}
	public  ArrayList<Player> getPlayers(){
		return this.players;
	}

	public static int setNumberOfPlayers(){
		int number = enterAnInteger();
		if(number == -1)
			return 2;
		return number;
	}
	public static void initPlayers(int number){
		for(int i = 0 ; i < number ; i ++){
			globalCounter++ ;
			String name;
			do {
				System.out.println("Choose name for player n° " + globalCounter);
				name = enterAString();
				if(name.length() > 10){
					name = name.substring(0, 10);
				}
			}while(existedName(name) == true);
			Player player = new Player(name);
			addPlayers(player);
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
		if(in.hasNextInt()) {
			int integer = in.nextInt();
				return integer;
		}
		return -1;
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
		System.out.println("His word: " );
		player.toStringWords();
	}
	
	public static void printPlayersWords(){
		Iterator<Player> playerIterator = players.iterator();
		while (playerIterator.hasNext()) {
			Player player = playerIterator.next();
			System.out.print(player.getName() + "'s words (" + player.getScore() + "): ");
			Iterator<Word> wordIterator = player.getWords().iterator();
			while (wordIterator.hasNext()){
				Word word = wordIterator.next();
				System.out.print(word.toString() + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void aPlayersTurn(Player player){
		boolean end = false;
		commonJar.drawLetter(2);
		do {
			printForAPlayerTurn(player.getName());
			String option = enterAString();
			switch (option) {
				case "n":
					newWord(player);

					break;
				case "s":
					stealWordInit(player);
					break;
				case "q":
					end = true;
					break;
				default:
					System.out.println("Please select an appropriate option");
					System.out.println();
			}
		}while (end == false || player.getScore() == 10);
	}

	public static void printForAPlayerTurn(String name){
		printPlayersWords();
		commonJar.printCommonJar();
		System.out.println();
		System.out.println(name + "'s turn");
		System.out.println("What do you want to do ?");
		System.out.println("q: end your turn | n: enter a new word | s: steal a word from other players");
	}


	public static void newWord(Player player){
		System.out.println("Enter a new Word from common jar");
		String in = enterAString();
		Word word = new Word(in);

		if(commonJar.letterContains(word) && word.isWord(dictionnary)){
			System.out.println(word  + " is a word ! You win 1 point");
			player.addWord(word);
			commonJar.removeLetterFromWord(word);
			commonJar.drawLetter(1);
		}
		else{
			System.out.println(word + " is not in dictionary or there is not enough letter in common jar");
		}
	}
	
	public static void stealWordInit(Player player){
		Player stolenPlayer = null;
		do {
			System.out.println("From whom you want to steal a word ?");
			printPlayersWords();
			String name = enterAString();
			stolenPlayer = existedPlayer(name);

		}while(stolenPlayer == null);

		if(stolenPlayer.getScore() > 0){
			stealWordProcess(player, stolenPlayer);
		}else{
			System.out.println(stolenPlayer.getName()+ " haven't any words");
		}
	}

	public static void stealWordProcess(Player player, Player stolenPlayer){
		System.out.println("You want to steal a word from "+ stolenPlayer.getName() +"!\nWhich word do you want to steal ?");
		Word stolenWord = selectStolenWord(stolenPlayer);
		System.out.println("You want to steal the word '" + stolenWord.toString()+ "'\nEnter the new word from stolen word and common jar?");
		commonJar.toString();
		String wordStr = enterAString();
		Word newWord = new Word(wordStr);
		Word newWordCopy = new Word(newWord);
		Word differenceResult = wordDifference(newWordCopy, stolenWord);
		if(stealWordCheck(differenceResult, newWord.getWord().size(), stolenWord.getWord().size()) && newWord.isWord(dictionnary)){
			commonJar.removeLetterFromWord(differenceResult);
			stolenPlayer.removeWord(stolenWord);
			player.addWord(newWord);
			commonJar.drawLetter(1);
		}else{
			System.out.println(newWord + " is not in dictionary or you don'y use all letter from the word stolen or there is not enough letter in common jar");
		}
	}
	public static Word selectStolenWord(Player stolenPlayer){
		do {
			stolenPlayer.toStringWords();
			String stolenPlayerString = enterAString();
			Iterator<Word> wordIterator = stolenPlayer.getWords().iterator();
			while(wordIterator.hasNext()) {
				Word word = wordIterator.next();
				if(word.toString().equals(stolenPlayerString)){
					return word;
				}
			}
			System.out.println("Invalid word!\nWhich word you want to steal ?");
		}while(true);
	}

	public static boolean stealWordCheck(Word differenceResult, int sizeNewWord, int sizeStolenWord){
		int differenceResultSize = differenceResult.getWord().size();
		if(differenceResultSize == 0 || sizeNewWord - differenceResultSize != sizeStolenWord){
			return false;
		}
		return commonJar.letterContains(differenceResult);
	}

	public static Word wordDifference(Word firstWord, Word secondWord){
		Iterator<Character> wordIterator = secondWord.getWord().iterator();

		while(wordIterator.hasNext()) {
			firstWord.getWord().remove(wordIterator.next());
		}
		return firstWord;
	}


	
	public static Player existedPlayer(String name){
		Iterator<Player> playerIterator = players.iterator();
		while (playerIterator.hasNext()) {
			Player player = playerIterator.next();
			if(player.getName().equals(name)){
				return player;
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
