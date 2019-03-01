package gui;

import java.util.ArrayList;

public class Interface {
	public static void updateGUIFlags(int p1, int p2) {
		Grid.updateGrid(p1, p2);
	}
	public static void resetGrid() {
		System.out.println("reset baby ##################################");
		Grid.reset();
	}
}
