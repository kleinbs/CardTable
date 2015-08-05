package com.house;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by scipio on 8/4/15.
 */
public class TableTest {

    @Test
    public void TestInitialization(){

        Table table = new Table(5);
        Assert.assertEquals(table.getMaxPlayers(), 5);

        table = new Table(6, 1);
        Assert.assertEquals(table.getMaxPlayers(), 6);
        Assert.assertEquals(table.getMinPlayers(), 1);

        table = new Table(7, 2, 8);
        Assert.assertEquals(table.getMaxPlayers(), 7);
        Assert.assertEquals(table.getMinPlayers(), 2);
        Assert.assertEquals(table.getMaxCardsInHand(), 8);
    }

    @Test
    public void TestAddPlayers(){

        Table table = new Table(5);
        Assert.assertEquals(table.getCurrentPlayerCount(), 0);
        table.AddPlayer("JOE");
        Assert.assertEquals(table.getCurrentPlayerCount(), 1);
    }

    @Test
    public void TestRemovePlayers(){
        Table table = new Table(5);
        Assert.assertEquals(table.getCurrentPlayerCount(), 0);
        table.AddPlayer("JOE");
        table.AddPlayer("FRANK");
        table.AddPlayer("JOBE");
        Assert.assertEquals(table.getCurrentPlayerCount(), 3);
        Player player = table.GetNextPlayer();
        Assert.assertEquals(table.RemovePlayer(player), true);
        Assert.assertEquals(table.getCurrentPlayerCount(), 2);
    }

    @Test
    public void TestGetNextPlayer(){
        Table table = new Table(5);
        table.AddPlayer("JOE");
        table.AddPlayer("FRANK");
        table.AddPlayer("JOBE");

        Assert.assertEquals(table.GetNextPlayer().getName(), "JOE");
        Assert.assertEquals(table.GetNextPlayer().getName(), "FRANK");
        Assert.assertEquals(table.GetNextPlayer().getName(), "JOBE");
    }
}
