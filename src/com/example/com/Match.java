package com.example.com;

public class Match {
	private Team[] team;
	int t;
	
	Match(){
		team = new Team[2];
		this.t = 0;
	}
	
	public void setteam(int teamsize,Player[] P1) {
		team[this.t]  = new Team(teamsize,P1);
		Player p1 = team[this.t].getQplayers().poll();
		Player p2 = team[this.t].getQplayers().poll();
		Pair<Player, Player> currPlayers = new Pair<Player, Player>(p1,p2);
		team[this.t].setCurrentPlayer(currPlayers);
		p1.setPlayerstatus(PlayerStatus.PLAYING);
		p2.setPlayerstatus(PlayerStatus.WAITING);
		this.t++;
	}
	
	public void addRuns(int currentTeam,int run) {
		Team currTeam  = team[currentTeam];
		if(currTeam.getCurrentPlayer()==null && currTeam.getQplayers().size()==0) {
			return;
		}else {
			if(run==-1) {
				if(currTeam.getCurrentPlayer().getFirst().getPlayerstatus() == PlayerStatus.PLAYING) {
					currTeam.getCurrentPlayer().getFirst().setPlayerstatus(PlayerStatus.OUT);
					currTeam.getCurrentPlayer().getFirst().setBalls_faced(1);
					if(currTeam.getQplayers().size()>0) {
						Player p1 = currTeam.getQplayers().poll();
						currTeam.getCurrentPlayer().setFirst(p1);
						p1.setPlayerstatus(PlayerStatus.PLAYING);
					}
					else
						currTeam.setCurrentPlayer(null);
				}else {
					currTeam.getCurrentPlayer().getSecond().setPlayerstatus(PlayerStatus.OUT);
					
					currTeam.getCurrentPlayer().getSecond().setBalls_faced(1);
					if(currTeam.getQplayers().size()>0) {
						Player p2 = currTeam.getQplayers().poll();
						currTeam.getCurrentPlayer().setSecond(p2);
						p2.setPlayerstatus(PlayerStatus.PLAYING);
					}
					else
						currTeam.setCurrentPlayer(null);
				}
			}else {
				currTeam.setTeamscore(run);
				if(currTeam.getCurrentPlayer().getFirst().getPlayerstatus() == PlayerStatus.PLAYING) {
					currTeam.getCurrentPlayer().getFirst().setBalls_faced(1);
					currTeam.getCurrentPlayer().getFirst().setScore(run);
					if(run==4)
						currTeam.getCurrentPlayer().getFirst().setFours(1);
					if(run==6)
						currTeam.getCurrentPlayer().getFirst().setSixes(1);
					if(run==1 ||run==3)
					{
						currTeam.getCurrentPlayer().getFirst().setPlayerstatus(PlayerStatus.WAITING);
						currTeam.getCurrentPlayer().getSecond().setPlayerstatus(PlayerStatus.PLAYING);
					}
				}else {
					currTeam.getCurrentPlayer().getSecond().setBalls_faced(1);
					currTeam.getCurrentPlayer().getSecond().setScore(run);
					if(run==4)
						currTeam.getCurrentPlayer().getSecond().setFours(1);
					if(run==6)
						currTeam.getCurrentPlayer().getSecond().setSixes(1);
					if(run==1 ||run==3)
					{
						currTeam.getCurrentPlayer().getSecond().setPlayerstatus(PlayerStatus.WAITING);
						currTeam.getCurrentPlayer().getFirst().setPlayerstatus(PlayerStatus.PLAYING);
					}
				}
			}
		}
	}
	
	public void reverseplayerstatus(int currentTeam) {
		Team currTeam  = team[currentTeam];
		if(currTeam.getCurrentPlayer()==null) {
			if(currTeam.getCurrentPlayer().getFirst().getPlayerstatus() == PlayerStatus.PLAYING) {
				currTeam.getCurrentPlayer().getFirst().setPlayerstatus(PlayerStatus.WAITING);
				currTeam.getCurrentPlayer().getSecond().setPlayerstatus(PlayerStatus.PLAYING);
			}
		}else {
			currTeam.getCurrentPlayer().getSecond().setPlayerstatus(PlayerStatus.WAITING);
			currTeam.getCurrentPlayer().getFirst().setPlayerstatus(PlayerStatus.PLAYING);
		}
	}

	public void playmatch(int currentTeam, String run) {
		
		if(run.equals("W")) {
			this.addRuns(currentTeam, -1);
		}else if(run.equals("Wd")) {
			return;
		}else {
			int r = Integer.parseInt(run);
			this.addRuns(currentTeam, r);	
		}
		
		
	}

	public void setovers(int i) {
		Team currTeam  = team[i];
		currTeam.setOvers(1);		
	}
	
	public void printscorecard(int t) {
		Team currTeam  = team[t];
		Player[] p = currTeam.getPlayers();
		for(int i=0;i<p.length;i++) {
			System.out.println(p[i].getID()+" "+ p[i].getScore()+" "+p[i].getFours()+" "+p[i].getSixes()+" "+p[i].getBalls_faced());
		}
		System.out.println("Total score:"+currTeam.getTeamscore()+"/"+(currTeam.getTeamSize()-currTeam.getQplayers().size()));
	}
	
}
