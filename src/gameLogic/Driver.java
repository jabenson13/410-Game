package gameLogic;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gui.GUI;
import gui.Listener;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Player p1 = new Player(0, null, 0);
//		Player p2 = new Player(0, null, 0);
//		
//		p1.resetNumberPile();
//		for(int i=0; i<20; i++) {
//			p1.drawNumber();
//			System.out.println(p1.drawnNumbers.get(i));
//		}
//		System.out.println("");
//		p2.resetNumberPile();
//		for(int i=0; i<20; i++) {
//			p2.drawNumber();
//			System.out.println(p2.drawnNumbers.get(i));
//		}
//		test
//		ArrayList<Boolean> test = new ArrayList<Boolean>();
//		test = SubsetFinder.isSubset(p1, p2, test);
		
		
		
		Game g1 = new Game(1, 4);
		g1.initializeGame();
		
		
	}

}
