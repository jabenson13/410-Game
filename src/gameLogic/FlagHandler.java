package gameLogic;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import gui.Interface;

public class FlagHandler {
	/* FlagHandler is the class that receives the ArrayList<Boolean> flags and checks the subset and win conditions
	 * and then returns the result accordingly to the other classes. 
	 * 
	 *  Written by Luke and Tyler
	 */ 
	
	public static ArrayList<Boolean> isSubset (Player p1, Player p2, ArrayList<Boolean> flags) {
		Player Player1 = p1; // not necessarily Player1, it's a name for any player that is input first in the arguments
		Player Player2 = p2; // same as Player1
		int index = -1; // arbitrary number - will get changed if the program is running correctly
		
		if(Player1.drawnNumbers.containsAll(Player2.drawnNumbers)){
			// update flag that P1 has P2
			index = (Player1.playerID - 1) * 4;
			index = index + (Player2.playerID - 1);
			flags.set(index, true);
			Interface.updateGUIFlags(Player1.playerID, Player2.playerID);
		}
		if (Player2.drawnNumbers.containsAll(Player1.drawnNumbers)) {
			// update flag that P2 has P1
			index = (Player2.playerID - 1) * 4;
			index = index + (Player1.playerID - 1);
			flags.set(index, true);
			Interface.updateGUIFlags(Player2.playerID, Player1.playerID);
		}
		else {
			// nothing happens
		}
		return flags;
	}
	
	public static ArrayList<Boolean> flagReset (int roundCount){ // resets the flags to their default values
		ArrayList<Boolean> flags = new ArrayList<Boolean>();
		for(int i=0; i<16; i++) {
			if(i % 5 == 0) {
				flags.add(true);
			}
			else {
				flags.add(false);
			}
		}
		if (roundCount != 1) {
			Interface.resetGrid();
		}
		return flags;
	}
	
	public static boolean isRoundDone (ArrayList<Boolean> flags) { // checks if a round is concluded
		boolean isDone = false;
		int count = 0;
		int winnerID = 0;
		for(int p = 0; p < 4; p++) {
			count = 0;
			for(int i = p*4; i < (p*4)+4; i++) {
				
				if(flags.get(i) == false) {
					break;
				}else {
					count++;
				}
				if (count == 4) {
					isDone = true;
				}
			}
			if(isDone == true) { // win conditions
				winnerID = p+1;
				Game.players.get(p).incrementWins();
				Interface.updateWinCount(p+1, Game.players.get(p).wins);
				ArrayList<Integer> points = Game.getPoints();
				int turnCount = Turn.getTurnCount();
				points = Completion.pointUpdate(winnerID, turnCount, points);
				Game.setPoints(points);
				JOptionPane.showMessageDialog(null, "Player " + winnerID + " has won!!!");
				break;
			}
			
		}
		
		return isDone;
		
	}
	public static void flagsToString(ArrayList<Boolean> flags) { // toString for the arraylist of flags
		String output = "";
		for(int i=0; i<flags.size(); i++) {
			if(flags.get(i) == true) {
				output += i;
				output += ": true - ";
			}
			else if(flags.get(i) == false) {
				output += i;
				output += ": false - ";
			}
		}
		System.out.println(output);
	}

	
	
	
	
	
}