package fr.esiea.liu.rondot.literatureTests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.liu.rondot.literature.Dictionnary;
import fr.esiea.liu.rondot.literature.Word;

public class DictionnaryTest {

	protected Dictionnary dictionnary;
	
	@Before
	public void setUp() {
		dictionnary = new Dictionnary();
	}

	@After
	public void tearDown(){
	}

	@Test
	public void testInit() throws Exception {
		dictionnary.testDictionnary();
	}

}
