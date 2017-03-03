package fr.esiea.liu.rondot.literature;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import fr.esiea.liu.rondot.literature.Dictionnary;

public class DictionnaryTest {

	protected Dictionnary dictionnary;
	
	@Before
	public void setUp() {
		dictionnary = new Dictionnary();
	}

	@After
	public void tearDown()throws Exception{
	}

	@Test
	public void testStripAccents() {
		assertEquals("eeeeaaauuuooii", dictionnary.stripAccents("éèëêàâäùüûöôîï"));
	}

	@Test
	public  void  testContainsTrue(){
		assertEquals(true, dictionnary.contains("bonjour"));
	}

	@Test
	public  void  testContainsFalse(){
		assertEquals(false, dictionnary.contains("zeurjdnfjekdo"));
	}

	@Test
	public void testDictionnary() throws Exception {
		int lowerIndex = 0;
		int upperIndex = 100;
		System.out.println("Dictionnary from word "+ lowerIndex + " to word "+upperIndex);
		for(int index=lowerIndex; index < upperIndex ; index ++){
			System.out.println(dictionnary.getDictionnary().get(index));
		}
		System.out.println("Size of the dictionnary: " + dictionnary.getDictionnary().size());
	}
}
