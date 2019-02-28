package gameLogic;
import java.util.ArrayList;

public class Turn {
	static ArrayList<Player> players;
	static ArrayList<Boolean> flags;
	static int turncount = 0;
	
	public Turn(ArrayList<Player> p, ArrayList<Boolean> f) {
		players = p;
		flags = f;
		turncount++;	

		Play.setIndex(0);
		Play play = new Play(players.get(0), players.size(), turncount, flags, players, 0);
	}
	
	public static void turnSequence(int pc) {
		Play play = new Play(players.get(pc), players.size(), turncount, flags, players, 0);
	}
	
	
}
