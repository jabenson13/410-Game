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
		
		p1 = new Player(1, null, 0, list, guis); // the name would be given from the initial start by the GUI - done later
		players.add(p1);
		guis.add(new GUI("Player " + 1));
		
		guis.get(0).setListener(list);
		list.setGUI(guis.get(0));
		
		System.out.println(guis.size());
		p2 = new Player(2, null, 0, list, guis);
		players.add(p2);
		guis.add(new GUI("Player " + 2));
		
		guis.get(1).setListener(list);
		list.setGUI(guis.get(1));
		p3 = new Player(3, null, 0, list, guis);
		players.add(p3);
		guis.add(new GUI("Player " + 3));
		
		guis.get(2).setListener(list);
		list.setGUI(guis.get(2));
		
		System.out.println(guis.size());
		p4 = new Player(4, null, 0, list, guis);
		players.add(p4);
		guis.add(new GUI("Player " + 4));
		
		guis.get(3).setListener(list);
		list.setGUI(guis.get(3));
		
		System.out.println(guis.size());
		
		System.out.println(players.size());
		for(int i=0; i<players.size(); i++) {
			points.add(0);
		}
		
		newRound();
	}
	public static void newRound () {
		roundCount++;
		Interface.updatePoints(points);
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
	public static void setPoints(ArrayList<Integer> pts) {
		points = pts;
	}
	public static ArrayList<Integer> getPoints(){
		return points;
	}
	public static ArrayList<GUI> getGUIs(){
		return guis;
	}
}