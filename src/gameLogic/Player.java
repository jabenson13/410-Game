package gameLogic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import gui.GUI;
import gui.Listener;

public class Player {
	
	int playerID;
	String playerName;
	ArrayList<Integer> drawnNumbers;
	ArrayList<Integer> nonDrawnNumbers;
	int handsize;
	int points;
	Listener myListener;
	ArrayList<GUI> guis;
	
	// constructor
	public Player(int pID, String name, int pts, Listener l, ArrayList<GUI> g) {
		
		playerID = pID;
		playerName = name;
		points = pts;
		guis = g;
		
		
		handsize = 0;
		resetNumberPile();
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
	
	public void rigidDrawNumber(int i) {
		int numberValue = i;
		
		drawnNumbers.add(numberValue);
		handsize++;
	}
	
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
}
