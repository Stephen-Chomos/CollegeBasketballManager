import java.util.Random;
import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScheduleCheck {
	Random random = new Random();
	int home;
	int neutral;
	int team;
	Vector<Team> left = new Vector<>();
	public ScheduleCheck(Vector<Team> tm, Coach ch, Team yu) {
		left = tm;
		JFrame frame = new JFrame("College Basketball Manager");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel panel = new JPanel();
	    frame.setSize(1000, 500);
	    frame.setVisible(true);
	    for (Team t : tm) {
	    	System.out.println("New Team-" + t.getTeamName());
	    	t.setNumGames(0);
	    	//if (t.getNumGames() < 31) {
	    	for(Team t2 : tm) {
	    		System.out.println("Checking team-" + t2.getTeamName());
	    		if(t2.getConfrence().equals(t.getConfrence()) && t2.getId() != t.getId() && t.onSchedule(t2.getId()) && t2.onSchedule(t.getId())) {
	    			System.out.println(t.getConfrence() + "=" + t2.getConfrence());
	    			t.addGame(t2, t2.getId(), true, false);
	    			t.addGame(t2, t2.getId(), false, false);
	    			t2.addGame(t, t.getId(), true, false);
	    			t2.addGame(t, t.getId(), false, false);
	    			System.out.println("Added game!");
	    		}
	    		else {
	    			System.out.println(t.getConfrence() + "=/=" + t2.getConfrence());
	    		}
	    	}
	    	
	    	//Other games
	    	
	    	/**while(t.getNumGames() < 31) {
	    		System.out.println("New Game test");
	    		int max = left.size();
	    		team = random.nextInt(max);
	    		Team t2 = tm.elementAt(team);
	    		if (t.onSchedule(t2.getId()) && t2.onSchedule(t.getId()) && t2.getNumGames() < 31) {
	    			home = random.nextInt(2);
	    			neutral = random.nextInt(10);
	    			if(home == 0 && neutral != 7) {
	    				t.addGame(t2, t2.getId(), true, false);
	    				t2.addGame(t, t.getId(), false, false);
	    			}
	    			else if (home == 1 && neutral == 7) {
	    				t.addGame(t2, t2.getId(), true, true);
	    				t2.addGame(t, t.getId(), false, true);
	    			}
	    			else if(home == 0 && neutral == 7) {
	    				t.addGame(t2, t2.getId(), false, true);
	    				t2.addGame(t, t.getId(), true, true);
	    			}
	    			else {
	    				t.addGame(t2, t2.getId(), false, false);
	    				t2.addGame(t, t.getId(), true, false);
	    			}
	    		}
	    	}*/
	    	//NEED TO FIGURE OUT HOW TO MAKE IT THE SAME
	    	//t.randomSced();
	    	}
	    	
	    //}
	    JLabel sced = new JLabel("SCHEDULE");
    	JTextArea textArea = new JTextArea(10, 50); // Rows x Columns
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.append(yu.printsced());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(sced);
		panel.add(scrollPane);
		
		JButton cont = new JButton("Continue");
		panel.add(cont);
		frame.add(panel);
		
		cont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ch.setPointinSeason(1);
                new MainScreen(tm, ch);
            }
        });
	    
	}
}
