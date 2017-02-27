package fr.esiea.liu.rondot.literature;

import java.util.ArrayList;
import java.util.Iterator;

public class Word {
	
	public ArrayList<Character> word = new ArrayList<>();
	
	public Word(String word){
		if(word != null && !word.equals("")){
			for(int i = 0 ; i < word.length() ; i++){
				this.word.add(new Character(word.charAt(i)));
			}
		}
	}
	
	public String toString(){
		Iterator<Character> itr = word.iterator();
		StringBuilder strBuild = new StringBuilder();

		while(itr.hasNext()) {
			strBuild.append(itr.next());
		}
		return strBuild.toString();
	}
	
	/*public boolean isWord(Dictionnary d){
		if(d.contains(string())){
			return true;
		}
		else{
			return false;
		}
	}*/
	
	public void testWord(){
		Dictionnary d = new Dictionnary();
		System.out.println(d.contains("a"));
	}
}
