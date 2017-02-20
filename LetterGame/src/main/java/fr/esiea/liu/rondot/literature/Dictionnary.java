package fr.esiea.liu.rondot.literature;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionnary {
	private ArrayList<String> dictionnary = new ArrayList<String>();
	
	public Dictionnary(){
		File rawDic = new File("C:/Users/Kev/Documents/EclipseProjects/Inf4043_Liu_Rondot/LetterGame/src/main/resources/dico.txt");
		Scanner s;
		try {
			s = new Scanner(rawDic);
			s.useDelimiter("\n");
			while (s.hasNext()){
			    this.dictionnary.add(s.next());
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}
	
	public void testDictionnary(){
		for(int index=0; index < 5 ; index ++){
			System.out.println(dictionnary.get(index));
		}
		System.out.println("Size of the dictionnary: " + dictionnary.size());
	}
	
}
