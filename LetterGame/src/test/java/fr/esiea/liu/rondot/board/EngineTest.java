package fr.esiea.liu.rondot.board;

import fr.esiea.liu.rondot.domain.Player;
import fr.esiea.liu.rondot.literature.Dictionnary;
import fr.esiea.liu.rondot.literature.Word;
import fr.esiea.liu.rondot.board.Engine;
import fr.esiea.liu.rondot.board.CommonJar;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;
public class EngineTest {

	Engine engine;
	@Before
	public void setUp() throws Exception {
		engine = new Engine();
	}

	@Test
	public void testExistedPlayer(){
		Player toto = new Player("toto", false);
		Player titi = new Player("titi", false);
		Player tutu = new Player("tutu", false);
		engine.getPlayers().add(toto);
		engine.getPlayers().add(tutu);
		engine.getPlayers().add(titi);
		Player result = engine.existedPlayer("titi");
		assertEquals(titi, result);

	}

	@Test
	public void testWordDifference(){
		Word firstword = new Word("firstWord");
		Word secondWord = new Word("secondWord");
		Word result = new Word("fitr");
		assertEquals(result.toString(), engine.wordDifference(firstword, secondWord).toString());
	}

	@Test
	public void testStealWordCheck(){
		String str = "ohnfcjdkascn";
		for (int i = 0; i < str.length(); i++) {
			engine.getCommonJar().add(str.charAt(i));
		}
		Word word = new Word("non");

		assertEquals(true, engine.stealWordCheck(word, 6, 3));
	}

}
