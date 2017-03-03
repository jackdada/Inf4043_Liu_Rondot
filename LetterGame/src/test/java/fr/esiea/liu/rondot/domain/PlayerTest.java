package fr.esiea.liu.rondot.domain;


import fr.esiea.liu.rondot.literature.Word;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTest {

    protected Player player;
    protected Player ia;

    @Before
    public void setUp() throws Exception {
       player = new Player("playerName",false);
        ia= new Player("iaName",true);
    }
    @Test
    public void testGetName() throws Exception {
        assertEquals("playerName", player.getName());
        assertEquals("iaName", ia.getName());
    }
    
    @Test
    public void testGetScore() throws Exception {
        assertEquals(0, player.getScore());
        assertEquals(0, ia.getScore());
    }

    @Test
    public void testIA() throws Exception{
    	System.out.println(player.isAnIA());
    }

    @Test
    public void testAddWord(){
        Word word = new Word("bonjour");
        player.addWord(word);
        assertEquals(1, player.getScore());
        assertEquals(true, player.getWords().contains(word));
    }

    @Test
    public void testRemoveWord(){
        Word word = new Word("bonjour");
        player.addWord(word);
        assertEquals(1, player.getScore());
        assertEquals(true, player.getWords().contains(word));
        player.removeWord(word);
        assertEquals(0, player.getScore());
        assertEquals(false, player.getWords().contains(word));
    }

    @Test
    public void testIsWinnerTrue(){
        for(int i =0; i<10; i++){
            player.addWord(new Word("bonjour"));
        }
        assertEquals(true, player.isWinner());
    }
    @Test
    public void testIsWinnerFalse(){
        for(int i =0; i<5; i++){
            player.addWord(new Word("bonjour"));
        }
        assertEquals(false, player.isWinner());
    }

    @Test
    public void testIsAnIATrue(){
        assertEquals(true, ia.isAnIA());
    }
    @Test
    public void testIsAnIAFalse(){
        assertEquals(false, player.isAnIA());
    }

    @Test
    public void testSetGetFisrtLetter(){
        player.setFirstLetter('c');
        Character c = new Character('c');
        assertEquals(c, player.getFirstLetter());
    }
}