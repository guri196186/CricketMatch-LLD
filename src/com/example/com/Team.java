package com.example.com;

import java.util.LinkedList;
import java.util.Queue;

public class Team {
	private int teamSize;
	private Player[] players;
	private int teamscore;
	private int id;
	private int overs;
	public int getOvers() {
		return overs;
	}
	public void setOvers(int overs) {
		this.overs += overs;
	}
	//check if required or not
	private Pair<Player,Player>currentPlayer;
	private Queue<Player> qplayers;
	public int getTeamscore() {
		return teamscore;
	}
	public void setTeamscore(int teamscore) {
		this.teamscore += teamscore;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Team(int teamSize,Player[] players) {
		this.teamSize = teamSize;
		this.players = players;
		this.teamscore = 0;
		this.overs = 0;
		this.qplayers = new LinkedList<Player>();
		for(int i=0;i<this.players.length;i++)
			qplayers.add(this.players[i]);
		this.currentPlayer = null;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public Queue<Player> getQplayers() {
		return qplayers;
	}
	public void setQplayers(Queue<Player> qplayers) {
		this.qplayers = qplayers;
	}
	public Player[] getPlayers() {
		return players;
	}
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	public Pair<Player, Player> getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(Pair<Player, Player> currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
}
