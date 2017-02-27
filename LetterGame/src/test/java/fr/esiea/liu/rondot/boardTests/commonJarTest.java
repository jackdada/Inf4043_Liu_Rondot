package fr.esiea.liu.rondot.boardTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.liu.rondot.board.CommonJar;

import java.util.*;

public class commonJarTest {

	protected CommonJar commonJar;
	private int countLooper = 10000;
	private Map<Character,Integer> alphabet = new HashMap<Character,Integer>();
	@Before
	public void setUp() throws Exception {
		commonJar = new CommonJar();
		char a = 'a';
		for(int i = 0; i < 26 ; i++){
			alphabet.put(a,0);
			a++;
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRandomLetter() {
		for(int i = 0 ; i < countLooper ; i++){
			char a = commonJar.randomLetter();
			if(alphabet.containsKey(a)){
				alphabet.put(a, alphabet.get(a) + 1);
			}
		}

		Set<Map.Entry<Character,Integer>> setHM = alphabet.entrySet();
		Iterator<Map.Entry<Character,Integer>> it = setHM.iterator();
		while(it.hasNext()){
			Map.Entry<Character,Integer> e = it.next();
			System.out.println(e.getKey() + " : " + e.getValue());
		}

	}

	@Test
	public void testDrawLetter1() {

		commonJar.drawLetter(1);

		commonJar.printCommonJar();

	}
	@Test
	public void testDrawLetter2() {

		commonJar.drawLetter(2);

		commonJar.printCommonJar();

	}

}
