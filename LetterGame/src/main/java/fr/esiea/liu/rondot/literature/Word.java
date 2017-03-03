package fr.esiea.liu.rondot.literature;

import java.util.ArrayList;
import java.util.Iterator;

public class Word {
	
	private ArrayList<Character> word;
	
	public Word(String word){
		this.word = new ArrayList<>();
		if(word != null && !word.equals("")){
			word = word.toLowerCase();
			for(int i = 0 ; i < word.length() ; i++){
				this.word.add(new Character(word.charAt(i)));
			}
		}
	}
	public Word(Word anotherWord){
		this.word = new ArrayList<>(anotherWord.getWord());
	}
	public ArrayList<Character> getWord(){
		return this.word;
	}

	public String toString(){
		Iterator<Character> itr = word.iterator();
		StringBuilder strBuild = new StringBuilder();

		while(itr.hasNext()) {
			strBuild.append(itr.next());
		}
		return strBuild.toString();
	}

	public boolean isWord(Dictionnary d){
		if(d.contains(toString())){
			return true;
		}
		else{
			return false;
		}
	}



}
