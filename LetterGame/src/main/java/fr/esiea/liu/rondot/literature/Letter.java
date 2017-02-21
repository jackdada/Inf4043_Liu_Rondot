package fr.esiea.liu.rondot.literature;

import java.util.Random;

public class Letter {
	private char letter;
	
	public Letter(){
		letter = randomLetter();
	}
	
	public Letter(char a){
		letter = a ;
	}
	
	public String getLetter(){
		return String.valueOf(this.letter);
	}
	
	public char randomLetter(){
		Random r = new Random();
		char c = (char)(r.nextInt(26) + 'a');
		return c;
	}
	
	public void generateRandomLetter(){
		System.out.println(getLetter());
	}
}
