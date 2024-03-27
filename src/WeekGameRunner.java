import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WeekGameRunner {

	public WeekGameRunner(Vector<Team> tm, Coach ch, Team yu, int week) {
		String check = "";
		Frame frame = new JFrame("College Basketball Manager");
	    ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel panel = new JPanel();
	    frame.setSize(1000, 500);
	    frame.setVisible(true);
		JLabel sced = new JLabel("Results for Week " + yu.getWeekOn() + 1);
		JTextArea textArea = new JTextArea(10, 50); // Rows x Columns
		Random random = new Random();
		for (Team t1 : tm) {
			if(t1.getWeekOn() == week && t1.getWeekOn() < t1.getNumGames()) {
			Game ours = t1.getGame(week);
			int id1 = t1.getId();
			boolean neutral = false;
			int home = 0;
			int id2;
			int homeScore= 0;
			int awayScore = 0;
			int score1 = 0;
			int score2 = 0;
			Team t2 = new Team();
			if(t2.getWeekOn() == week) {
			if (id1 == ours.homeID && !ours.neutralsite) {
				id2 = ours.getAwayID();
				home = 1;
				homeScore = 5;
			}
			else if (id1 == ours.awayID && !ours.neutralsite) {
				id2 = ours.getHomeID();
				home = 2;
				homeScore = 5;
			}
			else if (id1 == ours.homeID && ours.neutralsite) {
				id2 = ours.getAwayID();
				home = 1;
				neutral = true;
			}
			else {
				id2 = ours.getHomeID();
				home = 2;
				neutral = true;
			}
			
			for(Team t3 : tm) {
				if (id2 == t3.getId()) {
					t2 = t3;
				}
			}
			
			switch(t1.getSpeed()) {
			case 1:
				score1 = score1 + t1.calcSpeed1();
				break;
			case 2:
				score1 = score1 + t1.calcSpeed2();
				break;
			case 3:
				score1 = score1 + t1.calcSpeed3();
				break;
			}
			
			switch(t1.getRebagg()) {
			case 1:
				score1 = score1 + t1.calcReb1();
				break;
			case 2:
				score1 = score1 + t1.calcReb2();
				break;
			case 3:
				score1 = score1 + t1.calcReb3();
				break;
			}
			
			switch(t1.getShotrang()) {
			case 1:
				score1 = score1 + t1.calcRange1();
				break;
			case 2:
				score1 = score1 + t1.calcRange2();
				break;
			case 3:
				score1 = score1 + t1.calcRange3();
				break;
			}
			
			switch(t2.getSpeed()) {
			case 1:
				score2 = score2 + t2.calcSpeed1();
				break;
			case 2:
				score2 = score2 + t2.calcSpeed2();
				break;
			case 3:
				score2 = score2 + t2.calcSpeed3();
				break;
			}
			
			switch(t2.getRebagg()) {
			case 1:
				score2 = score2 + t2.calcReb1();
				break;
			case 2:
				score2 = score2 + t2.calcReb2();
				break;
			case 3:
				score2 = score2 + t2.calcReb3();
				break;
			}
			
			switch(t2.getShotrang()) {
			case 1:
				score2 = score2 + t2.calcRange1();
				break;
			case 2:
				score2 = score2 + t2.calcRange2();
				break;
			case 3:
				score2 = score2 + t2.calcRange3();
				break;
			}
			
			score1 = score1 /3;
			score2 = score2 / 3;
			
			score1 = score1 + random.nextInt(20);
			score2 = score2 + random.nextInt(20);
			
			if(home == 1) {
				homeScore = homeScore + score1;
				awayScore = score2;
				while(homeScore == awayScore) {
					homeScore = homeScore + random.nextInt(10);
					awayScore = awayScore + random.nextInt(10);
				}
				t1.ScoreGame(homeScore, awayScore, t2.getWeekOn());
				t2.ScoreGame(homeScore, awayScore, t1.getWeekOn());
			}
			
			else {
				homeScore = homeScore + score2;
				awayScore = score1;
				while(homeScore == awayScore) {
					homeScore = homeScore + random.nextInt(10);
					awayScore = awayScore + random.nextInt(10);
				}
				t1.ScoreGame(homeScore, awayScore, t2.getWeekOn());
				t2.ScoreGame(homeScore, awayScore, t1.getWeekOn());
			}
			
			if(home == 1 && neutral) {
				check = check + t1.getTeamName() + " vs(neutral) " + t2.getTeamName() + " Result: " + homeScore + "-" + awayScore + "\n";
			}
			
			else if(home == 2 && neutral) {
				check = check + t2.getTeamName() + " vs(neutral) " + t1.getTeamName() + " Result: " + homeScore + "-" + awayScore + "\n"; 
			}
			
			else if(home == 1 && !neutral) {
				check = check + t1.getTeamName() + " vs " + t2.getTeamName() + " Result: " + homeScore + "-" + awayScore + "\n"; 
			}
			
			else {
				check = check + t2.getTeamName() + " vs " + t1.getTeamName() + " Result: " + homeScore + "-" + awayScore + "\n"; 
			}
			
			textArea.append(check);
			System.out.println("DONE");
			}
			}
		}
		
		
		
	    textArea.setWrapStyleWord(true);
	    textArea.setLineWrap(true);
	    textArea.setEditable(false);
	    JScrollPane scrollPane = new JScrollPane(textArea);
	    panel.add(scrollPane);
	    JButton cont = new JButton("Continue");
		panel.add(cont);
		frame.add(panel);
		
		cont.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            frame.setVisible(false);
	            new MainScreen(tm, ch);
	        }
	    });
	    
	    
	}
}
