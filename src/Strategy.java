import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Strategy {

	public Strategy(Vector<Team> tm, Coach ch, Team yu) {
		JFrame frame = new JFrame("College Basketball Manager");
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 400);
	    frame.setVisible(true);
	    
	    JPanel panel = new JPanel();
	    
	    JLabel Ruler = new JLabel("Select one of the three of speed, rebounding aggresivness, and shot range");
	    JButton exit = new JButton("Return to Main Menu");
	    JRadioButton spe1 = new JRadioButton("Speed 1-Slowest");
	    JRadioButton spe2 = new JRadioButton("Speed 2-Middle");
	    JRadioButton spe3 = new JRadioButton("Speed 3-Fastest");
	    ButtonGroup speed = new ButtonGroup();
	    speed.add(spe1);
	    speed.add(spe2);
	    speed.add(spe3);
	    JRadioButton reb1 = new JRadioButton("Rebounding 1-Lowest");
	    JRadioButton reb2 = new JRadioButton("Rebounding 2-Middle");
	    JRadioButton reb3 = new JRadioButton("Rebounding 3-Most aggressive");
	    ButtonGroup rebounding = new ButtonGroup();
	    rebounding.add(reb1);
	    rebounding.add(reb2);
	    rebounding.add(reb3);
	    JRadioButton sht1 = new JRadioButton("Shot range 1-Closest");
	    JRadioButton sht2 = new JRadioButton("Shot range 2-Middle");
	    JRadioButton sht3 = new JRadioButton("Shot range 3-Farthest");
	    ButtonGroup shotrange = new ButtonGroup();
	    shotrange.add(sht1);
	    shotrange.add(sht2);
	    shotrange.add(sht3);
	    JTextArea current = new JTextArea(10, 50);
	    String adder = "";
	    adder = adder + "Current Stats: Speed: " + yu.getSpeed() + "; Rebounding: " + yu.getRebagg() + "; Shot range: " + yu.getShotrang();
	    current.append(adder);
	    current.setEditable(false);
	    panel.add(current);
	    panel.add(Ruler);
	    panel.add(spe1);
	    panel.add(spe2);
	    panel.add(spe3);
	    panel.add(reb1);
	    panel.add(reb2);
	    panel.add(reb3);
	    panel.add(sht1);
	    panel.add(sht2);
	    panel.add(sht3);
	    panel.add(exit);
	    frame.add(panel);
	    
	    exit.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            frame.setVisible(false);
	            new MainScreen(tm, ch);
	        }
	    });
	    
	    
	    spe1.addActionListener(e -> {
	        yu.setSpeed(1);
	    });
	    spe2.addActionListener(e -> {
	        yu.setSpeed(2);
	    });
	    spe3.addActionListener(e -> {
	        yu.setSpeed(3);
	    });
	    reb1.addActionListener(e -> {
	        yu.setRebagg(1);
	    });
	    reb2.addActionListener(e -> {
	        yu.setRebagg(2);
	    });
	    reb3.addActionListener(e -> {
	        yu.setRebagg(3);
	    });
	    sht1.addActionListener(e -> {
	        yu.setShotrang(1);
	    });
	    sht2.addActionListener(e -> {
	        yu.setShotrang(2);
	    });
	    sht3.addActionListener(e -> {
	        yu.setShotrang(3);
	    });
	}
	
}
