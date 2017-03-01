package fr.esiea.liu.rondot.board;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.esiea.liu.rondot.board.Engine;
import fr.esiea.liu.rondot.domain.Player;


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
	public  void testInitiatePlayersOrder(){
		for(int i = 0 ; i < 4 ; i++ ){
			Player player = new Player("p"+ i );
			game.addPlayers(player);
		}
		game.firstRound();
	}
}
