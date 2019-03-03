package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;

import gameLogic.Game;

public class Interface {
	static ArrayList<GUI> guis = Game.getGUIs();
	
	public static void updateGUIFlags(int p1, int p2) {
		Grid.updateGrid(p1, p2);
	}
	public static void resetGrid() {
		System.out.println("reset baby ##################################");
		Grid.reset();
	}
	public static void resetWestPanel() {
		for(int j=0; j<guis.size(); j++) {
			for(int i = 1; i <= 20; i++) {
				String output = Integer.toString(i);
				guis.get(j).digits[i-1].setBackground(Color.WHITE);
				guis.get(j).digits[i-1].setText(output);
				guis.get(j).digits[i-1].setFont(new Font("Sans Serif", Font.PLAIN, 20));
				guis.get(j).digits[i-1].setMargin(new Insets(1,1,1,1));
				guis.get(j).digits[i-1].setEnabled(false);
			}
		}
	}
	public static void setTurnCount(int turncount) {
		for(int i=0; i<guis.size(); i++) {
			guis.get(i).lblTurnCount.setText("Turn Count: " + Integer.toString(turncount));
		}
	}
	public static void setGameCount(int roundcount) {
		for(int i=0; i<guis.size(); i++) {
			guis.get(i).lblGameCount.setText("Game Count: " + Integer.toString(roundcount));
		}
	}
	public static void updatePoints(ArrayList<Integer> points) {
		for(int i=0; i<guis.size(); i++) {
			guis.get(i).p1points.setText("Player 1: " + points.get(0));
			guis.get(i).p2points.setText("Player 2: " + points.get(1));
			guis.get(i).p3points.setText("Player 3: " + points.get(2));
			guis.get(i).p4points.setText("Player 4: " + points.get(3));
			
		}
	}
	public static void updateTurnIndicator(int pID) {
		int player = 0;
		switch(pID) {
		case 1: 
			player = 2; break;
		case 2:
			player = 3; break;
		case 3:
			player = 4; break;
		case 4:
			player = 1; break;
		}	
		for(int i=0; i<guis.size(); i++) {
			guis.get(i).turnIndicator.setText("It is currently Player " + player + "'s turn!");
		}
	}
	public static void updateDrawButton(int pID) {
		int player = 0;
		switch(pID) {
		case 1: 
			player = 2; break;
		case 2:
			player = 3; break;
		case 3:
			player = 4; break;
		case 4:
			player = 1; break;
		}	
		for(int i=0; i<guis.size(); i++) {
			if (i + 1 == player) {
				guis.get(i).btnDraw.setEnabled(true);
			}
			else {
				guis.get(i).btnDraw.setEnabled(false);
			}
		}
	}
	
}
