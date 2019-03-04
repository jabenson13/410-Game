package gameLogic;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gui.GUI;
import gui.Listener;

public class Driver {
	public static void main(String[] args) {
		Game g1 = new Game(1, 4);
		g1.initializeGame();
	}
}
