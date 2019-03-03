package gameLogic;

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
}
