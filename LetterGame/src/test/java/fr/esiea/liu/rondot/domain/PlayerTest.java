package fr.esiea.liu.rondot.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    protected Player player = new Player("playerName");
    @Test
    public void testGetName() throws Exception {
        System.out.println(player.getName());
    }
    @Test
    public void testGetScore() throws Exception {
        System.out.println(player.getScore());
    }

}