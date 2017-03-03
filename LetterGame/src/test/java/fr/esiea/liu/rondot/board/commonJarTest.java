package fr.esiea.liu.rondot.board;

import fr.esiea.liu.rondot.literature.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
		assertEquals(1, commonJar.getCommonJar().size());
	}

	@Test
	public void testDrawLetter2() {
		commonJar.drawLetter(2);
		assertEquals(2, commonJar.getCommonJar().size());
	}

	@Test
	public void testGetLetter(){
		commonJar.drawLetter(10);
		ArrayList<Character> jar = commonJar.getCommonJar();
		assertEquals(jar.get(5), commonJar.getLetter(5));
	}

	@Test
	public  void testLetterContainsTrue() {
		String str = "ohnfcjdkascn";
		for (int i = 0; i < str.length(); i++) {
			commonJar.add(str.charAt(i));
		}
		assertEquals(true, commonJar.letterContains((new Word("canon"))));
	}

	@Test
	public  void testLetterContainsFalse() {
		String str = "ohnfcjdkascn";
		for (int i = 0; i < str.length(); i++) {
			commonJar.add(str.charAt(i));
		}
		assertEquals(false, commonJar.letterContains((new Word("colon"))));
	}

	@Test
	public  void testRemoveLetterFromWord(){
		String str = "ohnfcjdkascn";
		for(int i = 0 ; i < str.length() ; i++){
			commonJar.add(str.charAt(i));
		}
		System.out.println("commonJar : " + commonJar.getCommonJar());
		System.out.println("remove canon's letters : ");
		commonJar.removeLetterFromWord(new Word("canon"));
		System.out.println("commonJar : " + commonJar.getCommonJar());
	}

	@Test
	public void testGetCommon(){
		String str = "ohnfcjd";
		for(int i = 0 ; i < str.length() ; i++){
			commonJar.add(str.charAt(i));
		}
		ArrayList<Character> jar = new ArrayList<>();
		jar.add('o');
		jar.add('h');
		jar.add('n');
		jar.add('f');
		jar.add('c');
		jar.add('j');
		jar.add('d');
		assertEquals(jar, commonJar.getCommonJar());
	}
}
