package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
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
	
	public GameOver(ArrayList<Player> players, Dimension dim, Point p) {
		int x = dim.width;
		int y = dim.height;
		
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
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
		GridBagConstraints c = new GridBagConstraints();
		pnlInfo.setLayout(new GridBagLayout());
		c.weightx = 1.0;
		c.insets = (new Insets (20,0,0,0));
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 0.0;
		f = new Font("Impact", Font.PLAIN, 40);
		
		lblTitle = new JLabel();
		lblTitle.setText("Game Over");
		
		lblWinner = new JLabel();
		lblWinner.setText("Winner: \t\t" + players.get(0).getName() + " - \t\t" + players.get(0).getPoints() + " points");
		
		lblSecond = new JLabel();
		lblSecond.setText("2nd place: \t\t" + players.get(1).getName() + " - \t\t" + players.get(1).getPoints() + " points");
		
		lblThird = new JLabel();
		lblThird.setText("3rd place: \t\t" + players.get(2).getName() + " - \t\t" + players.get(2).getPoints() + " points");
		
		lblFourth = new JLabel();
		lblFourth.setText("4th place: \t\t" + players.get(3).getName() + " - \t\t" + players.get(3).getPoints() + " points");
		
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
		
		pnlInfo.setBackground(Color.DARK_GRAY);
	
		c.insets = new Insets(20, 350, 10, 0);
		c.gridy = 0;
		pnlInfo.add(lblTitle, c); c.gridy++;
		c.insets = new Insets(20, 200, 0, 0);
		pnlInfo.add(lblWinner, c); c.gridy++;
		pnlInfo.add(lblSecond, c); c.gridy++;
		pnlInfo.add(lblThird, c); c.gridy++;
		pnlInfo.add(lblFourth, c); c.gridy++;
		
		
		titlePanel.setBackground(Color.DARK_GRAY);
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(pnlInfo, BorderLayout.CENTER);
		titlePanel.setLocation(p);
		
		this.setPreferredSize(dim);
		this.pack();
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
