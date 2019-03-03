package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gameLogic.Player;

public class gameOver extends JFrame {

	JLabel lblTitle, lblWinner, lblSecond, lblThird, lblFourth;
	Font f;
	
	public gameOver(ArrayList<Player> players, Dimension dim) {
		f = new Font("Impact", Font.PLAIN, 40);
		
		lblTitle = new JLabel();
		lblTitle.setText("Game Over");
		
		/*
		 * need to sort the array list from least amount of points to the most
		 * in order to set the text of the labels ranking the players
		 */
		
		lblWinner = new JLabel();
		
		
		lblSecond = new JLabel();
		
		
		lblThird = new JLabel();
		
		
		lblFourth = new JLabel();
		
		
		lblTitle.setFont(f);
		lblWinner.setFont(f);
		lblSecond.setFont(f);
		lblThird.setFont(f);
		lblFourth.setFont(f);
		
		this.add(lblTitle);
		this.add(lblWinner);
		this.add(lblSecond);
		this.add(lblThird);
		this.add(lblFourth);
		
		this.setPreferredSize(dim);
		this.pack();
		this.setVisible(true);
	}
}
