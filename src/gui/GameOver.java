package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameLogic.Player;

public class GameOver extends JFrame {

	BackgroundPanel titlePanel;
	JPanel pnlInfo;
	JLabel lblTitle, lblWinner, lblSecond, lblThird, lblFourth;
	Font f;
	int player1, player2, player3, player4;
	
	public GameOver(ArrayList<Player> players, Dimension dim) {
		int x = dim.width;
		int y = dim.height;
		
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
		
		pnlInfo = new JPanel();
		
		f = new Font("Impact", Font.PLAIN, 40);
		
		lblTitle = new JLabel();
		lblTitle.setText("Game Over");
		
		lblWinner = new JLabel();
		lblWinner.setText("Winner: " + players.get(0).getName() + " with " + players.get(0).getPoints());
		
		lblSecond = new JLabel();
		lblSecond.setText("2nd place: " + players.get(1).getName() + " with " + players.get(1).getPoints());
		
		lblThird = new JLabel();
		lblThird.setText("3rd Place: " + players.get(2).getName() + " with " + players.get(2).getPoints());
		
		lblFourth = new JLabel();
		lblFourth.setText("4th Place: " + players.get(3).getName() + " with " + players.get(3).getPoints());
		
		lblTitle.setFont(f);
		lblTitle.setForeground(Color.WHITE);
		
		lblWinner.setFont(f);
		lblWinner.setForeground(Color.WHITE);
		
		lblSecond.setFont(f);
		lblSecond.setForeground(Color.WHITE);
		
		lblThird.setFont(f);
		lblThird.setForeground(Color.WHITE);
		
		lblFourth.setFont(f);
		lblFourth.setForeground(Color.WHITE);
		
		pnlInfo.setLayout( new BoxLayout(pnlInfo, 0));
		pnlInfo.setBackground(Color.DARK_GRAY);
		
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.CENTER_ALIGNMENT);
		box.add(lblTitle);
		box.add(lblWinner);
		box.add(lblSecond);
		box.add(lblThird);
		box.add(lblFourth);
		
		pnlInfo.add(box, BorderLayout.CENTER);
		
		titlePanel.setBackground(Color.DARK_GRAY);
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(pnlInfo, BorderLayout.CENTER);
		
		this.setPreferredSize(dim);
		this.pack();
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
