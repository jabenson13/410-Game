package gui;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI extends JFrame {

	JFrame frmFrame;
	JPanel pnlPlayer, TITLE, pnlCount;
	static JPanel numbers;
	Grid pnlGrid;
	JButton btnDraw, btnExit;
	JLabel lblPlayerName, lblPointsTitle, p1points, p2points, p3points, p4points, turnIndicator,
		lblMiscInfo, lblPlayerHand[], lblWinCount, lblTITLE, lblTurnCount, lblGameCount;
	int winCount = 0;
	int x, y;
	ArrayList<JLabel> labelList;
	String playerName;
	Font f;
	Font buttons;
	Font buttonsBold;
	Graphics graphics;
	BackgroundPanel titlePanel;
	JButton[] digits = new JButton[20];
	
	public GUI(String player) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension scaledScreenSize = new Dimension(screenSize.width / 2,screenSize.height / 2); // 640x480
		x = scaledScreenSize.width; // generally speaking, this will be 640
		y = scaledScreenSize.height; // generally, this will be 480
		
		f = new Font("Impact", Font.PLAIN, 40);
		buttons = new Font("Impact", Font.PLAIN, 20);
		buttonsBold = new Font("Impact", Font.PLAIN, 25);
		frmFrame = new JFrame("Numbers Game");
				
		//NORTH
		TITLE = new JPanel();
		TITLE.setLayout(new BorderLayout());
		TITLE.setPreferredSize(new Dimension(x, 96));
		TITLE.setSize(x, 96);
		TITLE.setBackground(Color.darkGray);
		TITLE.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0,Color.black));
		try {
			Image titleBackground = ImageIO.read(new File("Assets/TitleCard.png"));
			titlePanel = new BackgroundPanel(titleBackground, 0);
			TITLE.setVisible(false);
			titlePanel.setLayout(new BorderLayout());
			titlePanel.setPreferredSize(new Dimension(x, 500));
			titlePanel.setVisible(true);
			titlePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLACK));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//WEST PANEL
		pnlPlayer = new JPanel();
		pnlPlayer.setPreferredSize(new Dimension((x / 4), (y / 5) * 4));
		GridBagConstraints c = new GridBagConstraints();
		pnlPlayer.setLayout(new GridBagLayout());
		pnlPlayer.setBackground(Color.darkGray);	
		pnlPlayer.setForeground(Color.WHITE);
		pnlPlayer.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 0));
		
		//WEST PANEL CONTENTS
		int rowheight = (pnlPlayer.getHeight() / 8);
		btnDraw = new JButton("Draw Number");
		btnDraw.setPreferredSize(new Dimension((1/4)*x, 2*rowheight));	
		
		lblPlayerName = new JLabel();
		lblPlayerName.setForeground(Color.WHITE);
		pnlPlayer.add(lblPlayerName);
		lblPlayerName.setText(player);
		lblPlayerName.setFont(f);
		lblMiscInfo = new JLabel();
		lblMiscInfo.setText("Your Numbers: ");
		lblMiscInfo.setForeground(Color.WHITE);
		lblMiscInfo.setFont(buttons);
		
		c.weightx = 1.0;
		c.insets = (new Insets (20,0,0,0));
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 0.0;
		pnlPlayer.add(lblPlayerName,c);
		c.insets = new Insets(0,0,0,0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 0.0;
		c.insets = new Insets(10, 0, 10, 0);
		pnlPlayer.add(lblMiscInfo,c);
		c.insets = new Insets(0, 0, 0, 0);
		
		labelList = this.ButtonGenerator();
		numbers = new JPanel();
		JLabel temp = new JLabel();
		numbers.setLayout(new GridLayout(4, 5));
		numbers.setPreferredSize(new Dimension((x / 4), 1000));
		String output = "";
		
		for(int i = 1; i <= 20; i++) {
			digits[i-1] = new JButton();
			output = Integer.toString(i);
			digits[i-1].setBackground(Color.WHITE);
			digits[i-1].setText(output);
			digits[i-1].setFont(buttons);
			digits[i-1].setMargin(new Insets(1,1,1,1));
			digits[i-1].setEnabled(false);
			digits[i-1].setPreferredSize(new Dimension(numbers.getWidth() / 5, numbers.getHeight() / 4));
			numbers.add(digits[i-1]);
		}
		c.gridx = 0;
		c.gridy = 2;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.BOTH;
		pnlPlayer.add(numbers,c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 0.5;
		pnlPlayer.add(btnDraw,c);
		
		
		//EAST PANEL
		pnlCount = new JPanel();
		pnlCount.setPreferredSize(new Dimension((x / 4), (y / 5) * 4));
		c = new GridBagConstraints();
		pnlCount.setLayout(new GridBagLayout());
		pnlCount.setBackground(Color.darkGray);	
		
		//EAST PANEL CONTENTS
		btnExit = new JButton("Exit Game");
		btnExit.setPreferredSize(new Dimension((1/4)*x, 2*rowheight));	
		
		//need to add the values for these that we will show the user.
		lblTurnCount = new JLabel();
		c.weightx = 1.0;
		c.insets = (new Insets (0,0,0,0));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 0.0;
		
		Font impact = new Font("Impact", Font.PLAIN, 20);
		
		lblTurnCount.setText("Turn Count: ");
		lblTurnCount.setFont(impact);
		
		lblGameCount = new JLabel();
		lblGameCount.setText("Game Count: ");
		lblGameCount.setFont(impact);
		
		lblWinCount = new JLabel();
		lblWinCount.setText("Win Count: " + winCount);
		lblWinCount.setFont(impact);
		
		lblPointsTitle = new JLabel();
		lblPointsTitle.setText("Current Points: ");
		lblPointsTitle.setFont(impact);
		
		p1points = new JLabel();
		p1points.setText("Player 1: 0");
		p1points.setFont(impact);
		
		p2points = new JLabel();
		p2points.setText("Player 2: 0");
		p2points.setFont(impact);
		
		p3points = new JLabel();
		p3points.setText("Player 3: 0");
		p3points.setFont(impact);
		
		p4points = new JLabel();
		p4points.setText("Player 4: 0");
		p4points.setFont(impact);
		
		turnIndicator = new JLabel();
		turnIndicator.setText("It is currently " + "Player 1" + "'s turn!");
		turnIndicator.setFont(new Font("Impact", Font.PLAIN, 14));
		
		lblTurnCount.setForeground(Color.WHITE);
		lblGameCount.setForeground(Color.WHITE);
		lblWinCount.setForeground(Color.WHITE);
		lblPointsTitle.setForeground(Color.WHITE);
		p1points.setForeground(Color.WHITE);
		p2points.setForeground(Color.WHITE);
		p3points.setForeground(Color.WHITE);
		p4points.setForeground(Color.WHITE);
		turnIndicator.setForeground(Color.WHITE);
		
		c.insets = new Insets(20,5,0,0);
		pnlCount.add(lblTurnCount,c);
		c.gridy = 1;
		c.insets = new Insets(0,5,0,0);
		pnlCount.add(lblGameCount,c);
		c.gridy = 2;
		pnlCount.add(lblWinCount,c);
		c.gridy = 3;
		c.insets = new Insets(30,5,0,0);
		pnlCount.add(lblPointsTitle,c);
		c.gridy = 4;
		c.insets = new Insets(0,5,0,0);
		pnlCount.add(p1points,c);
		c.gridy++;
		pnlCount.add(p2points,c);
		c.gridy++;
		pnlCount.add(p3points,c);
		c.gridy++;
		pnlCount.add(p4points,c);
		c.gridy++;
		c.insets = new Insets(30,5,0,0);
		pnlCount.add(turnIndicator,c);
		c.gridy++;
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 0.5;
		c.insets = new Insets(30,0,0,0);
		pnlCount.add(btnExit,c);
		pnlCount.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 5));
		
		
		//CENTER
		try {
			pnlGrid = new Grid(5,5);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pnlGrid.setBackground(Color.BLACK);
		pnlGrid.setPreferredSize(new Dimension((x / 2), (y / 5) * 4));
		//pnlGrid.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
				
		lblPlayerHand = new JLabel[20];
		
		//NORTH ADD TO PANEL
		lblTITLE = new JLabel("", SwingConstants.CENTER);
		lblTITLE.setFont(f);
		lblTITLE.setForeground(Color.WHITE);
		TITLE.add(lblTITLE, BorderLayout.CENTER);
		

		/*
		 *  ADDING PANELS TO DISPLAY w/ BORDERLAYOUT
		 *  					TITLEPANEL - NORTH
		 * PNLPLAYER - WEST		PNLGRID - CENTER			PNLCOUNT - EAST
		 *  
		 */
		
		frmFrame.setLayout(new BorderLayout());
		frmFrame.add(TITLE,BorderLayout.NORTH);
		frmFrame.add(titlePanel,BorderLayout.NORTH);
			titlePanel.add(lblTITLE, BorderLayout.CENTER);
			titlePanel.setBackground(Color.darkGray);
			titlePanel.setForeground(Color.WHITE);
		frmFrame.add(pnlPlayer, BorderLayout.WEST);
		frmFrame.add(pnlGrid, BorderLayout.CENTER);
		frmFrame.add(pnlCount,BorderLayout.EAST);	
		
		frmFrame.setBounds(0, 0, screenSize.width, screenSize.height);
		frmFrame.setPreferredSize(scaledScreenSize);
		
		frmFrame.pack();
		frmFrame.setVisible(true);
		
		frmFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	Listener l;
	public void setListener(Listener myListener) {
		// TODO Auto-generated method stub
		l = myListener;
		
		btnDraw.addActionListener(l);
		btnExit.addActionListener(l);
	}
	
	public void checkWin() { // Checks the win condition
		String message = pnlGrid.checkWin();
		
		if(!(message.equals(""))) {
			JOptionPane.showMessageDialog(pnlGrid, message);
			pnlGrid.reset();
			this.updateWinCount();
		}	
	}
	
	public void updateWinCount() { // incremeents the win counter
		winCount++;
		lblWinCount.setText("Win Count: " + winCount);
	}
	
	public ArrayList <JLabel> ButtonGenerator(){
		
		ArrayList<JLabel> labelList1 = new ArrayList<JLabel>();
		
		for(int i = 1; i < 21; i++) {
			
			String temp = "" + i;
			JLabel button = new JLabel(temp);
			
			labelList1.add(button);
			
		}	
		return labelList1;
	}
	
	public void updateNumbers(int i) {
		digits[i-1].setBackground(Color.GREEN);
		digits[i-1].setFont(buttonsBold);
	}
	
	public Point getLoc() {
		Point loc = getLocation();
		return loc;
	}
	
}
