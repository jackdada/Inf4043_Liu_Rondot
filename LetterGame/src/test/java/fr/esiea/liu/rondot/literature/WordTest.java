package fr.esiea.liu.rondot.literature;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.liu.rondot.literature.Word;

public class WordTest {
	
	protected Word word;

	@Before
	public void setUp() throws Exception {
		word = new Word("bonjour");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		word.testWord();
	}

}
