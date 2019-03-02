package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Grid extends JPanel{
	
	static Image defaultTile; static Image greenTile; static Image redTile;
	static Image P1DarkTile, P2DarkTile, P3DarkTile, P4DarkTile;
	int columns;
	int rows;
	static BackgroundPanel[][] cells = new BackgroundPanel[5][5];
	static final int bord = 1;
	static LineBorder Border = new LineBorder(Color.BLACK,bord);
	Font f = new Font("Sans Serif", Font.BOLD, 100);
	static Font g = new Font("Times New Roman", Font.BOLD, 125);
	
	public Grid(int col, int row) throws IOException {		
		defaultTile = ImageIO.read(new File("Assets/DarkTile.png"));
		greenTile = ImageIO.read(new File("Assets/DarkTileGreenDot.png"));
		redTile = ImageIO.read(new File("Assets/DarkTileRedDot.png"));
		P1DarkTile = ImageIO.read(new File("Assets/P1DarkTile.png"));
		P2DarkTile = ImageIO.read(new File("Assets/P2DarkTile.png"));
		P3DarkTile = ImageIO.read(new File("Assets/P3DarkTile.png"));
		P4DarkTile = ImageIO.read(new File("Assets/P4DarkTile.png"));

		
		columns = col;
		rows = row;
		setLayout(new GridLayout(columns, rows));
				
		for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cells[i][j] = new BackgroundPanel(redTile) {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(20, 20);
                    }
                };
                //cells[i][j].setEditable(false);
                
                if(i == 0 && j == 0) {
                	cells[i][j].setImage(defaultTile);
                }
                else if(i == 0) {
                	String playerName = "Player " + j;
                	//cells[i][j].setText(playerName);
                	switch (j) {
                		case 1: cells[i][j].setImage(P1DarkTile); break;
                		case 2: cells[i][j].setImage(P2DarkTile); break;
                		case 3: cells[i][j].setImage(P3DarkTile); break;
                		case 4: cells[i][j].setImage(P4DarkTile); break;
                	}
                }
                else if(j == 0) {
                	String playerName = "Player " + i;
                	//cells[i][j].setText(playerName);
                	switch (i) {
	            		case 1: cells[i][j].setImage(P1DarkTile); break;
	            		case 2: cells[i][j].setImage(P2DarkTile); break;
	            		case 3: cells[i][j].setImage(P3DarkTile); break;
	            		case 4: cells[i][j].setImage(P4DarkTile); break;
                	}
                }
                else if(i == 1 && j == 1) {
                	//cells[i][j].setText(".");
                	cells[i][j].setImage(greenTile);
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                }
                else if(i == 2 && j == 2) {
                	//cells[i][j].setText(".");
                	cells[i][j].setImage(greenTile);
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                }
                else if(i == 3 && j == 3) {
                	//cells[i][j].setText(".");
                	cells[i][j].setImage(greenTile);
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                }
                else if(i == 4 && j == 4) {
                	//cells[i][j].setText(".");
                	cells[i][j].setImage(greenTile);
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                }
                else {
                	//cells[i][j].setText(".");
                	cells[i][j].setImage(redTile);
                	cells[i][j].setFont(g);
                	cells[i][j].setForeground(Color.RED);
                }
                cells[i][j].setPreferredSize(new Dimension(50, 50));
                //cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                cells[i][j].setFocusTraversalKeysEnabled(false);
                cells[i][j].setBorder(Border);
                add(cells[i][j]);
            }
        }
	}
	public static void updateGrid(int p1, int p2) {
		cells[p1][p2].setImage(greenTile);

	}
	public String checkWin() {
		// TODO Auto-generated method stub
		String win = "";
		
		if(cells[1][1].getForeground().equals(Color.GREEN) && cells[1][2].getForeground().equals(Color.GREEN) && cells[1][3].getForeground().equals(Color.GREEN) && cells[1][4].getForeground().equals(Color.GREEN)) {
			win = "Player 1 wins!";
		}
		else if(cells[2][1].getForeground().equals(Color.GREEN) && cells[2][2].getForeground().equals(Color.GREEN) && cells[2][3].getForeground().equals(Color.GREEN) && cells[2][4].getForeground().equals(Color.GREEN)) {
			win = "Player 2 wins!";
		}
		else if(cells[3][1].getForeground().equals(Color.GREEN) && cells[3][2].getForeground().equals(Color.GREEN) && cells[3][3].getForeground().equals(Color.GREEN) && cells[3][4].getForeground().equals(Color.GREEN)) {
			win = "Player 3 wins!";
		}
		else if(cells[4][1].getForeground().equals(Color.GREEN) && cells[4][2].getForeground().equals(Color.GREEN) && cells[4][3].getForeground().equals(Color.GREEN) && cells[4][4].getForeground().equals(Color.GREEN)) {
			win = "Player 4 wins!";
		}
		
		return win;
	}
	
	public static void reset() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				
//				cells[i][j] = new JTextField() {
//                    @Override
//                    public Dimension getPreferredSize() {
//                        return new Dimension(20, 20);
//                    }
//                };
//                cells[i][j].setEditable(false);
				
				if(i == 0 && j == 0) {
                	//cells[i][j].setText("");
					cells[i][j].setImage(defaultTile);
                }
                else if(i == 0) {
                	switch (j) {
	            		case 1: cells[i][j].setImage(P1DarkTile); break;
	            		case 2: cells[i][j].setImage(P2DarkTile); break;
	            		case 3: cells[i][j].setImage(P3DarkTile); break;
	            		case 4: cells[i][j].setImage(P4DarkTile); break;
                	}
                }
                else if(j == 0) {
                	switch (i) {
            			case 1: cells[i][j].setImage(P1DarkTile); break;
            			case 2: cells[i][j].setImage(P2DarkTile); break;
            			case 3: cells[i][j].setImage(P3DarkTile); break;
            			case 4: cells[i][j].setImage(P4DarkTile); break;
                	}                
                }
                else if(i == 1 && j == 1) {
                	//cells[i][j].setText(".");
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                    cells[i][j].setImage(greenTile);
                }
                else if(i == 2 && j == 2) {
                	//cells[i][j].setText(".");
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                    cells[i][j].setImage(greenTile);
                }
                else if(i == 3 && j == 3) {
                	//cells[i][j].setText(".");
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                    cells[i][j].setImage(greenTile);
                }
                else if(i == 4 && j == 4) {
                	//cells[i][j].setText(".");
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                    cells[i][j].setImage(greenTile);
                }
                else {
                	//cells[i][j].setText(".");
                	cells[i][j].setFont(g);
                	cells[i][j].setForeground(Color.RED);
                	cells[i][j].setImage(redTile);
                }
			}
		}
	}
}
