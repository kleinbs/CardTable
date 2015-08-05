package com.house;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by scipio on 8/4/15.
 */
public class Table {

    private int minPlayers;
    private int maxPlayers;
    private int maxCardsInHand;
    private Iterator iterator;

    List<Player> players;

    public Table(int maxPlayers){
        players = new ArrayList<Player>();
        this.maxPlayers = maxPlayers;
    }

    public Table(int maxPlayers, int minPlayers){
        players = new ArrayList<Player>();
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
    }

    public Table(int maxPlayers, int minPlayers, int maxCardsInHand){
        players = new ArrayList<Player>();
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
        this.maxCardsInHand = maxCardsInHand;
    }

    public int getCurrentPlayerCount(){ return players.size(); }

    public int getMinPlayers(){ return this.minPlayers; }

    public int getMaxPlayers(){ return this.maxPlayers; }

    public int getMaxCardsInHand(){ return this.maxCardsInHand; }

    /**
     * Add player. if player is added we return true, if the number of players already at
     * the table is greater than the max allowed players we don't add the player and return false;
     * @param name
     * @return
     */
    public boolean AddPlayer(String name){
        if(players.size() < maxPlayers || maxPlayers != 0) {
            players.add(new Player(name));
            return true;
        }
        else
            return false;
    }

    /**
     * Removes player by name, if player found return true. if no player found return false;
     * @param player
     * @return
     */
    public boolean RemovePlayer(Player player){
        Boolean foundPlayer = false;

        for(int i = 0; i < players.size(); i++){
            if(player.equals(players.get(i).getName()));{
                foundPlayer = true;
                players.remove(i);
                break;
            }
        }

        return foundPlayer;
    }

    public Player GetNextPlayer(){
        if(iterator == null)
            iterator = players.iterator();
        if(!iterator.hasNext())
            iterator = players.iterator();
        return (Player)iterator.next();
    }


}
