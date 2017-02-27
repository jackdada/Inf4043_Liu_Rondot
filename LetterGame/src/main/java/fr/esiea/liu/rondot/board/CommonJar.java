package fr.esiea.liu.rondot.board;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import fr.esiea.liu.rondot.literature.Letter;

public class CommonJar {
	private ArrayList<Character> commonJar = new ArrayList<>();
	
	public void drawLetter(int nbOfLetter){
		for(int i = 0 ; i < nbOfLetter ; i ++){
			commonJar.add(randomLetter());
		}
	}
		
	public void printCommonJar(){
		System.out.println("Common Jar has: ");
		for(int i = 0 ; i < commonJar.size() ; i++){
			System.out.print(commonJar.get(i)+ "  ");
		}
	}

	public void testCommonJar(){
		int amountOfLetter = 0;
		System.out.println("How much letter you want ?");
		Scanner in = new Scanner(System.in);
		amountOfLetter = in.nextInt();
			
		drawLetter(amountOfLetter);
		
		printCommonJar();
	}
	public char randomLetter(){
		Random r = new Random();
		char c = (char)(r.nextInt(26) + 'a');

		return new Character(c);
	}

}
