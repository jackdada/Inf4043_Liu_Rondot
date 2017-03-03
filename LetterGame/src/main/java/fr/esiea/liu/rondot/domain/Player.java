package fr.esiea.liu.rondot.domain;

import java.util.ArrayList;
import java.util.Iterator;

import fr.esiea.liu.rondot.board.CommonJar;
import fr.esiea.liu.rondot.literature.Dictionnary;
import fr.esiea.liu.rondot.literature.Word;

public class Player{
	private String name;
	private int score = 0;
	private ArrayList<Word> words = new ArrayList<>();
	private Character firstLetter;
	private boolean isAnIA;
	
	public Player(String name, boolean isAnIA){
		this.name = name; 
		this.score = words.size();
		this.isAnIA = isAnIA;
	}
	
	public boolean isAnIA(){
		return isAnIA;
	}
	
	public String getName(){ 
		return this.name; 
	}
	
	public int getScore(){ 
		return this.score; 
	}
	
	public ArrayList<Word> getWords() { 
		return this.words;
	}
	
	public void addWord(Word word){
		words.add(word);
		score++;
	}
	public void removeWord(Word word){
		words.remove(word);
		score--;
	}
	
	public void countWords(){ 
		this.score = this.words.size() ;
	}
	
	public void setFirstLetter(Character letter){
		this.firstLetter = letter;
	}
	public Character getFirstLetter(){
		return this.firstLetter;
	}


	public void toStringWords(){
		for(int i=0; i<words.size(); i++){
			System.out.print(words.get(i) + "  ");
		}
		System.out.println();
	}

	public boolean isWinner(){
		if(this.score == 10){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean lookForAWord(CommonJar cj , Dictionnary d){
		Iterator<String> itr = d.getDictionnary().iterator();
		Word choosenWord = new Word("");
		boolean iaHasPlayed = false;
		while(itr.hasNext()){
			Word word = new Word(itr.next());
			if(cj.letterContains(word)){
				this.addWord(word);
				cj.removeLetterFromWord(word);
				cj.drawLetter(1);
				if(choosenWord.getWord().size() < word.getWord().size()){
					choosenWord = word;
				}
				iaHasPlayed = true;
			}
		}
		return iaHasPlayed;
	}
}
