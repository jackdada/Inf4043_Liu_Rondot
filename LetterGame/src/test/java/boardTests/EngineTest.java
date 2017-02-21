package boardTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.liu.rondot.board.Engine;

public class EngineTest {

	protected Engine game;
	
	@Before
	public void setUp() throws Exception {
		game = new Engine();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		game.main(null);
	}

}
