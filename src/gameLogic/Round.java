package gameLogic;
import java.util.ArrayList;

public class Round {
	int gameID;
	int playerCount;
	int roundCount;
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
		players = p;
		
		flags = FlagHandler.flagReset(roundCount);
		turns = new ArrayList<Turn>();
		turnCount = 0;
		
		for(int i=0; i<playerCount; i++) {
			players.get(i).resetNumberPile();
		}
		
		// organizes players according to draw order
		
		Turn turn = new Turn(players, flags);
		
		for(int index=0; index<4; index++) {
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
	
	
}
