package gameLogic;
import java.util.ArrayList;

import gui.Interface;

public class Round {
	int gameID;
	int playerCount;
	static int roundCount;
	static ArrayList<Boolean> flags;
	ArrayList<Player> players;
	int initialDrawCount = 4;
	int turnCount = 0;
	String test;
	ArrayList<Turn> turns;
	
	// constructor
	public Round(int rNumber, ArrayList<Player> p) {
		playerCount = p.size();
		roundCount = rNumber;
		Interface.setGameCount(roundCount);
		Interface.resetWestPanel();
		players = p;
		
		flags = FlagHandler.flagReset(roundCount);
		turns = new ArrayList<Turn>();
		turnCount = 0;
		Turn.turncount = 0;
		Interface.setTurnCount(turnCount);
		
		for(int i=0; i<playerCount; i++) {
			players.get(i).resetNumberPile();
		}
		
		// organizes players according to draw order
//		if(roundCount == 1) {
//			currentOrder = players;
//		}
//		else {
//			currentOrder = newOrder(currentOrder);
//		}
		
		Turn turn = new Turn(players, flags);
		
		for(int index=0; index<18; index++) {
			for(int i=0; i<playerCount; i++) {
				players.get(i).drawNumber();
				test = players.get(i).getHandtoString();
				System.out.println(test);
				
			}
			
		}
		
		
		for(int i = 0; i <4;i++) {
			System.out.println(players.get(i).getHandtoString());
		}
	}
	
	public String toString() {
		String g = "";
		
		for(int i = 0; i < flags.size(); i++) {
			g += flags.get(i).toString() + " - ";
		}
		
		
		return g;
	}
	public static ArrayList<Boolean> getFlags(){
		return flags;
	}
	
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
