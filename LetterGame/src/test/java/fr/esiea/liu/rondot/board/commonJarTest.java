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
	@Test
	public void oto(){
		Collection<String> listOne = new ArrayList(Arrays.asList("a","b", "c", "d", "d", "e", "f", "g"));
		Collection<String> listTwo = new ArrayList(Arrays.asList("a","b", "d", "e", "f", "gg", "h"));

		List<String> sourceList = new ArrayList<String>(listOne);
		List<String> destinationList = new ArrayList<String>(listTwo);

		sourceList.removeAll( listTwo );
		destinationList.removeAll( listOne );

		System.out.println( sourceList );
		System.out.println( destinationList );
	}
}
