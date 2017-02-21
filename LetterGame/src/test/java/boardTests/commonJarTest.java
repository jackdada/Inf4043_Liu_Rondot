package boardTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.liu.rondot.board.CommonJar;

public class commonJarTest {

	protected CommonJar commonJar;
	
	@Before
	public void setUp() throws Exception {
		commonJar = new CommonJar();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		commonJar.testCommonJar();
	}

}
