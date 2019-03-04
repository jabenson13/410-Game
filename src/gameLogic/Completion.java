package gameLogic;
import gui.GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Completion {
	public static ArrayList<Integer> pointUpdate (int pID, int turnCount, ArrayList<Integer> currentPts) {
		for(int i=0; i<currentPts.size(); i++) {
			if (i == (pID - 1)) {
				currentPts.set(i, currentPts.get(i) + turnCount);
			}
			else {
				currentPts.set(i, currentPts.get(i) + 10);
			}
		}
		
		return currentPts;
	}
	
	public static void gameOver(ArrayList<Player> p) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension scaledScreenSize = new Dimension(screenSize.width / 2,screenSize.height / 2); 
		
		ArrayList<Player> sortedPlayers = new ArrayList<Player>();
		Player[] temp = new Player[4];
		
		for(int i = 0; i < p.size(); i++) {
			temp[i] = p.get(i);
		}
		
		for (int i = 0; i < temp.length; i++) {
		    for (int j = 0; j < temp.length; j++) {
		        if (temp[i].getPoints() > temp[j].getPoints()) {
		            Player tmp = temp[i];
		            temp[i] = temp[j];
		            temp[j] = tmp;
		        }
		    }
		}
		
		for(int i = 0; i < temp.length; i++) {
			sortedPlayers.add(temp[i]);
		}
		
		gui.GameOver finalScores = new gui.GameOver(sortedPlayers, scaledScreenSize);
	}
}
