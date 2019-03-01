package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import gameLogic.FlagHandler;
import gameLogic.Game;
import gameLogic.Play;
import gameLogic.Player;
import gameLogic.Round;
import gameLogic.Turn;

public class Listener implements ActionListener {
	int index = 0;
	ArrayList<Player> players = Game.getPlayers();
	ArrayList<Boolean> flags;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clicked = (JButton) e.getSource();
		
		
		if(clicked.getText().equals("Draw Number")) {
			flags = Play.getFlags();
			index = Play.makePlay();
			System.out.println("index is " + index);
			boolean check = FlagHandler.isRoundDone(flags);
			if (check == true) {
				boolean test = Game.isGameDone();
				
				System.out.println("!!!!!!!!!!!");
				if(test == false) {
					Game.newRound();
				}
			}
			if(index == 4) {
				Turn turn = new Turn(players, flags);
				FlagHandler.flagsToString(flags);
			}
			else {
				Turn.turnSequence(index);
			}
		}
		else if(clicked.getText().equals("Exit Game")) {
			System.exit(0);
		}
	}

	GUI g;
	public void setGUI(GUI myGUI) {
		// TODO Auto-generated method stub
		g = myGUI;
	}

}
