package gameLogic;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

import gui.GUI;
import gui.Interface;

public class Play {
	static Player player;
	static int count;
	static int turn;
	static ArrayList<Boolean> flags;
	static ArrayList<Player> players;
	static int index = 0;
	static boolean isDone;
	
	public Play (Player p, int c, int t, ArrayList<Boolean> f, ArrayList<Player> ps, int i) {
		player = p;
		count = c;
		turn = t;
		flags = f;
		players = ps;
	}
	
	// index setter - the index tracks who is making the Play
	public static void setIndex (int i) {
		index = i;
	}
	
	public static int makePlay (){ // once a player draws a card, this method is called to handle the drawing of the card
		int playerID = player.playerID; // retrieves the PlayerID
		System.out.println(playerID + "############");
		
		// actually draw the card
		player.drawNumber();
		
		// flag check
		for(int j=0; j<count; j++) {
			if (playerID != j+1) {
				flags = FlagHandler.isSubset(player, players.get(j), flags);
				isDone = FlagHandler.isRoundDone(flags);
			}
		}
		
		if(isDone == false) {
			// updating the GUI accordingly
			Interface.updateTurnIndicator(playerID);
			Interface.updateDrawButton(playerID);
			
			// index to index the playcount (4 per turn)
			index++;
		}
		else {
			index = 0;
			boolean test = Game.isGameDone();
			if (test == true) { // Are the 10 rounds complete?
				Completion.gameOver(players);
			}
			else {
				Game.newRound();
			}	
		}
		return index;
	}
	
	// method to return the flags
	public static ArrayList<Boolean> getFlags(){
		return flags;
	}
	

}

