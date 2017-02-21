package literatureTests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.liu.rondot.literature.Letter;

public class LetterTest {

	private int countLooper = 10000;
	private Map<Character,Integer> alphabet = new HashMap<Character,Integer>();

	@Before
	public void setUp() throws Exception {
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
	public void test() {
		for(int i = 0 ; i < countLooper ; i++){
			Letter letter = new Letter();
			char a = letter.getLetter().charAt(0);
			if(alphabet.containsKey(a)){
				alphabet.put(a, alphabet.get(a) + 1);
			}	
		}
	
		Set<Entry<Character,Integer>> setHM = alphabet.entrySet();
		Iterator<Entry<Character,Integer>> it = setHM.iterator();
		while(it.hasNext()){
			Entry<Character,Integer> e = it.next();
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}

}
