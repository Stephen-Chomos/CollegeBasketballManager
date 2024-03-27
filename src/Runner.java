import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Runner {

	public static void main(String[] args) {
		JFrame frame = new JFrame("College Basketball Manager");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel welcome = new JLabel("WELCOME TO COLLEGE BASKETBALL MANAGER:");
        
        JButton nButton = new JButton("New Game");
        JButton lButton = new JButton("Old Game");
        JButton end = new JButton("EXIT");
        
        JPanel panel = new JPanel();
        
        panel.add(welcome);
        panel.add(nButton);
        panel.add(lButton);
        panel.add(end);
        
        nButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewGame();
                frame.setVisible(false);
            }
        });
        
        lButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoadGame();
                frame.setVisible(false);
            }
        });
        
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }
        });
        
        frame.add(panel);
        
        frame.setSize(300, 150);
        
        frame.setVisible(true);
	}
	
	public Runner() {
		JFrame frame = new JFrame("College Basketball Manager");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel welcome = new JLabel("WELCOME TO COLLEGE BASKETBALL MANAGER:");
        
        JButton nButton = new JButton("New Game");
        JButton lButton = new JButton("Old Game");
        JButton end = new JButton("EXIT");
        
        JPanel panel = new JPanel();
        
        panel.add(welcome);
        panel.add(nButton);
        panel.add(lButton);
        panel.add(end);
        
        nButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewGame();
                frame.setVisible(false);
            }
        });
        
        lButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoadGame();
                frame.setVisible(false);
            }
        });
        
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }
        });
        
        frame.add(panel);
        
        frame.setSize(300, 150);
        
        frame.setVisible(true);
	}

}
