import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OffSeasonTasks {
	
	public OffSeasonTasks(Vector<Team> tm, Coach ch, Team yu) {
		JFrame frame = new JFrame("College Basketball Manager");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel panel = new JPanel();
	    frame.add(panel);
	    frame.setSize(1000, 500);
	    frame.setVisible(true);
	    
	    for(Team t : tm) {
	    	t.addYear();
	    }
	    
	    JButton trainspeed = new JButton("Train speed");
	    JButton trainmental = new JButton("Train mental");
	    JButton trainshot = new JButton("Train shot");
	    
	    panel.add(trainspeed);
	    panel.add(trainmental);
	    panel.add(trainshot);
	    
	    trainspeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                yu.trainSpeed();
                new ScheduleCheck(tm, ch, yu);
            }
        });
	    trainmental.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                yu.trainMental();
                new ScheduleCheck(tm, ch, yu);
            }
        });
	    trainshot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                yu.trainShot();
                new ScheduleCheck(tm, ch, yu);
            }
        });
	}
}
