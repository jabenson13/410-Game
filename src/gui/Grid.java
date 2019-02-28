package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Grid extends JPanel{
	
	int columns;
	int rows;
	static JTextField[][] cells = new JTextField[5][5];
	static final int bord = 1;
	static LineBorder Border = new LineBorder(Color.BLACK,bord);
	Font f = new Font("Sans Serif", Font.BOLD, 100);
	Font g = new Font("Times New Roman", Font.BOLD, 125);
	
	public Grid(int col, int row) {		
		columns = col;
		rows = row;
		setLayout(new GridLayout(columns, rows));
				
		for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cells[i][j] = new JTextField() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(20, 20);
                    }
                };
                cells[i][j].setEditable(false);
                
                if(i == 0 && j == 0) {
                	cells[i][j].setText("");
                }
                else if(i == 0) {
                	String playerName = "Player " + j;
                	cells[i][j].setText(playerName);
                }
                else if(j == 0) {
                	String playerName = "Player " + i;
                	cells[i][j].setText(playerName);
                }
                else if(i == 1 && j == 1) {
                	cells[i][j].setText(".");
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                }
                else if(i == 2 && j == 2) {
                	cells[i][j].setText(".");
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                }
                else if(i == 3 && j == 3) {
                	cells[i][j].setText(".");
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                }
                else if(i == 4 && j == 4) {
                	cells[i][j].setText(".");
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                }
                else {
                	cells[i][j].setText(".");
                	cells[i][j].setFont(g);
                	cells[i][j].setForeground(Color.RED);
                }
                cells[i][j].setPreferredSize(new Dimension(50, 50));
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                cells[i][j].setFocusTraversalKeysEnabled(false);
                cells[i][j].setBorder(Border);
                add(cells[i][j]);
            }
        }
	}
	public void updateGrid(String p1, String p2) {
		if(p1.equals("Player 1") && p2.equals("Player 2")) {
			cells[1][2].setForeground(Color.GREEN);
		}
		else if(p1.equals("Player 1") && p2.equals("Player 3")) {
			cells[1][3].setForeground(Color.GREEN);
		}
		else if(p1.equals("Player 1") && p2.equals("Player 4")) {
			cells[1][4].setForeground(Color.GREEN);
		}
		else if(p1.equals("Player 2") && p2.equals("Player 1")) {
			cells[2][1].setForeground(Color.GREEN);
		}
		else if(p1.equals("Player 2") && p2.equals("Player 3")) {
			cells[2][3].setForeground(Color.GREEN);
		}
		else if(p1.equals("Player 2") && p2.equals("Player 4")) {
			cells[2][4].setForeground(Color.GREEN);
		}
		else if(p1.equals("Player 3") && p2.equals("Player 1")) {
			cells[3][1].setForeground(Color.GREEN);
		}
		else if(p1.equals("Player 3") && p2.equals("Player 2")) {
			cells[3][2].setForeground(Color.GREEN);
		}
		else if(p1.equals("Player 3") && p2.equals("Player 4")) {
			cells[3][4].setForeground(Color.GREEN);
		}
		else if(p1.equals("Player 4") && p2.equals("Player 1")) {
			cells[4][1].setForeground(Color.GREEN);
		}
		else if(p1.equals("Player 4") && p2.equals("Player 2")) {
			cells[4][2].setForeground(Color.GREEN);
		}
		else if(p1.equals("Player 4") && p2.equals("Player 3")) {
			cells[4][3].setForeground(Color.GREEN);
		}
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
	public void reset() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(i == 0 && j == 0) {
                	cells[i][j].setText("");
                }
                else if(i == 0) {
                	String playerName = "Player. " + j;
                	cells[i][j].setText(playerName);
                }
                else if(j == 0) {
                	String playerName = "Player " + i;
                	cells[i][j].setText(playerName);
                }
                else if(i == 1 && j == 1) {
                	cells[i][j].setText(".");
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                }
                else if(i == 2 && j == 2) {
                	cells[i][j].setText(".");
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                }
                else if(i == 3 && j == 3) {
                	cells[i][j].setText(".");
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                }
                else if(i == 4 && j == 4) {
                	cells[i][j].setText(".");
                    cells[i][j].setFont(g);
                    cells[i][j].setForeground(Color.GREEN);
                }
                else {
                	cells[i][j].setText(".");
                	cells[i][j].setFont(g);
                	cells[i][j].setForeground(Color.RED);
                }
			}
		}
	}
}