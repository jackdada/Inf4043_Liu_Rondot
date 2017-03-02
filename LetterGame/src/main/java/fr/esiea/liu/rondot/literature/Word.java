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
<<<<<<< HEAD
	
<<<<<<< HEAD
=======
	public void jesuiskevinetjaimelamuscu(){
		
	}
	
>>>>>>> kévin
=======

>>>>>>> 0b6bbb7681c57eae3f96be4ec84a4a2134ab494d
	public boolean isWord(Dictionnary d){
		if(d.contains(toString())){
			return true;
		}
		else{
			return false;
		}
	}
}
