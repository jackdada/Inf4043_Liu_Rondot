package literatureTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.liu.rondot.literature.Letter;

public class LetterTest {
	
	protected Letter letter;

	@Before
	public void setUp() throws Exception {
		letter = new Letter(' ');
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		letter.generateRandomLetter();
	}

}
