package gameLogic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import gui.GUI;
import gui.Listener;


// Luke and Tyler
public class Player {
	
	int playerID;
	String playerName;
	ArrayList<Integer> drawnNumbers;
	ArrayList<Integer> nonDrawnNumbers;
	int handsize;
	int points; int wins;
	Listener myListener;
	ArrayList<GUI> guis;
	
	// constructor
	public Player(int pID, String name, int pts, int w, Listener l, ArrayList<GUI> g) {
		
		playerID = pID; // a player is defined by their player ID
		playerName = name; // not implemented currently, but potential option for a player to set their name
		points = pts; // tracks a players points
		guis = g; // each player has a unique GUI
		wins = w; // tracks a players wins
		
		handsize = 0; // a player begins with no cards in their hand
		resetNumberPile(); // resets the player's hand
	}
	
	// setters and getters
	public void setPlayerName (String name) {
		playerName = name;
	}
	
	// set nonDrawnNumbers (reset)
	public void resetNumberPile () {
		nonDrawnNumbers = new ArrayList<Integer>();
		drawnNumbers = new ArrayList<Integer>();
		int number = 1;
		
		for(int i=0; i<20; i++) {
			nonDrawnNumbers.add(number);
			number++;
		}
	}
	
	// A player has two ArrayLists of numbers:
	// Drawn numbers and non drawn numbers
	// A player draws a number by popping a number from the non drawn numbers by a random index
	// and then pushing that onto the drawn numbers ArrayList
	public void drawNumber() {
		Random randomNumber = new Random();
		int indexDraw = -1;
		int numberValue = 0;
		
		indexDraw = randomNumber.nextInt(nonDrawnNumbers.size());
		numberValue = nonDrawnNumbers.get(indexDraw);
		nonDrawnNumbers.remove(indexDraw);
		drawnNumbers.add(numberValue);
		handsize++;
		
		guis.get(playerID - 1).updateNumbers(numberValue);
		
		System.out.println(numberValue + " has been drawn!");
		
	}
	
	// fixes a player's draw for a certain number - used for bug testing
	public void rigidDrawNumber(int i) {
		int numberValue = i;
		
		drawnNumbers.add(numberValue);
		handsize++;
	}
	
	// toString for the player's hand
	public String getHandtoString() {
		int[] test = new int[drawnNumbers.size()];
		
		for(int i=0; i<drawnNumbers.size(); i++) {
			test[i] = drawnNumbers.get(i);
		}
		Arrays.sort(test);
		
		String output = "";
		
		for(int i=0; i<drawnNumbers.size(); i++) {
			output+=test[i] + " ";        
			
		}
		
		return output;
	}
	
	// self explanatory: get Name
	public String getName() {
		return playerName;
	}
	public int getPoints() { // get points
		return points;
	}
	public void incrementWins() { // increment wins
		wins++;
	}
}
