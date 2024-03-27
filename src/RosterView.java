import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class RosterView {

	public RosterView(Vector<Team> tm, Coach ch, Team yu) {
	
		JFrame frame = new JFrame("College Basketball Manager");
	    frame.setSize(1000, 500);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JLabel label = new JLabel("Roster for " + yu.getTeamName());
    	JTextArea textArea = new JTextArea(20, 50); // Rows x Columns
	    JPanel panel = new JPanel();
	    JButton exit = new JButton("Back to main menu");
	    
	    textArea.append(yu.rosterView());
	    
	    exit.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            frame.setVisible(false);
	            new MainScreen(tm, ch);
	        }
	    });
	    
	    panel.add(label);
	    panel.add(textArea);
	    panel.add(exit);
	    frame.add(panel);
	    frame.setVisible(true);
	}
}
