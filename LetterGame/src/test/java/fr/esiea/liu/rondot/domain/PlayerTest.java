package fr.esiea.liu.rondot.domain;

import org.junit.Test;


public class PlayerTest {

    protected Player player = new Player("playerName",true);
    
    @Test
    public void testGetName() throws Exception {
        System.out.println(player.getName());
    }
    
    @Test
    public void testGetScore() throws Exception {
        System.out.println(player.getScore());
    }

    @Test
    public void testIA() throws Exception{
    	System.out.println(player.isAnIA());
    }
}