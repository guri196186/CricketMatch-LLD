package com.example.com;

import java.util.Scanner;

public class MainApplication {

	public static void main(String[] args) {
		
		Match match = new Match();
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("No. of players for each team:");
			Integer playerCount = Integer.parseInt(scanner.nextLine());
			System.out.println("No. of overs:");
			Integer overCount = Integer.parseInt(scanner.nextLine());
			
			for(int k=1;k<=2;k++) {
				System.out.println("Batting Order for team:"+k);
				Player[] teamPlayers = new Player[playerCount];
				for(int i=0;i<playerCount;i++) {
					String player = scanner.nextLine();
					teamPlayers[i] = new Player(player);
				}
				match.setteam(playerCount,teamPlayers);
				int wicket = playerCount;
				for(int i=0;i<overCount;i++) {
					int extraballs = 6;
					System.out.println("Over:"+(i+1));
					int j = 0;
					while(j<extraballs && wicket>1) {
						String run = scanner.nextLine();
						if(!run.equals("Wd"))
							j++;
						if(run.equals("W"))
							wicket--;
						match.playmatch(k-1,run); //currentteam
					}
					if(wicket>1)
						match.reverseplayerstatus(k-1);
					match.setovers(k-1);
					match.printscorecard(k-1);
					/*Print score card */
					
					
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		int WinnerTeam;
//		int Runs;
//		System.out.println("Result: Team"+WinnerTeam+ " won the match by "+ Runs + "runs");
//		
			

	}

}
