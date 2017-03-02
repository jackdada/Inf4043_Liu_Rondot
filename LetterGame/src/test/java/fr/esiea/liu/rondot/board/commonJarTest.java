package fr.esiea.liu.rondot.board;

import fr.esiea.liu.rondot.literature.Word;
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
		System.out.println();
	}

	@Test
	public void testDrawLetter2() {
		commonJar.drawLetter(2);
		commonJar.printCommonJar();
		System.out.println();
	}

	@Test
	public void testGetLetter(){
		commonJar.drawLetter(10);
		commonJar.printCommonJar();
		System.out.println();
		System.out.println(commonJar.getLetter(5));

	}

	@Test
	public  void testLetterContains(){
		String str = "ohnfcjdkascn";
		for(int i = 0 ; i < str.length() ; i++){
			commonJar.add(str.charAt(i));
		}

		System.out.println("commonJar : " + commonJar.getCommonJar());
		System.out.println("canon is contain ? " + commonJar.letterContains(new Word("canon")));
		System.out.println("colon is contain ? " + commonJar.letterContains(new Word("colon")));
		System.out.println("nanoc is contain ? " + commonJar.letterContains(new Word("nanoc")));
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
}
