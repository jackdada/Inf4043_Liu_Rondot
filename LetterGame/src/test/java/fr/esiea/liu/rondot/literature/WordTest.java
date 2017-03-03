package fr.esiea.liu.rondot.literature;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
		assertEquals(false, word.isWord(dictionnary));
	}

	@Test
	public void testExistingWord() {
		word = new Word("bonjour");
		assertEquals(true, word.isWord(dictionnary));
	}

	@Test
	public void testComparingWords(){
		Word word = new Word("bonjour");
		assertEquals("bonjour", word.toString());
	}

	@Test
	public void testGetWord(){
		Word word = new Word("bonjour");
		ArrayList<Character> wordArray = new ArrayList<>();
		wordArray.add('b');
		wordArray.add('o');
		wordArray.add('n');
		wordArray.add('j');
		wordArray.add('o');
		wordArray.add('u');
		wordArray.add('r');
		assertEquals(wordArray, word.getWord());
	}
	@Test
	public void testWordFromAnother(){
		Word word = new Word("bonjour");
		Word word2 = new Word(word);

		assertEquals("bonjour", word.toString());
	}
}
