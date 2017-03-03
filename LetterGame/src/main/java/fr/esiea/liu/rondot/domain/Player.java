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
		if(this.score >=  10){
			return true;
		}
		else{
			return false;
		}
	}

	public void lookForAWord(CommonJar cj , Dictionnary d){
		Iterator<String> itr = d.getDictionnary().iterator();
		boolean iaHasPlayed = false;
		int i = 0 ;
		while(itr.hasNext()){
			Word word = new Word(itr.next());
			if(cj.letterContains(word)){
				this.addWord(word);
				cj.removeLetterFromWord(word);
				cj.drawLetter(1);
				iaHasPlayed = true;
				i++;
			}
		}
		if(iaHasPlayed){
			if(i == 1){
				System.out.println(this.name +" has found " + i + " word ! He wins " + i + " point");
				System.out.println();
			}else{
				System.out.println(this.name +" has found " + i + " words ! He wins " + i + " points");
				System.out.println();
			}
		}
		else{
			System.out.println(this.name + " didn't find a word");
			System.out.println();
		}
	}
}
