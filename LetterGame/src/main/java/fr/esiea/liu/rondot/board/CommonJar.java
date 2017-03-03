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
		System.out.println("The common jar contains: ");
		if(commonJar.size() != 0){
			for(int i = 0 ; i < commonJar.size() ; i ++){
				System.out.print(commonJar.get(i) + "  ");
			}
			System.out.println();
		}
		else{
			System.out.println("No letters in the common jar");
		}
	}

	public ArrayList<Character> getCommonJar(){
		return this.commonJar;
	}

	public char randomLetter(){
		Random r = new Random();
		ArrayList<String> alphabet = new ArrayList<String>();
		alphabet.add("aei");
		alphabet.add("dnrt");
		alphabet.add("ouls");
		alphabet.add("jcmpf");
		alphabet.add("gbvhq");
		alphabet.add("yxjkwz");
		char c = ' ';
		int position = (r.nextInt(6));
		for(int i = 0 ; i < alphabet.get(position).length() ; i ++){
			int j = (r.nextInt(alphabet.get(position).length()));
			c = alphabet.get(position).charAt(j);
		}

		return c;
	}
	public void add(Character character){
		this.commonJar.add(character);
	}

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
