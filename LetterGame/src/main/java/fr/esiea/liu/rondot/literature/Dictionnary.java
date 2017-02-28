package fr.esiea.liu.rondot.literature;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.Normalizer;

public class Dictionnary {
	private ArrayList<String> dictionnary = new ArrayList<String>();
	
	public Dictionnary(){
		File rawDic = new File("src/main/resources/dico.txt");
		Scanner s;
		try {
			s = new Scanner(rawDic,"UTF-8");
			while (s.hasNext()){
			    this.dictionnary.add(s.next());
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		convertCharacters();
	}
	
	public boolean contains(String word){
		if(dictionnary.contains(word)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void convertCharacters(){
		for(int i = 0; i < dictionnary.size(); i++){
			String newString = stripAccents(dictionnary.get(i));
			dictionnary.set(i, newString);
		}
	}
	
	public String stripAccents(String s){
		return s == null ? null: Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+","");
	}
	
	public void testDictionnary(){
		int lowerIndex = 0;
		int upperIndex = 100;
		System.out.println("Dictionnary from word "+ lowerIndex + " to word "+upperIndex);
		for(int index=lowerIndex; index < upperIndex ; index ++){
			System.out.println(dictionnary.get(index));
		}
		System.out.println("Size of the dictionnary: " + dictionnary.size());
	}
	
}
