package gameLogic;
import java.util.ArrayList;

import gui.Interface;


// Test Push for Jords tikmes 2

public class Turn {
	static ArrayList<Player> players;
	static ArrayList<Boolean> flags;
	static int turncount = 0;
	static int index = 0;
	static int drawButton = 4;
	
	public Turn(ArrayList<Player> p, ArrayList<Boolean> f) {
		players = p;
		flags = f;
		turncount++;
		
		Interface.setTurnCount(turncount);
		Interface.updateDrawButton(drawButton);
		Play.setIndex(index);
		
		System.out.println("Making a new play for Player 1!");
		Play play = new Play(players.get(0), players.size(), turncount, flags, players, 0);
	}
	
	public static void turnSequence(int pc) {
		if (pc == 0) {
			
		}
		else {
			Interface.updateDrawButton(players.get(pc).playerID-1);
			System.out.println("Making a new play for Player " + (pc+1) + "! PC");
			Play play = new Play(players.get(pc), players.size(), turncount, flags, players, 0);
		}
	}
	
	public static int getTurnCount() {
		return turncount;
	}
	
	
}
