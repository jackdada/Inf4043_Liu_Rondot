package fr.esiea.liu.rondot.board;

import fr.esiea.liu.rondot.literature.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class CommonJar {
	private ArrayList<Character> commonJar = new ArrayList<>();
	
	public void drawLetter(int nbOfLetter){
		for(int i = 0 ; i < nbOfLetter ; i ++){
			commonJar.add(new Character(randomLetter()));
		}
	}
	
	public Character getLetter(int position){
		return commonJar.get(position);
	}
		
	public void printCommonJar(){
		System.out.println("Common Jar has: ");
		for(int i = 0 ; i < commonJar.size() ; i++){
			System.out.print(commonJar.get(i)+ "  ");
		}
	}

	public ArrayList<Character> getCommonJar(){
		return this.commonJar;
	}

	public char randomLetter(){
		Random r = new Random();
		char c = (char)(r.nextInt(26) + 'a');

		return c;
	}
	public void add(Character character){
		this.commonJar.add(character);
	}

	//class pour verifier si un mot peut être fait à partir es lettre du pot commun
	public boolean letterContains(Word word){
		Iterator<Character> itr = word.getWord().iterator();
		while(itr.hasNext()){
			Character character = itr.next();
			int freqInWord = Collections.frequency(word.getWord(), character);
			int freqInCommonJar = Collections.frequency(this.commonJar, character);
			if(freqInWord > freqInCommonJar){
				return false;
			}
		}
		return true;
	}

	public void removeLetter(Character character){
		this.commonJar.remove(character);
	}

	public void removeLetterFromWord(Word word){
		Iterator<Character> itr = word.getWord().iterator();
		while(itr.hasNext()){
			removeLetter(itr.next());
		}
	}

}
