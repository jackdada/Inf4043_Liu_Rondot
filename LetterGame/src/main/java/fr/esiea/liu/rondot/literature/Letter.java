package fr.esiea.liu.rondot.literature;

import java.util.Random;

public class Letter {
	private char letter;
	
	public Letter(char c){
		letter = c;
	}
	
	public String getLetter(){
		return String.valueOf(this.letter);
	}
	
	public Letter randomLetter(){
		Random r = new Random();
		char c = (char)(r.nextInt(26) + 'a');
		this.letter = c;
		return this;
	}
	
	public void generateRandomLetter(){
		Letter l = new Letter(' ');
		l = l.randomLetter();
		System.out.println(l.getLetter());
	}
}
