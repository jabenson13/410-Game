package gameLogic;
import java.util.ArrayList;

public class Game {
	
	int gameID;
	int playerCount;
	ArrayList<Boolean> flags;
	Player p1, p2, p3, p4;
	static ArrayList<Player> players;
	static ArrayList<Round> rounds;
	static int roundCount = 0;
	
	// constructor
	public Game(int gID, int pCount) {
		gameID = gID;
		playerCount = pCount;
	
	}
	public void initializeGame() {
		// initialize Player
		players = new ArrayList<Player>();
		
		p1 = new Player(1, null, 0); // the name would be given from the initial start by the GUI - done later
		players.add(p1);
		p2 = new Player(2, null, 0);
		players.add(p2);
		p3 = new Player(3, null, 0);
		players.add(p3);
		p4 = new Player(4, null, 0);
		players.add(p4);
		
		newRound();
	}
	public static void newRound () {
		roundCount++;
		Round round = new Round(roundCount, players);
		//rounds.add(round);
	}
	public static ArrayList<Player> getPlayers(){
		return players;
	}
	public static boolean isGameDone() {
		if(roundCount == 10) {
			return true;
		}
		else {
			return false;
		}
	}
}