package fr.esiea.liu.rondot.board;

import java.util.ArrayList;

import fr.esiea.liu.rondot.literature.Letter;

public class CommonJar {
	private ArrayList<Letter> commonjar;
	
	public void drawNextLetter(){
		Letter newLetter = new Letter(' ');
		commonjar.add(newLetter.randomLetter());		
	}
		
}
