package fr.esiea.liu.rondot.board;

import java.util.ArrayList;
import java.util.Scanner;

import fr.esiea.liu.rondot.literature.Letter;

public class CommonJar {
	private ArrayList<Letter> commonjar = new ArrayList<Letter>();
	
	public void drawLetter(int nbOfLetter){
		for(int i = 0 ; i < nbOfLetter ; i ++){
			Letter newLetter = new Letter();
			commonjar.add(newLetter);	
		}
	}
		
	public void printCommonJar(){
		System.out.println("Common Jar has: ");
		for(int i = 0 ; i < commonjar.size() ; i ++){
			System.out.print(commonjar.get(i).getLetter()+ "  ");
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
}
