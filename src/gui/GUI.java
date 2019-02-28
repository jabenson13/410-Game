package gui;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI extends JFrame {

	JFrame frmFrame;
	JPanel pnlPlayer, TITLE, pnlCount;
	Grid pnlGrid;
	JButton btnDraw, btnExit;
	JLabel lblPlayerName, lblPlayerHand[], lblAvailableNumbers[], lblWinCount, lblTITLE;
	int winCount = 0;
	int x, y;
	String title = "IYENGAR'S FOUR PLAYER GAME";
	Font f;
	Graphics graphics;
	BackgroundPanel titlePanel;
	
	public GUI(String player) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension scaledScreenSize = new Dimension(screenSize.width-100, screenSize.height-100);
		x = scaledScreenSize.width;
		y = scaledScreenSize.height;
		
		f = new Font("Sans Serif", Font.BOLD, 40);
		frmFrame = new JFrame("Numbers Game");
				
		//NORTH
		TITLE = new JPanel();
		TITLE.setLayout(new BorderLayout());
		TITLE.setPreferredSize(new Dimension(x, y/8));
		TITLE.setBackground(Color.GRAY);
		TITLE.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,Color.black));
		try {
			Image titleBackground = ImageIO.read(new File("background-title.png"));
			System.out.println("load image pls");
			titlePanel = new BackgroundPanel(titleBackground, 0);
			TITLE.setOpaque(true);
			titlePanel.setLayout(new BorderLayout());
			titlePanel.setPreferredSize(new Dimension(x, y/8));
			titlePanel.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//WEST PANEL
		pnlPlayer = new JPanel();
		pnlPlayer.setLayout(new BorderLayout());
		pnlPlayer.setPreferredSize(new Dimension(240, 350));
		pnlPlayer.setBackground(Color.GRAY);
		pnlPlayer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnDraw = new JButton("Draw Number");
		btnDraw.setPreferredSize(new Dimension(100, 50));		
		
		//EAST PANEL
		pnlCount = new JPanel();
		pnlCount.setLayout(new BorderLayout());
		pnlCount.setPreferredSize(new Dimension(240, 350));
		pnlCount.setBackground(Color.GRAY);
		pnlCount.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnExit = new JButton("Exit Game");
		btnExit.setPreferredSize(new Dimension(100, 50));
		
		//CENTER
		pnlGrid = new Grid(5,5);
		pnlGrid.setBackground(Color.GRAY);
		pnlGrid.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
				
		lblAvailableNumbers = new JLabel[20];
		
		for(int i = 0; i < lblAvailableNumbers.length; i++) {
			int z = i;
			int y = z + 1;
			String x = "" + y;
			lblAvailableNumbers[i] = new JLabel(x);
		}
		
		lblPlayerHand = new JLabel[20];
		
		lblWinCount = new JLabel();
		lblWinCount.setText("Win Count: " + winCount);
		lblWinCount.setFont(new Font("Sans Serif", Font.BOLD, 30));
		
		//NORTH ADD TO PANEL
		lblTITLE = new JLabel(title, SwingConstants.CENTER);
		lblTITLE.setFont(f);
		lblTITLE.setForeground(Color.WHITE);
		TITLE.add(lblTITLE, BorderLayout.CENTER);
		
		//WEST ADD TO PANEL
		lblPlayerName = new JLabel();
		lblPlayerName.setText(player);
		lblPlayerName.setFont(f);
		pnlPlayer.add(btnDraw, BorderLayout.SOUTH);
		pnlPlayer.add(lblPlayerName, BorderLayout.NORTH);
		
		for(int i = 0; i < lblAvailableNumbers.length; i++) {
			pnlPlayer.add(lblAvailableNumbers[i]);
		}
		//pnlPlayer.add(lblPlayerName, BorderLayout.WEST);
		
		//EAST ADD TO PANEL
		pnlCount.add(lblWinCount, BorderLayout.NORTH);
		pnlCount.add(btnExit, BorderLayout.SOUTH);
		
		//CENTER ADD TO PANEL
				
		//FRAME ADDING PANELS
		//frmFrame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\vw0542vb\\Documents\\410\\back.jpg")));
		frmFrame.setLayout(new BorderLayout());
		frmFrame.add(TITLE,BorderLayout.NORTH);
		frmFrame.add(titlePanel,BorderLayout.NORTH);
		titlePanel.add(lblTITLE, BorderLayout.CENTER);
		titlePanel.setBackground(Color.GRAY);
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
	
	public void updateGrid(String p1, String p2) {
		pnlGrid.updateGrid(p1, p2);
	}
	
	public void checkWin() {
		String message = pnlGrid.checkWin();
		
		if(!(message.equals(""))) {
			JOptionPane.showMessageDialog(pnlGrid, message);
			pnlGrid.reset();
			this.updateWinCount();
		}	
	}
	
	public void updateWinCount() {
		winCount++;
		lblWinCount.setText("Win Count: " + winCount);
	}
//	public void paintTitle (Graphics g) {
//		try {
//			Image titleBackground = ImageIO.read(new File("background-title.png"));
//			g.drawImage(titleBackground, TITLE.getX(), TITLE.getY(), null);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
