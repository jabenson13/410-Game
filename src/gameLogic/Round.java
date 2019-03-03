package gameLogic;
import java.util.ArrayList;

import gui.Interface;

public class Round {
	int gameID;
	static int roundCount;				// tracks the round count
	static ArrayList<Boolean> flags;	// arraylist of boolean flags - true indicating a green dot, false for a red dot
	ArrayList<Player> players;			// arraylist of players
	int initialDrawCount = 18;			// how many numbers a player draws at the beginning of the round
	int turnCount;						// tracks the turn count
	
	// constructor for Round
	public Round(int rNumber, ArrayList<Player> p) {
		roundCount = rNumber; // the game tracks the round count and gives it to the round
		players = p;
		
		Interface.setGameCount(roundCount); // tells the GUI the round count so it can be displayed
		Interface.resetWestPanel(); // resets the west panel (the player flags panel)
		
		flags = FlagHandler.flagReset(roundCount); // resets the flags for the new round
		Turn.turncount = 0; // resets the turn count for the new round
		turnCount = Turn.turncount;
		Interface.setTurnCount(turnCount); // tells the GUI the new turncount (reset)
		
		// resets the numbers for each of the players
		for(int i=0; i<players.size(); i++) {
			players.get(i).resetNumberPile();
		}
		
		// each player draws 4 new numbers for the new round (their starting numbers)
		for(int index=0; index<initialDrawCount; index++) {
			for(int i=0; i<players.size(); i++) {
				players.get(i).drawNumber();
			}
		}
		
		// begins a new turn
		Turn turn = new Turn(players, flags);
	}
	
	// A simple toString method
	public String toString() {
		String g = "";	
		for(int i = 0; i < flags.size(); i++) {
			g += flags.get(i).toString() + " - ";
		}	
		return g;
	}
	
	// getter for the flags
	public static ArrayList<Boolean> getFlags(){
		return flags;
	}
	
	// Re-arranges the order between turns - WIP
	public static ArrayList<Player> newOrder(ArrayList<Player> currentOrder){
		ArrayList<Player> newOrder = currentOrder;
		
		for(int i=0; i<newOrder.size(); i++) {
			System.out.println(currentOrder.get(i).playerID);
		}
		int temp = (roundCount-1)%4;
		
		for(int i=0; i<temp; i++) {
			newOrder.add(currentOrder.get(i));
			newOrder.remove(i);
		}
		for(int i=0; i<newOrder.size(); i++) {
			System.out.println(newOrder.get(i).playerID);
		}
		
		return newOrder;
	}
	
	
}
