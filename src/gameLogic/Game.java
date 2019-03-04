package gameLogic;
import java.util.ArrayList;

import gui.GUI;
import gui.Interface;
import gui.Listener;

public class Game {
	
	int gameID;
	int playerCount;
	ArrayList<Boolean> flags;
	Player p1, p2, p3, p4;
	static ArrayList<Player> players;
	static ArrayList<Round> rounds;
	static ArrayList<Integer> points = new ArrayList<Integer>();
	static int roundCount = 0;
	static int maxRounds = 10;
	Listener list;
	static ArrayList<GUI> guis = new ArrayList<GUI>();
	
	// constructor
	public Game(int gID, int pCount) {
		gameID = gID;
		playerCount = pCount;
	
	}
	public void initializeGame() {
		// initialize Player
		players = new ArrayList<Player>();
		list = new Listener();
		
		// Adds Player 1 - ID, Name, Pts, Wins, Listener, GUI list
		p1 = new Player(1, null, 0, 0, list, guis); // the name would be given from the initial start by the GUI - done later
		players.add(p1);
		guis.add(new GUI("Player " + 1));
		guis.get(0).setListener(list);
		list.setGUI(guis.get(0));
		
		// Adds Player 2
		p2 = new Player(2, null, 0, 0, list, guis);
		players.add(p2);
		guis.add(new GUI("Player " + 2));
		guis.get(1).setListener(list);
		list.setGUI(guis.get(1));
		
		// Adds Player 3
		p3 = new Player(3, null, 0, 0, list, guis);
		players.add(p3);
		guis.add(new GUI("Player " + 3));
		guis.get(2).setListener(list);
		list.setGUI(guis.get(2));
		
		// Adds Player 4
		p4 = new Player(4, null, 0, 0, list, guis);
		players.add(p4);
		guis.add(new GUI("Player " + 4));
		guis.get(3).setListener(list);
		list.setGUI(guis.get(3));
		
		// Implements ArrayList for the points
		for(int i=0; i<players.size(); i++) {
			points.add(players.get(i).points);
		}
		
		// calls method newRound
		newRound();
	}
	
	// Begins a new round of the game
	public static void newRound () {
		roundCount++;
		Interface.updatePoints(points);
		Round round = new Round(roundCount, players);
	}
	
	// Returns to the ArrayList of players
	public static ArrayList<Player> getPlayers(){
		return players;
	}
	
	// Simple boolean check to see if the game is done
	public static boolean isGameDone() { 
		if(roundCount == 2) { 
			// if incrementing round count = max rounds (10) .. return true
			return true;
		}
		else { 
			// else return false
			return false;
		}
	}
	
	// Sets the points in the player information through the ArrayList pts
	public static void setPoints(ArrayList<Integer> pts) {
		for(int i=0; i<players.size(); i++) {
			players.get(i).points = pts.get(i);
		}
	}
	
	// Returns points based on the points in player info
	public static ArrayList<Integer> getPoints(){
		for(int i=0; i<players.size(); i++) {
			points.set(i, players.get(i).points);
		}
		return points;
	}
	
	// Returns the GUIs
	public static ArrayList<GUI> getGUIs(){
		return guis;
	}
}