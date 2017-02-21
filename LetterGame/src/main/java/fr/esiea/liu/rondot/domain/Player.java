package fr.esiea.liu.rondot.domain;

import java.util.ArrayList;
import fr.esiea.liu.rondot.literature.Letter;
import fr.esiea.liu.rondot.literature.Word;

public class Player {
	private String name;
	private int score;
	private ArrayList<Word> words;
	private Letter firstLetter;
	
	public Player(String name){
		this.name = name; 
		this.score = words.size();
	}
	
	public String getName(){ return this.name; }
	public int getScore(){ return this.score; }
	public ArrayList<Word> getWords() { return this.words;}
	
	public void countWords(){ this.score = this.words.size() ;}
	public void setFirstLetter(Letter letter){this.firstLetter = letter;}
	
}
