package fr.esiea.liu.rondot.board;

import java.util.ArrayList;
import java.util.Random;

public class CommonJar {
	private ArrayList<Character> commonJar = new ArrayList<>();
	
	public void drawLetter(int nbOfLetter){
		for(int i = 0 ; i < nbOfLetter ; i ++){
			commonJar.add(new Character(randomLetter()));
		}
	}
		
	public void printCommonJar(){
		System.out.println("Common Jar has: ");
		for(int i = 0 ; i < commonJar.size() ; i++){
			System.out.print(commonJar.get(i)+ "  ");
		}
	}


	public char randomLetter(){
		Random r = new Random();
		char c = (char)(r.nextInt(26) + 'a');

		return c;
	}

}
