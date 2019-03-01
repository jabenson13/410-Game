/**
 *  
 *  
 */
package server;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Logic.java
 *
 * Feb 28, 2019
 * 
 */
public class Logic {
	
	public Logic() {
		
	}
	
	
	public int squareReturn(String inputLine) {
	
		int num = Integer.parseInt(inputLine);
		
		return(num*num*num);
	}
	
	public String stringReverse(String inputLine) {
		String rValue = "";
		
		for(int i = inputLine.length()-1; i >= 0; i--) {
			rValue += inputLine.substring(i,i+1);
		}
		
		return(rValue);
		
	}
	
	
	

    public void popup() {
        final JFrame parent = new JFrame();
        JButton button = new JButton();

        button.setText("Click me to show dialog!");
        parent.add(button);
        parent.pack();
        parent.setVisible(true);

        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = JOptionPane.showInputDialog(parent,
                        "What is your name?", null);
            }
        });
    }
	
	
	

}
