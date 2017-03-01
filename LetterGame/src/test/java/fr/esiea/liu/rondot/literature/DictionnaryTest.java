package fr.esiea.liu.rondot.literature;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
		System.out.println("éèëêàâäùüûöôîï : " + dictionnary.stripAccents("éèëêàâäùüûöôîï"));
	}

	@Test
	public  void  testContains(){
		System.out.println("bonjour : " + dictionnary.contains("bonjour"));
		System.out.println("zlskdie : " + dictionnary.contains("zlskdie"));
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
