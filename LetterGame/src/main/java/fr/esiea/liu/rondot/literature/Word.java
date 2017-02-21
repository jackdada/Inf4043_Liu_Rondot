package fr.esiea.liu.rondot.literature;

import java.util.ArrayList;

public class Word {
	
	public ArrayList<Letter> word = new ArrayList<Letter>();
	
	public Word(String word){
		if(word != null && !word.equals("")){
			for(int i = 0 ; i < word.length() ; i++){
				this.word.add(new Letter(word.charAt(i)));
			}
		}
	}
	
	public String string(){
		String word = "" ;
		for(int i = 0 ; i < this.word.size() ; i++){
			word += this.word.get(i).getLetter();
		}
		return word;
	}
	
	public boolean isWord(Dictionnary d){
		if(d.contains(string())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void testWord(){
		Dictionnary d = new Dictionnary();
		System.out.println(d.contains("a"));
	}
}
