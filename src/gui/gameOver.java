package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameLogic.Player;

public class gameOver extends JFrame {

	BackgroundPanel titlePanel;
	JLabel lblTitle, lblWinner, lblSecond, lblThird, lblFourth;
	Font f;
	
	public gameOver(ArrayList<Player> players, Dimension dim) {
		int x = dim.width;
		
		try {
			Image titleBackground = ImageIO.read(new File("Assets/TitleCard.png"));
			titlePanel = new BackgroundPanel(titleBackground, 0);
			titlePanel.setLayout(new BorderLayout());
			titlePanel.setPreferredSize(new Dimension(x, 500));
			titlePanel.setVisible(true);
			titlePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLACK));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		f = new Font("Impact", Font.PLAIN, 40);
		
		lblTitle = new JLabel();
		lblTitle.setText("Game Over");
		
		lblWinner = new JLabel();
		lblWinner.setText(players.get(0).getName());
		
		lblSecond = new JLabel();
		lblSecond.setText(players.get(1).getName());
		
		lblThird = new JLabel();
		lblThird.setText(players.get(2).getName());
		
		lblFourth = new JLabel();
		lblFourth.setText(players.get(3).getName());
		
		lblTitle.setFont(f);
		lblWinner.setFont(f);
		lblSecond.setFont(f);
		lblThird.setFont(f);
		lblFourth.setFont(f);
		
		this.add(titlePanel);
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
