package fr.esiea.liu.rondot.literature;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.liu.rondot.literature.Dictionnary;
import fr.esiea.liu.rondot.literature.Word;

public class WordTest {
	
	protected Word word;
	protected Dictionnary dictionnary;

	@Before
	public void setUp() throws Exception {
		dictionnary = new Dictionnary();
	}

	@Test
	public void testNonExistingWord() {
		word = new Word("psjdfljsdf");
		System.out.print("The dictionnary contains the word <"+ word + "> : ");
		System.out.println(word.isWord(dictionnary));
	}
	
	@Test
	public void testExistingWord() {
		word = new Word("bonjour");
		System.out.print("The dictionnary contains the word <"+ word + "> : ");
		System.out.println(word.isWord(dictionnary));
	}

}
