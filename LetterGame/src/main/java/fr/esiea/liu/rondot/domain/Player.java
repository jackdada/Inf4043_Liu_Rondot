package fr.esiea.liu.rondot.domain;

import java.util.ArrayList;

import fr.esiea.liu.rondot.literature.Word;

public class Player {
	private String name;
	private int score = 0;
	private ArrayList<Word> words = new ArrayList<>();
	private Character firstLetter;
	
	public Player(String name){
		this.name = name; 
		this.score = words.size();
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
}
