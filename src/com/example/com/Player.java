package com.example.com;

public class Player {
	private String ID;
	private int score;
	private int fours;
	private int sixes;
	private int balls_faced;
	private PlayerStatus playerstatus;
	
	Player(String ID){
		this.ID = ID;
		this.score = 0;
		this.fours = 0;
		this.sixes = 0;
		this.balls_faced = 0;
		this.playerstatus = PlayerStatus.NEW;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}

	public int getFours() {
		return fours;
	}

	public void setFours(int fours) {
		this.fours += fours;
	}

	public int getSixes() {
		return sixes;
	}

	public void setSixes(int sixes) {
		this.sixes += sixes;
	}

	public int getBalls_faced() {
		return balls_faced;
	}

	public void setBalls_faced(int balls_faced) {
		this.balls_faced += balls_faced;
	}

	public PlayerStatus getPlayerstatus() {
		return playerstatus;
	}

	public void setPlayerstatus(PlayerStatus playerstatus) {
		this.playerstatus = playerstatus;
	}
}
