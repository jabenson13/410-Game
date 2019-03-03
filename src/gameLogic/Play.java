package gameLogic;

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
	static int semaphore = 0;
	static int index = 0;
	
	public Play (Player p, int c, int t, ArrayList<Boolean> f, ArrayList<Player> ps, int i) {
		player = p;
		count = c;
		turn = t;
		flags = f;
		players = ps;
	}
	
	public static void setIndex (int i) {
		index = i;
	}
	public static int makePlay (){
		int playerID = player.playerID;
		
		Interface.updateTurnIndicator(playerID);
		Interface.updateDrawButton(playerID);
		
	//	int temp = -1;
		// send information for player to draw a card
		// wait for player to say push button
		 			
		// draw the card
		
		player.drawNumber();
		
		for(int j=0; j<count; j++) {
			System.out.println(players.get(j).getHandtoString());
			if (playerID != j+1) {
				flags = FlagHandler.isSubset(player, players.get(j), flags);
				
		//System.out.println(this.toString());
			}
		}
		
		index++;
		
		return index;
	}
	public static ArrayList<Boolean> getFlags(){
		return flags;
	}
	

}

